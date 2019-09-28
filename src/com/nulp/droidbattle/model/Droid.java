package com.nulp.droidbattle.model;

import java.util.Random;

public class Droid {

  private String name;
  private Integer health;
  private Integer maxDamage;
  protected  Random random = new Random();

  public Droid(String name, Integer health, Integer maxDamage) {
    this.name = name;
    this.health = health;
    this.maxDamage = maxDamage;
  }

  public String getName() {
    return name;
  }

  public Integer getDamage() {
    return random.nextInt(maxDamage + 1);
  }


  public void getHit(Integer damage) {
    health -= damage;
  }
  public void getHeal(Integer heal)
  {
    health += heal;
  }

  public boolean isAlive() {
    return health > 0;
  }

  @Override
  public String toString() {
    return "Droid{" +
        "name='" + name + '\'' +
        ", health=" + health +
        ", damage=" + maxDamage +
        '}';
  }
  public Integer getHealth()
  {
    return this.health;
  }
}
