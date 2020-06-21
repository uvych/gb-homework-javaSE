package com.geekbrains.georgy.lesson2;

import java.util.Objects;

public class Worker {
    private String name;
    private String email;
    private int age;
    private String post;

    public Worker(String name, String email, int age, String post) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return age == worker.age &&
                name.equals(worker.name) &&
                email.equals(worker.email) &&
                Objects.equals(post, worker.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age, post);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                '}';
    }

    public void printInfo() {
        System.out.println(this.toString());
    }
}
