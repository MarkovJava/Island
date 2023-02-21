package com.javarush.markov.island.model.sector;

import com.javarush.markov.island.model.organism.Organism;

import java.util.concurrent.CopyOnWriteArrayList;

class Cell implements Sector {

    private final int x;

    private final int y;

    CopyOnWriteArrayList<Organism> objectsList;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        objectsList = new CopyOnWriteArrayList<>();
    }

    @Override
    public CopyOnWriteArrayList<Organism> getOrganismList() {
        return this.objectsList;
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
        return "\n" + "Cell {" +
                "x=" + x +
                ", y=" + y +
                ", objectsList=" + objectsList +
                '}';
    }
}
