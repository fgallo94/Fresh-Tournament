package dto;

import interfaces.Drink;
import interfaces.ToPee;

public class Spartan extends Human {
    private Integer peeBuff;

    public Spartan(String name, Integer age, Integer weight, ToPee toPee, Drink drink) {
        super(name, age, weight, toPee, drink);
        this.peeBuff = 1;
    }

    public Integer getPeeBuff() {
        return peeBuff;
    }

    public void setPeeBuff(Integer peeBuff) {
        this.peeBuff = peeBuff;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                super.toString()+
                "peeBuff=" + peeBuff +
                '}';
    }
}
