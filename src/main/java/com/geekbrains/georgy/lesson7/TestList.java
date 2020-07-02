package com.geekbrains.georgy.lesson7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {

        /* по 10000 обращений
                      10     100     10000    100000
        ArrayList:    1       1        0         1
        LinkedList:   1       2        85        1119        */

        /*удаление элемента из середины
                       100      10000       100000
         ArrayList:     0         2           132
        LinkedList:     0         26          3039
        */

        ArrayList<Integer> arrayList10 = new ArrayList<>();
        ArrayList<Integer> arrayList100 = new ArrayList<>();
        ArrayList<Integer> arrayList10000 = new ArrayList<>();
        ArrayList<Integer> arrayList100000 = new ArrayList<>();

        fillAnArray(10,arrayList10);
        fillAnArray(100,arrayList100);
        fillAnArray(10000,arrayList10000);
        fillAnArray(100000,arrayList100000);

        LinkedList<Integer> linkedList10 = new LinkedList<>();
        LinkedList<Integer> linkedList100 = new LinkedList<>();
        LinkedList<Integer> linkedList10000 = new LinkedList<>();
        LinkedList<Integer> linkedList100000 = new LinkedList<>();

        fillAnArray(10,linkedList10);
        fillAnArray(100,linkedList100);
        fillAnArray(10000,linkedList10000);
        fillAnArray(100000,linkedList100000);

        long time = System.currentTimeMillis();
        accessingTheIndex(arrayList10);
        System.out.println("Time arrayList(10): " + (System.currentTimeMillis() - time));

        long time1 = System.currentTimeMillis();
        accessingTheIndex(arrayList100);
        System.out.println("Time arrayList(100): " + (System.currentTimeMillis() - time1));

        long time2 = System.currentTimeMillis();
        accessingTheIndex(arrayList10000);
        System.out.println("Time arrayList(10000): " + (System.currentTimeMillis() - time2));

        long time3 = System.currentTimeMillis();
        accessingTheIndex(arrayList100000);
        System.out.println("Time arrayList(100000): " + (System.currentTimeMillis() - time3));

        long time4 = System.currentTimeMillis();
        accessingTheIndex(linkedList10);
        System.out.println("Time linkedList(10): " + (System.currentTimeMillis() - time4));

        long time5 = System.currentTimeMillis();
        accessingTheIndex(linkedList100);
        System.out.println("Time linkedList(100): " + (System.currentTimeMillis() - time5));

        long time6 = System.currentTimeMillis();
        accessingTheIndex(linkedList10000);
        System.out.println("Time linkedList(10000): " + (System.currentTimeMillis() - time6));

        long time7 = System.currentTimeMillis();
        accessingTheIndex(linkedList100000);
        System.out.println("Time linkedList(100000): " + (System.currentTimeMillis() - time7));

        long time8 = System.currentTimeMillis();
        deleteMiddleElement(linkedList100);
        System.out.println("Time delete linkedList(100): " + (System.currentTimeMillis() - time8));

        long time9 = System.currentTimeMillis();
        deleteMiddleElement(linkedList10000);
        System.out.println("Time delete linkedList(10000): " + (System.currentTimeMillis() - time9));

        long time10 = System.currentTimeMillis();
        deleteMiddleElement(linkedList100000);
        System.out.println("Time delete linkedList(100000): " + (System.currentTimeMillis() - time10));

        long time11 = System.currentTimeMillis();
        deleteMiddleElement(arrayList100);
        System.out.println("Time delete arrayList(100): " + (System.currentTimeMillis() - time11));

        long time12 = System.currentTimeMillis();
        deleteMiddleElement(arrayList10000);
        System.out.println("Time delete arrayList(10000): " + (System.currentTimeMillis() - time12));

        long time13 = System.currentTimeMillis();
        deleteMiddleElement(arrayList100000);
        System.out.println("Time delete arrayList(100000): " + (System.currentTimeMillis() - time13));
    }

    public static void fillAnArray(int count, List<Integer> list){
        for (int i = 0; i < count; i++){
            list.add(i);
        }
    }

    public static void accessingTheIndex(List<Integer> list){
        for (int i = 0; i < 10000; i++) {
            list.get(list.size()/2);
        }
    }

    public static void deleteMiddleElement(List<Integer> list){
        int count = list.size();
        for (int i = 0; i < count/2; i++){
            list.remove(list.size()/2);
        }
    }
}
