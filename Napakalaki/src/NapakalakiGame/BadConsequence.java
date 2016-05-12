    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author francisco
 */
public abstract class BadConsequence {
    protected String text;
    protected int levels;
    
    
    protected BadConsequence(String Text, int numLevels){
        text = Text;
        levels = numLevels;
    }
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    @Override
    public String toString(){
        return "Text = " + text + "\nLevels = " + Integer.toString(levels) + "\n"; 
    }
 }
