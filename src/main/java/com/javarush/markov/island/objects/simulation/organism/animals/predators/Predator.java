package com.javarush.markov.island.objects.simulation.organism.animals.predators;

import com.javarush.markov.island.objects.simulation.field.PlayingField;
import com.javarush.markov.island.objects.simulation.organism.animals.Animal;
import com.javarush.markov.island.objects.simulation.organism.Organism;

import java.util.List;
import java.util.Optional;

public abstract class Predator extends Animal {

    public Predator(double weight, int travelSpeed, int satiety, List<String> dietList, PlayingField playingField) {
        super(weight, travelSpeed, satiety, dietList, playingField);
    }

    @Override
    public void eat() {

    }

    @Override
    protected boolean isCanEatSomeone() {
        return false;
    }

    @Override
    protected Optional<? extends Organism> chooseVictim() {
        return null;
    }
}
