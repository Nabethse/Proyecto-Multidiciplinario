package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import com.nabethse.bufetadogados.models.Casos;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EditarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Editar;

    @FXML
    private TextArea InformacionCasoEditada;

    @FXML
    private TextField NombreAbogadoEditado;

    @FXML
    private TextField NombreCasoEditado;

    @FXML
    private TextField NumeroCaso;

    @FXML
    private TextField TipoCasoEditado;

    @FXML
    private Button salir;

    // Lista para almacenar los casos
    private ArrayList<Casos> casosList;

    @FXML
    void onClickEditar(MouseEvent event) {
        try {
            int numeroCaso = Integer.parseInt(NumeroCaso.getText().trim());

            // Buscar el caso por su número
            Casos caso = buscarCasoPorNumero(numeroCaso);

            if (caso != null) {
                // Actualizar los campos del caso solo si se proporcionan nuevos valores
                String nuevoNombreAbogado = NombreAbogadoEditado.getText().trim();
                String nuevoNombreCaso = NombreCasoEditado.getText().trim();
                String nuevoTipoCaso = TipoCasoEditado.getText().trim();
                String nuevaInformacion = InformacionCasoEditada.getText().trim();

                if (!nuevoNombreAbogado.isEmpty()) {
                    caso.setNombreAbogado(nuevoNombreAbogado);
                }
                if (!nuevoNombreCaso.isEmpty()) {
                    caso.setNombreCaso(nuevoNombreCaso);
                }
                if (!nuevoTipoCaso.isEmpty()) {
                    caso.setTipoCaso(nuevoTipoCaso);
                }
                if (!nuevaInformacion.isEmpty()) {
                    caso.setInformacion(nuevaInformacion);
                }

                mostrarAlerta("Hecho", "Caso editado con éxito", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "No se encontró ningún caso con ese número", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El número de caso debe ser un valor numérico válido", Alert.AlertType.ERROR);
        } catch (Exception e) {
            mostrarAlerta("Error", "Ha ocurrido un error al editar el caso: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Editar != null : "fx:id=\"Editar\" was not injected: check your FXML file 'editar-view.fxml'.";
        assert InformacionCasoEditada != null : "fx:id=\"InformacionCasoEditada\" was not injected: check your FXML file 'editar-view.fxml'.";
        assert NombreAbogadoEditado != null : "fx:id=\"NombreAbogadoEditado\" was not injected: check your FXML file 'editar-view.fxml'.";
        assert NombreCasoEditado != null : "fx:id=\"NombreCasoEditado\" was not injected: check your FXML file 'editar-view.fxml'.";
        assert NumeroCaso != null : "fx:id=\"NumeroCaso\" was not injected: check your FXML file 'editar-view.fxml'.";
        assert TipoCasoEditado != null : "fx:id=\"TipoCasoEditado\" was not injected: check your FXML file 'editar-view.fxml'.";
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'editar-view.fxml'.";

        // Inicializa la lista de casos
        casosList = Casos.getCasosList(); // Obtener la lista de casos
    }

    // Método para mostrar una alerta
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Método para buscar un caso por su número
    private Casos buscarCasoPorNumero(int numeroCaso) {
        for (Casos caso : casosList) {
            if (caso.getNumerocaso() == numeroCaso) {
                return caso;
            }
        }
        return null;
    }
}
