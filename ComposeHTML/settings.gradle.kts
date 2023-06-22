pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val composeVersion = extra["compose.version"] as String
        val ktorVersion = extra["ktor.version"] as String

        kotlin("jvm").version(kotlinVersion)
        kotlin("js").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)
        id("org.jetbrains.compose").version(composeVersion)
        id("io.ktor.plugin").version(ktorVersion)
    }
}

rootProject.name = "ComposeHTML"

include(":backEnd")
include(":shared")
include(":jsFrontEnd")
