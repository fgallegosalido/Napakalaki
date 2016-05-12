/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author francisco
 */
public class Dice {
    private static final Dice instance = new Dice();
    
    private Dice(){}
    
    public static Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        Random ran = new Random();
        return ran.nextInt(6) + 1;
    }
}
