plugins {
    kotlin("jvm") version "2.2.0"

    alias(libs.plugins.kotlinPluginSerialization)
    alias(libs.plugins.ktlint)
}

group = "dev.lizainslie.moeka"
version = "0.0.1"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.lizainslie.dev/repository/maven-public/")
    }
}

dependencies {
    api(libs.bundles.moeka)
    implementation(libs.kord.core)
    implementation(libs.bundles.exposed)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
