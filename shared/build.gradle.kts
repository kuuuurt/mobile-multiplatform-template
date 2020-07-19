plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

version = "1.0.0"

kotlin {
    android()
    ios()

    cocoapods {
        summary = "Shared Android/iOS library for Multiplatform App"
        homepage = "N/A"
        frameworkName = "MultiplatformAppShared"
    }

    val coroutinesVersion = "1.3.7"

    val commonMain by sourceSets.getting {
        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutinesVersion")
        }
    }

    val androidMain by sourceSets.getting {
        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-stdlib")
            implementation("org.jetbrains.kotlin:kotlin-stdlib")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
            implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

        }
    }

    val iosMain by sourceSets.getting {
        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-stdlib")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesVersion")
        }
    }

    val commonTest by sourceSets.getting {
        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-test-common")
            implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
        }
    }

    val androidTest by sourceSets.getting {
        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-test")
            implementation("org.jetbrains.kotlin:kotlin-test-junit")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.7")
        }
    }
}

android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            consumerProguardFiles("consumer-rules.pro")
        }
    }
}