package com.utn.dto;


import com.utn.controller.Dice;
import com.utn.interfaces.ToPee;

public class SpartanPee implements ToPee {

    @Override
    public boolean pee() {
        boolean rta = false;
        if (Dice.roll() - Spartan.getPeeBuff() > 3) {
            rta = true;
        }
        return rta;
    }
}