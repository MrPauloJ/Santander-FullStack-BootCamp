package com.entities;

public class Client {
    private final String name;
    private final int age;

    public Client(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}
