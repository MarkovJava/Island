package com.javarush.markov.island.engine;

import com.javarush.markov.island.objects.simulation.field.PlayingField;
import com.javarush.markov.island.objects.simulation.organism.Organism;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleEngine implements Engine {

    private final CopyOnWriteArrayList<? extends Organism> objectsSimulation;

    private final PlayingField playingField;

    public SimpleEngine(CopyOnWriteArrayList<? extends Organism> objectsSimulation, PlayingField playingField) {
        this.objectsSimulation = objectsSimulation;
        this.playingField = playingField;
    }

    @Override
    public void start() {
        fillInLocation();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(playingField);
        System.out.println("-----------------------------");
        System.out.println(objectsSimulation);
        for (Organism organism : objectsSimulation) {
            executorService.execute(organism);
        }
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println(playingField);
    }

    void fillInLocation() {
        playingField.putAll(objectsSimulation, 1,1);
    }

    @Override
    public String toString() {
        return "SimpleEngine{" +
                "objectsSimulation=" + objectsSimulation +
                ", playingField=" + playingField +
                '}';
    }
}
