package com.javarush.markov.island.objects.simulation.organism.animals;

import com.javarush.markov.island.objects.simulation.field.PlayingField;
import com.javarush.markov.island.objects.simulation.organism.Organism;
import com.javarush.markov.island.objects.simulation.field.location.Location;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal<T extends Organism> extends Organism {

    private final int maxTravelSpeed;

    private final AtomicInteger satiety;

    private AtomicBoolean isHunger;

    private final PlayingField playingField;

    private Location location;

    private final List<String> dietList;

    public Animal(double weight, int travelSpeed, int satiety, List<String> dietList, PlayingField playingField) {
        super(weight);
        this.maxTravelSpeed = travelSpeed;
        this.satiety = new AtomicInteger(satiety);
        this.dietList = dietList;
        this.playingField = playingField;
    }

    public int getMaxTravelSpeed() {
        return maxTravelSpeed;
    }

    public int getSatiety() {
        return satiety.get();
    }

    protected void burnSatiety() {
        this.satiety.decrementAndGet();
    }
    public boolean getIsHunger() {
        return isHunger.get();
    }

    protected void setIsHunger(boolean isHunger) {
        //TODO
        throw new UnsupportedOperationException();
    }
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(int x, int y) {
        location = playingField.getLocation(x, y);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getDietList() {
        return dietList;
    }

    public void move() {
        int direction = ThreadLocalRandom.current().nextInt(5);
        switch (direction) {
            case (0):
                return;
            case (1):
                System.out.println("Север");
                break;
            case (2):
                playingField.put(this, location.getY()+1, location.getX());
                break;
            case (3):
                System.out.println("Запад");
                break;
            case (4):
                System.out.println("Восток");
                break;
        }
    }

    public abstract void eat();

    protected boolean isCanEatSomeone() {
        Location location = getLocation();
        CopyOnWriteArrayList<? extends Organism> organisms = location.getCreaturesInThisLocationList();
        for (Organism organism : organisms) {
            if(isIncludedInTheDiet(organism))
                return true;
        }
        return false;
    }

    protected boolean isIncludedInTheDiet(Organism prey) {
        List<String> dietArray = getDietList();
        for (String diet : dietArray) {
            if(prey.getName().equals(diet))
                return true;
        }
        return false;
    }

    protected abstract Optional<T> chooseVictim();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Animal animal = (Animal) o;
        return maxTravelSpeed == animal.maxTravelSpeed && satiety == animal.satiety;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxTravelSpeed, satiety);
    }
    
}
