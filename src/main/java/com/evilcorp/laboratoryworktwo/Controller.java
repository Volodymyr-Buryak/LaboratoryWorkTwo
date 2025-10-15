package com.evilcorp.laboratoryworktwo;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Node;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
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

    private int count;
    private List<Integer> board;

    @FXML
    public void initialize() {
        InitComboBox();
        board = new ArrayList<>(Collections.nCopies(8, -1));
    }

    private void InitComboBox() {
        ObservableList<AlgorithmType> algorithmTypes =
                FXCollections.observableArrayList(AlgorithmType.ASTAR, AlgorithmType.ANNEAL);
        comboBox.setItems(algorithmTypes);
    }

    @FXML
    private void MouseClickedInImageView (MouseEvent event) {
        Node node =  event.getPickResult().getIntersectedNode();

        Integer rowIndex = GridPane.getRowIndex(event.getPickResult().getIntersectedNode());
        Integer colIndex = GridPane.getColumnIndex(event.getPickResult().getIntersectedNode());

        int row = (rowIndex == null) ? 0 : rowIndex;
        int col = (colIndex == null) ? 0 : colIndex;

        ImageView view = (ImageView) node;
        if (null == view.getImage() && count <= 7 && board.get(col) == -1) {
            count++;
            board.set(col, row);
            System.out.println(board);
            view.setImage(ChessPiece.QUEEN.getImage());
        } else if (null != view.getImage()) {
            count--;
            board.set(col, -1);
            System.out.println(board);
            view.setImage(null);
        }
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
