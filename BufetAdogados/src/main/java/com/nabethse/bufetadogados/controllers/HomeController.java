package com.nabethse.bufetadogados.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.bufetadogados.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AgregarCaso;

    @FXML
    private Button EditarCaso;

    @FXML
    private Button EliminarCaso;

    @FXML
    private Button Horario;

    @FXML
    private Button Salir;

    @FXML
    private Button VerCaso;

    @FXML
    void onClickAgregarCaso(MouseEvent event) {
        HelloApplication.newStage("agregar-view","AGREGAR");
    }

    @FXML
    void onClickEditarCaso(MouseEvent event) {
        HelloApplication.newStage("editar-view", "EDITAR");
    }

    @FXML
    void onClickEliminarCaso(MouseEvent event) {
        HelloApplication.newStage("eliminar-view","ELIMINAR");
    }

    @FXML
    void onClickHorario(MouseEvent event) {
        HelloApplication.newStage("horario-view","HORARIO");
    }

    @FXML
    void onClickSalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void onClickVerCaso(MouseEvent event) {
        HelloApplication.newStage("buscar-view","BUSCAR");
    }

    @FXML
    void initialize() {
        assert AgregarCaso != null : "fx:id=\"AgregarCaso\" was not injected: check your FXML file 'home-view.fxml'.";
        assert EditarCaso != null : "fx:id=\"EditarCaso\" was not injected: check your FXML file 'home-view.fxml'.";
        assert EliminarCaso != null : "fx:id=\"EliminarCaso\" was not injected: check your FXML file 'home-view.fxml'.";
        assert Horario != null : "fx:id=\"Horario\" was not injected: check your FXML file 'home-view.fxml'.";
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'home-view.fxml'.";
        assert VerCaso != null : "fx:id=\"VerCaso\" was not injected: check your FXML file 'home-view.fxml'.";

    }

}
