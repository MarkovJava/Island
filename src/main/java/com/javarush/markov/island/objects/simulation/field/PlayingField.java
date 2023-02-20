package com.javarush.markov.island.objects.simulation.field;

import com.javarush.markov.island.objects.simulation.field.location.Location;
import com.javarush.markov.island.objects.simulation.organism.Organism;
import com.javarush.markov.island.objects.simulation.organism.animals.Animal;

import java.util.concurrent.CopyOnWriteArrayList;

public interface PlayingField {

    Location getLocation(int x, int y);

    void putAll(CopyOnWriteArrayList<? extends Organism> organisms, int x, int y);

    void put(Animal animal, int x, int y);

    CopyOnWriteArrayList<? extends Location> getAllLocationList();

}
