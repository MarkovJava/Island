package com.javarush.markov.island.objects.simulation.organism;

import com.javarush.markov.island.objects.simulation.field.location.Location;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Organism implements Runnable {

    private final String name;

    private final double weight;

    private final AtomicBoolean isDeadBody;

    public Organism(double weight) {
        this.name = this.getClass().getSimpleName();
        this.weight = weight;
        isDeadBody = new AtomicBoolean();
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isDeadBody() {
        return isDeadBody.get();
    }

    public abstract void setLocation(int x, int y);

    public void kill() {
        isDeadBody.set(true);
    }

    public void reproduce() {
        //TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organism organism = (Organism) o;
        return Double.compare(organism.weight, weight) == 0 && isDeadBody == organism.isDeadBody && Objects.equals(name, organism.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, isDeadBody);
    }

    @Override
    public String toString() {
        return "Organism{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", isDeadBody=" + isDeadBody +
                '}';
    }
}
