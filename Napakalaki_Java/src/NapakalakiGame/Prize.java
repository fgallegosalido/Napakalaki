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
public class Prize {
    private int treasures; 
    private int level;
    
    public Prize(int numTreasures, int numLevel){
        treasures = numTreasures;
        level = numLevel;
    }
    
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevel(){
        return level;
    }
    
    @Override
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + "\nLevels = " + Integer.toString(level) + "\n";
    }
}
