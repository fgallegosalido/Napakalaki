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
public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist(String n, int levels){
        name = n;
        gainedLevels = levels;
    }
    
    public String getName(){
        return name;
    }
    
    public int getGainedLevels(){
        return gainedLevels;
    }
    
    @Override
    public String toString(){
        return name  + ", gainedLevels=" + Integer.toString(gainedLevels);
    }
}
