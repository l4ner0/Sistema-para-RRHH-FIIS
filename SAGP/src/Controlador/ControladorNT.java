/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.EmpleadoDAO;
import Vista.Ventanas.VtnNuevoTrabajador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ControladorNT implements ActionListener {
    
    VtnNuevoTrabajador vtnNuevoTrabajador = new VtnNuevoTrabajador();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    ControladorValidarInputs validarVacios= new ControladorValidarInputs();
     ControladorCarnet carnet=new ControladorCarnet();
    String opcionSexo;
    
    public ControladorNT(VtnNuevoTrabajador vtnNuevoTrabajador, 
            EmpleadoDAO empleadoDAO){
        
        this.vtnNuevoTrabajador=vtnNuevoTrabajador;
        this.empleadoDAO = empleadoDAO;
        this.vtnNuevoTrabajador.btnGrabar.addActionListener(this);
        this.vtnNuevoTrabajador.cbArea.addActionListener(this);
        this.vtnNuevoTrabajador.cbPuesto.addActionListener(this);
        llenarAreas();
    }
    
    public void actionPerformed(ActionEvent e){
        

        if(e.getSource()==vtnNuevoTrabajador.btnGrabar)
        {
            if(vtnNuevoTrabajador.txtApPa.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Apellido Paterno está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.txtApMa.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Apellido Materno está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.txtNom.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Nombres está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.rbtnHombre.isSelected())
            {
                  opcionSexo="Masculino";
            }else if(vtnNuevoTrabajador.rbtnMujer.isSelected())
            {
                  opcionSexo="Femenino";
            }else{
                JOptionPane.showMessageDialog(null,"El campo sexo está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.txtDni.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo DNI está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.txtFechNac.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Fecha de Nacimiento está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.cbDsitritoRes.getSelectedItem().equals("Seleccione un opción"))
            {
                JOptionPane.showMessageDialog(null,"Seleccione un Distrito");
                return;
            }
            
            if(vtnNuevoTrabajador.txtDirec.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Dirección está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.txtTelf.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Teléfono está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.txtEmail.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo E-mail está vacío");
                return;
            }
            
            if(vtnNuevoTrabajador.cbAsig.getSelectedItem().equals("Seleccione una opción"))
            {
                JOptionPane.showMessageDialog(null,"Responda a la asignación familiar");
                return;
            }
            
            if(vtnNuevoTrabajador.cbArea.getSelectedItem().equals("Seleccione una opción"))
            {
                JOptionPane.showMessageDialog(null,"Seleccione un Area");
                return;
            }
            
            if(vtnNuevoTrabajador.cbPuesto.getSelectedItem().equals("Seleccione una opción"))
            {
                JOptionPane.showMessageDialog(null,"Seleccione un Puesto");
                return;
            }
            
            if(vtnNuevoTrabajador.cbReten.getSelectedItem().equals("Seleccione una opción"))
            {
                JOptionPane.showMessageDialog(null,"Seleccione un tipo de retención");
                return;
            }
            
            if(vtnNuevoTrabajador.txtRutaFoto.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Elija una foto a subir");
                return;
            }
            
            if(vtnNuevoTrabajador.txtRutaCarnet.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Elija donde salvar el carnet");
                return;
            }

            String idEmpleado=generarCodigo();
            String nombres=vtnNuevoTrabajador.txtNom.getText();
            String apellidoPaterno=vtnNuevoTrabajador.txtApPa.getText();
            String apellidoMaterno=vtnNuevoTrabajador.txtApMa.getText();
            String sexo=opcionSexo;
            String DNI=vtnNuevoTrabajador.txtDni.getText();
            String fechaNacimiento=vtnNuevoTrabajador.txtFechNac.getText();
            String distrito=(String) vtnNuevoTrabajador.cbDsitritoRes.getSelectedItem();
            String direccion=vtnNuevoTrabajador.txtDirec.getText();
            String telefono=vtnNuevoTrabajador.txtTelf.getText();
            String correoElectronico=vtnNuevoTrabajador.txtEmail.getText();
            String asignacionFamiliar=(String) vtnNuevoTrabajador.cbAsig.getSelectedItem();
            String nombreArea=  (String)vtnNuevoTrabajador.cbArea.getSelectedItem();
            String nombrePuesto=(String) vtnNuevoTrabajador.cbPuesto.getSelectedItem();
            int idRetencion=Integer.parseInt((String) vtnNuevoTrabajador.cbReten.getSelectedItem());
            String rutaFoto=vtnNuevoTrabajador.txtRutaFoto.getText();
            String rutaCarnet = vtnNuevoTrabajador.txtRutaCarnet.getText();
            
            int idArea=empleadoDAO.getIdArea(nombreArea);
            int idPuesto = empleadoDAO.getIdPuesto(nombrePuesto);
            
            boolean registro=empleadoDAO.InsertarEmpleado(idEmpleado,rutaFoto, nombres, 
                    apellidoPaterno, apellidoMaterno, sexo, DNI, fechaNacimiento, 
                    distrito, direccion, telefono, correoElectronico, 
                    asignacionFamiliar, idArea, idPuesto, idRetencion);
            
            if(registro)
            {
                JOptionPane.showMessageDialog(null,"Registro exitoso!! :-)");
                
               
                carnet.generarCarnet("Nombre de la empresa", idEmpleado, 
                        apellidoPaterno+" "+apellidoMaterno+" "+nombres, 
                        nombreArea, nombrePuesto,
                        "Vencimiento: 09/11/2018",rutaFoto,
                        rutaCarnet+idEmpleado);
                
                vtnNuevoTrabajador.txtApPa.setText("");
                vtnNuevoTrabajador.txtApMa.setText("");
                vtnNuevoTrabajador.txtNom.setText("");
                vtnNuevoTrabajador.rbtnHombre.setSelected(false);
                vtnNuevoTrabajador.rbtnMujer.setSelected(false);
                vtnNuevoTrabajador.txtDni.setText("");
                vtnNuevoTrabajador.txtFechNac.setText("");
                vtnNuevoTrabajador.cbDsitritoRes.setSelectedItem("Seleccione un opción");
                vtnNuevoTrabajador.txtDirec.setText("");
                vtnNuevoTrabajador.txtTelf.setText("");
                vtnNuevoTrabajador.txtEmail.setText("");
                vtnNuevoTrabajador.cbAsig.setSelectedItem("Seleccione una opción");
                vtnNuevoTrabajador.cbArea.setSelectedItem("Seleccione una opción");
                vtnNuevoTrabajador.cbPuesto.setSelectedItem("Seleccione una opción");
                vtnNuevoTrabajador.cbReten.setSelectedItem("Seleccione una opción");
                vtnNuevoTrabajador.txtRutaFoto.setText("");
                vtnNuevoTrabajador.lblFoto.setIcon(null);
                
            }else
            {
                JOptionPane.showMessageDialog(null,"Error al registrar!! :-(");
            }
        }
        
        if(e.getSource()==vtnNuevoTrabajador.cbArea)  
        {   
            vtnNuevoTrabajador.cbPuesto.removeAllItems();
            String nombreArea=(String)vtnNuevoTrabajador.cbArea.getSelectedItem();
            llenarPuestos(nombreArea);
        }
             
    } 
    
    //utilizar metodo hasta crear areaDAO y puestoDAO
    public String generarCodigo(){
        String codigoEmpleado="";
        String dni= vtnNuevoTrabajador.txtDni.getText();
        
        String nombreArea=(String) vtnNuevoTrabajador.cbArea.getSelectedItem();
        int idArea=empleadoDAO.getIdArea(nombreArea);
        String area=String.valueOf(idArea);
        
        String nombrePuesto=(String) vtnNuevoTrabajador.cbPuesto.getSelectedItem();
        int idPuesto=empleadoDAO.getIdPuesto(nombrePuesto);
        String puesto=String.valueOf(idPuesto);
        
        if(idArea<10)
        { 
            area="0"+String.valueOf(idArea);
        }
        if(idPuesto<10)
        {
            puesto="0"+String.valueOf(idPuesto);
        }
        codigoEmpleado="E"+area+puesto+dni;
        
        return codigoEmpleado;
    }
    
    public void llenarAreas(){
        ArrayList areas= new ArrayList();
        
        areas=empleadoDAO.getNomArea();
        if(areas!=null)
        {
            vtnNuevoTrabajador.cbArea.addItem("Seleccione una opción");
            System.out.println(areas.size());
            for(int i=0; i<areas.size();i++)
            {
                vtnNuevoTrabajador.cbArea.addItem(areas.get(i));
            }
        }    
    }
    
    public void llenarPuestos(String nombreArea){
        ArrayList puestos= new ArrayList();
        
        puestos=empleadoDAO.getNomPuesto(nombreArea);
        if(puestos!=null)
        {
            vtnNuevoTrabajador.cbPuesto.addItem("Seleccione una opción");
            System.out.println(puestos.size());
            for(int i=0; i<puestos.size();i++)
            {
                vtnNuevoTrabajador.cbPuesto.addItem(puestos.get(i));
            }
        }    
    }
    
}

