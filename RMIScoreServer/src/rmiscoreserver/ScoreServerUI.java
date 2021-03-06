/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiscoreserver;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ibrahim
 */
public class ScoreServerUI extends javax.swing.JFrame {

    DBConnector connector;
    ResultSet result;

    /**
     * Creates new form ServerUI
     */
    public ScoreServerUI() {
        try {
            initComponents();
            this.connector = new DBConnector();
            this.connector.connect();
//            this.connector.connectSQLServer();
            result = connector.results();
            String string = " ";
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int column = 2; column <= columnCount; column++) {
                string += "  " + metaData.getColumnName(column);
            }
            string += "\n";
            while (result.next()) {
                for (int columnIndex = 2; columnIndex <= columnCount; columnIndex++) {
                    string += "         " + result.getString(columnIndex) + "  \t";
                    System.out.print(result.getString(columnIndex));
                }
                string += "\n";
            }

            jTextPane1.setText(string);
        } catch (SQLException ex) {
            Logger.getLogger(ScoreServerUI.class.getName()).log(Level.SEVERE, null, ex);
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
        updateScores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jLabel1.setText("النتائج");

        updateScores.setText("تحديث النتائج");
        updateScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateScoresActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateScores)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1)
                        .addGap(0, 174, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(updateScores)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateScoresActionPerformed
        // TODO add your handling code here:
        try {
            result = connector.results();
            String string = " ";
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int column = 2; column <= columnCount; column++) {
                string += "  " + metaData.getColumnName(column);
            }
            string += "\n";
            while (result.next()) {
                for (int columnIndex = 2; columnIndex <= columnCount; columnIndex++) {
                    string += "         " + result.getString(columnIndex) + "  \t";
                    System.out.print(result.getString(columnIndex));
                }
                string += "\n";
            }

            jTextPane1.setText(string);
        } catch (SQLException ex) {
            Logger.getLogger(ScoreServerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateScoresActionPerformed

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
            java.util.logging.Logger.getLogger(ScoreServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreServerUI().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton updateScores;
    // End of variables declaration//GEN-END:variables
}
