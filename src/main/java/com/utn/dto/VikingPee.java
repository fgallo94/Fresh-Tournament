package com.utn.dto;


import com.utn.controller.Dice;
import com.utn.interfaces.ToPee;

public class VikingPee implements ToPee {

    @Override
    public boolean pee() {
        boolean rta = false;
        if (Dice.roll() > 3) {
            rta = true;
        }
        return rta;
    }
}