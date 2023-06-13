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

afterEvaluate {
    rootProject.extensions.configure<NodeJsRootExtension> {
        versions.webpackDevServer.version = "5.0.0"
        versions.webpackCli.version = "4.10.0"
    }
}