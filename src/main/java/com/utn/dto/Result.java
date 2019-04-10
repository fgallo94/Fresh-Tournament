package com.utn.dto;

public class Result {
    private String nameOfWinner;
    private Integer drinkInBody;

    public Result(String nameOfWinner, Integer drinkInBody) {
        this.nameOfWinner = nameOfWinner;
        this.drinkInBody = drinkInBody;
    }

    @Override
    public String toString() {
        return "Result{" +
                "nameOfWinner='" + nameOfWinner + '\'' +
                ", drinkInBody=" + drinkInBody +
                '}';
    }
}