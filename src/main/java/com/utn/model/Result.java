package com.utn.model;

/**
 * Simple POJO of Result
 */
public class Result {
    private String nameOfWinner;
    private Integer drinkInBody;

    public Result(String nameOfWinner, Integer drinkInBody) {
        this.nameOfWinner = nameOfWinner;
        this.drinkInBody = drinkInBody;
    }

    public String getNameOfWinner() {
        return nameOfWinner;
    }

    public Integer getDrinkInBody() {
        return drinkInBody;
    }

    @Override
    public String toString() {
        return "Result{" +
                "nameOfWinner='" + nameOfWinner + '\'' +
                ", drinkInBody=" + drinkInBody +
                '}';
    }
}