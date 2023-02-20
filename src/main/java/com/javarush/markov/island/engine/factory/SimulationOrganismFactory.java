package com.javarush.markov.island.engine.factory;

import com.javarush.markov.island.objects.simulation.organism.Organism;
import com.javarush.markov.island.objects.simulation.organism.animals.herbivores.Horse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimulationOrganismFactory implements SimulationObjectFactory {

    @Override
    public CopyOnWriteArrayList<? extends Organism> create() {
        CopyOnWriteArrayList<? extends Organism> list = new CopyOnWriteArrayList<>();
        Properties properties = new Properties();
        FileInputStream inputStream;

        try {
            inputStream = new FileInputStream("src/main/resources/properties/app-config.properties");
            properties.load(inputStream);
            int counter = Integer.parseInt(properties.getProperty("NUMBER_OF_HORSES"));
            list = createHouses(counter);
        } catch (IOException exception) {
            System.out.println("Object was not created!");
        }
        return list;
    }

    private CopyOnWriteArrayList<Horse> createHouses(int quantity) {
        CopyOnWriteArrayList<Horse> horseList = new CopyOnWriteArrayList<>();
        int counter = quantity;
        while (counter != 0) {
            Horse animal = new Horse.HorseBuilder()
                    .setWeight(400)
                    .setMaxTravelSpeed(4)
                    .setSatiety(60)
                    .setDietList(new ArrayList<String>())//Заглушка
                    .build();
            horseList.add(animal);
            counter = counter - 1;
        }
        return horseList;
    }

}
