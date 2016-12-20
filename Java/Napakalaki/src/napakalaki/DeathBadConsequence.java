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
public class DeathBadConsequence extends NumericBadConsequence{
    private boolean death;
    
    public DeathBadConsequence(String p_text, boolean p_death){
        super(p_text, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
        death= p_death;
    }
}
