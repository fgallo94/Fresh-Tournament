package interfaces.implementation;

import interfaces.Drink;

public class SpartanDrink implements Drink {

    @Override
    public boolean drink() {
        boolean rta = true;
        int diceRoll = (int)(Math.random() * 6) + 1;
        if (diceRoll>5){
            rta = false;
        }
        return rta;
    }
}
