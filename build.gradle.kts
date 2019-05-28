import Build_gradle.Versions.kotlinVersion

object Versions {
    const val kotlinVersion = "1.3.31"
}

plugins {
    kotlin ("multiplatform") version "1.3.31"
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js()
    wasm32 {
        binaries {
            executable()
        }
    }
    linuxX64 {
        binaries {
            executable()
        }
    }


    sourceSets {
        val commonMain by getting {
            kotlin.srcDir("src")
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion")
            }
        }
    }
}

