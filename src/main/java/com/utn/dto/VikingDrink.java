package com.utn.dto;

import com.utn.controller.Dice;
import com.utn.interfaces.Drink;

public class VikingDrink implements Drink {

    /**
     * Roll a dice get a number plus the Viking drink buff if it is greater than 5 avoid drink and return false, if it is a lower number return true and drink
     *
     * @return true if drink, false if avoid
     */
    @Override
    public boolean drink() {
        boolean rta = true;
        if (Dice.roll() + Viking.getDrinkBuff() > 5) {
            rta = false;
        }
        return rta;
    }
}