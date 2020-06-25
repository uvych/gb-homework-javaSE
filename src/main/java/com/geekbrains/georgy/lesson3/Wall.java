package com.geekbrains.georgy.lesson3;

import java.util.Objects;

public class Wall implements Obstacle {
     private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return height == wall.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }

    @Override
    public boolean tryToOvercome(Move mover) {
        return mover.jump(height);
    }
}
