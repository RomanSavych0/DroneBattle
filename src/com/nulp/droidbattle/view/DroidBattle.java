package com.nulp.droidbattle.view;

import com.nulp.droidbattle.controller.Battle5vs5Arena;
import com.nulp.droidbattle.controller.BattleArena;
import com.nulp.droidbattle.model.Droid;
import com.nulp.droidbattle.model.DroidHealer;
import com.nulp.droidbattle.model.DroidTeam;

import java.util.ArrayList;

public class DroidBattle {

  public void startGame() {
    ArrayList<Droid>teamOne = new ArrayList<Droid>();
    ArrayList<Droid>secondTeam = new ArrayList<Droid>();

    Droid droid1 = new Droid("Droid1TeamOne", 100, 10);
    Droid droid2 = new Droid("Droid2TeamOne", 100, 10);
    Droid droid3 = new Droid("Droid3TeamOne", 100, 10);
    Droid droid4 = new Droid("Droid4TeamOne", 100, 10);
    Droid droid5 = new DroidHealer("DroidHealer5TeamOne", 100, 10);

    Droid enemyDroid1 = new Droid("Droid1EnemyTeam", 100, 10);
    Droid enemyDroid2 = new Droid("Droid2EnemyTeam", 100, 10);
    Droid enemyDroid3 = new Droid("Droid3EnemyTeam", 100, 10);
    Droid enemyDroid4 = new Droid("Droid4EnemyTeam", 100, 10);
    Droid enemyDroid5 = new DroidHealer("DroidHealer5EnemyTeam", 100, 10);


    teamOne.add(droid1);
    teamOne.add(droid2);
    teamOne.add(droid3);
    teamOne.add(droid4);
    teamOne.add(droid5);

    secondTeam.add(enemyDroid1);
    secondTeam.add(enemyDroid2);
    secondTeam.add(enemyDroid3);
    secondTeam.add(enemyDroid4);
    secondTeam.add(enemyDroid5);


    Battle5vs5Arena battle5vs5Arena = new Battle5vs5Arena(teamOne , "ASU" , secondTeam , "SAPR");
    battle5vs5Arena.fight();

  }
}
