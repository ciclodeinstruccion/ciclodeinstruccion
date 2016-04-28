
package ciclodeinstruccion.Usuarios;

import ciclodeinstruccion.Personaje;
import ciclodeinstruccion.Usuarios.Usuarios;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;


public class Administrador extends Usuarios{

    public Administrador(String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
    }

    public void modificarUsuarioNombre(Registrados r, String nombreNuevo){
        
        r.setNombre(nombreNuevo);  
    }
    
    public void modificarUsuarioContraseña(Registrados r, String contraseñaNueva){
        
        r.setContraseña(contraseñaNueva);
    }
    
    public void modificarUsuarioCorreo(Registrados r, String CorreoNuevo){
        
        r.setCorreo(CorreoNuevo);
    }

    public void eliminarUsuarios(Registrados r){
        
    }
    
    public void modificarPersonaje(Personaje p){
        
    }
    
    public void verUsuarios(ArrayList <Usuarios> usuarios){
        Iterator it = usuarios.iterator();
    }
    
    public void verPersonajes(listaDePersonajes){
        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    }
    
    public void historialDePartidas(listaDePartidas){
        
    }
    
    public void verEstadisticasAvanzadas(listaDePartidas){
        
    }
    
    
}
