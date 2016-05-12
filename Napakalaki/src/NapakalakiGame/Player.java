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
public class Player {
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private BadConsequence pendingBadConsequence;
    
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    
    public Player(String n){
        name = n;
        level = 1;
        pendingBadConsequence = new NumericBadConsequence("", 0, 0, 0);
    }
    
    public Player(Player pl){
        name = pl.getName();
        level = pl.getLevels();
        dead = pl.isDead();
        pendingBadConsequence = pl.getPendingBadConsequence();
        visibleTreasures = new ArrayList(pl.getVisibleTreasures());
        hiddenTreasures = new ArrayList(pl.getHiddenTreasures());
    }
    
    public String getName(){
        return name;
    }
    
    public int getLevels(){
        return level;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    protected int getCombatLevel(){
        int suma = level;
        for (Treasure element : visibleTreasures){
            suma += element.getBonus();
        }
        return suma;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        return Dice.getInstance().nextNumber() == 6;
    }
    
    private void incrementLevels(int i){
        level += i;
    }
    
    private void decrementLevels(int i){
        if ((level - i) <= 1){
            level = 1;
        }
        else{
            level -= i;
        }
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();

        if (nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            Treasure treasure;

            for (int i=0; i<nTreasures; i++){
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        if (t.getType() == TreasureKind.ONEHAND){
            return (howManyVisibleTreasures(TreasureKind.ONEHAND) < 2) && (howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0);
        }
        else if (t.getType() == TreasureKind.BOTHHANDS){
            return (howManyVisibleTreasures(TreasureKind.ONEHAND) == 0) && (howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0);
        }
        else{
            return howManyVisibleTreasures(t.getType()) == 0;
        }
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int suma = 0;
    
        for (Treasure element : visibleTreasures){
            if (element.getType() == tKind){
                suma += 1;
            }
        }
        
        return suma;
    }
    
    private void dieIfNoTreasures(){
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty()){
            dead = true;
        }
    }
    
    public CombatResult combat(Monster m){
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        CombatResult combatResult;

        if (myLevel > monsterLevel){
            applyPrize(m);
            
            if (level >= MAXLEVEL){
                combatResult = CombatResult.WINGAME;
            }
            else{
                combatResult = CombatResult.WIN;
            }
        }
        else{
            applyBadConsequence(m);
            
            if (shouldConvert()){
                combatResult = CombatResult.LOSEANDCONVERT;
            }
            else{
                combatResult = CombatResult.LOSE;
            }
        }
        
        return combatResult;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);

        if (canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);

        if (pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure(t);
        }

        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);

        if (pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure(t);
        }

        dieIfNoTreasures();
    }
    
    public boolean validState(){
        System.out.println(pendingBadConsequence.toString());
        return pendingBadConsequence.isEmpty() && (hiddenTreasures.size() <= 4);
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        
        int number = dice.nextNumber();

        if (number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }

        if (number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> auxVisible = new ArrayList(visibleTreasures);
        ArrayList<Treasure> auxHidden = new ArrayList(hiddenTreasures);

        for (Treasure treasure : auxVisible){
            discardVisibleTreasure(treasure);
        }

        for (Treasure treasure : auxHidden){
            discardHiddenTreasure(treasure);
        }
    }
    
    @Override
    public String toString(){
        return name + ", level " + Integer.toString(level);
    }
}
