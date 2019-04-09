package interfaces.implementation;

import controller.Dice;
import interfaces.Drink;

public class SpartanDrink implements Drink {

    @Override
    public boolean drink() {
        boolean rta = true;
        if (Dice.roll() > 5) {
            rta = false;
        }
        return rta;
    }
}
