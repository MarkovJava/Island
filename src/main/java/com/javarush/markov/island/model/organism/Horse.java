package com.javarush.markov.island.model.organism;


import com.javarush.markov.island.model.location.APILocation;

import java.util.ArrayList;

public class Horse extends Herbivores {

    public Horse(APILocation location) {
        super(400, 4, 100, location, new ArrayList<>());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void run() {
        move();
    }
}
