
package Controlador;

import entity.Empleado;
import java.util.ArrayList;
import Modelo.EmpleadoDAO;

public class empleadoController {
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    public ArrayList<Empleado> ListarEmpleado(){
        return empleadoDAO.getEmpleado();
    }
    
    public ArrayList<Empleado> ListarDatosEmpleado(){
        return empleadoDAO.getEmpleado();
    }
}
