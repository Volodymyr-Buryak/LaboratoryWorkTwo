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
            for (int col = 0; col < n; col++) {
                if (col == currentCol) continue;
                List<Integer> newBoard = new ArrayList<>(board);
                newBoard.set(row, col);
                successors.add(new AStarState(newBoard, g + 1, this));
            }
        }
        return successors;
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
