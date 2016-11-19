/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author juane619
 */
public class Food {
    private static String kindOfDiet;
    public String name;
    private int calories;
    
    Food(String n, int c){
        name= n;
        calories= c;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCalories(){
        return calories;
    }
    
    private void setName(String n){
        name= n;
    }
    
    private void setCalories(int c){
        calories= c;
    }
    
    private static void setKindOfDiet(String k){
        kindOfDiet= k;
    }
}
