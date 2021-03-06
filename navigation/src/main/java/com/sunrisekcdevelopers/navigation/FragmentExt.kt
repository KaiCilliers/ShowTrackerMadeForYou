package com.sunrisekcdevelopers.navigation

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun Fragment.pop() = parentFragmentManager.popBackStack()

fun Fragment.popUntil(
    fragmentTag: String
) = parentFragmentManager.popBackStack(fragmentTag, FragmentManager.POP_BACK_STACK_INCLUSIVE)

fun Fragment.replaceFragmentExt(
    newFragment: Fragment,
    addToBackStack: Boolean,
    fromActivity: Boolean = true,
    containerId: Int? = null,
    transactionAnimations: TransactionAnimations = TransactionAnimations.NONE
) = this.navUtils(
    TransactionType.REPLACE_FRAGMENT,
    newFragment,
    addToBackStack,
    fromActivity,
    containerId ?: R.id.root_container,
    transactionAnimations
)

fun Fragment.addFragmentExt(
    newFragment: Fragment,
    addToBackStack: Boolean,
    fromActivity: Boolean = true,
    containerId: Int? = null,
    transactionAnimations: TransactionAnimations = TransactionAnimations.NONE
) = this.navUtils(
    TransactionType.ADD_FRAGMENT,
    newFragment,
    addToBackStack,
    fromActivity,
    containerId ?: R.id.root_container,
    transactionAnimations
)

internal fun Fragment.navUtils(
    transactionType: TransactionType,
    newFragment: Fragment,
    addToBackStack: Boolean,
    fromActivity: Boolean,
    containerId: Int,
    transactionAnimations: TransactionAnimations
) {
    val manager = if (fromActivity) activity?.supportFragmentManager else childFragmentManager

    // potential issue when a link exists to a detail screen on the target destination
    // possible solution:
    // 1) concat the fragment tag name with something else like an ID
    // 2) remove this condition and handle manually that the "same" fragment is not added
    if(manager?.findFragmentByTag(newFragment::class.java.simpleName) != null) {
        Log.w(
            "NavUtils",
            "${newFragment::class.java.simpleName} already added. Transaction aborted"
        )
        return
    }

    manager?.beginTransaction()?.fragmentTransactionExt(
        transactionType = transactionType,
        newFragment = newFragment,
        addToBackStack = addToBackStack,
        containerId = containerId,
        fragmentTag = newFragment::class.java.simpleName,
        transactionAnimations = transactionAnimations
    )
}