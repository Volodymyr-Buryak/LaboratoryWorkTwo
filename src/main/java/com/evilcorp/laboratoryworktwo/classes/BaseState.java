package com.evilcorp.laboratoryworktwo.classes;

import java.util.List;

public abstract class BaseState {
    protected List<Integer> board;
    private static final char queenSymbol = '\u265B';

    protected BaseState(List<Integer> board) {
        this.board = board;
    }

    // Підрахунок кількості пар ферзів, які атакують один одного (індекс — колонка, значення — рядок)
    public int attackingPairs() {
        int pairs = 0;
        int n = board.size();
        for (int col1 = 0; col1 < n; col1++) {
            int row1 = board.get(col1);
            for (int col2 = col1 + 1; col2 < n; col2++) {
                int row2 = board.get(col2);
                if (row1 == row2) {
                    pairs++;
                }
                if (Math.abs(col1 - col2) == Math.abs(row1 - row2)) {
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
