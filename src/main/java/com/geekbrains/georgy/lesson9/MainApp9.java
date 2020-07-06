package com.geekbrains.georgy.lesson9;


import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class MainApp9 {
    public static void main(String[] args) {
       /*                Time
        ForkJoinPool      489
              Stream      155
                Main      79
       */

        int [] mass = new int[100000000];

        fill(mass);

        long time = System.currentTimeMillis();
        System.out.println(getMaxValue(mass));
        System.out.println("Время однопоточного : " + (System.currentTimeMillis() - time));

        long time1 = System.currentTimeMillis();
        System.out.println(getMaxValueStream(mass));
        System.out.println("Время stream : " + (System.currentTimeMillis() - time1));

        DemoRecursiveTask demoRecursiveTask = new DemoRecursiveTask(mass);

        long time3 = System.currentTimeMillis();
        System.out.println(ForkJoinPool.commonPool().invoke(demoRecursiveTask));
        System.out.println("Время fork : " + (System.currentTimeMillis() - time3));

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

    public static int getMaxValue(int [] mass) {
        int maxValue = mass[0];
        for(int i=1;i < mass.length;i++){
            if(mass[i] > maxValue){
            maxValue = mass[i];
            }
        }
        return maxValue;
    }

    public static int getMaxValueStream(int [] mass) {
        return Arrays.stream(mass)
                .parallel()
                .max()
                .orElse(0);
    }

}
