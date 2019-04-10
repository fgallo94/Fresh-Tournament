package com.utn;

import com.utn.controller.FreshTournament;
import com.utn.dto.*;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Human> teamOne = Arrays.asList(new Viking("Ragnar", 20, new VikingPee(), new VikingDrink()), new Viking("Theon", 14, new VikingPee(), new VikingDrink()));
        List<Human> teamTwo = Arrays.asList(new Spartan("Maximus", 30, new SpartanPee(), new SpartanDrink()), new Spartan("Oret", 21, new SpartanPee(), new SpartanDrink()));
        FreshTournament tournament = new FreshTournament();
        tournament.fight(teamOne, teamTwo);
    }
}
