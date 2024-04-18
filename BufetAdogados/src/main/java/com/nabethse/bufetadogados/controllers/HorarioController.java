package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HorarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AgregarC;

    @FXML
    private Button EditarC;

    @FXML
    private Button EliminarH;

    @FXML
    private Button Salir;

    @FXML
    private Button VerA;

    @FXML
    void onClickAgregarC(MouseEvent event) {
        HelloApplication.newStage("agregarHorario-view","AGREGARH");
    }

    @FXML
    void onClickEditarC(MouseEvent event) {
        HelloApplication.newStage("editarHorario-view","EDITARH");
    }

    @FXML
    void onClickEliminarH(MouseEvent event) {
        HelloApplication.newStage("eliminarHorario-view","ELIMINARH");
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void onClickVerA(MouseEvent event) {
        HelloApplication.newStage("verHorario-view","VERH");
    }

    @FXML
    void initialize() {
        assert AgregarC != null : "fx:id=\"AgregarC\" was not injected: check your FXML file 'horario-view.fxml'.";
        assert EditarC != null : "fx:id=\"EditarC\" was not injected: check your FXML file 'horario-view.fxml'.";
        assert EliminarH != null : "fx:id=\"EliminarH\" was not injected: check your FXML file 'horario-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'horario-view.fxml'.";
        assert VerA != null : "fx:id=\"VerA\" was not injected: check your FXML file 'horario-view.fxml'.";

    }

}
