pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//        https://github.com/a914-gowtham/compose-ratingbar/blob/main/README.md
        maven { setUrl("https://jitpack.io")  }
    }
}

rootProject.name = "LEVEL3_TASK_1"
include(":app")
 