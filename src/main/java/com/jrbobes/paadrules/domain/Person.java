package com.jrbobes.paadrules.domain;

public class Person {

    private String id;
    private String name;
    private int age;

    String race;


    public Person() {
    }

    public Person(String id, String name, String race, int age) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return this.race;
    }
}
