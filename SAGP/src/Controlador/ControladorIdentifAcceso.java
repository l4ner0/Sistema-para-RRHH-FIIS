/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Vista.Ventanas.IdentifAcceso;
import Vista.Ventanas.VtnNuevoTrabajador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ControladorIdentifAcceso implements ActionListener{
    
    VtnNuevoTrabajador nuevoTrabajador = new VtnNuevoTrabajador();
    IdentifAcceso carnetAcceso = new IdentifAcceso();
    
    public ControladorIdentifAcceso(VtnNuevoTrabajador nuevoTrabajador,
            IdentifAcceso carnetAcceso){
        this.nuevoTrabajador=nuevoTrabajador;
        this.carnetAcceso=carnetAcceso;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== carnetAcceso.btnGenerarCarnet)
        {
            JOptionPane.showMessageDialog(null,"Le distes a generar Carnet :-)");
        }
    }
}
