package com.geekbrains.georgy.lesson2;

import java.util.Arrays;
import java.util.Objects;

public class Team {
    private String name;
    private final Worker [] worker;

    public Team(String name) {
        this.name = name;
        worker = new Worker[10];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return name.equals(team.name) &&
                Arrays.equals(worker, team.worker);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(worker);
        return result;
    }

    public void addWorker(Worker newWorker) {
        for (int i = 0; i < worker.length; i++) {
            if (worker[i] == null) {
                worker[i] = newWorker;
                break;
            }
        }
    }

    public void removeWorker(int index) {
        if ( 9 >= index && index >= 0) {
            worker[index] = null;
        } else {
            System.out.println("The index is not in the range");
        }
    }

    public void removeAllWorker(){
        Arrays.fill(worker, null);
    }

    public void printAllWorkers() {
        System.out.println("Team : " + name + " \nWorkers : " );
        for (Worker workers : worker) {
            if (workers != null) workers.printInfo();
        }
    }
}
