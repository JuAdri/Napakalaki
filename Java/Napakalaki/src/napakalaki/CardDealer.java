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
public class CardDealer {
    
    private CardDealer() {
    }
    
    public static CardDealer getInstance() {
        return CardDealerHolder.INSTANCE;
    }
    
    private static class CardDealerHolder {

        private static final CardDealer INSTANCE = new CardDealer();
    }
    
    private void initTreasureCardDeck(){
    
    }
    
    private void initMonsterCardDeck(){
    
    }
    
    private void shuffleTreasures(){
    
    }
    
    private void shuffleMonster(){
    
    }
    
    public Treasure nextTreasure(){
        
    }
    
    public Monster nextMonster(){
    
    }
    
    public void giveTreasuresBack(Treasure t){
    
    }
    
    public void giveMonsterBack(Monster m){
    
    }
    
    public void initCards(){
    
    }
}
