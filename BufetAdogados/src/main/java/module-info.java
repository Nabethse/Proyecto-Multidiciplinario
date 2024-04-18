module com.nabethse.bufetadogados {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.nabethse.bufetadogados to javafx.fxml;
    exports com.nabethse.bufetadogados;
    exports com.nabethse.bufetadogados.controllers;
    opens com.nabethse.bufetadogados.controllers to javafx.fxml;
}