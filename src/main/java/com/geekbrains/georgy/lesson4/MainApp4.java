package com.geekbrains.georgy.lesson4;

public class MainApp4 {
    public static void main(String[] args) {
        /* String [][] strings = {{"3","4" ,"2","0"},{"4","2" , "2" ,"2"},{"4","2" , "2" ,"2"}};*/  /*MyArraySizeException*/
        /*String [][] strings = {{"3","4" ,"2","0"},{"4","2" , "2" ,"2"},{"4","2" , "2" ,"2"},{"4","2" , "2" ,"2"}};*/  /*39*/
        String [][] strings = {{"3","4" ,"2","0"},{"4","2" , "2" ,"2"},{"4","2" , "2" ,"f"},{"4","2" , "2" ,"2"}};  /*MyArrayDataException*/

        try {
            sumArrayElement(strings);
        }catch (MyArraySizeException | MyArrayDataException e ){
            e.printStackTrace();
        }
    }

    public static void sumArrayElement(String [][] array){
        checkArray(array);
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("В ячейке "+ i + " X " + j + " лежит символ или текст вместо числа");
                }
            }
        }

        System.out.println("Сумма элементов массива = " + sum);
    }

    public static void checkArray(String [][] array){
        if (!(array.length == 4 && array[0].length == 4)) throw new MyArraySizeException("Массив должен быть размером 4х4");
    }
}
