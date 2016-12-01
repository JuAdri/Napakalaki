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
        int nLevels= m.getLevelsGained();
        int n_treasures= m.getTreasuresGained();
        
        incrementLevels(nLevels);
        
        if(n_treasures>0){
            CardDealer dealer=CardDealer.getInstance();
            Treasure tr_aux;
            for(int i=0; i<n_treasures; i++){
                tr_aux= dealer.nextTreasure();
                hiddenTreasures.add(tr_aux);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badC= m.getBadConsequence();
        int nLevels= badC.getLevels();
        
        decrementLevels(nLevels);
        
        BadConsequence pendingBad= badC.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private Boolean canMakeTreasureVisible(Treasure t){
        Boolean puede_make=true;
        int n_tr_oh=0;  //Contamos el nº de tesoros de una mano
        for(Treasure tes :visibleTreasures ){
            
            if(tes.getType()==t.getType() && t.getType() != TreasureKind.ONEHAND)
                return false;
            
            if(tes.getType()==TreasureKind.ONEHAND){
                n_tr_oh++;
                
                if(t.getType()==TreasureKind.BOTHHANDS)
                    return false;
            }
            
            if(tes.getType()==TreasureKind.BOTHHANDS && t.getType()==TreasureKind.ONEHAND)
                return false;
                
        }
        if(t.getType()==TreasureKind.ONEHAND && n_tr_oh>=2)
                return false;
        
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
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        CombatResult cr;
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
        }
            if(myLevel > monsterLevel){
                applyPrize(m);
                if(level >= MAXLEVEL) 
                    cr=CombatResult.WINGAME;
                else
                    cr= CombatResult.WIN;
            }
            else{
                applyBadConsequence(m);
                cr= CombatResult.LOSE;
            }
        return cr;
    }
    
        public void makeTreasureVisible(Treasure t){
        Boolean canI=canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        dielfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if(pendingBadConsequence != null && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractHiddenTreasure(t);
        dielfNoTreasures();
    }
    
    public boolean validState(){
        return (hiddenTreasures.size() < 5) && (pendingBadConsequence == null || pendingBadConsequence.isEmpty());
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure t = dealer.nextTreasure();
        hiddenTreasures.add(t);
        int number = dice.nextNumber();
        
        if(number > 1){
            t = dealer.nextTreasure();
            hiddenTreasures.add(t);
        }
        else if(number == 6){
            t = dealer.nextTreasure();
            hiddenTreasures.add(t);
        }
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        Treasure t = null;
        if(canISteal())
            if(enemy.canYouGiveMeATreasure()){
                t = giveMeATreasure();
                hiddenTreasures.add(t);
                haveStolen();
            }
                    
        return t;
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
        ArrayList<Treasure> tr_vis_aux= new ArrayList(visibleTreasures);
        ArrayList<Treasure> tr_hid_aux= new ArrayList(hiddenTreasures);
        
        for(Treasure tr_v :tr_vis_aux)
            discardVisibleTreasure(tr_v);
        
        for(Treasure tr_h :tr_hid_aux)
            discardHiddenTreasure(tr_h);
    }
    
    public String toString(){
        return name;
    }
}
