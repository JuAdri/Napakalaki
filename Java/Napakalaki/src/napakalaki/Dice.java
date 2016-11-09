/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author adriii
 */
public class Dice {
    
    private Dice() {
    }
    
    public static Dice getInstance() {
        return DiceHolder.INSTANCE;
    }
    
    private static class DiceHolder {

        private static final Dice INSTANCE = new Dice();
    }
    
    private int nextNumber(){
        return 1;
    }
}
