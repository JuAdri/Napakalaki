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
public class PruebaNapakalaki {
    /**
     * @param args the command line arguments
     */
    static ArrayList<Monster> monstruos= new ArrayList();
    
    static ArrayList<Monster> level10(){
        ArrayList<Monster> monsters= new ArrayList();
        
        for(Monster m: monstruos){
            if(m.getCombatLevel()>10)
                monsters.add(m);
        }
        
        return monsters;
    }
    
    static ArrayList<Monster> lose_levels(){
        ArrayList<Monster> monsters= new ArrayList();
        
        for(Monster m: monstruos){
            if(m.getCastigo().getLevels()>0 && m.getCastigo().getnHiddenTreasures()==0 && m.getCastigo().getnVisibleTreasures()==0 && m.getCastigo().getSpecificHiddenTreasures().isEmpty() && m.getCastigo().getSpecificVisibleTreasures().isEmpty())
                monsters.add(m);
        }
        
        return monsters;
    }
    
    static ArrayList<Monster> win_levels(){
        ArrayList<Monster> monsters= new ArrayList();
        
        for(Monster m: monstruos){
            if(m.getPremio().getLevel()>1)
                monsters.add(m);
        }
        
        return monsters;
    }
    
    static ArrayList<Monster> lose_tr_sp(TreasureKind tr){
       ArrayList<Monster> monsters= new ArrayList<Monster>();
       boolean aniadir = true;
        
        for(Monster m: monstruos){
            BadConsequence bad_aux= m.getCastigo();
            if(!m.getCastigo().getSpecificHiddenTreasures().isEmpty())
                for(int i=0; i<bad_aux.getSpecificHiddenTreasures().size(); i++)
                    //System.out.println(bad_aux.getSpecificHiddenTreasures().get(i));
                    if(bad_aux.getSpecificHiddenTreasures().get(i)==tr)
                        monsters.add(m);
            
            if(!bad_aux.getSpecificVisibleTreasures().isEmpty())
                for(int j=0; j<bad_aux.getSpecificVisibleTreasures().size(); j++)
                    if(bad_aux.getSpecificVisibleTreasures().get(j)==tr)
                        monsters.add(m);
        }
        
        return monsters;
    }
    
    public static void main(String[] args) {    //METODO DE LA CLASE
        // TODO code application logic here
        
        /*System.out.println("Estos son los monstruos con más de nivel 10:");
        for(Monster m: level10())
            System.out.println(m);
        
        System.out.println("Estos son los monstruos con te hacen perder solo nivel");
        for(Monster m: lostLevel())
            System.out.println(m);
        
        System.out.println("Estos son los monstruos con un buen rollo");
        for(Monster m: BuenRollo())
            System.out.println(m);
        */
        System.out.println("Estos son los monstruos con perdida de objetos específica");
        for(Monster m: lose_tr_sp(TreasureKind.ONEHAND))      // Probamos con perder una mano
            System.out.println(m);
    }
    
}
