package com.geekbrains.georgy.lesson3;

import java.io.StringReader;
import java.util.Objects;

public class Human implements Move{
    private int runDistance;
    private int jumpHeight;
    private String name;

    public Human(String name ,int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return runDistance == human.runDistance &&
                jumpHeight == human.jumpHeight &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runDistance, jumpHeight, name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "runDistance=" + runDistance +
                ", jumpHeight=" + jumpHeight +
                ", name='" + name + '\'' +
                '}';
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
