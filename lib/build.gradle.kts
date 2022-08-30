plugins {
    `maven-publish`
    id("com.android.library")
    kotlin("android")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.kyant.monet"
    compileSdk = 33
    buildToolsVersion = "33.0.0"

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + listOf("-Xexplicit-api=strict")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0-beta01"
    }
}

dependencies {
    implementation("androidx.compose.ui:ui:1.3.0-beta01")
    implementation("androidx.compose.material3:material3:1.0.0-beta01")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0-alpha07")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.0-beta01")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.0-beta01")
}
