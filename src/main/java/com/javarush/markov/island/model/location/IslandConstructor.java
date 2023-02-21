package com.javarush.markov.island.model.location;

import com.javarush.markov.island.model.sector.Sector;
import com.javarush.markov.island.model.sector.SectorConstructor;

import java.util.concurrent.CopyOnWriteArrayList;


public class IslandConstructor implements LocationConstructor {

    @Override
    public Location create(int width, int depth, SectorConstructor sectorConstructor) {
        CopyOnWriteArrayList<? extends Sector> sectors = sectorConstructor.create(width, depth);
        return new Island(width, depth, sectors);
    }
}
