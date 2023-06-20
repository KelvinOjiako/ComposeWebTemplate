


plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {

    // JS
    js(IR) {
        browser()
    }
    sourceSets {
        // COMMON
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
                api(compose.animation)

                implementation("com.arkivanov.decompose:decompose:2.1.0-compose-experimental-alpha-02")
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains:2.1.0-compose-experimental-alpha-02")

                val ktor_version = "2.3.1"
                implementation("io.ktor:ktor-client-core:$ktor_version")

                implementation("io.ktor:ktor-client-js:$ktor_version")
                implementation("io.ktor:ktor-client-auth:$ktor_version")
                implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }

}

