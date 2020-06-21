package com.geekbrains.georgy.lesson2;

import java.util.function.DoubleToIntFunction;

public class LessonTwoMain {
    public static void main(String[] args) {
        Worker worker = new Worker("Georgy", "email@mail.com", 23, "rekrut");
        Worker worker1 = new Worker("Kolya", "email@mail.com", 43, "rekrut");
        Worker worker2 = new Worker("Petya", "email@mail.com", 25, "rekrut");

        worker.printInfo();

        Team team = new Team("Fist TEAM");
        team.addWorker(worker);
        team.addWorker(worker1);
        team.addWorker(worker2);

        team.printAllWorkers();

        team.removeWorker(2);

        team.printAllWorkers();

        team.removeAllWorker();

        team.printAllWorkers();

    }
}
