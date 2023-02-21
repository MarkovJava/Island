package com.javarush.markov.island;


import com.javarush.markov.island.engine.Engine;
import com.javarush.markov.island.engine.SimpleEngine;
import com.javarush.markov.island.model.location.IslandConstructor;
import com.javarush.markov.island.model.location.Location;
import com.javarush.markov.island.model.location.LocationConstructor;
import com.javarush.markov.island.model.organism.AbstractOrganismFactory;
import com.javarush.markov.island.model.organism.Herbivores;
import com.javarush.markov.island.model.organism.HorseFactory;
import com.javarush.markov.island.model.sector.CellConstructor;
import com.javarush.markov.island.view.ConsoleView;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        new Game().start();
    }

    public void start() {
        Engine engine;
        engine = new SimpleEngine(createLocation(), new ConsoleView());
        engine.run();
    }

    private Location createLocation() {
        Location location;
        LocationConstructor locationConstructor = new IslandConstructor();
        location = locationConstructor.create(5, 5, new CellConstructor());
        List<Herbivores> list;
        AbstractOrganismFactory factory = new HorseFactory();
        list = factory.createHerbivores(10, location);
        location.putAll(list, 3,3);
        return location;
    }

}
