/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RetrieveOrder extends javax.swing.JFrame {

    /**
     * Creates new form RetrieveOrder
     */
    public RetrieveOrder() {
        initComponents();
        this.setLocationRelativeTo(null);
         getContentPane().setBackground(new Color(255, 255, 190));
        try{
                OrderBusinessTier bt = new OrderBusinessTier();
                ArrayList order_no = bt.retrieveOrderNo();
                for(int i=0 ; i<order_no.size(); i++){
                    cb_order_no.addItem(order_no.get(i));
                }
    }catch(Exception ex){
        ex.printStackTrace();
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bt_search = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();
        cb_order_no = new javax.swing.JComboBox();
        lb_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Retrieve Order");

        jLabel1.setText("Order No:");

        bt_search.setText("Search");
        bt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_searchActionPerformed(evt);
            }
        });

        bt_cancel.setText("Cancel");
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });

        lb_title.setBackground(new java.awt.Color(200, 100, 200));
        lb_title.setFont(new java.awt.Font("Vrinda", 3, 24)); // NOI18N
        lb_title.setForeground(new java.awt.Color(255, 125, 125));
        lb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_title.setText("Retrieve Order");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cb_order_no, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(bt_search)
                        .addGap(59, 59, 59)
                        .addComponent(bt_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lb_title, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lb_title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_order_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_search)
                    .addComponent(bt_cancel))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_searchActionPerformed
        String order_no = (String)cb_order_no.getSelectedItem();
        
        
           try{
                OrderBusinessTier obt = new OrderBusinessTier();
                String message = obt.retrieveOrder(order_no);
                if(message.equals(null)){
                    JOptionPane.showMessageDialog(null, "Error in Searching");
               dispose();
                }else
                    JOptionPane.showMessageDialog(null, message);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

    }//GEN-LAST:event_bt_searchActionPerformed

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
       dispose();
    }//GEN-LAST:event_bt_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RetrieveOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetrieveOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetrieveOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetrieveOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetrieveOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_search;
    private javax.swing.JComboBox cb_order_no;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_title;
    // End of variables declaration//GEN-END:variables
}
