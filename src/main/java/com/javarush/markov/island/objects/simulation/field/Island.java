package com.javarush.markov.island.objects.simulation.field;

import com.javarush.markov.island.objects.simulation.field.location.Cell;
import com.javarush.markov.island.objects.simulation.field.location.Location;
import com.javarush.markov.island.objects.simulation.organism.Organism;
import com.javarush.markov.island.objects.simulation.organism.animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Island implements PlayingField {

    private int width;

    private int depth;

    private final CopyOnWriteArrayList<? extends Location> locationsList;

    public Island(int width, int depth) {
        this.width = width;
        this.depth = depth;
        this.locationsList = fillIslandWithLocations(width, depth);
    }

    private CopyOnWriteArrayList<Location> fillIslandWithLocations(int width, int depth) {
        List<Location> locations = new ArrayList<>(width*depth);
        for (int i = 1; i <= width; i++) {
            Collections.addAll(locations, createLocations(i, depth));
        }
        return new CopyOnWriteArrayList<>(locations);
    }

    private Cell[] createLocations(int x, int depth) {
        Cell[] cells = new Cell[depth];
        int y = 0;
        for (int i = 0; i < cells.length; i++) {
            y = y+1;
            cells[i] = new Cell(x, y);
        }
        return cells;
    }

    @Override
    public void putAll(CopyOnWriteArrayList<? extends Organism> organisms, int x, int y) {
        Location location = getLocation(x, y);
        for (int i = 0; i < organisms.size(); i++) {
            organisms.get(i).setLocation(x, y);
        }
        location.getCreaturesInThisLocationList().addAll(organisms);
    }

    @Override
    public void put(Animal animal, int x, int y) {
        for (Location location : locationsList) {
            if (location.getX() == x && location.getY() == y) {
                location.getCreaturesInThisLocationList().add(animal);
                animal.getLocation().getCreaturesInThisLocationList().remove(animal);
            }
        }
    }

    @Override
    public Location getLocation(int x, int y) {
        for (Location location : locationsList) {
            if(location.getX() == x && location.getY() == y)
                return location;
        }
        //TODO
        return null;
    }

    @Override
    public CopyOnWriteArrayList<? extends Location> getAllLocationList() {
        return locationsList;
    }

    @Override
    public String toString() {
        return "Island{" +
                "sizeX=" + width +
                ", sizeY=" + depth +
                ", locationsList=" + locationsList +
                '}';
    }
}
