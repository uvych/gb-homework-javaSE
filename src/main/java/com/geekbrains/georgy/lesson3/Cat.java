package com.geekbrains.georgy.lesson3;

import java.util.Objects;

public class Cat implements Move {
    private String name;
    private int runDistance;
    private int jumpHeight;

    public Cat(String name, int runDistance, int jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return runDistance == cat.runDistance &&
                jumpHeight == cat.jumpHeight &&
                Objects.equals(name, cat.name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", runDistance=" + runDistance +
                ", jumpHeight=" + jumpHeight +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, runDistance, jumpHeight);
    }

    @Override
    public boolean jump(int height) {
        if (height <= jumpHeight) {
            System.out.println(name +" :Successfully jumped");
            return true;
        }
        System.out.println(name + " :Couldn't jump");
        return false;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= runDistance) {
            System.out.println(name + " :Successfully ran");
            return true;
        }
        System.out.println(name + " :Couldn't run");
        return false;
    }
}
