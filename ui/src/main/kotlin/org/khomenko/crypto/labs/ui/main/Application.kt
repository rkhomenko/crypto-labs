package org.khomenko.crypto.labs.ui.main

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

class HelloFX : Application() {
    override fun start(stage: Stage) {
        val javaVersion = System.getProperty("java.version")
        val javafxVersion = System.getProperty("javafx.version")
        val l = Label("Hello, JavaFX $javafxVersion, running on Java $javaVersion.")
        val scene = Scene(StackPane(l), 640.toDouble(), 480.toDouble())
        stage.scene = scene
        stage.show()
    }

    companion object {
        @JvmStatic
        fun run(args: Array<String>) {
            launch(HelloFX::class.java, *args)
        }
    }
}

fun main(args: Array<String>) {
    println("Hello from Kotlin")
    HelloFX.run(args);
}