package com.evilcorp.laboratoryworktwo.Enum;

public enum AlgorithmType {
    ASTAR("A*"),
    ANNEAL("ЛПСВ");

    private final String name;

    AlgorithmType(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
