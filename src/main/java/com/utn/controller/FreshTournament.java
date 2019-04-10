package com.utn.controller;

import com.utn.dao.ResultDao;
import com.utn.dto.Human;

import java.util.*;

public class FreshTournament {

    private ArrayList<Human> fighters = new ArrayList<>();
    private ResultDao resultDao;

    public FreshTournament() {
        resultDao = new ResultDao();
    }

    public void fight(List<Human> teamOne, List<Human> teamTwo) {
        showLastWinners();
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
                saveWinner(winner.get());
            } else {
                System.out.println("In the last drink both Human pee");
            }
        } else {
            System.err.println(" Some list doesn't have any Human");
        }
    }

    private void showLastWinners() {
        System.out.println("----Last Winners Are ----\n");
        System.out.println(resultDao.getResults().toString());
        System.out.println("-----------------------\n");
    }

    private void showWinner(Human winner) {
        System.out.println("\n The winner is: " + winner.toString() + "\n");
    }

    private void saveWinner(Human winner) {
        try {
            resultDao.saveResult(winner);
        } catch (Exception ex) {
            System.err.println("Problems saving data.");
        }
    }

    private Optional<Human> drinkUntilPee() {
        while (fighters.stream().noneMatch(Human::isWetPants)) fighters
                .forEach(human -> {
                    human.setDrinkedBeers(human.getDrinkedBeers() + 1);
                    if (human.getDrink().drink() &&
                            human.getBeerLimit() <= human.getDrinkedBeers() &&
                            human.getToPee().pee()) {
                        human.setWetPants(true);
                    }
                });
        return fighters.stream().filter(human -> !human.isWetPants()).findAny();
    }

    private void addToFightersList(Human... human) {
        fighters.addAll(Arrays.asList(human));
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
        System.out.println("  Sorted Team \n");
        System.out.println("--------------------\n");
        System.out.println(team.toString());
        System.out.println("--------------------\n");
    }

    private void sortList(List<Human> listHuman) {
        listHuman.sort(Comparator.comparing(Human::getAge));
    }
    //TODO ADD FIGHT VS BOSS
}