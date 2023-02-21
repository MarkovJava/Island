package com.javarush.markov.island.model.location;

import com.javarush.markov.island.model.organism.Organism;

public interface APILocation {

    boolean put(Organism organism, int x, int y);

}
