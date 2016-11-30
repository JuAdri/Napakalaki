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
public class BadConsequence {
    static final int MAXTREASURES=10;
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures= new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures= new ArrayList();
    
    public BadConsequence(String text, int levels, int nVIsible, int nHidden){
        this.text= text;
        this.levels= levels;
        this.nHiddenTreasures= nHidden;
        this.nVisibleTreasures= nVIsible;
        this.specificHiddenTreasures = new ArrayList();
        this.specificVisibleTreasures = new ArrayList();
    }
    
    public BadConsequence(String text, boolean death){
        this.text= text;
        this.death= death;
        this.levels = 1;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
        this.specificHiddenTreasures = new ArrayList();
        this.specificVisibleTreasures = new ArrayList();
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text= text;
        this.levels= levels;
        this.specificHiddenTreasures= tHidden;
        this.specificVisibleTreasures= tVisible;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
    }
    
    public Boolean isEmpty(){
        return nVisibleTreasures==0 && 
                nHiddenTreasures==0 && 
                specificHiddenTreasures.isEmpty() && 
                specificVisibleTreasures.isEmpty();
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        int pn_vis=v.size(), pn_hid= h.size();
        ArrayList<TreasureKind> sp_v=new ArrayList(), sp_h=new ArrayList();
        BadConsequence bad_ret=new BadConsequence(this.text, this.levels, sp_v, sp_h);
        
        if(!isEmpty()){
            if(nHiddenTreasures==0 && nVisibleTreasures==0){
                for(TreasureKind spvi :specificVisibleTreasures){
                    for(Treasure spvp :v)
                        if(spvi==spvp.getType())
                            sp_v.add(spvi);
                }
                
                for(TreasureKind sphi :specificHiddenTreasures){
                    for(Treasure sphp :h)
                        if(sphi==sphp.getType())
                            sp_h.add(sphi);
                }
                bad_ret.specificVisibleTreasures= sp_v;
                bad_ret.specificHiddenTreasures= sp_h;
            }
            else{
                if(pn_vis<nVisibleTreasures)
                    bad_ret.nVisibleTreasures=pn_vis;
                
                if(pn_hid<nHiddenTreasures)
                    bad_ret.nHiddenTreasures=pn_hid;
            }
            return bad_ret;
        }
        return this;
    }

     public int getLevels() {
        return levels;
    }
    
    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures() {
        return nHiddenTreasures;
    }


    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t){
        specificVisibleTreasures.remove(t.getType());
    }
    
    public void substractHiddenTreasure(Treasure t){
        specificHiddenTreasures.remove(t.getType());
    }
    
    public String toString(){
        return "\nMal rollo= " +text + 
                "\nPErderas niveles= "+Integer.toString(levels)+
                "\nPErderas tesoros visibles= " + Integer.toString(nVisibleTreasures)+
                "\nPErderas Tesoros ocultos: " +  Integer.toString(nHiddenTreasures)+
                "\nMoriras: " + Boolean.toString(death) +
                "\nPerderas estos tesoros especificos visibles: " + specificVisibleTreasures.toString() +
                "\nPerderas estos tesoros especificos ocultos: " + specificHiddenTreasures.toString();
    }
}
