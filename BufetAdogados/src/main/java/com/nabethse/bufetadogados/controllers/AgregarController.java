package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import com.nabethse.bufetadogados.models.Casos;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgregarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AgregarCaso;

    @FXML
    private TextArea InformacionCaso;

    @FXML
    private TextField NombreAbogado;

    @FXML
    private TextField NombreCaso;

    @FXML
    private TextField NumeroCaso;

    @FXML
    private Button Salir;

    @FXML
    private TextField TipoCaso;

    @FXML
    void onClickAgregarCaso(MouseEvent event) {
        if (InformacionCaso.getText().trim().isEmpty() || NombreAbogado.getText().trim().isEmpty() ||
                NombreCaso.getText().trim().isEmpty() || NumeroCaso.getText().trim().isEmpty() ||
                TipoCaso.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.INFORMATION);
        } else {
            try {
                String nombreAbogado = NombreAbogado.getText();
                String nombreCaso = NombreCaso.getText();
                String tipoCaso = TipoCaso.getText();
                String informacion = InformacionCaso.getText();
                int numeroCaso = Integer.parseInt(NumeroCaso.getText());
                Casos caso = new Casos(nombreCaso, tipoCaso, nombreAbogado, informacion, numeroCaso);
                if (caso.save()) {
                    mostrarAlerta("Hecho", "Caso agregado con éxito", Alert.AlertType.INFORMATION);
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "El número de caso debe ser un valor numérico válido", Alert.AlertType.ERROR);
            } catch (Exception e) {
                mostrarAlerta("Error", "Ha ocurrido un error al agregar el caso: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert AgregarCaso != null : "fx:id=\"AgregarCaso\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert InformacionCaso != null : "fx:id=\"InformacionCaso\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert NombreAbogado != null : "fx:id=\"NombreAbogado\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert NombreCaso != null : "fx:id=\"NombreCaso\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert NumeroCaso != null : "fx:id=\"NumeroCaso\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert TipoCaso != null : "fx:id=\"TipoCaso\" was not injected: check your FXML file 'agregar-view.fxml'.";
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
