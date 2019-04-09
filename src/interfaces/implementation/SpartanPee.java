package interfaces.implementation;

import dto.Spartan;
import interfaces.ToPee;

public class SpartanPee implements ToPee {

    @Override
    public boolean pee() {
        boolean rta = false;
        int diceRoll = (int)(Math.random() * 6) + 1;
        if (diceRoll - Spartan.getPeeBuff() >3){
            rta = true;
        }
        return rta;
    }
}
