


pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    }

    plugins {
        val kotlinVersion = extra["kotlin_version"] as String
        val composeVersion = extra["compose.version"] as String
        val ktorVersion = extra["ktor_version"] as String

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)
        id("org.jetbrains.compose").version(composeVersion)
        id("io.ktor.plugin").version(ktorVersion)
    }
}

rootProject.name = "ComposeWasm"

include(":backEnd")
include(":shared")
include(":frontEnd")



