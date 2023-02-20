package com.javarush.markov.island.engine.factory;

public class Factory {

    public static SimulationObjectFactory getSimulationOrganismFactory() {
        return new SimulationOrganismFactory();
    }

}
