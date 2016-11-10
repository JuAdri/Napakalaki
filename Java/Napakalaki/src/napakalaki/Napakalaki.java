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
public class Napakalaki {
    private static final Napakalaki instance= new Napakalaki();
    
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    
    private Napakalaki(){
        currentPlayer= new Player();
        players= new ArrayList<>();
        dealer= new CardDealer();
    }
    private void  initPlayers(String[] names){}
    
    private Player nextPlayer(){}
    
    private boolean nextTurnAllowed(){}
    
    private void setEnemies(){}
    
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
    public boolean endOfGame(CombatResult result){}
}
