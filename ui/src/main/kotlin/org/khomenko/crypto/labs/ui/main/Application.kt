package org.khomenko.crypto.labs.ui.main

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.khomenko.crypto.labs.ui.controls.UserInterfaceControl

class HelloFX : Application() {
    override fun start(stage: Stage) {
        val userInterfaceControl = UserInterfaceControl()
        val scene = Scene(StackPane(userInterfaceControl))
        stage.scene = scene
        stage.width = 640.toDouble()
        stage.height = 480.toDouble()
        stage.show()
    }
}

fun main(args: Array<String>) {
    println("Hello from Kotlin")
    Application.launch(HelloFX::class.java, *args)
}