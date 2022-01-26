import kotlin.collections.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

        missingDimensionStrategy("persons", "standard")

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
            applicationIdSuffix = ".release"
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        allWarningsAsErrors = true
    }

    /**
     * The idea is to use the persons flavor to provide custom versions of the
     * application for family members for testing new features
     */
    setFlavorDimensions(listOf("persons"))
    productFlavors {
        // region persons
        create("standard") {
            isDefault = true
            dimension = "persons"
            applicationIdSuffix = ".standard"
            versionNameSuffix = "-standard"

            @kotlin.Suppress("DEPRECATION")
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

            @kotlin.Suppress("DEPRECATION")
            setManifestPlaceholders(
                mapOf(
                    "appIcon" to "",
                    "appIconRound" to ""
                )
            )
        }
        // endregion
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

    // Modules
    implementation(project(Modules.logging))
    implementation(project(Modules.uiComponents))

    // Test
    testImplementation (Libraries.junit)
    androidTestImplementation (Libraries.junitTest)
    androidTestImplementation (Libraries.espressoCore)
}