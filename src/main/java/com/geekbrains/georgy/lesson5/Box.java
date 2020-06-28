package com.geekbrains.georgy.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Box<T extends Fruit> {
    private final ArrayList<T> list = new ArrayList();

    public Box() {
    }

    @SafeVarargs
    public final void addFruit(T... fruit) {
        this.list.addAll(Arrays.asList(fruit));
    }

    public float getWeight() {
        if (list.size() == 0) return 0f;
        return list.get(0).weight * list.size();
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.00001;
    }

    public void changeBox(Box<T> box) {
        for (T element : list){
            box.addFruit(element);
        }

        list.clear();
    }

    public int countFruit() {
        return list.size();
    }
}
