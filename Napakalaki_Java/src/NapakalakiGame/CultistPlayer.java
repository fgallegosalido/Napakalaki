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
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    @Override
    protected int getCombatLevel(){
        double exactSum = super.getCombatLevel();
        exactSum = exactSum + exactSum/2 + totalCultistPlayers*myCultistCard.getGainedLevels();
        return (int) exactSum;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", " + myCultistCard.getName();
    }
}
