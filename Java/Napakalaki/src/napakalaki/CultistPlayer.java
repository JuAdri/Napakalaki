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
public class CultistPlayer extends Player{
    private static int totalCultistPlayers=0;
    
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard= c;
        totalCultistPlayers++;
    }
    
    protected int getCombatLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        
    }
    
    @Override
    protected boolean shouldConvert(){
        
    }
    
    private Treasure giveMeATreasure(){
        
    }
    
    private void canYouyGiveMeATreasure(){
        
    }
    
    public int getTotalCultistPlayers(){
        
    }
}
