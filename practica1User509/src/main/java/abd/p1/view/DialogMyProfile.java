/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JOptionPane;

import abd.p1.controller.Controlador;
import abd.p1.model.Usuario;

/**
 *
 * @author JuanluRomero
 */
public class DialogMyProfile extends javax.swing.JDialog{
	private static final long serialVersionUID = 1L;
	
	private Controlador c;
    /**
     * Creates new form DialogMyProfile
     */
    public DialogMyProfile(java.awt.Frame parent, boolean modal, Controlador c) {
    	super(parent, modal);
    	this.c = c;
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPanel1 = new abd.p1.view.UserPanel(this.c.getU());
        buttonCambiarPass = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        userPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonCambiarPass.setText("Cambiar contraseña");
        buttonCambiarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarPassActionPerformed(evt);
                String s = JOptionPane.showInputDialog("Nueva contraseña:");
                if (s != null){
                	c.getU().setPassword(s);
                }
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
                Usuario u = c.recuperarUsuario(c.getU().getEmail());
                if (u != null)
                	c.setU(u);
                dispose();
            }
        });
        

        buttonGuardar.setText("Guardar cambios");
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
                Usuario u = c.getU();
                //	Descripcion
                String newDesc = userPanel1.getDescripcion();
                u.setDescripcion(newDesc);
                
                //	Fecha nacimiento
                Date fnac = (Date) userPanel1.getFnac();
                if (u.getGenero() != null){
                	c.guardarCambios(u);
                	dispose();
                }
                else{
                	JOptionPane.showConfirmDialog(null, "Debes indicar tu género.", "ERROR", JOptionPane.CLOSED_OPTION);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCambiarPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar)
                        .addContainerGap())
                    .addComponent(userPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCambiarPass)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void buttonGuardarActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	protected void buttonCambiarPassActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
		
    }//GEN-LAST:event_buttonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DialogMyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogMyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogMyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogMyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogMyProfile dialog = new DialogMyProfile(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCambiarPass;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonGuardar;
    private abd.p1.view.UserPanel userPanel1;
    // End of variables declaration//GEN-END:variables
}