import Build_gradle.Versions.kotlinVersion

object Versions {
    const val kotlinVersion = "1.3.31"
}

plugins {
    kotlin("multiplatform") version "1.3.31"
}

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
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
            kotlin.srcDir("commonMain")
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")
            }
        }
        val jsMain by getting {
            kotlin.srcDir("jsMain")
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion")
            }
        }
        val wasm32Main by getting {
            kotlin.srcDir("wasm32Main")
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
            }
        }
        val linuxX64Main by getting {
            kotlin.srcDir("linuxX64Main")
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
            }
        }
    }
}

