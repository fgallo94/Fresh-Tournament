package com.utn.dto;


import com.utn.controller.Dice;
import com.utn.interfaces.ToPee;

public class SpartanPee implements ToPee {

    /**
     * Roll a dice get a number less the Spartan pee buff if it is greater than 3, pee and return true, if it is a lower number return false and avoid pee
     *
     * @return true if pee, false if avoid
     */
    @Override
    public boolean pee() {
        boolean rta = false;
        if (Dice.roll() - Spartan.getPeeBuff() > 3) {
            rta = true;
        }
        return rta;
    }
}