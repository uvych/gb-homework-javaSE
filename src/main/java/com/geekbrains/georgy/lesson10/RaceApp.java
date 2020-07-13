package com.geekbrains.georgy.lesson10;

import com.geekbrains.georgy.lesson10.stages.Road;
import com.geekbrains.georgy.lesson10.stages.Tunnel;

import java.util.concurrent.BrokenBarrierException;

public class RaceApp {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        race.begin();
    }
}


