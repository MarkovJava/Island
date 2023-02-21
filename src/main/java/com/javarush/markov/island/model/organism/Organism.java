package com.javarush.markov.island.model.organism;

import com.javarush.markov.island.model.sector.Sector;


public interface Organism extends Runnable {

    void eat();

    void multiply();

    void kill();

    boolean isAlive();

    Sector getPosition();

    void setPosition(Sector position);

}
