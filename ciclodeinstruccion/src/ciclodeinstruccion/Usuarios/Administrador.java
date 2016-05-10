
package ciclodeinstruccion.Usuarios;

import ciclodeinstruccion.Partida;
import ciclodeinstruccion.Personaje;
import ciclodeinstruccion.Usuarios.Usuario;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.Scanner;


public class Administrador extends Usuario{

    public Administrador(String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
    }
    public Administrador(String nombre){
        super(nombre);
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
    
    public void modificarPersonajeNombre(Personaje p, String nombreNuevo){
        
        p.setNombre(nombreNuevo);
    }
    
    public void modificarPersonajeDaño(Personaje p, float dañoNuevo){
        
        p.setDaño(dañoNuevo);
    }
    
    public void modificarPersonajeVida(Personaje p, float vidaNueva){
        
        p.setVida(vidaNueva);
    }
    
    public void modificarPersonajePrecio(Personaje p, int precioNuevo){
        
        p.setPrecio(precioNuevo);
    }
    
    public void verUsuarios(ArrayList <Registrado> registrados){
        
        String [][] tablaDeUsuarios = new String [registrados.size()][6];
        for (int i = 0; i < registrados.size(); i++  )  {
            Registrado r =(Registrado) registrados.get(i);
            tablaDeUsuarios[i][0] =r.getNombre();
            tablaDeUsuarios[i][1] =r.getCorreo();
            tablaDeUsuarios[i][2] =r.getContraseña();
            System.out.println(tablaDeUsuarios);
        }      
        for(String[] s: tablaDeUsuarios){
            
        }
    }
    
    /*public void verPersonajes(ArrayList <Personaje> personajes){
        
        String [][] tablaDeUsuarios = new String [registrados.size()][6];
        for (int i = 0; i < registrados.size(); i++  )  {
            Registrado r =(Registrado) registrados.get(i);
            tablaDeUsuarios[i][0] =r.getNombre();
            tablaDeUsuarios[i][1] =r.getCorreo();
            tablaDeUsuarios[i][2] =r.getContraseña();
        }      
        System.out.println(tablaDeUsuarios);
            
        
    }*/
    
    public void historialDePartidas(ArrayList <Partida> partidas){
        
        for (Partida p: partidas){
            p.mostrarDatos();
        }
    }
    
    public void verEstadisticasAvanzadas(ArrayList <Partida> partidas){
        
        
    }

    public void menuGrande(){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE ADMINSTRACIÓN");
            System.out.println("-------------------------");
            System.out.println("1.-Gestionar");
            System.out.println("2.-Ver");
            System.out.println("3.-Salir");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    menuGestionar();
                    break;
                case 2:
                    menuVer();
                    break;
                case 3:
                    break;
            }
        }while(opcion < 3);
                          
    }
    
    public void menuGestionar(){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE GESTIÓN");
            System.out.println("----------------");
            System.out.println("1.-Usuarios");
            System.out.println("2.-Personajes");
            System.out.println("3.-Volver");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    menuGestionarUsuarios();
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
            }
        }while(opcion < 3);
    }
    
    public void menuVer(){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE VER");
            System.out.println("----------------");
            System.out.println("1.-Ver historial de partidas");
            System.out.println("2.-Usuarios");
            System.out.println("3.-Personajes");
            System.out.println("4.-Volver");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    menuVerHistorialPartidas();
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }while(opcion < 3);
        
    }
    
    public void menuGestionarUsuarios(){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE USUARIOS");
            System.out.println("----------------");
            System.out.println("1.-Modificar usuarios");
            System.out.println("2.-Eliminar usuarios");
            System.out.println("3.-Volver");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
            }
        }while(opcion < 3);
    }
    
    
    public void menuVerHistorialPartidas(){
        
    }
    
    public void modificarUsuarios(){
       Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ MODIFICAR USUARIOS");
            System.out.println("-------------------------");
            System.out.println("1.-Modificar nombre");
            System.out.println("2.-Modificar contraseña");
            System.out.println("3.-Modificar e-mail");
            System.out.println("4.-Volver");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    String nombre1;
                    String nombre2;
                    nombre1 = teclado.nextLine();
                    teclado.hasNextLine();
                    nombre2 = teclado.nextLine();
                    teclado.hasNextLine();
                    modificarUsuarioNombre(null, null);
                    break;
                case 2:
                    modificarUsuarioContraseña(null, null);
                    break;
                case 3:
                    modificarUsuarioCorreo(null, null);
                    break;
                case 4:
                    break;
            }
        }while(opcion<3);
                          
    }
    }
        
 }
    
    
    
    
    
