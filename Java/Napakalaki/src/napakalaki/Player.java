/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
    
    private Boolean canMakeTreasureVisible(Treasure t){
    
    }
    
    private int howManyVisibleTreasures(TreasureKind t){
        int n_trs=0;
        for(int i=0; i<visibleTreasures.size(); i++)
            if(visibleTreasures.get(i).getType()==t)
                n_trs++;
        return n_trs;
    }
    
    private void dielfNoTreasures(){
        dead= true;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        
    }
    
    public CombatResult combat(Monster m){
    
    }
    
    public void makeTreasureVisible(Treasure t){
    
    }
    
    public void discardVisibleTreasures(Treasure t){

    }
    
    public void discardHiddenTreasures(Treasure t){
    
    }
    
    public boolean validState(){
        if(hiddenTreasures.size() < 5 && !pendingBadConsequence)
            return true;
        return false;
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
    
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        if(visibleTreasures.size())
            return true;
        return false;
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
    
    }
}
