package com.geekbrains.georgy.lesson8;

/*Взять строку, состоящую из 100 слов разделенных пробелом, получить список слов длиннее 5 символов, и склеить их в одну строку с пробелом в качестве разделителя;
        Найти список уникальных слов в двумерном массиве размером 5х5;
        Посчитать сумму четных чисел в пределах от 100 до 200 (включительно);
        Посчитать суммарную длину строк в одномерном массиве;
        Из массива слов получить первые три слова в алфавитном порядке;*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp8 {
    public static void main(String[] args) {
        String str = "Так бережно разливается по воздуху звук торопливого ручейка весело бегущего извилистой ленточкой среди травы" +
                " Словно играя на арфе падают росинки с деревьев перепрыгивают  еле слышно на цветы а потом беззвучно исчезают в траве" +
                " На  поляне жужжат деловые шмели саранча поет свою незамысловатую песню То здесь то там слышно щебетанье птиц" +
                "  А тон всему задает тихий шелест ветра Словно дирижер он руководит журчанием ручья следит за тональностью росинок и периодически утихомиривает насекомых" +
                " Лида лежит на мягкой траве прикрывая голову от солнца большим листом лопуха и наслаждается музыкой природы" +
                " Она ничего не может слышать уже несколько лет Ей помогает в этом память";

        System.out.println(getWordsOnlyLongerFive(str));

        String [][] strings = new String[][]{
                {"One" ,"Two" ,"Three" ,"One" ,"For"},
                {"One" ,"Two" ,"Three" ,"One" ,"Five"},
                {"One" ,"Two" ,"Three" ,"One" ,"For"},
                {"One" ,"Two" ,"Three" ,"One" ,"Seven"},
                {"One" ,"Two" ,"Three" ,"One" ,"For"},
        };

        System.out.println(getListUniqueWords(strings));

        System.out.println("Сумма четных чисел от 100 до 200 :" + sumEvenNumber());

        String [] mass = new String[]{"logger" ,"hold" ,"told"};

        System.out.println("Сумарная длинна строк : " + sumStringLength(mass));

        String [] names = new String[]{"Georgy" ,"Mark" ,"Max" ,"Arch" ,"Abraham" ,"Boris"};

        System.out.println(getAlphabeticalOrder(names));
    }

    public static String getWordsOnlyLongerFive(String string) {
        return Stream.of(string.split("\\s"))
                .filter(s -> s.length() > 5)
                .collect(Collectors.joining(" "));
    }

    public static List<String> getListUniqueWords(String [][] strings) {
        return Arrays.stream(strings)
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static int sumEvenNumber() {
        return Stream.iterate(100, x -> x + 2)
                .limit(51)
                .reduce(0,Integer::sum);
    }

    public static int sumStringLength(String [] strings) {
        return Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();
    }

    public static List<String> getAlphabeticalOrder(String [] strings) {
        return Arrays.stream(strings)
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }
}
