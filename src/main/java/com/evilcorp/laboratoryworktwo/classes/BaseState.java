package com.evilcorp.laboratoryworktwo.classes;

import java.util.List;

public abstract class BaseState {
    protected List<Integer> board;
    private static final char queenSymbol = '\u265B';

    protected BaseState(List<Integer> board) {
        this.board = board;
    }

    public int attackingPairs() {
        int pairs = 0;
        int n = board.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int row1 = i, col1 = board.get(i);
                int row2 = j, col2 = board.get(j);
                if (col1 == col2 || Math.abs(row1 - row2) == Math.abs(col1 - col2)) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public List<Integer> getBoard() {
        return board;
    }

    public boolean isGoal() {
        return attackingPairs() == 0;
    }
}
