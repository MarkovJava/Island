package com.javarush.markov.island.objects.simulation.field.location;

import com.javarush.markov.island.objects.simulation.organism.Organism;

import java.util.concurrent.CopyOnWriteArrayList;

public class Cell implements Location {

    private final int x;

    private final int y;

    private CopyOnWriteArrayList<Organism> arrayObjectSimulation;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.arrayObjectSimulation = new CopyOnWriteArrayList<>();
    }

    @Override
    public CopyOnWriteArrayList<Organism> getCreaturesInThisLocationList() {
        return this.arrayObjectSimulation;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Cell {" +
                "x=" + x +
                ", y=" + y +
                ", arrayObjectSimulation=" + arrayObjectSimulation +
                '}';
    }
}
