package com.javarush.markov.island.engine.factory;

import com.javarush.markov.island.objects.simulation.organism.Organism;

import java.util.concurrent.CopyOnWriteArrayList;

public interface SimulationObjectFactory {

    CopyOnWriteArrayList<? extends Organism> create();

}
