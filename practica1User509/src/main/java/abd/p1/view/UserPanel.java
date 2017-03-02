/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;

import abd.p1.controller.Controlador;
import abd.p1.model.Genero;
import abd.p1.model.Usuario;

/**
 *
 * @author JuanluRomero
 */
public class UserPanel extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	
	private String nombre;
    private int edad;
    private boolean editable = true;
    private String [] listAficiones = { };
    private Usuario u;
    //private Controlador c;

	/**
     * Creates new form UserPanel
     */
    public UserPanel (){
        initComponents();
    }
    
    public UserPanel(Usuario u) {
    	this.u = u;
    	initComponents();
        labelNombre.setText(u.getNombre());
        String s = this.u.getDescripcion();
        textDescripcion.setText(s);
        Date fechaNac = this.u.getF_nacimiento();
        if ( fechaNac != null){
        	Calendar cal = new GregorianCalendar();
        	cal.setTime(fechaNac);
        	edad = this.calcularEdad(cal);
        	labelEdad.setText(edad + " años");
        }
        
        if (this.u.getAvatar() != null) {
            this.avatarPanel.setIcon(new ImageIcon (this.u.getAvatar()));
        }
        if (this.u.getGenero() != null)
        	this.labelSexo.setText("Sexo: " + this.u.getGenero().toString());
        
        if (this.u.getGeneroAmigo() != null)
        	this.labelBusca.setText("Busca: " + this.u.getGeneroAmigo().toString());
        else{
        	this.u.setGeneroAmigo(Genero.AMBOS);
        	this.labelBusca.setText("Busca: " + this.u.getGeneroAmigo().toString());
        	}
        
        DefaultListModel m = new DefaultListModel();
        List<String> aficiones = this.u.getAficiones();
        if (aficiones != null){
            for (String aficion : aficiones) {
                m.addElement(aficion);
            }
        }
        this.listaAficiones.setModel(m);
    }
    
    public String[] getListAficiones() {
		return listAficiones;
	}


	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        labelNombre.setText(nombre);
    }

    public int getEdad() {        
        return edad;
    }
    private int calcularEdad(Calendar fechaNac) {
    	
        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) -  fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1; 
        }
	return diffYear;    
    }
    public Date getFnac(){
    	return null;
    }
    
    public void setEdad() {
    	Calendar cal = new GregorianCalendar();
    	cal.setTime(getFnac());
        this.edad = calcularEdad(cal);
        labelEdad.setText(this.edad + "años");
    }
    
    public String getDescripcion(){
    	return this.textDescripcion.getText();
    }
        
    public boolean isEditable() {
        return editable;
    }
    
    public void setEditable(boolean editable) {
        this.editable = editable;
        buttonAddAficion.setVisible(editable);
        buttonCambiarAvatar.setVisible(editable);
        buttonFecha.setVisible(editable);
        buttonCambiarNombre.setVisible(editable);
        buttonCambiarPref.setVisible(editable);
        buttonCambiarSexo.setVisible(editable);
        buttonEditarAficion.setVisible(editable);
        buttonEliminarAficion.setVisible(editable);
        textDescripcion.setEditable(editable);
    }


	public void setListaAficiones(javax.swing.JList<String> listaAficiones) {
		this.listaAficiones = listaAficiones;
	}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        avatarPanel = new abd.p1.view.AvatarPanel();
        labelNombre = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        buttonCambiarNombre = new javax.swing.JButton();
        buttonCambiarAvatar = new javax.swing.JButton();
        labelDescripcion = new javax.swing.JLabel();
        labelAficiones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAficiones = new javax.swing.JList<>();
        buttonAddAficion = new javax.swing.JButton();
        buttonEliminarAficion = new javax.swing.JButton();
        buttonEditarAficion = new javax.swing.JButton();
        labelSexo = new javax.swing.JLabel();
        labelBusca = new javax.swing.JLabel();
        buttonCambiarSexo = new javax.swing.JButton();
        buttonCambiarPref = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        buttonFecha = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout avatarPanelLayout = new javax.swing.GroupLayout(avatarPanel);
        avatarPanel.setLayout(avatarPanelLayout);
        avatarPanelLayout.setHorizontalGroup(
            avatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        avatarPanelLayout.setVerticalGroup(
            avatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        labelNombre.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelNombre.setText("Nombre");

        labelEdad.setText("Edad");

        buttonCambiarNombre.setText("Cambiar nombre");
        buttonCambiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarNombreActionPerformed(evt);
            }
        });

        buttonCambiarAvatar.setText("Cambiar avatar");
        buttonCambiarAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarAvatarActionPerformed(evt);
            }
        });

        labelDescripcion.setText("Descripción");

        labelAficiones.setText("Aficiones");

        jScrollPane1.setViewportView(listaAficiones);

        buttonAddAficion.setText("Añadir afición");
        buttonAddAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddAficionActionPerformed(evt);
            }
        });

        buttonEliminarAficion.setText("Eliminar seleccionada");
        buttonEliminarAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarAficionActionPerformed(evt);
            }
        });

        buttonEditarAficion.setText("Editar seleccionada");
        buttonEditarAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarAficionActionPerformed(evt);
            }
        });

        labelSexo.setText("Sexo:");

        labelBusca.setText("Busca: ");

        buttonCambiarSexo.setText("Cambiar sexo");
        buttonCambiarSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarSexoActionPerformed(evt);
            }
        });

        buttonCambiarPref.setText("Cambiar preferencia");
        buttonCambiarPref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarPrefActionPerformed(evt);
            }
        });

        textDescripcion.setColumns(20);
        textDescripcion.setRows(5);
        jScrollPane3.setViewportView(textDescripcion);

        buttonFecha.setText("Cambiar fecha de nacimiento");
        buttonFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEdad)
                                    .addComponent(labelNombre)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelDescripcion)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(buttonCambiarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonCambiarAvatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelSexo)
                                .addGap(184, 184, 184)
                                .addComponent(buttonCambiarSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelBusca)
                                .addGap(174, 174, 174)
                                .addComponent(buttonCambiarPref, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonEditarAficion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonEliminarAficion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonAddAficion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelAficiones)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avatarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addGap(19, 19, 19)
                        .addComponent(labelDescripcion))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonCambiarNombre)
                            .addComponent(labelNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEdad)
                            .addComponent(buttonFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCambiarAvatar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(labelAficiones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonAddAficion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEliminarAficion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEditarAficion))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSexo)
                            .addComponent(buttonCambiarSexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelBusca)
                        .addContainerGap())
                    .addComponent(buttonCambiarPref)))
        );
    }// </editor-fold>//GEN-END:initComponents

    protected void buttonFechaActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JCalendar cal = new JCalendar();
                Object[] parametros = { cal };
                if (JOptionPane.showConfirmDialog(null, parametros, "Fecha de nacimiento", 
                        JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION){
                	Date fecha = cal.getDate();
                	u.setF_nacimiento(fecha);
                	Calendar calendario = new GregorianCalendar();
                	calendario.setTime(fecha);
                	labelEdad.setText(calcularEdad(calendario) + " años");
                }
	}

	private void buttonCambiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCambiarNombreActionPerformed
        String nuevoNombre = JOptionPane.showInputDialog("Introduce el nuevo nombre: ");
                if (nuevoNombre != null){
                    u.setNombre(nuevoNombre);
                    labelNombre.setText(nuevoNombre);
                }
    }//GEN-LAST:event_buttonCambiarNombreActionPerformed

    private void buttonCambiarAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCambiarAvatarActionPerformed
        // TODO add your handling code here:
        JFileChooser archivos = new JFileChooser();
                int resultado = archivos.showOpenDialog(null);
                
                if (resultado == JFileChooser.APPROVE_OPTION){
                	try{
                		FileInputStream in = new FileInputStream (archivos.getSelectedFile()); 
                		byte [] imagen = new byte[in.available()];	
                		in.read(imagen);	
                		u.setAvatar(imagen);
                		avatarPanel.setIcon(new ImageIcon(imagen));
                	} catch (IOException e){
                		e.printStackTrace();
                	}
                }
    }//GEN-LAST:event_buttonCambiarAvatarActionPerformed

    private void buttonAddAficionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddAficionActionPerformed
        // TODO add your handling code here:
        String nuevaAficion = JOptionPane.showInputDialog("Añade tu nueva afición:");
                if (nuevaAficion != null){
                	List<String> newAficiones = u.getAficiones();
                	newAficiones.add(nuevaAficion);
                	DefaultListModel <String> m = new DefaultListModel <String>();
                	for (String s : newAficiones)
                		m.addElement(s);
                	listaAficiones.setModel(m);
                	u.setAficiones(newAficiones);
                }
    }//GEN-LAST:event_buttonAddAficionActionPerformed

    private void buttonEliminarAficionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarAficionActionPerformed
        // TODO add your handling code here:
            List<String> aficiones = u.getAficiones();
            aficiones.remove(listaAficiones.getSelectedIndex());
            DefaultListModel <String> m = new DefaultListModel <String>();
            for (String s : aficiones)
           	m.addElement(s);
           listaAficiones.setModel(m);
           u.setAficiones(aficiones);
    }//GEN-LAST:event_buttonEliminarAficionActionPerformed

    private void buttonEditarAficionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarAficionActionPerformed
        // TODO add your handling code here:
        List<String> aficiones = u.getAficiones();
            	aficiones.remove(listaAficiones.getSelectedIndex());
            	String nuevaAficion = JOptionPane.showInputDialog("Añade tu nueva afición:");
            	if (nuevaAficion != null)
            		aficiones.add(nuevaAficion);
            	DefaultListModel <String> m = new DefaultListModel <String>();
            	for (String s : aficiones)
            		m.addElement(s);
            	listaAficiones.setModel(m);
            	u.setAficiones(aficiones);
    }//GEN-LAST:event_buttonEditarAficionActionPerformed

    private void buttonCambiarSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCambiarSexoActionPerformed
        // TODO add your handling code here:
        Genero[] sexo = {Genero.MASCULINO, Genero.FEMENINO};
                JComboBox<Genero> comboboxSexo = new JComboBox<>(sexo);

                Object[] params = {comboboxSexo};
                if (JOptionPane.showConfirmDialog(null, params, "Elige tu sexo", JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
                    u.setGenero((Genero) comboboxSexo.getSelectedItem());
                    labelSexo.setText("Sexo: " + u.getGenero().toString());
                }  
    }//GEN-LAST:event_buttonCambiarSexoActionPerformed

    private void buttonCambiarPrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCambiarPrefActionPerformed
        // TODO add your handling code here:
        Genero[] busca = {Genero.MASCULINO, Genero.FEMENINO, Genero.AMBOS};
                JComboBox<Genero> comboboxBusca = new JComboBox<>(busca);

                Object[] params = {comboboxBusca};
                if (JOptionPane.showConfirmDialog(null, params, "Selecciona el género que buscas", JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
                	
                	u.setGeneroAmigo((Genero) comboboxBusca.getSelectedItem());
                    labelBusca.setText("Sexo: " + u.getGeneroAmigo().toString());
                }  
    }//GEN-LAST:event_buttonCambiarPrefActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abd.p1.view.AvatarPanel avatarPanel;
    private javax.swing.JButton buttonAddAficion;
    private javax.swing.JButton buttonCambiarAvatar;
    private javax.swing.JButton buttonCambiarNombre;
    private javax.swing.JButton buttonCambiarPref;
    private javax.swing.JButton buttonCambiarSexo;
    private javax.swing.JButton buttonEditarAficion;
    private javax.swing.JButton buttonEliminarAficion;
    private javax.swing.JButton buttonFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelAficiones;
    private javax.swing.JLabel labelBusca;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JList<String> listaAficiones;
    private javax.swing.JTextArea textDescripcion;
    // End of variables declaration//GEN-END:variables
}
