/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AsistenciaDAO;
import Vista.Ventanas.VtnReporteAs;
import Vista.Ventanas.variableStatica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author eljoche
 */
public class ControladorRA implements ActionListener{
    VtnReporteAs vtnReporteAs = new VtnReporteAs();
    AsistenciaDAO asistenciaDAO = new AsistenciaDAO();
    variableStatica ventana = new variableStatica();
    public ControladorRA(VtnReporteAs vtnReporteAs, AsistenciaDAO asistenciaDAO){
        this.vtnReporteAs=vtnReporteAs;
        this.asistenciaDAO=asistenciaDAO;
        this.vtnReporteAs.cbBusquedaArea.addActionListener(this);
        this.vtnReporteAs.cbPuesto.addActionListener(this);
        this.vtnReporteAs.txtBusqEmp.addActionListener(this);
        this.vtnReporteAs.bttnGenerarPDF.addActionListener(this);
        this.vtnReporteAs.btnSalir.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vtnReporteAs.cbBusquedaArea)
        {
            JOptionPane.showMessageDialog(null,"Seleccionastes Busqueda Areas");
        }
        
        if(e.getSource()==vtnReporteAs.cbPuesto)
        {
            JOptionPane.showMessageDialog(null,"Seleccionastes Busqueda Puesto");
        }
        
        if(e.getSource()==vtnReporteAs.txtBusqEmp)
        {
            JOptionPane.showMessageDialog(null,"Seleccionastes Id Empleado");
        }
        
        if(e.getSource()==vtnReporteAs.bttnGenerarPDF)
        {
            JOptionPane.showMessageDialog(null,"Seleccionastes boton Generar PDF");
        }
        
        if(e.getSource()==vtnReporteAs.btnSalir)
        {
            vtnReporteAs.dispose();
            ventana.ventanaReporteAsistencias=false;
            
        }
    }
}
