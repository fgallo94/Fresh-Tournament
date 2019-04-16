package com.utn.controller;

public class Dice {

    /**
     * This method generate a random number between 1 and 6
     *
     * @return random Integer
     */
    public static Integer roll() {
        return (int) (Math.random() * 6) + 1;
    }
}