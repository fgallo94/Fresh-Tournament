package controller;

import dto.Human;

import java.util.*;
import java.util.stream.Collectors;

public class FreshTournament {

    private ArrayList<Human> fighters = new ArrayList<>();

    public static void main(String[] args) {

    }

    private void fight(List<Human> teamOne, List<Human> teamTwo) {
        sortAndShowList(teamOne);
        sortAndShowList(teamTwo);
        Optional<Human> fighterOne = getRandomFighter(teamOne);
        Optional<Human> fighterTwo = getRandomFighter(teamTwo);
        if (fighterOne.isPresent() &&
                fighterTwo.isPresent()) {
            addToFightersList(fighterOne.get(), fighterTwo.get());
            Optional<Human> winner = drinkUntilPee();
            if (winner.isPresent()) {
                showWinner(winner.get());
            } else {
                System.out.println("In the last drink both Human pee");
            }
        } else {
            System.err.println(" Some list doesn't have any Human");
        }
    }

    private void showWinner(Human winner) {
        System.out.println("\n The winner is: " + winner.toString() + "\n");
    }

    private Optional<Human> drinkUntilPee() {
        while (fighters.size() > 1) {
            fighters.forEach(human -> {
                        if (human.getDrink().drink()) {
                            human.setBeerLimit(human.getBeerLimit() - 1);
                            if (human.getToPee().pee()) {
                                fighters.remove(human);
                            }
                        }

                    });
        }
        return fighters.stream().findFirst();
    }

    private void addToFightersList(Human... human) {
        Arrays.stream(human).forEach(h -> {
            fighters.add(h);
        });
    }

    private Optional<Human> getRandomFighter(List<Human> listHuman) {
        Collections.shuffle(listHuman);
        return listHuman.stream().findFirst();
    }

    private void sortAndShowList(List<Human> team) {
        sortList(team);
        showList(team);
    }

    private void showList(List<Human> team) {
        System.out.println("\n  Sorted Team \n");
        System.out.println("\n--------------------\n");
        System.out.println(team.toString());
        System.out.println("\n--------------------\n");
    }

    private List<Human> sortList(List<Human> listHuman) {
        return listHuman.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void evenFight(Human fighterOne, Human fighterTwo) {
        fighterOne.getDrink().drink();
        fighterTwo.getDrink().drink();
        fighterOne.getToPee().pee();
        fighterTwo.getToPee().pee();
    }

    private Boolean fightVsBoss() {
        boolean result = false;
        return result;
    }
}
