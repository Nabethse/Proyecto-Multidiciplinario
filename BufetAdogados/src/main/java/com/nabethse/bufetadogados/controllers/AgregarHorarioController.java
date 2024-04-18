package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import com.nabethse.bufetadogados.models.Horario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgregarHorarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AgregarHorario;

    @FXML
    private TextField Asunto;

    @FXML
    private TextField Dia;

    @FXML
    private TextField Hora;

    @FXML
    private TextField Lugar;

    @FXML
    private TextField NumeroCita;

    @FXML
    private Button Salir;

    @FXML
    void onClickAgregarHorario(MouseEvent event) {
        try {
            String asunto = Asunto.getText().trim();
            String hora = Hora.getText().trim();
            String dia = Dia.getText().trim();
            String lugar = Lugar.getText().trim();
            int numeroCita = Integer.parseInt(NumeroCita.getText().trim());

            // Validación de hora en formato HH:mm
            if (!hora.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
                mostrarAlerta("Error", "Ingrese una hora válida en formato HH:mm", Alert.AlertType.ERROR);
                return;
            }

            // Validación de fecha en formato dd-MM-yyyy
            if (!dia.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
                mostrarAlerta("Error", "Ingrese una fecha válida en formato dd-MM-yyyy", Alert.AlertType.ERROR);
                return;
            }

            Horario horario = new Horario(asunto, hora, dia, lugar, numeroCita);
            if (Horario.save(horario)) {
                mostrarAlerta("Hecho", "Horario agregado con éxito", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "No se pudo agregar el horario", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ingrese un número de cita válido", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert AgregarHorario != null : "fx:id=\"AgregarHorario\" was not injected: check your FXML file 'agregarHorario-view.fxml'.";
        assert Asunto != null : "fx:id=\"Asunto\" was not injected: check your FXML file 'agregarHorario-view.fxml'.";
        assert Dia != null : "fx:id=\"Dia\" was not injected: check your FXML file 'agregarHorario-view.fxml'.";
        assert Hora != null : "fx:id=\"Hora\" was not injected: check your FXML file 'agregarHorario-view.fxml'.";
        assert Lugar != null : "fx:id=\"Lugar\" was not injected: check your FXML file 'agregarHorario-view.fxml'.";
        assert NumeroCita != null : "fx:id=\"NumeroCita\" was not injected: check your FXML file 'agregarHorario-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'agregarHorario-view.fxml'.";
    }

    // Método para mostrar una alerta
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
