package com.utn.model;

import com.utn.interfaces.Drink;
import com.utn.interfaces.ToPee;

public class Spartan extends Human {
    private static final Integer PEE_BUFF = 1;

    public Spartan(String name, Integer age, ToPee toPee, Drink drink) {
        super(name, age, toPee, drink);
    }

    /**
     * Static method for the Spartan Pee buff
     *
     * @return peeBuf
     */
    public static Integer getPeeBuff() {
        return PEE_BUFF;
    }

    @Override
    public String toString() {
        return "Spartan {" + super.toString() + " }";
    }
}