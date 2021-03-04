package practicum;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<Game>();

    public Persoon(String nm, double bud){
        naam = nm;
        budget = bud;
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {
        if (budget < g.huidigeWaarde()) {
            return false;
        }
        else if (mijnGames.contains(g)){
            return false;
        }
        else if (budget >= g.huidigeWaarde() && !mijnGames.contains(g)) {
            budget -= g.huidigeWaarde();
            mijnGames.add(g);
            return true;
        }

        else {return false;}
    }

    public boolean verkoop(Game g, Persoon koper){
        if (koper.budget > g.huidigeWaarde()) {
            for (Game gimma : mijnGames) {
                if (g.equals(gimma)) {
                    for (Game tweedeGimma : koper.mijnGames) {
                        if (g.equals(tweedeGimma))
                            return false;
                    }
                    koper.budget -= g.huidigeWaarde();
                    koper.mijnGames.add(g);
                    budget += g.huidigeWaarde();
                    mijnGames.remove(g);
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        String s = naam+" heeft een budget van €" +String.format("%.2f",budget)+ " en bezit de volgende games:";
            for (Game g : this.mijnGames){
                s += "\n" + g;
            }
            return s;
    }

}
