package com.utn.controller;

import com.utn.dao.ResultDao;
import com.utn.dto.Human;
import com.utn.dto.Result;

import java.util.*;

/**
 * Main controller of the system.
 *
 * @author fgallo94
 */
public class FreshTournament {

    private ResultDao resultDao;
    private Human winner;

    public FreshTournament() {
        resultDao = new ResultDao();
    }

    /**
     * Public method of showLastResults
     */
    public void showResults() {
        showLastWinners();
    }

    /**
     * Put a Human to fight vs last winner if he exists, if isn't present show a message on console
     *
     * @param humanOne Human to fight against the Last winner.
     */
    public void fight(Human humanOne) {
        Optional<Human> winner = Optional.ofNullable(this.getWinner());
        if (winner.isPresent()) {
            this.fightMatch(humanOne, winner.get());
        } else {
            System.out.println("\n The Boss start ROFL!!! LMAO!");
        }
    }

    /**
     * Get Two teams, randomly pick 2 fighters if both is present go to Fight 1 vs 1, if aren't present show message on console
     *
     * @param teamOne List<Human>
     * @param teamTwo List<Human>
     */
    public void fight(List<Human> teamOne, List<Human> teamTwo) {
        sortAndShowList(teamOne);
        sortAndShowList(teamTwo);
        Optional<Human> fighterOne = getRandomFighter(teamOne);
        Optional<Human> fighterTwo = getRandomFighter(teamTwo);
        if (fighterOne.isPresent() &&
                fighterTwo.isPresent()) {
            this.fightMatch(fighterOne.get(), fighterTwo.get());
        } else {
            System.err.println(" Some Human isn't ready for Figth");
        }
    }

    /**
     * This is the 1 v 1 fight, get Humans into a list, call drinkUntilPee and get (or not) a winner,
     * if is present, show, persist,reset and make Winner of this tournament, if isn' present show a message on console
     *
     * @param fighterOne Human
     * @param fighterTwo Human
     */
    private void fightMatch(Human fighterOne, Human fighterTwo) {
        List<Human> listOfFighters = addToFightersList(fighterOne, fighterTwo);
        Optional<Human> winner = drinkUntilPee(listOfFighters);
        if (winner.isPresent()) {
            showWinner(winner.get());
            saveWinner(winner.get());
            restInBed(winner.get());
            this.winner = winner.get();
        } else {
            System.out.println("In the last drink both Human pee");
        }
    }

    /**
     * Show last Results of Fights from DataBase
     */
    private void showLastWinners() {
        System.out.println("----Last Winners Are ----\n");
        System.out.println(resultDao.getResults().toString());
        System.out.println("-----------------------\n");
    }

    /**
     * Show on console the winner
     *
     * @param winner Human
     */
    private void showWinner(Human winner) {
        System.out.println("\n The winner is: " + winner.toString() + "\n");
    }

    /**
     * Save on database the result of the fight
     *
     * @param winner Human
     */
    private void saveWinner(Human winner) {
        try {
            Result resultSave = new Result(winner.getName(), winner.getDrinkedBeers());
            resultDao.saveResult(resultSave);
        } catch (Exception ex) {
            System.err.println("Problems saving data.");
        }
    }

    /**
     * First check if the list is empty, then start to iterate until someone have wetPants,
     * on the iteration drink a beer and ask if the Human drink (Can be dodge a drink),if is overlimited of drinks and if it pee (Can be dodge pee)
     * After that, return some fighter with no wet pants.
     *
     * @param fighters List<Human> fighters
     * @return Any winner.
     */
    private Optional<Human> drinkUntilPee(List<Human> fighters) {
        if (!fighters.isEmpty()) {
            while (fighters.stream().noneMatch(Human::isWetPants))
                fighters.forEach(human -> {
                    human.setDrinkedBeers(human.getDrinkedBeers() + 1);
                    if (human.getDrink().drink() &&
                            human.getBeerLimit() <= human.getDrinkedBeers() &&
                            human.getToPee().pee()) {
                        human.setWetPants(true);
                    }
                });
        }
        return fighters.stream()
                .filter(human -> !human.isWetPants())
                .findAny();
    }

    /**
     * Put humans into a list
     *
     * @param human Human...
     * @return List<Human>
     */
    private List<Human> addToFightersList(Human... human) {
        return (Arrays.asList(human));
    }

    /**
     * Make a shuffle on list and take the first Human
     *
     * @param listHuman list to be shuffle
     * @return Human randomly picked
     */
    private Optional<Human> getRandomFighter(List<Human> listHuman) {
        Collections.shuffle(listHuman);
        return listHuman.stream()
                .findFirst();
    }

    /**
     * Sort list and show on console
     *
     * @param team list to be sorted and showed
     */
    private void sortAndShowList(List<Human> team) {
        sortList(team);
        showList(team);
    }

    /**
     * Show on console the result of the list sorted
     *
     * @param team list to be showed
     */
    private void showList(List<Human> team) {
        System.out.println("  Sorted Team \n");
        System.out.println("--------------------\n");
        System.out.println(team.toString());
        System.out.println("--------------------\n");
    }

    /**
     * Sort List<Human> by Age
     *
     * @param listHuman list to be sorted
     */
    private void sortList(List<Human> listHuman) {
        listHuman.sort(Comparator.comparing(Human::getAge));
    }

    /**
     * Private return of winner
     *
     * @return Last Winner
     */
    private Human getWinner() {
        return winner;
    }

    /**
     * Set drinkedBeers in 0
     *
     * @param human human to be restarted
     */
    private void restInBed(Human human) {
        human.setDrinkedBeers(0);
    }
}