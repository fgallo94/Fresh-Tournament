package interfaces.implementation;

import controller.Dice;
import dto.Spartan;
import interfaces.ToPee;

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
