plugins {
    kotlin("jvm") version "1.4.10"
    application
    id("org.openjfx.javafxplugin") version "0.0.8"
}

javafx {
    version = "14"
    modules = listOf("javafx.controls")
}

group = "org.khomenko.crypto.labs.ui"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}
