package com.example.zubermarcell_javafxrestclientdolgozat;

import com.google.gson.annotations.Expose;

public class Sport {
    private int id;
    @Expose
    private String name;
    @Expose
    private String sport;
    @Expose
    private int age;
    @Expose
    private String level;

    public Sport(int id, String name, String sport, int age, String level) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.age = age;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
