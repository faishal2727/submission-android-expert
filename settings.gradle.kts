@file:Suppress("UnstableApiUsage", "UnstableApiUsage", "UnstableApiUsage", "UnstableApiUsage",
    "UnstableApiUsage", "RedundantSuppression", "RedundantSuppression", "RedundantSuppression",
    "RedundantSuppression"
)

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
    }
}

rootProject.name = "SubmissionAndroidExpertPertama"
include(":app")
include(":core")
include(":paporit")
