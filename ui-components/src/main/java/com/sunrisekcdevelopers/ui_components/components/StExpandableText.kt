package com.sunrisekcdevelopers.ui_components.components

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.annotation.AttrRes
import com.sunrisekcdevelopers.ui_components.*
import com.sunrisekcdevelopers.ui_components.R.*
import kotlin.properties.Delegates

// Source https://medium.com/@yuriyskul/expandable-textview-with-layouttransition-part-1-b506681e78e7
// bug where "see more" is included in original text
@SuppressLint("Recycle")
class StExpandableText @JvmOverloads constructor(
    private val ctxt: Context,
    private val attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.textViewStyle
) : StTextViewBody(ctxt, attrs, defStyleAttr), View.OnClickListener {

    // animation variables
    private var animator: ValueAnimator? = null
    private val isCollapsed: Boolean
        get() = maxLines != Int.MAX_VALUE
    private var isCollapsing: Boolean = false
    private var originalText: CharSequence = ""
    private val animatorListener: AnimatorListenerAdapter by lazy { createAnimatorListener() }

    // attributes
    private var maxLineCount: Int = MAX_LINES_DEF
    private var startExpanded by Delegates.notNull<Boolean>()
    private var disableCollapse by Delegates.notNull<Boolean>()

    init {
        setPadding(8.dp, 8.dp, 8.dp, 8.dp)
        obtainStyledAttrs()
        initializeComponent()
    }

    companion object {
        private const val MAX_LINES_DEF = 3
        // todo use string resource
        // consider removing see more and add ellipse with black bottom gradient to indicate there is more text
        private const val POSTFIX = "...see more "
    }

    private fun initializeComponent() {
        when {
            disableCollapse -> {
                isClickable = false
                maxLines = Int.MAX_VALUE
            }
            startExpanded -> {
                maxLines = Int.MAX_VALUE
                normalSetup()
            }
            else -> {
                maxLines = maxLineCount
                normalSetup()
            }
        }
    }

    private fun normalSetup() {
        setOnClickListener(this)
        animator = createAnimator()
    }

    private fun obtainStyledAttrs() {
        ctxt.obtainStyledAttributes(attrs, styleable.StExpandableText).withRecycle {
            getInt(styleable.StExpandableText_stet_maxLines, MAX_LINES_DEF).also { maxLineCount = it }
            getBoolean(styleable.StExpandableText_stet_startExpanded, false).also { startExpanded = it }
            getBoolean(styleable.StExpandableText_stet_disableCollapse, false).also { disableCollapse = it }
        }
    }

    private fun createAnimator(): ValueAnimator {
        return ValueAnimator.ofInt(-1,-1).setDuration(450).apply {
            interpolator = AccelerateDecelerateInterpolator()
            addUpdateListener { updateHeight(it.animatedValue as Int) }
            addListener(animatorListener)
        }
    }

    private fun updateHeight(newHeight: Int) {
        val params = this.layoutParams
        params.height = newHeight
        layoutParams = params
    }

    private fun createAnimatorListener() : AnimatorListenerAdapter {
        return object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                when {
                    isCollapsed -> {
                        isCollapsing = false
                        maxLines = Int.MAX_VALUE
                        deEllipsize()
                    }
                    else -> isCollapsing = true
                }
            }

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                if (isCollapsing && !isCollapsed) {
                    ellipsizeColored()
                    maxLines = maxLineCount
                    isCollapsing = false
                }
                updateHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
    }

    private fun ellipsizeColored() {
        val end = layout.getLineEnd(maxLineCount - 1)
        val txt = text
        val chars = layout.getLineEnd(maxLineCount - 1) - layout.getLineStart(maxLineCount - 1)
        val additionalGap = 4

        if (chars + additionalGap < POSTFIX.length) {
            // handle rare case when text has a last  maxLine which has  only few chars and
            // then it goes to the next line .
            // lin such case there is nothing twe cannot replace because postfix
            // length is greater then max line length. Do nothing.
            return
        }

        val builder = SpannableStringBuilder(txt)
        builder.replace(end - POSTFIX.length, end, POSTFIX)
        builder.setSpan(
            ForegroundColorSpan(Color.RED),
            end - POSTFIX.length,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        // avoids our override setText that caches the value
        super.setText(builder, BufferType.NORMAL)
    }

    private fun deEllipsize() {
        text = originalText
    }

    private fun reverseAnimator() {
        animator?.let {
            isCollapsing = !isCollapsing
            it.reverse()
        }
    }

    private fun animateTo(): Int {
        return if (isCollapsed) {
            layout.height + getPaddingHeight()
        } else {
            layout.getLineBottom(maxLineCount - 1) + layout.bottomPadding + getPaddingHeight()
        }
    }

    private fun startAnimator() {
        animator?.start()
    }

    private fun getPaddingHeight(): Int {
        return compoundPaddingBottom + compoundPaddingTop
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        originalText = text.toString()
        super.setText(text, type)
    }

    override fun onClick(p0: View?) {
        animator?.let {
            if (it.isRunning) {
                reverseAnimator()
                return
            }

            val endPosition = animateTo()
            val startPosition = height

            it.setIntValues(startPosition, endPosition)
            startAnimator()
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (lineCount <= maxLineCount) {
            deEllipsize()
            isClickable = false
        } else if (!disableCollapse) {
            isClickable = true
            animator?.let {
                if (!it.isRunning && isCollapsed) {
                    ellipsizeColored()
                }
            }
        }
    }
}