package com.geekbrains.georgy.lesson3;

import java.util.Objects;

public class Robot implements Move{
    private int runDistance;
    private int jumpHeight;
    private String name;

    public Robot(String name, int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return runDistance == robot.runDistance &&
                jumpHeight == robot.jumpHeight &&
                Objects.equals(name, robot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runDistance, jumpHeight, name);
    }

    @Override
    public String toString() {
        return "Robot{" +
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
