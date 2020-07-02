package com.geekbrains.georgy.lesson7.entry;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMap {
    public static void main(String[] args) {
        /*ArrayList:  5893
          HashMap  :  8
        */
        
        ArrayList<MyEntry> myEntries = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        fill(myEntries);

        long time = System.currentTimeMillis();
        findValue(myEntries);
        System.out.println("Time find value MyEntry: " + (System.currentTimeMillis() - time));

        fill(map);

        long time1 = System.currentTimeMillis();
        findValue(map);
        System.out.println("Time find value HashMap: " + (System.currentTimeMillis() - time1));

    }

    public static void fill(ArrayList<MyEntry> arrayList){
        for (int i = 0; i < 50000; i++) {
            MyEntry myEntry = new MyEntry(i,i+2);
            arrayList.add(myEntry);
        }
    }

    public static void fill(HashMap<Integer, Integer> map){
        for (int i = 0; i < 50000; i++) {
            map.put(i,i+2);
        }
    }

    public static void findValue(HashMap<Integer, Integer> map){
        for (int i = 0; i < 100000; i++){
            map.get(randomNumber());
        }
    }

    public static void findValue(ArrayList<MyEntry> arrayList){
        for (int i = 0; i < 100000; i++){
            int key = randomNumber();
            for (MyEntry entry : arrayList){
                if (entry.getKey() == key){
                    break;
                }
            }
        }
    }

    public static int randomNumber() {
        int min = 0;
        int max = 49999;
        return min + (int) (Math.random() * max);
    }
}
