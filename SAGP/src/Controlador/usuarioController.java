
package Controlador;

import entity.Usuario;
import Modelo.usuarioDAO;

public class usuarioController {
    usuarioDAO model= new usuarioDAO();
    
    public boolean validarLogin(Usuario usu){
        return model.Validar(usu);
    }
}
