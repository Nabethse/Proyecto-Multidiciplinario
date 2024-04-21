package com.nabethse.bufetadogados.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;

public class CustomAlert extends Alert {
    public CustomAlert(AlertType alertType, String s, ButtonType... buttonTypes) {
        super(alertType, s, buttonTypes);
    }
    public CustomAlert(AlertType alertType) {
        super(alertType);
        DialogPane dialogPane = getDialogPane();
        dialogPane.setPrefWidth(600);
        dialogPane.setPrefHeight(400);
    }
}
