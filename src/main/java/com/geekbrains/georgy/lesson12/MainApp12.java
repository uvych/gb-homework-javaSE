package com.geekbrains.georgy.lesson12;

import com.geekbrains.georgy.lesson12.model.Car;
import com.geekbrains.georgy.lesson12.repo.ReflectionRepository;

import java.util.List;

public class MainApp12 {
    public static void main(String[] args) throws Exception {
        Car car = new Car("Firrari","mini");
        Car car2 = new Car("Suzuki", "enduro");

        ReflectionRepository<Car> reflectionRepository = new ReflectionRepository<>(Car.class);

        reflectionRepository.InsertToDB(car2);


       List<Car> arrayList =  reflectionRepository.readAll();

       for (Car car1 : arrayList) {
           System.out.println(car1.toString());
       }

       System.out.println(reflectionRepository.readToDbById(11L));

       reflectionRepository.deleteById(11L);

       reflectionRepository.clearTableEx();

    }
}
