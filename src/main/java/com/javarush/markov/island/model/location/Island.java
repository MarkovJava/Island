package com.javarush.markov.island.model.location;

import com.javarush.markov.island.model.organism.Organism;
import com.javarush.markov.island.model.sector.Sector;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Island implements Location {

    private final int x;

    private final int y;

    private final CopyOnWriteArrayList<? extends Sector> sectors;

    protected Island(int x, int y, CopyOnWriteArrayList<? extends Sector> sectors) {
        this.x = x;
        this.y = y;
        this.sectors = sectors;
    }

    @Override
    public synchronized Sector getSector(int x, int y) {
        for (Sector sector : sectors) {
            if (sector.getX() == x && sector.getY() == y)
                return sector;
        }
        return null;
    }

    @Override
    public CopyOnWriteArrayList<? extends Sector> getSectorAll() {
        return sectors;
    }

    @Override
    public boolean putAll(List<? extends Organism> organisms, int x, int y) {
        Sector sector = getSector(x, y);
        if(sector != null) {
            for (Organism organism : organisms) {
                put(organism, x, y);
            }
        }
        return false;
    }

    @Override
    public synchronized boolean put(Organism organism, int x, int y) {
        Sector sector = getSector(x, y);
        sector.getOrganismList().add(organism);
        if (organism.getPosition() != null) {
            delete(organism, organism.getPosition());
            organism.setPosition(sector);
            return true;
        }
        organism.setPosition(sector);
        return true;
    }

    private void delete(Organism organism, Sector sector) {
        int index = sectors.indexOf(sector);
        sectors.get(index).getOrganismList().remove(organism);
    }

    @Override
    public String toString() {
        return "Island{" +
                "sectors=" + sectors +
                '}';
    }
}
