
package ciclodeinstruccion.Usuarios;

import ciclodeinstruccion.Partida;
import ciclodeinstruccion.Personaje;
import ciclodeinstruccion.Usuarios.Usuario;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;


public class Administrador extends Usuario{

    public Administrador(String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
    }

    public void modificarUsuarioNombre(Registrado r, String nombreNuevo){
        
        r.setNombre(nombreNuevo);  
    }
    
    public void modificarUsuarioContraseña(Registrado r, String contraseñaNueva){
        
        r.setContraseña(contraseñaNueva);
    }
    
    public void modificarUsuarioCorreo(Registrado r, String CorreoNuevo){
        
        r.setCorreo(CorreoNuevo);
    }

    public void eliminarUsuarios(Registrado r, ArrayList <Usuario> usuarios){
        
        usuarios.remove(r);
    }
    
    public void modificarPersonaje(Personaje p){
        
    }
    
    public void verUsuarios(ArrayList <Usuario> usuarios){
        
        for (Usuario u: usuarios){
            u.mostrarDatos();
        }
    }
    
    public void verPersonajes(ArrayList <Personaje> personajes){
        
        for (Personaje p: personajes){
            p.mostrarDatos();
        }
    }
    
    public void historialDePartidas(ArrayList <Partida> partidas){
        
        for (Partida p: partidas){
            p.mostrarDatos();
        }
    }
    
    public void verEstadisticasAvanzadas(ArrayList <Partida> partidas){
        
        
    }

    
    
    
    
    
}
