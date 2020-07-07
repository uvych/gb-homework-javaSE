package com.geekbrains.georgy.lesson9;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class MainApp9 {
    public static void main(String[] args) {
       /*                    Time
 ForkJoinPool 2 потока       518
              Stream         174
     Parallel Stream          25
       */

        int [] mass = new int[100000000];

        fill(mass);

        long time1 = System.currentTimeMillis();
        System.out.println(getMaxValueStream(mass));
        System.out.println("Время stream : " + (System.currentTimeMillis() - time1));

        DemoRecursiveTask demoRecursiveTask = new DemoRecursiveTask(mass);

        long time3 = System.currentTimeMillis();
        System.out.println(ForkJoinPool.commonPool().invoke(demoRecursiveTask));
        System.out.println("Время fork : " + (System.currentTimeMillis() - time3));

        long time4 = System.currentTimeMillis();
        System.out.println(getMaxValueParallelStream(mass));
        System.out.println("Время parallel stream : " + (System.currentTimeMillis() - time4));

    }

    public static int randomNumber() {
        int min = 0;
        int max = 100001;
        return min + (int) (Math.random() * max);
    }

    public static void fill(int [] mass) {
        for (int i = 0; i < 100000000; i++) {
            mass[i] = randomNumber();
        }
    }

    public static int getMaxValueStream(int [] mass) {
        return IntStream.of(mass)
                .max()
                .orElse(0);
    }

    public static int getMaxValueParallelStream(int [] mass) {
        return IntStream.of(mass)
                .parallel()
                .max()
                .orElse(0);
    }
}
