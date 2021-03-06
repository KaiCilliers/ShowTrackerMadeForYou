object Libraries {
    // Core
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val kotlinStandardLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStandardLibVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"

    // Design
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"

    // Test
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val junitTest = "androidx.test.ext:junit:${Versions.junitTestVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"

    // Logging
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"

    // Koin (Dependency Injection Framework)
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinVersion}"
    const val koinWorkManger = "io.insert-koin:koin-androidx-workmanager:${Versions.koinVersion}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koinVersion}"
    const val koinJunit4 = "io.insert-koin:koin-test-junit4:${Versions.koinVersion}"
    const val koinJunit5 = "io.insert-koin:koin-test-junit5:${Versions.koinVersion}"

    // Viewpager2
    const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2Version}"

    // Coroutines
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"

    // Lifecycle
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:2.2.0"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:2.2.0"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"

    // 3rd party libraries
    object ThirdParty {
        const val ratingBar = "com.github.ome450901:SimpleRatingBar:${Versions.ThirdParty.ratingBarVersion}"
        const val roundedProgressBar = "com.github.MackHartley:RoundedProgressBar:${Versions.ThirdParty.roundedProgressBarVersion}"
        const val exoPlayer = "com.google.android.exoplayer:exoplayer:${Versions.ThirdParty.exoPlayerVersion}"
    }
}