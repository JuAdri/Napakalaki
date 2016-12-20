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
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificHiddenTreasures= new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures= new ArrayList();
    
    public SpecificBadConsequence(String p_text, int p_levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(p_text, p_levels);
        this.specificHiddenTreasures= tHidden;
        this.specificVisibleTreasures= tVisible;
    }
    
    
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
}
