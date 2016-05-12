/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author francisco
 */
public class Monster {
    private String name;
    private int combatLevel;
    private int levelChangeAgainstCultistPlayer;
    
    private BadConsequence badConsequence;
    private Prize prize;
    
    public Monster(String Name, int level, BadConsequence bc, Prize prz, int cultLevel){
        name = Name;
        combatLevel = level;
        badConsequence = bc;
        prize = prz;
        levelChangeAgainstCultistPlayer = cultLevel;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return badConsequence;
    }
    
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return combatLevel + levelChangeAgainstCultistPlayer;
    }
    
    @Override
    public String toString(){
        return "Name = " + name + "\nCombat Level = " + Integer.toString(combatLevel) +
               "\nBad Consequence:\n" + badConsequence.toString() + "Prize:\n" + prize.toString() + "\n";
    }
}
