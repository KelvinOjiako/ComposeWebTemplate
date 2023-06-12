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

                implementation("com.arkivanov.decompose:decompose-js:2.1.0-compose-experimental-alpha-02")
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains-js:2.1.0-compose-experimental-alpha-02")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }

}

