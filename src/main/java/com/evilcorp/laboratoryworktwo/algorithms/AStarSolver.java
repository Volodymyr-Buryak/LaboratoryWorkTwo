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

            // для кожної допустимої дії
            for (AStarState m : current.generateSuccessors()) {
                // якщо m ∈ CLOSED: продовжити
                if (closedSet.contains(m.getBoard())) {
                    continue;
                }

                int tentativeG = current.g + 1;

                // якщо m ∉ OPEN або tentative_g < g(m)
                AStarState existingState = openMap.get(m.getBoard());

                if (existingState == null || tentativeG < existingState.g) {
                    // g(m) ← tentative_g
                    m.g = tentativeG;
                    // f(m) ← g(m) + h(m)
                    m.fun = m.g + m.h;
                    // parent(m) ← n
                    m.parent = current;

                    // якщо m ∉ OPEN: додати m у OPEN
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
