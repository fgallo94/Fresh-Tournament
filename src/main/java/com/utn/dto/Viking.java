package com.utn.dto;


import com.utn.interfaces.Drink;
import com.utn.interfaces.ToPee;

public class Viking extends Human {
    private static final Integer drinkBuff = 1;

    public Viking(String name, Integer age, ToPee pee, Drink drink) {
        super(name, age, pee, drink);
    }

    public static Integer getDrinkBuff() {
        return drinkBuff;
    }

    @Override
    public String toString() {
        return "Viking { " + super.toString() + " }";
    }
}