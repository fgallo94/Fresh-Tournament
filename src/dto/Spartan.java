package dto;

import interfaces.Drink;
import interfaces.ToPee;

public class Spartan extends Human {
    private static final Integer peeBuff = 1;

    public Spartan(String name, Integer age, Integer weight, ToPee toPee, Drink drink) {
        super(name, age, weight, toPee, drink);
    }

    public static Integer getPeeBuff() {
        return peeBuff;
    }


    @Override
    public String toString() {
        return "Spartan {" + super.toString() + " }";
    }
}
