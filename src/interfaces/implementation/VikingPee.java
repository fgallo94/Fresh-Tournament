package interfaces.implementation;

import controller.Dice;
import interfaces.ToPee;

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
