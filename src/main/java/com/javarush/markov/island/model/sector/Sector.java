package com.javarush.markov.island.model.sector;

import com.javarush.markov.island.model.organism.Organism;

import java.util.concurrent.CopyOnWriteArrayList;

public interface Sector {

    CopyOnWriteArrayList<Organism> getOrganismList();

    int getX();

    int getY();

}
