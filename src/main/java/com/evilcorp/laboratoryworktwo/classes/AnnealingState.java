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
        int i = rand.nextInt(newBoard.size());
        int newCol;
        do {
            newCol = rand.nextInt(newBoard.size());
        } while (newCol == newBoard.get(i));
        newBoard.set(i, newCol);
        return new AnnealingState(newBoard);
    }
}
