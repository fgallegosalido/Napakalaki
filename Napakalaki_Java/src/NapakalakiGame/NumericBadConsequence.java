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
public class NumericBadConsequence extends BadConsequence{
    static final int MAXTREASURES = 10;
    protected int nVisibleTreasures;
    protected int nHiddenTreasures;
    
    public NumericBadConsequence(String Text, int numLevels, int nVisible, int nHidden){
        super(Text, numLevels);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    public int getVisible(){
        return nVisibleTreasures;
    }
    
    public int getHidden(){
        return nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        return (nVisibleTreasures == 0) && (nHiddenTreasures == 0);
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if (nVisibleTreasures > 0){
            nVisibleTreasures -= 1;
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if (nVisibleTreasures > 0){
            nVisibleTreasures -= 1;
        }
    }
    
    @Override
    public NumericBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        int nVisTre = nVisibleTreasures;
        int nHidTre = nHiddenTreasures;
        
        if (v.size() < nVisibleTreasures){
            nVisTre = v.size();
        }
    
        if (h.size() < nHiddenTreasures){
            nHidTre = h.size();
        }

        NumericBadConsequence newBadCons = new NumericBadConsequence("", 0, nVisTre, nHidTre);
        return newBadCons;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Visible Treasures = " + Integer.toString(nVisibleTreasures) +
                             "\nHidden Treasures = " + Integer.toString(nHiddenTreasures) + "\n";
    }
}
