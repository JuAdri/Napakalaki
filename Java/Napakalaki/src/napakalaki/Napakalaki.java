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
    
    public Napakalaki(){
        currentPlayer= new Player("");
        players= new ArrayList();
        currentMonster= new Monster("", 0, null, null);
        dealer= CardDealer.getInstance();
    }
    
    private void  initPlayers(ArrayList<String> names){
        if(names.size()>0){
            Player aux;
            for(int i=0; i<names.size(); i++){
                aux= new Player(names.get(i));
                players.add(aux);
            }
        }
    }
    
    private Player nextPlayer(){
        int index_next=0;
        Player n_pl=null;
        if(currentPlayer==null){
            index_next= (int) (Math.random() * (players.size()-1));
            n_pl= players.get(index_next);
        }
        else{
            index_next=players.indexOf(currentPlayer);
            if(index_next==players.size())
                index_next=0;
            else
                index_next++;
        }
        n_pl= players.get(index_next);
        currentPlayer= n_pl;
        return n_pl;
    }
    
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
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){}
    public boolean endOfGame(CombatResult result){}
}
