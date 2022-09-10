plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

group = "com.kyant.monet.demo"
version = extra["monet.version"] as String

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":lib"))
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                api(compose.material3)
            }
        }
        val androidMain by getting {
            dependencies {
                api(project(":lib"))
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                api(compose.material3)
                api("androidx.core:core-ktx:1.9.0")
                api("androidx.activity:activity-compose:1.5.1")
            }
        }
    }
}

android {
    namespace = "com.kyant.monet.demo.common"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }

    lint {
        baseline = file("build/lint-baseline.xml")
    }
}

