package com.nabethse.bufetadogados.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import com.nabethse.bufetadogados.models.Usuarios;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;

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
    void onClickIngresar(MouseEvent event) throws IOException {
        String nombre = Usuario.getText();
        String clave = Contraseña.getText();
        if (nombre.isEmpty() || clave.isEmpty()) {
            mostrarAlerta("Ingrese usuario y contraseña");
            return;
        }
        Usuarios usuarios = new Usuarios(nombre,clave);
        if (usuarios.validarIniciarSesion()){
            System.out.println("Inicio de sesion exitoso para el usuario:"+ nombre);
            try{
                Stage stage = (Stage) Ingresar.getScene().getWindow();
                HelloApplication.changeScene("home-view.fxml",600,400,stage);
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("Inicio de sesion fallido");
            mostrarAlerta("Inicio de sesion fallido");
        }
    }


    @FXML
    void onClickSalir(MouseEvent event) {
        Stage stage =(Stage) Salir.getScene().getWindow();
        stage.close();
    }
    protected void mostrarAlerta (String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuario");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert Contraseña != null : "fx:id=\"Contraseña\" was not injected: check your FXML file 'inicioSesion-view.fxml'.";
        assert Ingresar != null : "fx:id=\"Ingresar\" was not injected: check your FXML file 'inicioSesion-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'inicioSesion-view.fxml'.";
        assert Usuario != null : "fx:id=\"Usuario\" was not injected: check your FXML file 'inicioSesion-view.fxml'.";

    }

}
