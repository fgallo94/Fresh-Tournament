package com.utn.model;


import com.utn.interfaces.Drink;
import com.utn.interfaces.ToPee;

public class Viking extends Human {
    private static final Integer DRINK_BUFF = 1;

    public Viking(String name, Integer age, ToPee pee, Drink drink) {
        super(name, age, pee, drink);
    }

    /**
     * Static method for the Viking drink buff
     *
     * @return peeBuf
     */
    public static Integer getDrinkBuff() {
        return DRINK_BUFF;
    }

    @Override
    public String toString() {
        return "Viking { " + super.toString() + " }";
    }
}