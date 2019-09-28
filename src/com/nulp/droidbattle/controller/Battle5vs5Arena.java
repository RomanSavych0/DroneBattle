package com.nulp.droidbattle.controller;

import com.nulp.droidbattle.model.Droid;
import com.nulp.droidbattle.model.DroidHealer;
import com.nulp.droidbattle.model.DroidTeam;

import java.util.ArrayList;
import java.util.Random;

public class Battle5vs5Arena {
    private DroidTeam defendTeam;
    private DroidTeam attakerTeam;

    private int currentRoud = 0;
    Random random;

    public Battle5vs5Arena(ArrayList<Droid> firstTeam  , String firstTeamName , ArrayList<Droid> secondTeam , String secondTeamName) {
        boolean attackTeam = new Random().nextBoolean();
        if (attackTeam) {
             attakerTeam = new DroidTeam(firstTeam , firstTeamName);
            defendTeam = new DroidTeam(secondTeam , secondTeamName);
        } else {
            attakerTeam = new DroidTeam(secondTeam , secondTeamName);
            defendTeam = new DroidTeam(firstTeam , firstTeamName);
        }
    }


   public void fight() {
        do {
            System.out.println( "Round " + currentRoud++);
            swapTeams();
            nextRound();
            attakerTeam.printTeamInfo();
        }
        while (defendTeam.isTeamAlive());
       System.out.println(attakerTeam.getTeamName() + " is win");

    }

    private void nextRound() {
        currentRoud++;
        attakerTeam.healTeam();
        defendTeam.getDamage(attakerTeam.getArrayList().size()); /*
        Передаємо розмір команди яка атакує(пізніше це число буде кількістю ітерацій)
        Розмір - кількість атак команди яка атакує по команді яка захищається
        */
    }

    //Поміняти місцями атакуючу команду та команду яка буде захищаись
    private void swapTeams() {
        ArrayList<Droid> tmpList = new ArrayList<Droid>(attakerTeam.getArrayList()); //отримуємо приватне поле з нашого контейнера для дроїдів
        attakerTeam.clear();
        attakerTeam.addAll(defendTeam.getArrayList());
        defendTeam.clear();
        defendTeam.addAll(tmpList);
    }

}