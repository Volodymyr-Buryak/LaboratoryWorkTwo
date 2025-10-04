package com.evilcorp.laboratoryworktwo.Enum;

import java.util.Objects;
import java.io.IOException;
import java.io.InputStream;
import javafx.scene.image.Image;
import com.evilcorp.laboratoryworktwo.ApplicationChess;

public enum ChessPiece {
    QUEEN;

    private Image image;

    ChessPiece() {
        try (InputStream inputStream = Objects.requireNonNull(
                ApplicationChess.class.getResourceAsStream("img/queen.png"))) {
            this.image = new Image(inputStream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Image getImage() {
        return image;
    }
}
