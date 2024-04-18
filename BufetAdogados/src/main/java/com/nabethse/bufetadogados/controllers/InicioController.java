package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class InicioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button IniciarSecion;

    @FXML
    private Button Salir;

    @FXML
    private Label welcomeText;

    @FXML
    void onClickIniciarSecion(MouseEvent event) {
        HelloApplication.newStage("inicioSesion-view","SESION");
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert IniciarSecion != null : "fx:id=\"IniciarSecion\" was not injected: check your FXML file 'inicio-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'inicio-view.fxml'.";
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'inicio-view.fxml'.";

    }

}
