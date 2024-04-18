package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import com.nabethse.bufetadogados.models.Horario;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class VerHorarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Horario, String> Asunto;

    @FXML
    private TableColumn<Horario, String> Dia;

    @FXML
    private TableColumn<Horario, String> Hora;

    @FXML
    private TableColumn<Horario, String> Lugar;

    @FXML
    private TableColumn<Horario, Integer> NumeroCita;

    @FXML
    private Button Salir;

    @FXML
    private TableView<Horario> TablaHorario;

    @FXML
    private AnchorPane Vista;

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Asunto != null : "fx:id=\"Asunto\" was not injected: check your FXML file 'verHorario-view.fxml'.";
        assert Dia != null : "fx:id=\"Dia\" was not injected: check your FXML file 'verHorario-view.fxml'.";
        assert Hora != null : "fx:id=\"Hora\" was not injected: check your FXML file 'verHorario-view.fxml'.";
        assert Lugar != null : "fx:id=\"Lugar\" was not injected: check your FXML file 'verHorario-view.fxml'.";
        assert NumeroCita != null : "fx:id=\"NumeroCita\" was not injected: check your FXML file 'verHorario-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'verHorario-view.fxml'.";
        assert TablaHorario != null : "fx:id=\"TablaHorario\" was not injected: check your FXML file 'verHorario-view.fxml'.";
        assert Vista != null : "fx:id=\"Vista\" was not injected: check your FXML file 'verHorario-view.fxml'.";

        Asunto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAsunto()));
        Dia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
        Hora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHora()));
        Lugar.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLugar()));
        NumeroCita.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumeroCita()).asObject());

        ArrayList<Horario> horarios = Horario.getHorariosList();
        TablaHorario.getItems().addAll(horarios);
    }
}
