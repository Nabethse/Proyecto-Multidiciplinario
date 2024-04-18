package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.nabethse.bufetadogados.models.Horario;

public class EditarHorarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AsuntoEditado;

    @FXML
    private TextField DiaEditado;

    @FXML
    private TextField HoraEditado;

    @FXML
    private TextField LugarEditado;

    @FXML
    private TextField NumeroCita;

    @FXML
    private Button Salir;

    @FXML
    private Button editarHorario;

    @FXML
    void onClickEditarHorario(MouseEvent event) {
        try {
            int numeroCita = Integer.parseInt(NumeroCita.getText().trim());

            // Buscar el horario por su número de cita
            Horario horario = Horario.buscarHorarioPorNumeroCita(numeroCita);

            if (horario != null) {
                // Obtener los valores originales del horario
                String asuntoOriginal = horario.getAsunto();
                String horaOriginal = horario.getHora();
                String diaOriginal = horario.getFecha();
                String lugarOriginal = horario.getLugar();

                // Actualizar los campos del horario solo si se editaron
                String asuntoNuevo = AsuntoEditado.getText().trim().isEmpty() ? asuntoOriginal : AsuntoEditado.getText().trim();
                String horaNueva = HoraEditado.getText().trim().isEmpty() ? horaOriginal : HoraEditado.getText().trim();
                String diaNuevo = DiaEditado.getText().trim().isEmpty() ? diaOriginal : DiaEditado.getText().trim();
                String lugarNuevo = LugarEditado.getText().trim().isEmpty() ? lugarOriginal : LugarEditado.getText().trim();

                // Actualizar los campos del horario
                horario.setAsunto(asuntoNuevo);
                horario.setHora(horaNueva);
                horario.setFecha(diaNuevo);
                horario.setLugar(lugarNuevo);

                mostrarAlerta("Hecho", "Horario editado con éxito", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "No se encontró ningún horario con ese número de cita", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El número de cita debe ser un valor numérico válido", Alert.AlertType.ERROR);
        } catch (Exception e) {
            mostrarAlerta("Error", "Ha ocurrido un error al editar el horario: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert AsuntoEditado != null : "fx:id=\"AsuntoEditado\" was not injected: check your FXML file 'editarHorario-view.fxml'.";
        assert DiaEditado != null : "fx:id=\"DiaEditado\" was not injected: check your FXML file 'editarHorario-view.fxml'.";
        assert HoraEditado != null : "fx:id=\"HoraEditado\" was not injected: check your FXML file 'editarHorario-view.fxml'.";
        assert LugarEditado != null : "fx:id=\"LugarEditado\" was not injected: check your FXML file 'editarHorario-view.fxml'.";
        assert NumeroCita != null : "fx:id=\"NumeroCita\" was not injected: check your FXML file 'editarHorario-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'editarHorario-view.fxml'.";
        assert editarHorario != null : "fx:id=\"editarHorario\" was not injected: check your FXML file 'editarHorario-view.fxml'.";
    }

    // Método para mostrar una alerta
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
