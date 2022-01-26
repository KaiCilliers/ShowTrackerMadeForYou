package com.sunrisekcdevelopers.logging

import timber.log.Timber

inline fun <reified T: Any> timber(tag: String? = null) = TimberLoggerProperty<T>(tag)