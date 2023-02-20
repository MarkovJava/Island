package com.javarush.markov.island.objects.simulation.organism.animals.herbivores;

import com.javarush.markov.island.engine.Engine;
import com.javarush.markov.island.objects.simulation.field.PlayingField;
import com.javarush.markov.island.objects.simulation.organism.animals.Animal;
import com.javarush.markov.island.objects.simulation.organism.plant.Plant;
import com.javarush.markov.island.objects.simulation.organism.Organism;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;


public abstract class Herbivores extends Animal<Plant> {

    public Herbivores(double weight, int travelSpeed, int satiety, List<String> dietList, PlayingField playingField) {
        super(weight, travelSpeed, satiety, dietList, playingField);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void eat() {
        Optional<Plant> pray;
        if(isWantEat() && isCanEatSomeone()) {
            pray = chooseVictim();
            if(pray.isPresent() && isManagedToEat(pray.get()))
                pray.get().kill();
        }
    }

    protected boolean isWantEat() {
        return getIsHunger(); // Рефактор
    }

    private boolean isManagedToEat(Organism pray) {
        //TODO
        return true;
    }

    @Override
    protected Optional<Plant> chooseVictim() {
        CopyOnWriteArrayList<? extends Organism> organismArrayInLocation = getLocation().getCreaturesInThisLocationList();
        for (int i = 0; i < organismArrayInLocation.size(); i++) {
            Organism pray = organismArrayInLocation.get(i);
            if(isIncludedInTheDiet(pray)) {
                return Optional.of((Plant) organismArrayInLocation.get(i));
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
