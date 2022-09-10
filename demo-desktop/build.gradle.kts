import org.jetbrains.compose.compose

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}
group = "com.kyant.monet"
version = extra["monet.version"] as String


dependencies {
    api(project(":demo-common"))
    implementation(compose.desktop.currentOs)
}