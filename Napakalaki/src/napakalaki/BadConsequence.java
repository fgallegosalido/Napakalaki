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
public class BadConsequence {
    static final int MAXTREASURES = 10;
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    public BadConsequence(String Text, int numLevels, int nVisible, int nHidden){
        text = Text;
        levels = numLevels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    public BadConsequence(String Text){
        text = Text;
        levels = 10;
        nVisibleTreasures = 10;
        nHiddenTreasures = 10;
    }
    
    public BadConsequence(String Text, int numLevels, ArrayList<TreasureKind> tVisible, 
                            ArrayList<TreasureKind> tHidden){
        text = Text;
        levels = numLevels;
        nVisibleTreasures = -1;
        specificVisibleTreasures = tVisible;
        nHiddenTreasures = -1;
        specificHiddenTreasures = tHidden;
    }
    
    public boolean isEmpty(){}
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getVisible(){
        return nVisibleTreasures;
    }
    
    public int getHidden(){
        return nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public void substractVisibleTreasures(Treasure t){}
    
    public void substractHiddenTreasures(Treasure t){}
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){}
    
    @Override
    public String toString(){
        return "Text = " + text + "\nLevels = " + Integer.toString(levels) +
               "\nVisible Treasures = " + Integer.toString(nVisibleTreasures) +
               "\nHidden Treasures = " + Integer.toString(nHiddenTreasures) +
               "\nSpecific Visible Treasures = " + specificVisibleTreasures.toString() +
               "\nSpecific Hidden Treasures = " + specificHiddenTreasures.toString() + "\n"; 
    }
 }
