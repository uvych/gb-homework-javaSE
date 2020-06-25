package com.geekbrains.georgy.lesson3;

import java.util.Objects;

public class Treadmill implements Obstacle {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treadmill treadmill = (Treadmill) o;
        return distance == treadmill.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "distance=" + distance +
                '}';
    }

    @Override
    public boolean tryToOvercome(Move mover) {
        return mover.run(distance);
    }
}
