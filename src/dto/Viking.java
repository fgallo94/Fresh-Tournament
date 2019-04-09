package dto;

import interfaces.Drink;
import interfaces.ToPee;

public class Viking extends Human {
    private Integer drinkBuff;

    public Viking(String name, Integer age, Integer weight, ToPee pee, Drink drink) {
        super(name, age, weight, pee, drink);
        this.drinkBuff = 10;
    }

    public Integer getDrinkBuff() {
        return drinkBuff;
    }

    public void setDrinkBuff(Integer drinkBuff) {
        this.drinkBuff = drinkBuff;
    }
}
