package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import com.nabethse.bufetadogados.models.Usuarios;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InicioSesionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Contraseña;

    @FXML
    private Button Ingresar;

    @FXML
    private Button Salir;

    @FXML
    private TextField Usuario;

    @FXML
    void onClickIngresar(MouseEvent event) {
        String usuario = Usuario.getText();
        String contraseña = Contraseña.getText();
        if (autenticarUsuario(usuario, contraseña)) {
            HelloApplication.newStage("home-view","HOME");
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos");
        }
    }
    private boolean autenticarUsuario(String usuario,String contraseña){
        return usuario.equals("usuarioadriana")&& contraseña.equals("contraseña123");
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Contraseña != null : "fx:id=\"Contraseña\" was not injected: check your FXML file 'inicioSesion-view.fxml'.";
        assert Ingresar != null : "fx:id=\"Ingresar\" was not injected: check your FXML file 'inicioSesion-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'inicioSesion-view.fxml'.";
        assert Usuario != null : "fx:id=\"Usuario\" was not injected: check your FXML file 'inicioSesion-view.fxml'.";
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
