package com.javarush.markov.island.engine;

import com.javarush.markov.island.model.location.Location;
import com.javarush.markov.island.model.organism.Organism;
import com.javarush.markov.island.model.sector.Sector;
import com.javarush.markov.island.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleEngine implements Engine {

    private final Location location;

    private View view;

    public SimpleEngine(Location location, View view) {
        this.location = location;
        this.view = view;
    }

    @Override
    public void run() {
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            view.show(location);
            for (Sector sector : location.getSectorAll()) {
                if(!sector.getOrganismList().isEmpty())
                    for (Organism organism : sector.getOrganismList()) {
                        service.submit(organism);
                    }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
