/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author francisco
 */
public class Player {
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private BadConsequence pendingBadConsequence;
    
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    
    public Player(String name){}
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){}
    
    private int getCombatLevel(){}
    
    private void incrementLevels(int i){}
    
    private void decrementLevels(int i){}
    
    private void setPendingBadConsequence(BadConsequence b){}
    
    private void applyPrize(Monster m){}
    
    private void applyBadConsequence(Monster m){}
    
    private boolean canMakeTreasureVisible(Treasure t){}
    
    private int howManyVisibleTreasures(TreasureKind tKind){}
    
    private void dieIfNoTreasures(){}
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public CombatResult combat(Monster m){}
    
    public void makeTreasureVisible(Treasure t){}
    
    public void discardVisibleTreasure(Treasure t){}
    
    public void discardHiddenTreasure(Treasure t){}
    
    public boolean validState(){}
    
    public void initTreasures(){}
    
    public int getLevels(){}
    
    public void discardAllTreasures(){}
}
