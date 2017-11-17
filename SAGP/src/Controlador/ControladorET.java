/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EmpleadoDAO;
import Vista.Ventanas.VtnEditarTrabajador;
import Vista.Ventanas.VtnListar;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ControladorET implements ActionListener {
    VtnEditarTrabajador vtnEditarTrabajador= new VtnEditarTrabajador();
     String opcionSexo;
    ControladorCarnet carnet=new ControladorCarnet();
    EmpleadoDAO  empleadoDAO = new EmpleadoDAO();
    variableEstaticaCont vairableEstaticaCont= new variableEstaticaCont();
    String idEmpleado=variableEstaticaCont.idEmpleadoEdit;
    public ControladorET( VtnEditarTrabajador vtnEditarTrabajador,EmpleadoDAO empleadoDAO,String idEmpleado){
        this.empleadoDAO=empleadoDAO;
        this.vtnEditarTrabajador=vtnEditarTrabajador;
        this.idEmpleado=idEmpleado;
        this.vtnEditarTrabajador.btnGrabar.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vtnEditarTrabajador.btnGrabar)
        {
            if(vtnEditarTrabajador.txtApPa.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Apellido Paterno está vacío");
                return;
            }
            
            if(vtnEditarTrabajador.txtApMa.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Apellido Materno está vacío");
                return;
            }
            
            if(vtnEditarTrabajador.txtNom.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Nombres está vacío");
                return;
            }
            
            if(vtnEditarTrabajador.rbtnHombre.isSelected())
            {
                  opcionSexo="Masculino";
            }else if(vtnEditarTrabajador.rbtnMujer.isSelected())
            {
                  opcionSexo="Femenino";
            }else{
                JOptionPane.showMessageDialog(null,"El campo sexo está vacío");
                return;
            }
            
            
            if(vtnEditarTrabajador.txtFechNac.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Fecha de Nacimiento está vacío");
                return;
            }
            
            if(vtnEditarTrabajador.cbDsitritoRes.getSelectedItem().equals("Seleccione un opción"))
            {
                JOptionPane.showMessageDialog(null,"Seleccione un Distrito");
                return;
            }
            
            if(vtnEditarTrabajador.txtDirec.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Dirección está vacío");
                return;
            }
            
            if(vtnEditarTrabajador.txtTelf.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo Teléfono está vacío");
                return;
            }
            
            if(vtnEditarTrabajador.txtEmail.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"El campo E-mail está vacío");
                return;
            }
            
            if(vtnEditarTrabajador.cbAsig.getSelectedItem().equals("Seleccione una opción"))
            {
                JOptionPane.showMessageDialog(null,"Responda a la asignación familiar");
                return;
            }
            
            if(vtnEditarTrabajador.txtRutaFoto.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Elija una foto a subir");
                return;
            }
            
            if(vtnEditarTrabajador.txtRutaCarnet.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Elija donde salvar el carnet");
                return;
            }
            
            
            String nombres=vtnEditarTrabajador.txtNom.getText();
            String apellidoPaterno=vtnEditarTrabajador.txtApPa.getText();
            String apellidoMaterno=vtnEditarTrabajador.txtApMa.getText();
            String sexo=opcionSexo;
            String DNI="";
            String fechaNacimiento=vtnEditarTrabajador.txtFechNac.getText();
            String distrito=(String) vtnEditarTrabajador.cbDsitritoRes.getSelectedItem();
            String direccion=vtnEditarTrabajador.txtDirec.getText();
            String telefono=vtnEditarTrabajador.txtTelf.getText();
            String correoElectronico=vtnEditarTrabajador.txtEmail.getText();
            String asignacionFamiliar=(String) vtnEditarTrabajador.cbAsig.getSelectedItem();
            String nombreArea="";
            String nombrePuesto="";
            String rutaFoto=vtnEditarTrabajador.txtRutaFoto.getText();
            String rutaCarnet = vtnEditarTrabajador.txtRutaCarnet.getText();
            
            int idArea=empleadoDAO.getIdArea(nombreArea);
            int idPuesto = empleadoDAO.getIdPuesto(nombrePuesto);
            
            boolean registro=empleadoDAO.EditarEmpleado(idEmpleado,rutaFoto, nombres, 
                    apellidoPaterno, apellidoMaterno, sexo, DNI, fechaNacimiento, 
                    distrito, direccion, telefono, correoElectronico, 
                    asignacionFamiliar);
            
            if(registro)
            {
                JOptionPane.showMessageDialog(null,"Edición exitoso!! :-)");
                
               
                carnet.generarCarnet("Nombre de la empresa", idEmpleado, 
                        apellidoPaterno+" "+apellidoMaterno+" "+nombres, 
                        nombreArea, nombrePuesto,
                        "Vencimiento: 09/11/2018",rutaFoto,
                        rutaCarnet+idEmpleado);                 
                
            }else
            {
                JOptionPane.showMessageDialog(null,"Error al registrar!! :-(");
            }
        
        }
    }
    
    public void llenarDatos(){
        ArrayList datosEmpleado;
        datosEmpleado=empleadoDAO.BuscarEmpleado(idEmpleado);
         vtnEditarTrabajador.txtApPa.setText(String.valueOf(datosEmpleado.get(3)));
         vtnEditarTrabajador.txtApMa.setText(String.valueOf(datosEmpleado.get(4)));
         vtnEditarTrabajador.txtNom.setText(String.valueOf(datosEmpleado.get(2)));
         if(String.valueOf(datosEmpleado.get(5)).equals("Femenino"))
         {
             vtnEditarTrabajador.rbtnMujer.setSelected(true);
         }else
         {
             vtnEditarTrabajador.rbtnHombre.setSelected(true);
         }
         vtnEditarTrabajador.txtDNI.setText(String.valueOf(datosEmpleado.get(6)));
         vtnEditarTrabajador.txtDNI.setEditable(false);
         vtnEditarTrabajador.txtFechNac.setText(String.valueOf(datosEmpleado.get(7)));
         vtnEditarTrabajador.cbDsitritoRes.setSelectedItem(String.valueOf(datosEmpleado.get(8)));
         vtnEditarTrabajador.txtDirec.setText(String.valueOf(datosEmpleado.get(9)));
         vtnEditarTrabajador.txtTelf.setText(String.valueOf(datosEmpleado.get(10)));
         vtnEditarTrabajador.txtEmail.setText(String.valueOf(datosEmpleado.get(11)));
         vtnEditarTrabajador.cbAsig.setSelectedItem(String.valueOf(datosEmpleado.get(12)));
         vtnEditarTrabajador.cbArea.addItem(String.valueOf(datosEmpleado.get(13)));
         vtnEditarTrabajador.cbArea.setEditable(false);
         vtnEditarTrabajador.cbPuesto.addItem(String.valueOf(datosEmpleado.get(14)));
         vtnEditarTrabajador.cbPuesto.setEditable(false);
         vtnEditarTrabajador.cbReten.addItem(String.valueOf(datosEmpleado.get(15)));
         vtnEditarTrabajador.cbReten.setEditable(false);
         ImageIcon icono= new ImageIcon(String.valueOf(datosEmpleado.get(1)));
            Image imagen = icono.getImage();
            Image nuevaImagen = imagen.getScaledInstance(164, 210, java.awt.Image.SCALE_SMOOTH);
            ImageIcon nuevoIcono=new ImageIcon(nuevaImagen);
         vtnEditarTrabajador.lblFoto.setIcon(nuevoIcono);
         vtnEditarTrabajador.txtRutaFoto.setText(String.valueOf(datosEmpleado.get(1)));
     }
    
}
