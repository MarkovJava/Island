package com.javarush.markov.island.model.organism;


import com.javarush.markov.island.model.location.APILocation;

import java.util.ArrayList;

public interface AbstractOrganismFactory {

    ArrayList<Herbivores> createHerbivores(int amount, APILocation location);

}
