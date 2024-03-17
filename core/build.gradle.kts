@file:Suppress(
    "SpellCheckingInspection"
)

plugins {
    id("com.android.library")
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
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
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
}

dependencies {

    //noinspection GradleDependency
    implementation("androidx.room:room-runtime:${rootProject.extra["room_version"]}")
    //noinspection KaptUsageInsteadOfKsp
    kapt("androidx.room:room-compiler:${rootProject.extra["room_version"]}")
    //noinspection GradleDependency
    androidTestImplementation("androidx.room:room-testing:${rootProject.extra["room_version"]}")

    implementation("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofit_version"]}")
    implementation("com.squareup.retrofit2:converter-gson:${rootProject.extra["retrofit_version"]}")
    implementation("com.squareup.okhttp3:logging-interceptor:${rootProject.extra["logging_interceptor_version"]}")

    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.extra["kotlin_coroutines_version"]}")
    //noinspection GradleDependency
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${rootProject.extra["kotlin_coroutines_version"]}")
    //noinspection GradleDependency
    api("androidx.room:room-ktx:${rootProject.extra["room_version"]}")
    //noinspection GradleDependency
    api("androidx.lifecycle:lifecycle-livedata-ktx:${rootProject.extra["lifecycle_version"]}")

    implementation("net.zetetic:android-database-sqlcipher:${rootProject.extra["sql_chipper_version"]}")
    //noinspection GradleDependency
    implementation("androidx.sqlite:sqlite-ktx:${rootProject.extra["sqlite_version"]}")


}