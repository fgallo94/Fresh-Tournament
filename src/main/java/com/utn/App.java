package com.utn;

import com.utn.controller.FreshTournament;
import com.utn.model.Human;
import com.utn.model.Spartan;
import com.utn.model.SpartanDrink;
import com.utn.model.SpartanPee;
import com.utn.model.Viking;
import com.utn.model.VikingDrink;
import com.utn.model.VikingPee;

import java.util.Arrays;
import java.util.List;

public class App {

    /**
     * Init two List<Human> and one boss of class Human.
     * Init the controller FreshTournament.
     * Show Results of last battles on the console.
     * Fight TeamOne vs TeamTwo and the winner latter fight against the boss.
     */
    public static void main(String[] args) {
        List<Human> teamOne = Arrays.asList(new Viking("Ragnar", 20, new VikingPee(), new VikingDrink()), new Viking("Theon", 14, new VikingPee(), new VikingDrink()));
        List<Human> teamTwo = Arrays.asList(new Spartan("Maximus", 30, new SpartanPee(), new SpartanDrink()), new Spartan("Oret", 21, new SpartanPee(), new SpartanDrink()));

        Human humanBoss = new Human("BigBoss", 32, new SpartanPee(), new VikingDrink());

        FreshTournament freshTournament = new FreshTournament();
        freshTournament.showResults();
        freshTournament.fight(teamOne, teamTwo);
        freshTournament.fight(humanBoss);
    }
}
