/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import napakalaki.BadConsequence;

/**
 *
 * @author juane
 */
public class BadConsequenceView extends javax.swing.JPanel {
    BadConsequence bad_model;
    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
        initComponents();
    }

    public void setBad(BadConsequence p_bad){
        bad_model= p_bad;
        
        this.ind_descr_bad.setText("<HTML>asdgsdajgsdagsdahujghsdughsdughusdhgusdguisdhagusadhguhsdauighsduahguisadhguiasd</HTML>");
        
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_tittle_bad = new javax.swing.JLabel();
        ind_descr_bad = new javax.swing.JLabel();

        l_tittle_bad.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        l_tittle_bad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_tittle_bad.setText("BAD CONSEQUENCE");

        ind_descr_bad.setText("<HTML>asdgsdajgsdagsdahujghsdughsdughusdhgusdguisdhagusadhguhsdauighsduahguisadhguiasd</HTML>");
        ind_descr_bad.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ind_descr_bad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ind_descr_badFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_tittle_bad, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(ind_descr_bad, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_tittle_bad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ind_descr_bad, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ind_descr_badFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ind_descr_badFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ind_descr_badFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ind_descr_bad;
    private javax.swing.JLabel l_tittle_bad;
    // End of variables declaration//GEN-END:variables
}
