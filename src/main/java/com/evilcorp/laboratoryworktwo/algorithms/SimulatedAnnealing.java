package com.evilcorp.laboratoryworktwo.algorithms;

import java.util.Random;
import com.evilcorp.laboratoryworktwo.classes.BaseState;
import com.evilcorp.laboratoryworktwo.classes.AnnealingState;

public final class SimulatedAnnealing {
    private static final int MIN_E = 0;
    private static final double MIN_TEMPERATURE = 0.001;
    private static final double COOLING_COEFFICIENT = 0.004;// k - змінний коефіцієнт
    private static final double INITIAL_TEMPERATURE = 1000.0;
    private static final Random rand = new Random();

    public static AnnealingState solve(BaseState initialState) {
        double temperature = INITIAL_TEMPERATURE;
        AnnealingState startState = ((AnnealingState) initialState).generateSuccessor();
        int E = startState.attackingPairs();
        int iteration = 0;
        while (temperature > MIN_TEMPERATURE &&  E > MIN_E) {
            AnnealingState nextState = startState.generateSuccessor();
            int E_next = nextState.attackingPairs();
            int deltaE = E_next - E;
            if (deltaE < 0) {
                startState = nextState;
                E = E_next;
            } else {
                double acceptanceProbability = Math.exp(-deltaE / temperature);
                if (rand.nextDouble() < acceptanceProbability) {
                    startState = nextState;
                    E = E_next;
                }
            }
            temperature = INITIAL_TEMPERATURE - COOLING_COEFFICIENT * iteration;
            iteration++;
        }
        System.out.println(E);
        return startState;
    }
}
