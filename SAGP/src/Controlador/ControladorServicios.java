/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import static Controlador.ControladorUICT.PORT;
import Modelo.EmpleadoDAO;
import Vista.IUControlTiempos;
import Vista.Ventanas.*;
import Vista.Ventanas.*;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ControladorServicios implements Runnable{
    VtnControl vtnControl;
    EmpleadoDAO empleadoDAO;
    variableStatica ventana = new variableStatica();
    variableEstaticaCont variableEstaticaCont = new variableEstaticaCont();
    
    public ControladorServicios(VtnControl vtnControl, EmpleadoDAO empleadoDAO){
        this.vtnControl=vtnControl;
        this.empleadoDAO=empleadoDAO;
    }
    
    @Override
    public void run(){
        try
        {
           ServerSocket serverSocket=new ServerSocket(PORT); 
           System.out.println("Servidor> Servidor iniciado");
           System.out.println("Servidor> En espera del cliente...");

           Socket clientSocket;
           
           while(variableEstaticaCont.procesoServicios)
           {
             clientSocket=  serverSocket.accept();
             
             BufferedReader input= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

             
             String request=input.readLine();
             String estado="";
               if(request!=null)
               {    
                   
                   System.out.println("Cliente> petición [ "+request+" ]");
                   ArrayList datosEmpleado=empleadoDAO.BuscarEmpleado(request);
                   if(datosEmpleado!=null){
                       if(ventana.ventanaControlAsistencia==false)
                    {  
                        
                        vtnControl.setVisible(true);
                
                        ventana.ventanaControlAsistencia=true;
                    }
                       
                       String ApellidoP=String.valueOf(datosEmpleado.get(3));
                       String ApellidoM=String.valueOf(datosEmpleado.get(4));
                       String Nombres=String.valueOf(datosEmpleado.get(2));
                       String idEmpleado=String.valueOf(datosEmpleado.get(0));
                       String area=String.valueOf(datosEmpleado.get(13));
                       String puesto=String.valueOf(datosEmpleado.get(14));
                       String ruta=String.valueOf(datosEmpleado.get(1));
                       ImageIcon icono= new ImageIcon(ruta);
                       Image imagen = icono.getImage();
                       Image nuevaImagen = imagen.getScaledInstance(307, 395, java.awt.Image.SCALE_SMOOTH);
                       ImageIcon nuevoIcono=new ImageIcon(nuevaImagen);
                       vtnControl.lblFotoEmp.setIcon(nuevoIcono);
                       vtnControl.txtIdEmpleado.setText(idEmpleado);
                       vtnControl.txtApNom.setText(ApellidoP+" "+ApellidoM+" "+Nombres);
                       vtnControl.txtArea.setText(area);
                       vtnControl.txtPuesto.setText(puesto);
                       Calendar calendario = new GregorianCalendar();
                        int hora;
                        hora =calendario.get(Calendar.HOUR_OF_DAY);
                        boolean resultado=empleadoDAO.verificaHorario(request, String.valueOf(hora));
                        System.out.println(resultado);
                        if(resultado)
                        {
                            vtnControl.getContentPane().setBackground(new java.awt.Color(46, 204, 113));
                            estado="LLEGO TEMPRANO";
                        }else
                        {
                            vtnControl.getContentPane().setBackground(new java.awt.Color(231, 76, 60));
                            estado="LLEGO TARDE";
                        }
                       JOptionPane.showMessageDialog(null,"Se marco asistencia al empleado \n"+request+"\n"+estado);
                   }else{
                       JOptionPane.showMessageDialog(null,"El empleado no existe");
                       vtnControl.txtIdEmpleado.setText("");
                       vtnControl.txtApNom.setText("");
                       vtnControl.txtArea.setText("");
                       vtnControl.txtPuesto.setText("");
                   } 
               }
               
               request=null;
               
             clientSocket.close();
             
           }
        }
        catch(IOException ex )
        {
           System.err.println(ex.getMessage()); 
        }
    }
}
