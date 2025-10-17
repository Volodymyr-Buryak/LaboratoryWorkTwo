package com.evilcorp.laboratoryworktwo.classes;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class AStarState extends BaseState implements Comparable<AStarState> {
    public int g;
    public int h;
    public int fun;
    public AStarState parent;

    public AStarState(List<Integer> board) {
        super(board);
    }

    public AStarState(List<Integer> board, int g, AStarState parent) {
        this(new ArrayList<>(board));
        this.g = g;
        this.h = attackingPairs();
        this.fun = g + h;
        this.parent = parent;
    }

    public List<AStarState> generateSuccessors() {
        List<AStarState> successors = new ArrayList<>();
        int n = board.size();
        for (int row = 0; row < n; row++) {
            int currentCol = board.get(row);
            int bestCol = currentCol;
            int minConflicts = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                if (col == currentCol) continue;
                int conflicts = countConflictsAt(row, col);
                if (conflicts < minConflicts) {
                    minConflicts = conflicts;
                    bestCol = col;
                }
            }
            if (bestCol != currentCol) {
                List<Integer> newBoard = new ArrayList<>(board);
                newBoard.set(row, bestCol);
                successors.add(new AStarState(newBoard, g + 1, this));
            }
        }
        return successors;
    }

    private int countConflictsAt(int row, int newCol) {
        int conflicts = 0;
        for (int r = 0; r < board.size(); r++) {
            if (r == row) continue;
            int c = board.get(r);
            if (c == newCol || Math.abs(r - row) == Math.abs(c - newCol)) {
                conflicts++;
            }
        }
        return conflicts;
    }

    @Override
    public int compareTo(AStarState o) {
        int cmp = Integer.compare(this.fun, o.fun);
        if (cmp != 0) return cmp;
        return Integer.compare(this.h, o.h);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AStarState other)) return false;
        return Objects.equals(this.board, other.board);
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }
}
