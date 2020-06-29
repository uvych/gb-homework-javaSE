package com.geekbrains.georgy.lesson6;

import com.geekbrains.georgy.lesson6.handbook.Handbook;

import java.util.*;

public class MainApp6 {
    public static void main(String[] args) {
        List <String> strings = new ArrayList<>(Arrays.asList("Михаил", "Александр", "Андрей", "Дмитрий", "Михаил", "Григорий", "Георгий", "Андрей", "Павел", "Михаил"));

        printUniqueSet(strings);
        printCountRepeat(strings);
        System.out.println();

        Handbook handbook = new Handbook();
        handbook.add("Михаилов", "89991234567");
        handbook.add("Михаилов", "89991234534");
        handbook.add("Аксененко", "89991234588");
        handbook.add("Дзюба", "89991234590");
        handbook.add("Антошкин", "89991434590");
        handbook.add("Абигейл", "89631234590");

        System.out.println("Поиск по фамилии Головин : " + handbook.get("Головин"));
        System.out.println("Поиск по фамилии Дзюба : " + handbook.get("Дзюба"));
        System.out.println("Поиск по фамилии Михаилов : " + handbook.get("Михаилов"));
        System.out.println();
        handbook.printHandbook();
    }

    public static void printUniqueSet(List <String> objects){
        Set<Object> set = new HashSet<>(objects);
        System.out.println(set);
    }

    public static void printCountRepeat(List<String> objects){
        HashMap<Object,Integer> map = new HashMap<>();
        for (Object element : objects){
            map.put(element, Collections.frequency(objects,element));
        }
        System.out.println(map);
    }
}
