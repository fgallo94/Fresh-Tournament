package com.utn.dto;

import com.utn.interfaces.Drink;
import com.utn.interfaces.ToPee;

public class Human implements Comparable<Human> {
    private String name;
    private Integer age;
    private ToPee toPee;
    private Drink drink;
    private Integer drinkedBeers = 0;
    private boolean wetPants = false;

    Human(String name, Integer age, ToPee toPee, Drink drink) {
        this.name = name;
        this.age = age;
        this.toPee = toPee;
        this.drink = drink;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getBeerLimit() {
        return 3;
    }

    public boolean isWetPants() {
        return wetPants;
    }

    public void setWetPants(boolean wetPants) {
        this.wetPants = wetPants;
    }

    public Integer getDrinkedBeers() {
        return drinkedBeers;
    }

    public void setDrinkedBeers(Integer drinkedBeers) {
        this.drinkedBeers = drinkedBeers;
    }

    public ToPee getToPee() {
        return toPee;
    }

    public Drink getDrink() {
        return drink;
    }

    public int compareTo(Human human) {
        return this.age.compareTo(human.getAge());
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", drinkedBeers=" + drinkedBeers;
    }
}