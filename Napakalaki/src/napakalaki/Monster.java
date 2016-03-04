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
    
    @Override
    public String toString(){
        return "\nName = " + name + "\nCombat Level = " + Integer.toString(combatLevel) +
               "\nBad Consequence:" + badCons.toString() + "\nPrize:" + prize.toString() + "\n";
    }
}
