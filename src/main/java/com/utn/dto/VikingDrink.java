package com.utn.dto;

import com.utn.controller.Dice;
import com.utn.interfaces.Drink;

public class VikingDrink implements Drink {

    @Override
    public boolean drink() {
        boolean rta = true;
        if (Dice.roll() + Viking.getDrinkBuff() > 5) {
            rta = false;
        }
        return rta;
    }
}