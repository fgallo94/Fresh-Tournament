package com.utn.model;


import com.utn.controller.Dice;
import com.utn.interfaces.ToPee;

public class VikingPee implements ToPee {

    /**
     * Roll a dice if is greater than 3 pee and return true, if it is a lower number avoid pee and return false
     *
     * @return true if pee, false if avoid
     */
    @Override
    public boolean pee() {
        boolean rta = false;
        if (Dice.roll() > 3) {
            rta = true;
        }
        return rta;
    }
}