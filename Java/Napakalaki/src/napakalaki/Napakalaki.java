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
 * @author juane
 */
public class Napakalaki {
    private static final Napakalaki instance= new Napakalaki();
    
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    
    private void  initPlayers(String[] names){}
    
    private Player nextPlayer(){}
    
    private boolean nextTurnAllowed(){
        if(getCurrentPlayer() == null)
            return true;
        return getCurrentPlayer().validState();
    }
    
    private void setEnemies(){
        boolean no_asignado = true;
        for(int i = 1; i <= players.size(); i++){
            while(no_asignado){
                int aleatorio = (int) (Math.random() * players.size() + 1);
                if(aleatorio != i){
                    players.get(i).setEnemy(players.get(aleatorio));
                    no_asignado = false;
                }
            }
            no_asignado = true;
        }         
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){}
    public void discardVisibleTreasures(ArrayList<Treasure> tr_vis){}
    public void discardHiddenTreasures(ArrayList<Treasure> tr_hid){}
    public void makeTreasuresVisible(ArrayList<Treasure> tr){}
    public void initGame(String[] players){}
    public Player getCurrentPlayer(){}
    public Monster getCurrentMonster(){}
    public boolean nextTurn(){}
    public boolean endOfGame(CombatResult result){
        if(result == result.WINGAME)
            return true;
        return false;
    }
}
