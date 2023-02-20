package com.javarush.markov.island;

import com.javarush.markov.island.engine.Engine;
import com.javarush.markov.island.engine.SimpleEngine;
import com.javarush.markov.island.engine.factory.Factory;
import com.javarush.markov.island.objects.simulation.field.Island;
import com.javarush.markov.island.objects.simulation.field.PlayingField;
import com.javarush.markov.island.objects.simulation.organism.Organism;


import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;


public class App {

    CopyOnWriteArrayList<? extends Organism> organisms;

    PlayingField playingField;


    public static void main(String[] args) throws IOException {
        new App().execute();
    }

    public void execute() {
        Island island = new Island(3,3);
        organisms = Factory.getSimulationOrganismFactory().create();
        Engine engine = new SimpleEngine(organisms, island);
        engine.start();
    }

}