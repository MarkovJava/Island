package com.javarush.markov.island.view;

import com.javarush.markov.island.model.location.Location;

public class ConsoleView implements View {

    @Override
    public void show(Location location) {
        System.out.println(location);
    }
}
