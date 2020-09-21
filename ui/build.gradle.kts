plugins {
    kotlin("jvm") version "1.4.10"
    application
    id("org.openjfx.javafxplugin") version "0.0.8"
}

javafx {
    version = "14"
    modules = listOf(
            "javafx.controls",
            "javafx.fxml"
    )
}

group = "org.khomenko.crypto.labs.ui"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("org.khomenko.crypto.labs.ui.main.ApplicationKt")
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "org.khomenko.crypto.labs.ui.main.ApplicationKt"
    }

    from(configurations.compileClasspath.get().files
            .map { if (it.isDirectory) it else zipTree(it) })
}