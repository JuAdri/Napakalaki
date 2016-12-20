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
public abstract class BadConsequence {
    static final int MAXTREASURES=10;
    
    protected String text;
    protected int levels;
    
    public BadConsequence(String p_text, int p_lev){
        text= p_text;
        levels= p_lev;
    }
    
    public abstract Boolean isEmpty();
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence bad_ret;
        
        if(!isEmpty()){
            if(nHiddenTreasures==0 && nVisibleTreasures==0){
                Boolean insertado=false;
                
                ArrayList<TreasureKind> sp_v=new ArrayList(), sp_h=new ArrayList();
                
                for(TreasureKind spvi :specificVisibleTreasures){
                    insertado= false;
                    for(Treasure spvp :v){
                        if(!insertado)
                            if(spvi==spvp.getType()){
                                if(!sp_v.contains(spvi)){
                                    sp_v.add(spvi);
                                    insertado=true;
                                }
                            }
                    }
                }
                
                for(TreasureKind sphi :specificHiddenTreasures){
                    insertado= false;
                    for(Treasure sphp :h){
                        if(!insertado)
                            if(sphi==sphp.getType()){
                                if(!sp_h.contains(sphi)){
                                    sp_h.add(sphi);
                                    insertado= true;
                                }
                            }
                    }
                }
                bad_ret= new BadConsequence(text, levels, sp_v, sp_h);
            }
            else{
                int pn_vis=v.size();
                int pn_hid= h.size();
                
                pn_vis=pn_vis>nVisibleTreasures?nVisibleTreasures:pn_vis;
                pn_hid=pn_hid>nHiddenTreasures?nHiddenTreasures:pn_hid;
                bad_ret= new BadConsequence(text, levels, pn_vis, pn_hid);
            }
            return bad_ret;
        }
        return this;
    }

     public int getLevels() {
        return levels;
    }
    
    


    
    
    public void substractVisibleTreasure(Treasure t){
        if(!specificVisibleTreasures.isEmpty()){
            specificVisibleTreasures.remove(t.getType());
            if(nVisibleTreasures!=0)
                nVisibleTreasures--;
        }
        else if(nVisibleTreasures!=0)
            nVisibleTreasures--;
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(!specificHiddenTreasures.isEmpty()){
            specificHiddenTreasures.remove(t.getType());
            if(nHiddenTreasures!=0)
                nHiddenTreasures--;
        }
        else if(nHiddenTreasures!=0)
            nHiddenTreasures--;
    }
    
    public String toString(){
        return "\n\nMal rollo= " +text + 
                "\nPErderas niveles= "+Integer.toString(levels)+
                "\nPErderas tesoros visibles= " + Integer.toString(nVisibleTreasures)+
                "\nPErderas Tesoros ocultos: " +  Integer.toString(nHiddenTreasures)+
                "\nMoriras: " + Boolean.toString(death) +
                "\nPerderas estos tesoros especificos visibles: " + specificVisibleTreasures.toString() +
                "\nPerderas estos tesoros especificos ocultos: " + specificHiddenTreasures.toString();
    }
}
