package interfaces.implementation;

import dto.Viking;
import interfaces.Drink;

public class VikingDrink implements Drink {

    @Override
    public boolean drink() {
        boolean rta = true;
        int diceRoll = (int) (Math.random() * 6) + 1;
        if (diceRoll + Viking.getDrinkBuff() > 5) {
            rta = false;
        }
        return rta;
    }
}
