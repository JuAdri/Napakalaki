/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author juane
 */
public class Player {
    static final int MAXLEVEL=10;
    private  String name;
    private int level;
    private boolean dead=true;
    private boolean canISteal=true;
    private Player enemy;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.name= name;
        level=0;
        enemy= null;
        visibleTreasures= new ArrayList();
        hiddenTreasures= new ArrayList();            
    }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        dead=false;
    }
    
    private int getCombatLevel(){
        int i;
        int level_combat=level;
        for(i=0; i<visibleTreasures.size(); i++)
            level_combat+=visibleTreasures.get(i).getBonus();
        
        for(i=0; i<hiddenTreasures.size(); i++)
            level_combat+=hiddenTreasures.get(i).getBonus();
        
        return level_combat;
    }
    
    private void incrementLevels(int i){
        level+=i;
    }
    
    private void decrementLevels(int i){
        level-=i;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(BadConsequence bc){}
    
    private Boolean canMakeTreasureVisible(Treasure t){
        Boolean puede_make=true;
        for(Treasure tes :visibleTreasures ){
            if(tes.getType()==t.getType())
                return false;
        }
        return puede_make;
        
    }
    
    private int howManyVisibleTreasures(TreasureKind t){
        int n_trs=0;
        for(int i=0; i<visibleTreasures.size(); i++)
            if(visibleTreasures.get(i).getType()==t)
                n_trs++;
        return n_trs;
    }
    
    private void dielfNoTreasures(){
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        
    }
    
    public CombatResult combat(Monster m){
        Dice dice;
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        if(!canISteal()){
            dice = Dice.getInstance();
            int number = dice.nextNumber();
            
            if(number < 3){
                int enemyLevel = enemy.getCombatLevel();
                monsterLevel += enemyLevel;
            }
            
            if(myLevel > monsterLevel){
                applyPrize(m);
                return CombatResult.WIN;
            }
            else{
                applyBadConsequence(m.getBadConsequence());
                return CombatResult.LOSE;
            }
        }
    }
    
    public void makeTreasureVisible(Treasure t){
    
    }
    
    public void discardVisibleTreasures(Treasure t){
        visibleTreasures.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        dielfNoTreasures();
    }
    
    public void discardHiddenTreasures(Treasure t){
        hiddenTreasures.remove(t);
        if(pendingBadConsequence != null && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractHiddenTreasure(t);
        dielfNoTreasures();
    }
    
    public boolean validState(){
        return (hiddenTreasures.size() < 5) && pendingBadConsequence.isEmpty();
    }
    
    public void initTreasures(){
    
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
    
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure(){
        return hiddenTreasures.get((int) (Math.random() * hiddenTreasures.size()));
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        return visibleTreasures.size()>0;
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
    
    }
}
