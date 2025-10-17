package com.evilcorp.laboratoryworktwo.algorithms;

import java.util.*;
import com.evilcorp.laboratoryworktwo.classes.BaseState;
import com.evilcorp.laboratoryworktwo.classes.AStarState;

public final class AStarSolver {

    public static AStarState solve(BaseState state) {
        PriorityQueue<AStarState> openSet = new PriorityQueue<>();
        openSet.add((AStarState) state);

        Map<List<Integer>, AStarState> openMap = new HashMap<>();
        openMap.put(state.getBoard(), (AStarState) state);

        Set<List<Integer>> closedSet = new HashSet<>();

        while (!openSet.isEmpty()) {
            AStarState current = openSet.poll();
            openMap.remove(current.getBoard());

            if (current.isGoal()) {
                return current;
            }

            closedSet.add(current.getBoard());
            for (AStarState m : current.generateSuccessors()) {
                if (closedSet.contains(m.getBoard())) {
                    continue;
                }

                int tentativeG = current.g + 1;
                AStarState existingState = openMap.get(m.getBoard());

                if (existingState == null || tentativeG < existingState.g) {
                    m.g = tentativeG;
                    m.fun = m.g + m.h;
                    m.parent = current;
                    if (existingState == null) {
                        openSet.add(m);
                        openMap.put(m.getBoard(), m);
                    } else {
                        openSet.remove(existingState);
                        openSet.add(m);
                        openMap.put(m.getBoard(), m);
                    }
                }
            }
        }

        return null;
    }
}
