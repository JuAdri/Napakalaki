/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author juane619
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize premio;
    private BadConsequence bc;
    //EXAMEN
    private ArrayList<Food> foods;
    //FIN EXAMEN
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
       this.name= name;
       this.combatLevel= level;
       this.premio= prize;
       this.bc= bc;             
    }

    public String getName() {
        return name;
    }

    

    public int getLevelsGained(){
        return premio.getLevel();
    }
    
    public int getTreasuresGained(){
        return premio.getTreasures();
    }

    public BadConsequence getBadConsequence() {
        return bc;
    }
    
    //EXAMEN
    public ArrayList<Food> getFoods(){
        return foods;
    }
    
    public void addFood(Food f){
        foods.add(f);
    }
    
    public int getCombatLevel(){
        int media_calorias=0, i=0;
        
        for(i=0; i<foods.size(); i++){
            media_calorias+=foods.get(i).getCalories();
        }
        media_calorias=media_calorias/foods.size();
        
        return media_calorias;
    }
    //FIN EXAMEN
    
    public String toString(){
        return "\n\nNombre del monstruo= " +name + "\nNivel de combate= "+Integer.toString(combatLevel)+"\nPremio: " +premio.toString()+"\nCASTIGO: " + bc.toString();
    }
}
