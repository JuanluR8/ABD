/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

/**
 *
 * @author JuanluRomero
 */
public class ElementoListaPreguntas extends javax.swing.JPanel {
    private String enunciado = "Enunciado";
    private int numOpciones = 0;
    /**
     * Creates new form ElementoListaPreguntas
     */
    
    public String getEnunciado (){
        return this.enunciado;
    }
    public void setEnunciado (String e){
        this.enunciado = e;
        labelEnunciado.setText(enunciado);
    }
    public int getNumOpciones(){
        return this.numOpciones;
    }
    public void setNumOpciones (int n){
        this.numOpciones = n;
        labelOpciones.setText(numOpciones + " opciones");
    }
    
    public ElementoListaPreguntas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEnunciado = new javax.swing.JLabel();
        labelOpciones = new javax.swing.JLabel();

        labelEnunciado.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        labelEnunciado.setText("Enunciado");

        labelOpciones.setText("Numero opciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEnunciado, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(labelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labelEnunciado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelOpciones)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelEnunciado;
    private javax.swing.JLabel labelOpciones;
    // End of variables declaration//GEN-END:variables
}