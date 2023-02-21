package com.javarush.markov.island.model.sector;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CellConstructor implements SectorConstructor {

    @Override
    public CopyOnWriteArrayList<Cell> create(int x, int y) {
        CopyOnWriteArrayList<Cell> cells;
        ArrayList<Cell> cellArrayList = new ArrayList<>();
        createCells(cellArrayList, x, y);
        cells = new CopyOnWriteArrayList<>(cellArrayList);
        return cells;
    }

    private void createCells(ArrayList<Cell> list, int x, int y) {
        int value = 1;
        while (value <= x) {
            fill(list, value, y);
            value = value + 1;
        }
    }

    private void fill(ArrayList<Cell> list, int from, int to) {
        int value = 1;
        while (value <= to) {
            list.add(new Cell(from, value));
            value = value + 1;
        }
    }
}
