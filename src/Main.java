import controller.FreshTournament;
import dto.Human;
import dto.Spartan;
import dto.Viking;
import interfaces.implementation.SpartanDrink;
import interfaces.implementation.SpartanPee;
import interfaces.implementation.VikingDrink;
import interfaces.implementation.VikingPee;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> teamOne = Arrays.asList(new Viking("Ragnar", 20, 80, new VikingPee(), new VikingDrink()), new Viking("Theon", 14, 80, new VikingPee(), new VikingDrink()));
        List<Human> teamTwo = Arrays.asList(new Spartan("Maximus", 30, 80, new SpartanPee(), new SpartanDrink()), new Spartan("Oret", 21, 80, new SpartanPee(), new SpartanDrink()));
        FreshTournament tournament = new FreshTournament();
        tournament.fight(teamOne, teamTwo);
    }
}
