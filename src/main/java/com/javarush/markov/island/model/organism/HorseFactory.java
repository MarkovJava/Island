package com.javarush.markov.island.model.organism;

import com.javarush.markov.island.model.location.APILocation;

import java.util.ArrayList;

public class HorseFactory implements AbstractOrganismFactory {

    @Override
    public ArrayList<Herbivores> createHerbivores(int amount, APILocation location) {
        ArrayList<Herbivores> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            list.add(new Horse(location));
        }
        return list;
    }
}
