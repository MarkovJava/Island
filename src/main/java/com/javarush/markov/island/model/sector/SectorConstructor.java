package com.javarush.markov.island.model.sector;

import java.util.concurrent.CopyOnWriteArrayList;

public interface SectorConstructor {

    CopyOnWriteArrayList<? extends Sector> create(int x, int y);

}
