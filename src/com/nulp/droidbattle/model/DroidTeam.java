package com.nulp.droidbattle.model;

import java.util.ArrayList;
import java.util.Random;

public class DroidTeam{
    private static Random random = new Random();

    private String name;
    private ArrayList<Droid> droidTeam = new ArrayList<>();

    public DroidTeam(ArrayList<Droid> Team , String name) {
        this.droidTeam.addAll(Team);
        this.name = name;
    }

    public DroidTeam(ArrayList<Droid> Team)
    {
        this.droidTeam.addAll(Team);
    }

    public void inizializate(ArrayList<Droid>Team) {
        this.droidTeam.addAll(Team);

    }


    public ArrayList<Droid> getArrayList()
    {
        return this.droidTeam;
    }

    private void isTeammateAlive() {
        // якщо дроїд мертвий видаляємо його з Array List

        for (int i = 0; i < droidTeam.size(); i++) {

            if(!droidTeam.get(i).isAlive())
            {
                droidTeam.remove(i);
            }
        }
    }

    public boolean isTeamAlive() {
        isTeammateAlive();
        return droidTeam.size() > 0;
    }

    public void healTeam() {

        if (isTeamHaveHealer()) {
            droidTeam.get(random.nextInt(droidTeam.size())).getHeal(random.nextInt(4));

        }
    }


    private boolean isTeamHaveHealer() {
        for (Object obj : droidTeam) {
            if (obj instanceof DroidHealer) {
                return true;
            }
        }
        return false;
    }

    public void getDamage(Integer iterations)  //Передається розмір іншої команди команди(кількість ітерацій або атак по команді )
    {
        for (int i = 0; i < iterations ; i++) {
            if(isTeamAlive())
            droidTeam.get(random.nextInt(droidTeam.size())).getHit(10);  //Отримуємо рандомного дроїда з команди та завдаємо йому певну шкоду
        }
    }
    public void printTeamInfo()
    {
        System.out.println("-------------------------------------------------------------------------------");
        for (Droid obj:
             droidTeam) {
            System.out.println(obj.getName());
            System.out.println(obj.getHealth());
        }
        System.out.println("-------------------------------------------------------------------------------");

    }
public void clear()
{
    droidTeam.clear();
}
public void addAll(ArrayList<Droid> tmpList)
{
    droidTeam.addAll(tmpList);

}

public String getTeamName()
{
    return this.name;
}

}
