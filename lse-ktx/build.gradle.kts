plugins {
    kotlin("multiplatform") version "1.9.22"
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
        val jsMain by getting {
            dependencies {
                implementation(project(path = ":lse-reference"))
            }
        }
    }
}
