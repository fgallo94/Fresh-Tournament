package com.utn.model;


import com.utn.controller.Dice;
import com.utn.interfaces.Drink;

public class SpartanDrink implements Drink {

    /**
     * Roll a dice if is greater than 5 avoid the drink and return false, if it is a lower number return true and drink
     *
     * @return true if drink, false if avoid
     */
    @Override
    public boolean drink() {
        boolean rta = true;
        if (Dice.roll() > 5) {
            rta = false;
        }
        return rta;
    }
}