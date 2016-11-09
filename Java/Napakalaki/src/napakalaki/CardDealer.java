/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author adriii
 */
public class CardDealer {
    
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Monster> unusedMonster;
    private ArrayList<Monster> usedMonster;
    
    private CardDealer() {
    }
    
    public static CardDealer getInstance() {
        return CardDealerHolder.INSTANCE;
    }
    
    private static class CardDealerHolder {

        private static final CardDealer INSTANCE = new CardDealer();
    }
    
    private void initTreasureCardDeck(){
        //unusedTreasures = ;
    }
    
    private void initMonsterCardDeck(){
        //unusedMonster = ;
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonster(){
        Collections.shuffle(unusedMonster);
    }
    
    public Treasure nextTreasure(){
        
    }
    
    public Monster nextMonster(){
    
    }
    
    public void giveTreasuresBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonster.add(m);
    }
    
    public void initCards(){
    
    }
}
