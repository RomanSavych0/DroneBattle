package com.nulp.droidbattle.controller;

import com.nulp.droidbattle.model.Droid;

import java.util.Random;

public class BattleArena {

  private Droid attacker;
  private Droid defender;
  private int currentRound = 0;

  public BattleArena(Droid firstDroid, Droid secondDroid) {
    if (new Random().nextBoolean()) {
      attacker = firstDroid;
      defender = secondDroid;
    } else {
      attacker = secondDroid;
      defender = firstDroid;
    }
  }

  public void fight() {
    do {
      swapOpponents();
      nextRound();
    } while (defender.isAlive());

    printWinnerInfo();
  }

  private void nextRound() {
    currentRound++;
    Integer damage = attacker.getDamage();
    defender.getHit(damage);
    printRoundInfo(damage);
  }

  private void swapOpponents() {
    Droid newDefender = attacker;
    Droid newAttacker = defender;
    defender = newDefender;
    attacker = newAttacker;
  }

  private void printRoundInfo(Integer damage) {
    printSeparator();
    System.out.println("Round " + currentRound);

    System.out.println(defender.getName() + " was hit by " + attacker.getName()
        + " with damage " + damage);

    System.out.println("Defender: " + defender);
    System.out.println("Attacker: " + attacker);
  }

  private void printWinnerInfo() {
    printSeparator();
    System.out.println("The winner is " + attacker.getName());
  }

  private void printSeparator() {
    System.out.println("--------------------------------------------");
  }
}
