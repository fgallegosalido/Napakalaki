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
public class Napakalaki {
    private int currentPlayerIndex;
    private static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    
    private ArrayList<Player> players = new ArrayList();
    
    
    private Napakalaki(){}
    
    private void initPlayers(ArrayList<String> names){}
    
    private Player nextPlayer(){}
    
    private boolean nextTurnAllowed(){}
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){}
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){}
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){}
    
    public void makeTreasuresVisibles(ArrayList<Treasure> treasures){}
    
    public void initGame(ArrayList<String> players){}
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){}
    
    public boolean endOfGame(CombatResult result){}
}
