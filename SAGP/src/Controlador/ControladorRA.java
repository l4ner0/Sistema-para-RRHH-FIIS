/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AsistenciaDAO;
import Vista.Ventanas.VtnReporteAs;
import Vista.Ventanas.variableStatica;
import entity.Asistencia;
import entity.Empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        this.vtnReporteAs.btnAsistencias.addActionListener(this);
        this.vtnReporteAs.bttnGenerarPDF.addActionListener(this);
        this.vtnReporteAs.btnSalir.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==vtnReporteAs.btnAsistencias)
        {
           String idEmpleado= vtnReporteAs.txtBusqEmp.getText();
           System.out.println("Este es el id:"+idEmpleado);
           if(idEmpleado!="")
           {
               llenarTabla(idEmpleado);
           }else
           {
               JOptionPane.showMessageDialog(null,"Escriba un código válido");
           }
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
    
    public void llenarTabla(String idEmpleado){
         String data[][]={};
        String cabeza[]={"Fecha Asistencia","Hora Entrada","Hora Salida"};
        DefaultTableModel model = new DefaultTableModel(data,cabeza);
        vtnReporteAs.tablaReporteAs.setModel(model);
        empleadoController controller = new empleadoController();
        for (Asistencia  asistencia: controller.ListarAsistencias(idEmpleado)) {
        Object ob[] ={asistencia.getFechaAsistencia(),asistencia.getHoraEntrada().substring(0,5),asistencia.getHoraSalida().substring(0,5)};
        model.addRow(ob);
        }
         
     }
    
    
}
