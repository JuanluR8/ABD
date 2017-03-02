/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import abd.p1.model.Usuario;

import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author JuanluRomero
 */
public class UsuariosCellRenderer extends ElementoListaUsuarios implements ListCellRenderer <Usuario>{

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Usuario> list, Usuario value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        
        this.setNombre(value.getNombre());
        Calendar cal = new GregorianCalendar();
        Date fnac = value.getF_nacimiento();
        if (fnac != null)
        	cal.setTime(value.getF_nacimiento());
        this.setEdad(calcularEdad(cal));
        
        
        this.setOpaque(true);
        if (isSelected){
            this.setBackground(Color.LIGHT_GRAY);
        }
        else
            this.setBackground(Color.WHITE);
        
        if (value.getAvatar() != null){
        	this.setAvatar(value.getAvatar());
        }
        
        return this;
   
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
}