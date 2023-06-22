import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}



kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting  {
            dependencies {
                implementation(project(":shared"))
                implementation(compose.html.core)
                implementation("com.arkivanov.decompose:decompose-js:2.1.0-compose-experimental-alpha-02")
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains-js:2.1.0-compose-experimental-alpha-02")


            }
        }
    }
}

compose.experimental {
    web.application {}
}

rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
    versions.webpackCli.version = "5.0.0"
}

