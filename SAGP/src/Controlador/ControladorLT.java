/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EmpleadoDAO;
import Vista.Ventanas.VtnListar;
import Vista.Ventanas.variableStatica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author eljoche
 */
public class ControladorLT implements ActionListener{
    VtnListar vtnListar = new VtnListar();
    EmpleadoDAO  empleadoDAO = new EmpleadoDAO();
    variableStatica ventana = new variableStatica();
    
    public ControladorLT(VtnListar vtnListar, EmpleadoDAO empleadoDAO){
        this.empleadoDAO=empleadoDAO;
        this.vtnListar= vtnListar;
        this.vtnListar.btnModificar.addActionListener(this);
        this.vtnListar.btnEliminar.addActionListener(this);
        this.vtnListar.btnSalir.addActionListener(this);
    }
    
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==vtnListar.btnModificar)
         {
             JOptionPane.showMessageDialog(null,"Le distes a editar");
         }
         
         if(e.getSource()==vtnListar.btnEliminar)
         {
             JOptionPane.showMessageDialog(null,"Le distes a Eliminar");
         }
         if(e.getSource()==vtnListar.btnSalir)
         {
             vtnListar.dispose();
             ventana.ventanaListarEmpleado=false;
         }
     }
    
}
