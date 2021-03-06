plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Core
    implementation (Libraries.coreKtx)
    implementation (Libraries.appCompat)

    // Lifecycle
    implementation (Libraries.lifecycleRuntime)
    implementation (Libraries.lifecycleCommon)
    implementation (Libraries.lifecycleLiveData)
    implementation (Libraries.lifecycleViewModel)

    implementation (project(Modules.logging))
    implementation(project(Modules.styles))
    implementation(project(Modules.imageLoading))

    implementation (Libraries.coroutine)
    implementation (Libraries.ThirdParty.ratingBar)
    implementation (Libraries.ThirdParty.roundedProgressBar)
    implementation(Libraries.constraintLayout)
    implementation (Libraries.material)

}