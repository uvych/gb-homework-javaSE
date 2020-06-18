package com.geekbrains.georgy.lesson1;

import java.util.Arrays;

    public class LessonOne {
        public static void main(String[] args) {
            System.out.println(inRange(13 , 7)); //true

            positiveOrNegative(-5); //is negative
            positiveOrNegative(0); //is positive

            System.out.println(isNegative(0)); //false

            greetUser("Георгий"); //Привет, указанное_имя!

            System.out.println(Arrays.toString(binaryReplace(new int[]{1, 0, 1, 0, 1, 0}))); // 0 1 0 1 0 1

            System.out.println(Arrays.toString(fillArray(new int[8]))); // 2 5 8 11 14 17 20 23

            System.out.println(Arrays.toString(increaseLessSix(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}))); // 2 10 6 4 11 8 10 4 8 8 9 2

            printTwoDimensionalArray();
        }


    /*Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.*/

        public static boolean inRange(int firstNumber , int secondNumber){
            int sum = firstNumber + secondNumber;
            return sum >= 10 && sum <= 20;
        }


    /*Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.*/

        public static void positiveOrNegative(int number){
            if (number < 0) {
                System.out.println(number +" is negative number");
            } else {
                System.out.println(number + " is positive number");
            }
        }


    /*Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное.*/

        public static boolean isNegative(int number){
            return number < 0;
        }


    /*Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».*/

        public static void greetUser(String name){
            System.out.println("Привет, " + name + "!");
        }


    /*Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;*/

        public static int [] binaryReplace(int [] mass){
            for (int i = 0; i < mass.length; i++){
                if (mass[i] == 0) {
                    mass[i] = 1;
                } else if (mass[i] == 1){
                    mass[i] = 0;
                }
            }

            return mass;
        }


    /*Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 2 5 8 11 14 17 20 23;*/

        public static int [] fillArray(int [] mass){
            for (int i = 0; i < mass.length; i++){
                mass[i] = i + 2*(i+1);
            }
            return mass;
        }


    /*Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    пройти по нему циклом, и числа меньшие 6 умножить на 2;*/

        public static int [] increaseLessSix(int [] mass){
            for (int i = 0; i < mass.length; i++){
                if (mass[i] < 6) mass[i] = mass[i] * 2;
            }
            return mass;
        }


    /*Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/

        public static void printTwoDimensionalArray(){
            int [][] arr = new int[6][6];

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (i == j) arr[i][j] = 1;
                }
            }

            for (int[] ints : arr) {
                System.out.println();
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(ints[j]);
                }
            }
        }
    }

