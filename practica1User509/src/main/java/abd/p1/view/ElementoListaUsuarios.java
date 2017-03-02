/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import javax.swing.ImageIcon;

/**
 *
 * @author JuanluRomero
 */
public class ElementoListaUsuarios extends javax.swing.JPanel {
    private String nombre = "Nombre";
    private int edad = 22;
    private byte[] avatar;
    /**
     * Creates new form ElementoListaUsuarios
     */
    public ElementoListaUsuarios() {
        initComponents();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
        labelNombre.setText(nombre);
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public void setEdad (int n){
        this.edad = n;
        if (edad > 0)
        	labelEdad.setText(this.edad + " años");
        else 
        	labelEdad.setText("");
    }
    public byte[] getAvatar(){
        return this.avatar;
    }
    public void setAvatar (byte[] avatar){
        this.avatar = avatar;
        this.avatarUsuario.setIcon(new ImageIcon(avatar));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        avatarUsuario = new abd.p1.view.AvatarPanel();

        labelNombre.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelNombre.setText("Nombre");

        labelEdad.setText("edad");

        javax.swing.GroupLayout avatarUsuarioLayout = new javax.swing.GroupLayout(avatarUsuario);
        avatarUsuario.setLayout(avatarUsuarioLayout);
        avatarUsuarioLayout.setHorizontalGroup(
            avatarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        avatarUsuarioLayout.setVerticalGroup(
            avatarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(avatarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(labelEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEdad)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addComponent(avatarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abd.p1.view.AvatarPanel avatarUsuario;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables
}
