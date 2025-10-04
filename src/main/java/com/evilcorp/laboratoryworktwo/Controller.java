package com.evilcorp.laboratoryworktwo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.evilcorp.laboratoryworktwo.Enum.ChessPiece;
import com.evilcorp.laboratoryworktwo.Enum.AlgorithmType;

public class Controller {
    @FXML
    private Button button;
    @FXML
    private ComboBox<AlgorithmType> comboBox;
    @FXML
    private GridPane chessBoard;

    @FXML
    public void initialize() {
        InitComboBox();
    }

    private void InitComboBox() {
        ObservableList<AlgorithmType> algorithmTypes =
                FXCollections.observableArrayList(AlgorithmType.ASTAR, AlgorithmType.ANNEAL);
        comboBox.setItems(algorithmTypes);
    }

    @FXML
    private void MouseClickedInImageView (MouseEvent event) {
        ImageView view = (ImageView) event.getPickResult().getIntersectedNode();
        if (null == view.getImage()) {
            view.setImage(ChessPiece.QUEEN.getImage());
            return;
        }
        view.setImage(null);
    }

    @FXML
    private void onButtonClick() {
        AlgorithmType selectedAlgorithm = comboBox.getValue();
            switch (selectedAlgorithm) {
                case ASTAR:
                    System.out.println("A* algorithm selected");
                    break;
                case ANNEAL:
                    System.out.println("Simulated Annealing algorithm selected");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + selectedAlgorithm);
            }
    }

}
