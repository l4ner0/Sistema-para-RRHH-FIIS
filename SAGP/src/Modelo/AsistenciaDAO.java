/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import entity.Asistencia;
import entity.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;

/**
 *
 * @author eljoche
 */
public class AsistenciaDAO {
    Conexion conexion;
    
    public AsistenciaDAO(){
        conexion=new Conexion();
    }
    
    public boolean grabaAsistencia(String fechaAsistencia, String horaEntrada, 
            String horaSalida, String idEmpleado, int idHorario){
        boolean registro=false;
        Connection accesoDB=conexion.getConexion();
        try {
            CallableStatement cs = accesoDB.prepareCall("{call usp_graba_asistencia("
                    + "?,?,?,?,?)}");
            cs.setString(1,fechaAsistencia);
            cs.setString(2,horaEntrada);
            cs.setString(3,horaSalida);
            cs.setString(4,idEmpleado);
            cs.setInt(5,idHorario);
            
            int filasAfect=cs.executeUpdate();
           if(filasAfect>0)
           {
               registro=true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registro;
        
    }
    
    public int getIdHorario(String idEmpleado){
        int idHorario=0;
          try
        {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call usp_verifica_horario(?)}");
            cs.setString(1, idEmpleado);
            ResultSet rs=cs.executeQuery();
            boolean resultado=rs.next();
            if(resultado)
            {
               idHorario=rs.getInt(1);        
            }
        }catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        return idHorario;
    }
    
    public ArrayList<Asistencia> listarAsistencias(String idEmpleado){ 
       ArrayList<Asistencia> aisistencia= new ArrayList<>();
       Asistencia asis =null;
        try {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call usp_mostrar_asistencias(?)}");
            cs.setString(1,idEmpleado);
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                asis= new Asistencia();
                asis.setFechaAsistencia(rs.getString(2));
                asis.setHoraEntrada(rs.getString(3));
                asis.setHoraSalida(rs.getString(4));
                asis.setIdEmpleado(rs.getString(5));
                asis.setIdHorario(rs.getInt(6));
                aisistencia.add(asis);
            }
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
       return aisistencia;
    }
}
