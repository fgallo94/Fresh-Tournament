package interfaces.implementation;

import interfaces.ToPee;

public class VikingPee implements ToPee {

    @Override
    public boolean pee() {
        boolean rta = false;
        int diceRoll = (int)(Math.random() * 6) + 1;
        if (diceRoll>3){
            rta = true;
        }
        return rta;
    }
}
