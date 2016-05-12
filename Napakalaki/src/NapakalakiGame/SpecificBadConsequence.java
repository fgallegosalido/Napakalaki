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
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    public SpecificBadConsequence(String Text, int numLevels, ArrayList<TreasureKind> tVisible, 
                            ArrayList<TreasureKind> tHidden){
        super(Text, numLevels);
        specificVisibleTreasures = new ArrayList(tVisible);
        specificHiddenTreasures = new ArrayList(tHidden);
    }

    @Override
    public boolean isEmpty() {
        return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    }

    @Override
    public void substractVisibleTreasure(Treasure t) {
        int arraysize = specificVisibleTreasures.size();
        for (int i=0; i<arraysize; i++){
            if (t.getType() == specificVisibleTreasures.get(i)){
                specificVisibleTreasures.remove(i);
                break;
            }
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        int arraysize = specificHiddenTreasures.size();
        for (int i=0; i<arraysize; i++){
            if (t.getType() == specificHiddenTreasures.get(i)){
                specificHiddenTreasures.remove(i);
                break;
            }
        }
    }

    @Override
    public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        int size;
        
        ArrayList<TreasureKind> auxVisible = new ArrayList(specificVisibleTreasures);
        ArrayList<TreasureKind> auxArray = new ArrayList(auxVisible);
        for (Treasure treasure : v){
            size = auxArray.size();
            for (int i=0; i<size; i++){
                if (auxArray.get(i) == treasure.getType()){
                    auxArray.remove(i);
                    break;
                }
            }
        }
        
        for (TreasureKind tKind : auxArray){
            auxVisible.remove(tKind);
        }
        
        ArrayList<TreasureKind> auxHidden = new ArrayList(specificHiddenTreasures);
        auxArray = new ArrayList(auxHidden);
        for (Treasure treasure : v){
            size = auxArray.size();
            for (int i=0; i<size; i++){
                if (auxArray.get(i) == treasure.getType()){
                    auxArray.remove(i);
                    break;
                }
            }
        }
        
        for (TreasureKind tKind : auxArray){
            auxHidden.remove(tKind);
        }

        SpecificBadConsequence newBadCons = new SpecificBadConsequence("", 0, auxVisible, auxHidden);
        
        return newBadCons;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Specific Visible Treasures = " + specificVisibleTreasures.toString() +
                             "\nSpecific Hidden Treasures = " + specificHiddenTreasures.toString() + "\n";
    }
}
