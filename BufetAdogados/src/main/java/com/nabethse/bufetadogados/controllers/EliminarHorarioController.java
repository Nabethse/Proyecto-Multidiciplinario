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

public class EliminarHorarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EliminarHorario;

    @FXML
    private TextField NumeroCita;

    @FXML
    private Button salir;

    @FXML
    void onClickEliminarHorario(MouseEvent event) {
        try {
            int numeroCitaEliminar = Integer.parseInt(NumeroCita.getText().trim());

            // Buscar el horario por su número de cita
            Horario horarioEliminar = Horario.buscarHorarioPorNumeroCita(numeroCitaEliminar);

            if (horarioEliminar != null) {
                // Eliminar el horario de la lista
                if (Horario.getHorariosList().remove(horarioEliminar)) {
                    mostrarAlerta("Éxito", "El horario ha sido eliminado correctamente", Alert.AlertType.INFORMATION);
                } else {
                    mostrarAlerta("Error", "No se pudo eliminar el horario", Alert.AlertType.ERROR);
                }
            } else {
                mostrarAlerta("Error", "No se encontró ningún horario con ese número de cita", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ingrese un número de cita válido", Alert.AlertType.ERROR);
        } catch (Exception e) {
            mostrarAlerta("Error", "Ha ocurrido un error al eliminar el horario: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert EliminarHorario != null : "fx:id=\"EliminarHorario\" was not injected: check your FXML file 'eliminarHorario-view.fxml'.";
        assert NumeroCita != null : "fx:id=\"NumeroCita\" was not injected: check your FXML file 'eliminarHorario-view.fxml'.";
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'eliminarHorario-view.fxml'.";
    }

    // Método para mostrar una alerta
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
