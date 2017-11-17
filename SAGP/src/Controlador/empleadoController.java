
package Controlador;

import Modelo.AsistenciaDAO;
import entity.Empleado;
import java.util.ArrayList;
import Modelo.EmpleadoDAO;
import entity.Asistencia;

public class empleadoController {
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    public ArrayList<Empleado> ListarEmpleado(){
        return empleadoDAO.getEmpleado();
    }
    
    public ArrayList<Empleado> ListarDatosEmpleado(){
        return empleadoDAO.getEmpleado();
    }
    
    public ArrayList<Asistencia> ListarAsistencias(String idEmpleado){
        AsistenciaDAO asistenciaDAO = new AsistenciaDAO();
        return asistenciaDAO.listarAsistencias(idEmpleado);
    }
}
