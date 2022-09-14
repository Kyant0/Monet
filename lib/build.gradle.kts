plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    `maven-publish`
}

group = "com.kyant.monet"
version = extra["monet.version"] as String

kotlin {
    android {
        publishLibraryVariants("release")
    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                api(compose.material3)
            }
        }
    }
}

android {
    namespace = "com.kyant.monet"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}

afterEvaluate {
    publishing {
        publications.create("maven_public", MavenPublication::class) {
            groupId = "com.github.Kyant0"
            artifactId = "Monet"
            version = extra["monet.version"] as String
            from(components.getByName("release"))
        }
    }
}
