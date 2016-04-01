/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author francisco
 */
public class Monster {
    private String name;
    private int combatLevel;
    
    private BadConsequence badCons;
    private Prize prize;
    
    public Monster(String Name, int level, BadConsequence bc, Prize prz){
        name = Name;
        combatLevel = level;
        badCons = bc;
        prize = prz;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return badCons;
    }
    
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    @Override
    public String toString(){
        return "Name = " + name + "\nCombat Level = " + Integer.toString(combatLevel) +
               "\nBad Consequence:\n" + badCons.toString() + "Prize:\n" + prize.toString() + "\n";
    }
}
