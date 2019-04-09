package controller;

import dto.Human;

import java.util.List;
import java.util.stream.Collectors;

public class FreshTournament {

    public static void main(String[] args) {

    }

    public void fight(List<Human> teamOne, List<Human> teamTwo) {
        teamOne = sortList(teamOne);
        teamTwo = sortList(teamTwo);
    }

    public List<Human> sortList (List<Human> listHuman){
        return listHuman.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void evenFight(Human fighterOne, Human fighterTwo) {
        fighterOne.getDrink().drink();
        fighterTwo.getDrink().drink();
        fighterOne.getToPee().pee();
        fighterTwo.getToPee().pee();
    }

    public Boolean fightVsBoss() {
        boolean result = false;
        return result;
    }
}
