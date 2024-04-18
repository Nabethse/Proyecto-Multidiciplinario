package com.nabethse.bufetadogados;

import com.nabethse.bufetadogados.models.Casos;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;


import java.io.IOException;

public class HelloApplication extends javafx.application.Application {
    private static Stage stageView;
    private static Stage stageRoot;
    private static Casos casos;


    @Override
    public void start(Stage stage) throws IOException {
        stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("NameApplication - Home");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void changeScene(String fxml,double width,double heigt,Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,width,heigt);

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public static void newStage(String fxml, String title) {
        stageView = new Stage();
        Scene scene = null;
        try {
            scene = new Scene(loadFXML(fxml));
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stageView.setTitle(title);
            stageView.setScene(scene);
            stageView.centerOnScreen();
            stageView.initOwner(stageRoot);
            stageView.initModality(Modality.APPLICATION_MODAL);
            stageView.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stage getStageView(){
        return stageView;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Casos getCasos() {
        return casos;
    }

    public static void main(String[] args) {
        launch();
        System.exit(1);
    }
}
