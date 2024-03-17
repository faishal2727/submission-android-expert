plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

apply {
    from("../shared_dependencies.gradle")
}

android {
    namespace = "com.example.submissionandroidexpertpertama"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.submissionandroidexpertpertama"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = true
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
    buildFeatures{
        viewBinding = true
    }

    lint {
        disable += "MissingTranslation"
        disable += "TypographyFractions"
        abortOnError = false
        checkReleaseBuilds =  false
        lintConfig = file("$rootDir/linter.xml")
    }
    dynamicFeatures += setOf(":paporit")
}

dependencies {

    implementation(project(":core"))

}