

package Modelo;

import entity.Empleado;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;


public class EmpleadoDAO {
    Conexion conexion;
    
    public EmpleadoDAO(){
        conexion=new Conexion();
    }
    
    public boolean InsertarEmpleado(String idEmpleado,String fotoEmpleado,
        String nombres,String apellidoPaterno,String apellidoMaterno,String sexo,
        String DNI,String fechaNacimiento,String DistritoResidencia,
        String direccion,String telefono,String correoElectronico,
        String asignacionFamiliar,int idArea,int idPuesto,
        int idRetencion ){
        
        boolean registro=false;
        try
        {
           Connection accesoDB=conexion.getConexion();
           CallableStatement cs = accesoDB.prepareCall("{call usp_graba_empleado("
                   + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
           
           cs.setString(1,idEmpleado);
           cs.setString(2,fotoEmpleado);
           cs.setString(3,nombres);
           cs.setString(4,apellidoPaterno);
           cs.setString(5,apellidoMaterno);
           cs.setString(6,sexo);
           cs.setString(7,DNI);
           cs.setString(8,fechaNacimiento);
           cs.setString(9,DistritoResidencia);
           cs.setString(10,direccion);
           cs.setString(11,telefono);
           cs.setString(12,correoElectronico);
           cs.setString(13,asignacionFamiliar);
           cs.setInt(14,idArea);
           cs.setInt(15,idPuesto);
           cs.setInt(16,idRetencion);
           
           
           int filasAfect=cs.executeUpdate();
           if(filasAfect>0)
           {
               registro=true;
           }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return registro;
    }

    
    //Eliminar una vez que se cree AreasEmpresaDAO y PuestoDAO
    public ArrayList getNomArea(){
        ArrayList areas = new ArrayList();
        try
        {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call usp_mostrar_areas}");
            ResultSet rs=cs.executeQuery();
            while(rs.next())
            {
                areas.add(rs.getString(2));  
            } 
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return areas;
    }
    
    public int getIdArea(String nombreArea){
        int idArea=0;
        try
        {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call usp_buscar_idArea(?)}");
            cs.setString(1,nombreArea);
            ResultSet rs=cs.executeQuery();
            while(rs.next())
            {
                idArea=rs.getInt(1);  
            } 
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return idArea;
    }
    
    public ArrayList getNomPuesto(String nombreArea){
        ArrayList puesto= new ArrayList();
        try
        {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call usp_mostrar_puestos2(?)}");
            cs.setString(1,nombreArea);
            ResultSet rs=cs.executeQuery();
            while(rs.next())
            {
                puesto.add(rs.getString(1));  
            } 
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return puesto;
    }
    
    public int getIdPuesto(String nombrePuesto){
        int idPuesto=0;
        try
        {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call usp_buscar_idPuesto(?)}");
            cs.setString(1,nombrePuesto);
            ResultSet rs=cs.executeQuery();
            while(rs.next())
            {
                idPuesto=rs.getInt(1);  
            } 
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return idPuesto;
    }
    
    public ArrayList BuscarEmpleado(String idEmpleado){
        
        ArrayList <String> datosEmpleado = new ArrayList();       
        try {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call usp_buscar_empleado(?)}");
            cs.setString(1, idEmpleado);
            ResultSet rs=cs.executeQuery();
            boolean resultado=rs.next();
            System.out.println(resultado);
            if(resultado){ 
                datosEmpleado.add(rs.getString(1));
                datosEmpleado.add(rs.getString(2));
                datosEmpleado.add(rs.getString(3));
                datosEmpleado.add(rs.getString(4));
                datosEmpleado.add(rs.getString(5));
                datosEmpleado.add(rs.getString(6));
                datosEmpleado.add(rs.getString(7));
                datosEmpleado.add(rs.getString(8));
                datosEmpleado.add(rs.getString(9));
                datosEmpleado.add(rs.getString(10));
                datosEmpleado.add(rs.getString(11));
                datosEmpleado.add(rs.getString(12));
                datosEmpleado.add(rs.getString(13));
                datosEmpleado.add(rs.getString(14));
                datosEmpleado.add(rs.getString(15));
                datosEmpleado.add(rs.getString(16));
            }else
            {
                datosEmpleado=null;
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }    
        return datosEmpleado;
    }
    
    public double Sueld_Total(String idEmpleado){
        double sueld_basico=0;
        try {
             Connection accesoDB=conexion.getConexion();
             CallableStatement callableStatement = accesoDB.prepareCall("{call usu_sueldtotal(?) }");
             callableStatement.setString(1, idEmpleado);
             ResultSet rs = callableStatement.executeQuery();
             if(rs.next()){
                  sueld_basico= rs.getDouble(1);
             }
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
         double sueld_total = sueld_basico+ (sueld_basico*0.1)-(sueld_basico*0.09);
         return sueld_total; 
    }
    
    //Se agregó el método llenar Empleado
    public ArrayList<Empleado> getEmpleado(){ 
       ArrayList<Empleado> emp= new ArrayList<>();
       Empleado empleado =null;
        try {
            Connection connection = conexion.getConexion();
            PreparedStatement ps = connection.prepareStatement("select idEmpleado,nombres,apellidoPaterno,apellidoMaterno,DNI from empleado");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                empleado= new Empleado();
                empleado.setIdEmpleado(rs.getString(1));
                empleado.setNombres(rs.getString(2));
                empleado.setApellidoPaterno(rs.getString(3));
                empleado.setApellidoMaterno(rs.getString(4));
                empleado.setDNI(rs.getString(5));
                empleado.setSueld_total(Sueld_Total(empleado.getIdEmpleado()));
                emp.add(empleado);
            }
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
       return emp;
    }
    
}
