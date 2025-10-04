package com.evilcorp.laboratoryworktwo;

import java.util.Objects;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;

public class ApplicationChess extends Application {
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            BorderPane borderPane = FXMLLoader.load(Objects.requireNonNull(ApplicationChess.class.getResource("chess.fxml")));
            scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
