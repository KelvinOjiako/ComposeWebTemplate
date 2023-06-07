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
                api("io.github.pablichjenkov:templato-components:0.1.22")
                implementation("io.github.pablichjenkov:amadeus-api:0.1.10")
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }

}

