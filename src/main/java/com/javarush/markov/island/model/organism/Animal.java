package com.javarush.markov.island.model.organism;

import com.javarush.markov.island.model.sector.Sector;
import com.javarush.markov.island.model.location.APILocation;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal<T> implements Organism, CanMove {

    private final String name;

    private AtomicInteger weight;

    private final int maxSpeed;

    private final int satiety;

    private final List<T> dietList;

    private final APILocation location;

    private Sector position;

    private boolean isAlive;

    private boolean isHungry;

    public Animal(int weight, int maxSpeed, int satiety, APILocation location, List<T> dietList) {
        this.name = this.getClass().getSimpleName();
        this.weight = new AtomicInteger(weight);
        this.maxSpeed = maxSpeed;
        this.satiety = satiety;
        this.location = location;
        this.dietList = dietList;
        this.isAlive = true;
    }

    public String getName() {
        return this.name;
    }

    public AtomicInteger getWeight() {
        return this.weight;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getSatiety() {
        return this.satiety;
    }

    public List<T> getDietList() {
        return this.dietList;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean isHungry() {
        return this.isHungry;
    }

    @Override
    public Sector getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Sector position) {
        this.position = position;
    }

    @Override
    public void kill() {
        this.isAlive = false;
    }

    @Override
    public synchronized void move() {
        int directionOfTravel = ThreadLocalRandom.current().nextInt(0, 5);
        switch (directionOfTravel) {
            case 0:
                return;
            case 1:
                location.put(this, position.getX(), position.getY()+1);
                break;
            case 2:
                location.put(this, position.getX(), position.getY()-1);
                break;
            case 3:
                location.put(this, position.getX()-1, position.getY());
                break;
            case 4:
                location.put(this, position.getX()+1, position.getY());
                break;
        }
    }

    @Override
    public String toString() {
        return  "Animal{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight().get() +
                ", maxSpeed=" + getMaxSpeed() +
                ", satiety=" + getSatiety() +
                ", dietList=" + getDietList() +
                ", position= X = " + getPosition().getX() + " Y = " + getPosition().getY() +
                ", isAlive=" + isAlive() +
                ", isHungry=" + isHungry() +
                '}';
    }
}
