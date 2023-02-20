package com.javarush.markov.island.objects.simulation.field.location;

import com.javarush.markov.island.objects.simulation.organism.Organism;

import java.util.concurrent.CopyOnWriteArrayList;

public interface Location {

    CopyOnWriteArrayList<Organism> getCreaturesInThisLocationList();

    int getX();

    int getY();


}
