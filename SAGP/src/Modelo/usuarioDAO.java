
package Modelo;

import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Conexion;

public class usuarioDAO {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion = new Conexion();
    public boolean Validar(Usuario usuario){
        
        try {
            cn=conexion.getConexion();
            ps=cn.prepareStatement("select Usuario,contraseña from Usuarios where Usuario=? and contraseña=?");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContra());
            rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
        return false;
    }
    
}
