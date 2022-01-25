import java.util.Properties
import java.io.FileInputStream
import kotlin.collections.*

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Configs.compileSdkVersion

    defaultConfig {
        applicationId = Configs.applicationId
        minSdk = Configs.minSdkVersion
        targetSdk = Configs.targetSdkVersion
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", KeyHelper.TMDB_API_KEY, KeyHelper.getValue(KeyHelper.TMDB_API_KEY))
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
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

    setFlavorDimensions(listOf("persons"))
    productFlavors {
        create("standard") {
            dimension = "persons"
            applicationIdSuffix = ".standard"
            versionNameSuffix = "-standard"

            setManifestPlaceholders(
                mapOf(
                    "appIcon" to "",
                    "appIconRound" to ""
                )
            )
        }
        create("balanco") {
            dimension = "persons"
            applicationIdSuffix = ".balanco"
            versionNameSuffix = "-balanco"

            setManifestPlaceholders(
                mapOf(
                    "appIcon" to "",
                    "appIconRound" to ""
                )
            )
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Core
    implementation (Libraries.coreKtx)
    implementation (Libraries.appCompat)

    // Design
    implementation (Libraries.material)
    implementation (Libraries.constraintLayout)

    // Test
    testImplementation (Libraries.junit)
    androidTestImplementation (Libraries.junitTest)
    androidTestImplementation (Libraries.espressoCore)
}