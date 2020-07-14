package com.geekbrains.georgy.lesson12.model;

import com.geekbrains.georgy.lesson12.annotation.DbColumn;
import com.geekbrains.georgy.lesson12.annotation.DbId;
import com.geekbrains.georgy.lesson12.annotation.DbTable;

import java.util.Objects;

@DbTable(title = "Car")
public class Bike {
    @DbColumn
    private String brand;

    @DbId
    private Long id;

    @DbColumn
    private String type;

    public Bike(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public Bike() {
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

    public void setSpeed(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return Objects.equals(brand, bike.brand) &&
                Objects.equals(id, bike.id) &&
                Objects.equals(type, bike.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, id, type);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "brand='" + brand + '\'' +
                ", id=" + id +
                ", speed=" + type +
                '}';
    }
}
