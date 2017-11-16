

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class Conexion {
    static Connection con ;
    public Conexion(){
        con=null;
    }
    
    public  Connection getConexion(){
        String url="jdbc:sqlserver://localhost:1433;databaseName=sistema_gph";
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException e)
        {
            System.out.println("Error "+e);
        }
        
        try
        {
            con=DriverManager.getConnection(url,"sa","123456");
        }catch(SQLException e)
        {
            System.out.println("Error "+e);
        }
        
        return con;
    }
}
