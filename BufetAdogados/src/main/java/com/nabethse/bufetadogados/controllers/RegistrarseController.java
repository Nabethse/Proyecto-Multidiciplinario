package com.nabethse.bufetadogados.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.nabethse.bufetadogados.models.Abogado;
import com.nabethse.bufetadogados.models.Pasante;
import com.nabethse.bufetadogados.models.Usuarios;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegistrarseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button AltaBttn;

    @FXML
    private TextField Clave;

    @FXML
    private TextField Clave2;

    @FXML
    private TextField Correo;

    @FXML
    private TextField Nombre;

    @FXML
    private Button Registrarse;

    @FXML
    private Button Salir;

    @FXML
    private TextField Usuario;

    @FXML
    void onClickRegistrarse(MouseEvent event) {
        String nombre = Nombre.getText();
        String usuario = Usuario.getText();
        String correo = Correo.getText();
        String clave = Clave.getText();
        String clave2 = Clave2.getText();

        if (nombre.isEmpty() || usuario.isEmpty() || correo.isEmpty() || clave.isEmpty() || clave2.isEmpty()) {
            mostrarAlerta("Campos Vacíos", "Por favor, complete todos los campos.");
            return;
        }

        if (!Pattern.matches(".*@gmail\\.com",correo)) {
            mostrarAlerta("Correo invalido", "Ingrese un correo con Gmail valido.");
            return;
        }
        if (!clave.equals(clave2)){
            mostrarAlerta("Contraseñas incorectas","Las contraseñas no coinciden");
            return;
        }
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inicioSesion-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) AltaBttn.getScene().getWindow();
            currentStage.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        // Cerrar la ventana actual
    }

    @FXML
    void initialize() {
        assert AltaBttn != null : "fx:id=\"AltaBttn\" was not injected: check your FXML file 'inicio-view.fxml'.";
        assert Clave != null : "fx:id=\"Clave\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert Clave2 != null : "fx:id=\"Clave2\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert Correo != null : "fx:id=\"Correo\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert Nombre != null : "fx:id=\"Nombre\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert Registrarse != null : "fx:id=\"Registrarse\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert Usuario != null : "fx:id=\"Usuario\" was not injected: check your FXML file 'registrarse-view.fxml'.";
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
