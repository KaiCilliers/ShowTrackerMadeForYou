import java.net.URI

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
@kotlin.Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = URI("https://jitpack.io")
        }
    }
}
rootProject.name = "ShowTracker - Made for You"
include(":app")
include(":logging")
include(":ui-components")
include(":navigation")
include(":styles")
include(":imageloading")
include(":discovery")
include(":myCollectionTVShow")
include(":myCollectionMovie")
include(":episodeDetail")
include(":movieDetail")
include(":tvShowDetail")
