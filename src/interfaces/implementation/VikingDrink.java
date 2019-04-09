package interfaces.implementation;

import controller.Dice;
import dto.Viking;
import interfaces.Drink;

public class VikingDrink implements Drink {

    @Override
    public boolean drink() {
        boolean rta = true;
        if (Dice.roll() + Viking.getDrinkBuff() > 5) {
            rta = false;
        }
        return rta;
    }
}
