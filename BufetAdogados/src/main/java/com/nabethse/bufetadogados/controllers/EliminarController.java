package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import com.nabethse.bufetadogados.models.Casos;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EliminarController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EliminarCaso;

    @FXML
    private TextField NumeroCaso;

    @FXML
    private Button Salir;

    @FXML
    void onClickEliminarCaso(MouseEvent event) {
        try {
            int numeroCaso = Integer.parseInt(NumeroCaso.getText().trim());
            Casos caso = buscarCasoPorNumero(numeroCaso);
            if (caso != null) {
                Casos.eliminarCaso(caso);
                mostrarAlerta("Caso Eliminado", "El caso se ha eliminado correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "No se encontró ningún caso con ese número", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ingrese un número de caso válido", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert EliminarCaso != null : "fx:id=\"EliminarCaso\" was not injected: check your FXML file 'eliminar-view.fxml'.";
        assert NumeroCaso != null : "fx:id=\"NumeroCaso\" was not injected: check your FXML file 'eliminar-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'eliminar-view.fxml'.";
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

