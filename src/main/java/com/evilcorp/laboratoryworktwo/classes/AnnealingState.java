package com.evilcorp.laboratoryworktwo.classes;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class AnnealingState extends BaseState {
    public static final Random rand = new Random();

    public AnnealingState(List<Integer> board) {
        super(board);
    }

    public AnnealingState generateSuccessor() {
        List<Integer> newBoard = new ArrayList<>(board);
        int col = rand.nextInt(newBoard.size());
        int newRow;
        do {
            newRow = rand.nextInt(newBoard.size());
        } while (newRow == newBoard.get(col));
        newBoard.set(col, newRow);
        return new AnnealingState(newBoard);
    }
}
