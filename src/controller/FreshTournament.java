package controller;

import dao.ResultDao;
import dto.Human;
import dto.Result;

import java.util.*;
import java.util.stream.Collectors;

public class FreshTournament {

    private ArrayList<Human> fighters = new ArrayList<>();

    public FreshTournament() {
    }

    public void fight(List<Human> teamOne, List<Human> teamTwo) {
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

    private void showWinner(Human winner) {
        System.out.println("\n The winner is: " + winner.toString() + "\n");
    }

    private void saveWinner(Human winner){
        ResultDao resultDao = new ResultDao();
        try{
            resultDao.saveResult(winner);
        }catch(Exception ex){
            System.err.println("Problems saving data.");
        }
    }

    private Optional<Human> drinkUntilPee() {
        while (fighters.stream().noneMatch(h -> h.isWetPants())) {
            fighters.stream()
                    .forEach(human -> {
                        human.setDrinkedBeers(human.getDrinkedBeers() + 1);
                        if (human.getDrink().drink()) {
                            if (human.getBeerLimit() <= human.getDrinkedBeers() &&
                                    human.getToPee().pee()) {
                                human.setWetPants(true);
                            }
                        }

                    });
        }
        return fighters.stream().filter(human -> !human.isWetPants()).findAny();
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
        System.out.println("  Sorted Team \n");
        System.out.println("--------------------\n");
        System.out.println(team.toString());
        System.out.println("--------------------\n");
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
