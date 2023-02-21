package com.javarush.markov.island.model.location;

import com.javarush.markov.island.model.sector.SectorConstructor;

public interface LocationConstructor {

    Location create(int width, int depth, SectorConstructor sectorConstructor);

}
