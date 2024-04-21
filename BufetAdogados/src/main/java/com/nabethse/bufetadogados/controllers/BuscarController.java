package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.models.Casos;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BuscarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BuscarCaso;

    @FXML
    private TextField NumeroCaso;

    @FXML
    private Button Salir;

    @FXML
    void onClickBuscarCaso(MouseEvent event) {
        try {
            int numeroCaso = Integer.parseInt(NumeroCaso.getText().trim());
            Casos caso = buscarCasoPorNumero(numeroCaso);
            if (caso != null) {
                CustomAlert alert = new CustomAlert(Alert.AlertType.INFORMATION);
                alert.setTitle("Caso encontrado");
                alert.setContentText("Nombre del caso: " + caso.getNombreCaso() + "\nTipo de caso: " + caso.getTipoCaso() +
                        "\nNombre del abogado: " + caso.getNombreAbogado() + "\nInformación: " + caso.getInformacion());
                alert.showAndWait();
            } else {
                CustomAlert alert = new CustomAlert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("No se encontró ningún caso con ese número");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            CustomAlert alert = new CustomAlert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("El número de caso debe ser un valor numérico válido");
            alert.showAndWait();
        }
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        Stage stage = (Stage) Salir.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert BuscarCaso != null : "fx:id=\"BuscarCaso\" was not injected: check your FXML file 'buscar-view.fxml'.";
        assert NumeroCaso != null : "fx:id=\"NumeroCaso\" was not injected: check your FXML file 'buscar-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'buscar-view.fxml'.";
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private Casos buscarCasoPorNumero(int numeroCaso) {
        List<Casos> casosList = Casos.getCasosList();
        int size = casosList.size();
        for (int i = 0; i < size; i++) {
            Casos caso = casosList.get(i);
            if (caso.getNumerocaso() == numeroCaso) {
                return caso;
            }
        }
        return null;
    }
}
