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

    public static void printBoard(BaseState state) {
        List<Integer> board = state.getBoard();
        int n = board.size();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(board.get(col) == row ? queenSymbol + " " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
