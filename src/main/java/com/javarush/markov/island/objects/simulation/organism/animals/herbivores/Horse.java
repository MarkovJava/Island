package com.javarush.markov.island.objects.simulation.organism.animals.herbivores;

import com.javarush.markov.island.objects.simulation.field.PlayingField;
import com.javarush.markov.island.objects.simulation.field.location.Location;


import java.util.List;

public final class Horse extends Herbivores {

    private Horse(HorseBuilder builder) {
        super(builder.weight, builder.maxTravelSpeed, builder.satiety, builder.dietList, builder.playingField);
        this.setLocation(builder.location);
    }

    @Override
    protected boolean isCanEatSomeone() {
        return false;
    }

    @Override
    public String toString() {
        return "Horse{} " + super.toString();
    }

    @Override
    public void run() {
        move();
    }

    public static class HorseBuilder {

        private double weight;

        private int maxTravelSpeed;

        private int satiety;

        private PlayingField playingField;

        private Location location;

        private List<String> dietList;



        public HorseBuilder() {

        }

        public HorseBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public HorseBuilder setMaxTravelSpeed(int maxTravelSpeed) {
            this.maxTravelSpeed = maxTravelSpeed;
            return this;
        }

        public HorseBuilder setSatiety(int satiety) {
            this.satiety = satiety;
            return this;
        }

        public HorseBuilder setDietList(List<String> dietList) {
            this.dietList = dietList;
            return this;
        }

        public HorseBuilder setPlayField(PlayingField playingField) {
            this.playingField = playingField;
            return this;
        }

        public Horse build() {
            return new Horse(this);
        }

    }

}
