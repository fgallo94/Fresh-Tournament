package com.utn.controller;

public class Dice {

    public static Integer roll() {
        return (int) (Math.random() * 6) + 1;
    }
}