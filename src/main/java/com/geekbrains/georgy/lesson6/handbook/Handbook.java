package com.geekbrains.georgy.lesson6.handbook;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Handbook {
    private final Map<String, Set<String>> handbook = new TreeMap<>();

    public void add(String name , String number){
        if (handbook.containsKey(name)) {
            handbook.get(name).add(number);
        } else {
            Set<String> numberSet = new HashSet<>();
            numberSet.add(number);
            handbook.put(name,numberSet);
        }
    }

    public Set<String> get(String name){
        return handbook.get(name);
    }

    public void printHandbook(){
        handbook.forEach((key, value) ->  System.out.println(key + " : " + value));
    }
}
