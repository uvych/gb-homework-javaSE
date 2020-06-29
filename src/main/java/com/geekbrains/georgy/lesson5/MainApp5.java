package com.geekbrains.georgy.lesson5;

import java.util.ArrayList;

public class MainApp5 {
    public static void main(String[] args) {
        Orange orange = new Orange();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();
        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Box<Orange> box = new Box<>();
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        box.addFruit(orange, orange1, orange2);
        box1.addFruit(apple, apple1, apple2);
        box2.addFruit(orange3, orange4, orange5);
        System.out.println("Количество апельсинова в коробке = " + box.countFruit());
        System.out.println("Количество яблок в коробке = " + box1.countFruit());
        System.out.println("Количество апельсинова в коробке два = " + box2.countFruit());
        box.changeBox(box2);
        System.out.println("Количество апельсинова в коробке после перемещения в коробку два  = " + box.countFruit());
        System.out.println("Количество апельсинова в коробке два после перемещения = " + box2.countFruit());
        System.out.println("Вес коробки с апельсинами " + box.getWeight());
        System.out.println("Вес второй коробки с апельсинами " + box2.getWeight());
        System.out.println("Вес коробки с яблоками " + box1.getWeight());
        System.out.println(box.compare(box1));
        System.out.println();
        System.out.println("Метод swap и conversionToArrayList");
        Integer[] number = new Integer[]{0, 1, 2};
        System.out.println("Позиции ноль = " + number[0]);
        System.out.println("Позиции два = " + number[2]);
        swap(number, 0, 2);
        System.out.println("Позиции ноль после метода swap = " + number[0]);
        System.out.println("Позиции ноль осле метода swap= " + number[2]);
        ArrayList<Integer> arrayList = conversionToArrayList(number);
    }

    public static <T> void swap(T[] mass, int firstCell, int secondCell) {
        T swapCell = mass[firstCell];
        mass[firstCell] = mass[secondCell];
        mass[secondCell] = swapCell;
    }

    public static <E> ArrayList<E> conversionToArrayList(E[] mass) {
        ArrayList<E> list = new ArrayList();
        for (E element : mass){
            list.add(element);
        }

        return list;
    }
}
