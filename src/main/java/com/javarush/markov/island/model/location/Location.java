package com.javarush.markov.island.model.location;

import com.javarush.markov.island.model.organism.Organism;
import com.javarush.markov.island.model.sector.Sector;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface Location extends APILocation {

    Sector getSector(int x, int y);

    CopyOnWriteArrayList<? extends Sector> getSectorAll();

    boolean putAll(List<? extends Organism> organisms, int x, int y);

}
