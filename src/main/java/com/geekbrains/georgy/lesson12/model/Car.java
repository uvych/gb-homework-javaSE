package com.geekbrains.georgy.lesson12.model;

import com.geekbrains.georgy.lesson12.annotation.DbColumn;
import com.geekbrains.georgy.lesson12.annotation.DbId;
import com.geekbrains.georgy.lesson12.annotation.DbTable;

import java.util.Objects;

@DbTable(title = "Car")
public class Car {
    @DbColumn
    private String brand;

    @DbId
    private Long id;

    @DbColumn
    private String type;

    public Car() {
    }

    public Car(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) &&
                Objects.equals(id, car.id) &&
                Objects.equals(type, car.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, id, type);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
