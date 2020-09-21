package org.khomenko.crypto.labs.ui.controls

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import java.io.IOException


class UserInterfaceControl() : VBox() {
    private val fxmlFileName = "/user_interface_control.fxml"

    @FXML
    lateinit var label: Label

    @FXML
    lateinit var openButton: Button

    @FXML
    lateinit var closeButton: Button

    init {
        val loader = FXMLLoader(this::class.java.getResource(fxmlFileName))
        loader.setRoot(this)
        loader.setController(this)

        try {
            loader.load()
        } catch (exception: IOException) {
            throw RuntimeException(exception)
        }
    }

    @FXML
    private fun onOpenAction() {
        println("Open pressed")
    }

    @FXML
    private fun onCloseAction() {
        println("Close pressed")
    }
}