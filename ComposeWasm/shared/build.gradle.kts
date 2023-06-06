import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {
    jvm("serverSide") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    wasm {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
            }
        }
        val composeCore by creating {
            dependsOn(commonMain)
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val serverSideMain by getting {
            dependsOn(composeCore)
            dependencies {

            }
        }

        val wasmMain by getting {
            dependsOn(composeCore)
        }
    }
}

compose.experimental {
    web.application {}
}