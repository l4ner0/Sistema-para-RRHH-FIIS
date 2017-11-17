/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EmpleadoDAO;
import Vista.Ventanas.VtnEditarTrabajador;
import Vista.Ventanas.VtnListar;
import Vista.Ventanas.variableStatica;
import entity.Empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eljoche
 */
public class ControladorLT implements ActionListener{
    VtnListar vtnListar = new VtnListar();
    variableStatica ventana = new variableStatica();
    variableEstaticaCont variableEstatica = new variableEstaticaCont();
    
   
    
    public ControladorLT(VtnListar vtnListar){
        this.vtnListar= vtnListar;
        this.vtnListar.btnModificar.addActionListener(this);
        this.vtnListar.btnEliminar.addActionListener(this);
        this.vtnListar.btnActualizar.addActionListener(this);
        this.vtnListar.btnSalir.addActionListener(this);
        
    }
    
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==vtnListar.btnModificar)
         {       
            VtnEditarTrabajador vtnEditarTrabajador= new VtnEditarTrabajador();
            EmpleadoDAO  empleadoDAO = new EmpleadoDAO();
            if(elegirFila()!=null)
             {
                ControladorET controladorET = new ControladorET(vtnEditarTrabajador,empleadoDAO,elegirFila());   
                controladorET.llenarDatos();
                vtnEditarTrabajador.setVisible(true);
             }else{
                 JOptionPane.showMessageDialog(null,"Seleccione un Empleado");
             }       
         }
         
         if(e.getSource()==vtnListar.btnEliminar)
         {
             EmpleadoDAO  empleadoDAO = new EmpleadoDAO();
             if(elegirFila()!=null)
             {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
                if(resp==0)
                {
                    boolean respuesta=empleadoDAO.eliminarEmpleado(elegirFila());
                    if(respuesta)
                    {
                        JOptionPane.showMessageDialog(null,"Se elimino al empleado "+elegirFila());
                        llenarTabla();
                    }else{
                        JOptionPane.showMessageDialog(null,"Error al eliminar");
                    }
                }
                 
             }else{
                 JOptionPane.showMessageDialog(null,"Seleccione un Empleado");
             }
         }
         if(e.getSource()==vtnListar.btnActualizar)
         {
            llenarTabla();
         }
         
         if(e.getSource()==vtnListar.btnSalir)
         {
             vtnListar.dispose();
             ventana.ventanaListarEmpleado=false;
         }
     }
     
     public void llenarTabla(){
         String data[][]={};
        String cabeza[]={"ID Empleado","Apellido Paterno","Apellido Materno","Nombres","DNI"};
        DefaultTableModel model = new DefaultTableModel(data,cabeza);
        vtnListar.tablaListar.setModel(model);
        empleadoController controller = new empleadoController();
        for (Empleado  emp: controller.ListarDatosEmpleado()) {
        Object ob[] ={emp.getIdEmpleado(),emp.getApellidoPaterno(),emp.getApellidoMaterno(),
        emp.getNombres(),emp.getDNI()};
        model.addRow(ob);
        }
         
     }
     
     public String elegirFila(){
         int fila=vtnListar.tablaListar.getSelectedRow();
         if(fila>=0)
         {
            String idEmpleado = vtnListar.tablaListar.getValueAt(fila, 0).toString();
            System.out.println(idEmpleado);
            return idEmpleado; 
         }else{
             return null;
         } 
     }
     
     
    
}
