package com.utn.dto;


import com.utn.controller.Dice;
import com.utn.interfaces.Drink;

public class SpartanDrink implements Drink {

    @Override
    public boolean drink() {
        boolean rta = true;
        if (Dice.roll() > 5) {
            rta = false;
        }
        return rta;
    }
}