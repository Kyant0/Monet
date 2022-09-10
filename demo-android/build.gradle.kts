plugins {
    id("com.android.application")
    kotlin("android")
}

@Suppress("UnstableApiUsage")
group = "com.kyant.monet.demo"
version = extra["monet.version"] as String

android {
    namespace = "com.kyant.monetdemo"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.kyant.monetdemo"
        minSdk = 21
        targetSdk = 33
        versionCode = (extra["monet.versionCode"] as String).toInt()
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    api(project(":demo-common"))
    implementation(project(":lib"))
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.compose.ui:ui:1.3.0-beta02")
    implementation("androidx.compose.material3:material3:1.0.0-beta02")
}


