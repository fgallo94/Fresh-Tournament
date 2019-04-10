package com.utn.dto;

import com.utn.interfaces.Drink;
import com.utn.interfaces.ToPee;

public class Spartan extends Human {
    private static final Integer peeBuff = 1;

    public Spartan(String name, Integer age, ToPee toPee, Drink drink) {
        super(name, age, toPee, drink);
    }

    static Integer getPeeBuff() {
        return peeBuff;
    }


    @Override
    public String toString() {
        return "Spartan {" + super.toString() + " }";
    }
}