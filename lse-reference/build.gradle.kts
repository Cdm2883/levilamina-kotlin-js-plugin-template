plugins {
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
}

group = "vip.cdms"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser {}
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting
    }
}
