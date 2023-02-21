package com.javarush.markov.island.model.organism;

import com.javarush.markov.island.model.sector.Sector;
import com.javarush.markov.island.model.location.APILocation;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Herbivores extends Animal<Plant> {

    public Herbivores(int weight, int maxSpeed, int satiety, APILocation location, List<Plant> dietList) {
        super(weight, maxSpeed, satiety, location, dietList);
    }

    @Override
    public void eat() {
        if(isHungry()) {
            Optional<Plant> pray = findFood();
        }
    }

    private Optional<Plant> findFood() {
        Sector sector = getPosition();
        Plant pray = null;
        CopyOnWriteArrayList<Organism> organisms = sector.getOrganismList();
        for (Organism organism : organisms) {
            if (isCanEat(organism) && organism.isAlive()) {
                organism.kill();
                pray = (Plant) organism;
                break;
            }
        }
        return Optional.ofNullable(pray);
    }

    private boolean isCanEat(Organism organism) {
        return getDietList().contains(organism);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
