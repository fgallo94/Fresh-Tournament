package dto;

import interfaces.Drink;
import interfaces.ToPee;

public class Viking extends Human {
    private static final Integer drinkBuff = 2;

    public Viking(String name, Integer age, Integer weight, ToPee pee, Drink drink) {
        super(name, age, weight, pee, drink);
        setBeerLimit(getBeerLimit() + 2);
    }

    public static Integer getDrinkBuff() {
        return drinkBuff;
    }

    @Override
    public String toString() {
        return "Viking{" +
                super.toString() +
                "drinkBuff=" + drinkBuff +
                '}';
    }
}
