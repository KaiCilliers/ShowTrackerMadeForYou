package com.sunrisekcdevelopers.logging

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class TimberLoggerProperty<T: Any>(private val tag: String? = null) : ReadOnlyProperty<T, TimberLogger> {

    @Volatile
    var logger: TimberLogger? = null

    override fun getValue(thisRef: T, property: KProperty<*>): TimberLogger {
        logger?.let { return it }
        logger = TimberLogger(thisRef, tag)
        return logger!!
    }
}