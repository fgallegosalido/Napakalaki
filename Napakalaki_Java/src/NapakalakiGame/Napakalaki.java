/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author francisco
 */
public class Napakalaki {
    private int currentPlayerIndex;
    private static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private CardDealer dealer = CardDealer.getInstance();
    private Player currentPlayer;
    
    private ArrayList<Player> players = new ArrayList();
    
    
    private Napakalaki(){}
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    private void initPlayers(ArrayList<String> names){
        for (String string : names){
            players.add(new Player(string));
        }
    }
    
    private Player nextPlayer(){
        if (currentPlayerIndex < 0){
            Random ran = new Random();
            currentPlayerIndex = ran.nextInt(players.size());
        }
        else if (currentPlayerIndex == players.size()-1){
            currentPlayerIndex = 0;
        }
        else{
            currentPlayerIndex = currentPlayerIndex+1;
        }
        
        currentPlayer = players.get(currentPlayerIndex);
        
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        return (currentPlayer == null) || currentPlayer.validState();
    }
    
    public CombatResult developCombat(){
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        
        if (combatResult == CombatResult.LOSEANDCONVERT){
            Cultist cultCard = dealer.nextCultist();
            CultistPlayer cultPlayer = new CultistPlayer(currentPlayer, cultCard);
            players.set(currentPlayerIndex, cultPlayer);
            currentPlayer = cultPlayer;
        }
        
        return combatResult;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for (Treasure element : treasures){
            currentPlayer.discardVisibleTreasure(element);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for (Treasure element : treasures){
            currentPlayer.discardHiddenTreasure(element);
        }
    }
    
    public void makeTreasuresVisibles(ArrayList<Treasure> treasures){
        for (Treasure element : treasures){
            currentPlayer.makeTreasureVisible(element);
        }
    }
    
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        dealer.initCards();
        nextTurn();
    }
    
    public boolean nextTurn(){
        boolean stateOK = true;
        if (currentPlayer != null){
            stateOK = nextTurnAllowed();
        }
        
        if (stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            
            if (dead){
                currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    }
}
