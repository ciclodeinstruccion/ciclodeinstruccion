
package ciclodeinstruccion.Usuarios;

import ciclodeinstruccion.Partida;
import Personaje.Personaje;
import ciclodeinstruccion.Juego;
import ciclodeinstruccion.Usuarios.Usuario;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.Scanner;
import BaseDeDatos.consultasBD;

public class Administrador extends Usuario{
    
    Scanner teclado = new Scanner(System.in);

    public Administrador(String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
    }
    public Administrador(String nombre){
        super(nombre);
    }
    public String [][] tablaUsuarios(){
        ArrayList <Registrado> usuarios =new ArrayList();
        usuarios=consultasBD.instancia().todosRegistrados();
        String arrayUsuarios [][]=new String [usuarios.size()][3];
        for(int i=0; i<arrayUsuarios.length;i++){
            arrayUsuarios[i][0]=usuarios.get(i).getNombre();
            arrayUsuarios[i][1]=usuarios.get(i).getCorreo();
            arrayUsuarios[i][2]=usuarios.get(i).getContraseña();
        }
        return arrayUsuarios;
    }
    public Registrado elegirRegistrado(ArrayList <Registrado> registrados){
        
        Scanner teclado = new Scanner(System.in);
        this.verUsuarios(registrados);
        System.out.println("escribe el numero del usuario ");
        int numero = teclado.nextInt();
        
        return registrados.get(numero-1);   
    }
    
    public Personaje elegirPersonaje(ArrayList <Personaje> personajes){
        
        Scanner teclado = new Scanner(System.in);
        this.verPersonajes(personajes);
        System.out.println("escribe el numero del personaje ");
        int numero = teclado.nextInt();
        
        return personajes.get(numero-1);   
    }

    public void modificarUsuarioNombre(Registrado r){
        
        System.out.println("nombre nuevo");
        String nombreNuevo=teclado.nextLine();

        r.setNombre(nombreNuevo);  
    }
    
    public void modificarUsuarioContraseña(Registrado r){
        
        System.out.println("contraseña nuevo");
        String contraseñaNueva=teclado.nextLine();
        r.setContraseña(contraseñaNueva);
    }
    
    public void modificarUsuarioCorreo(Registrado r){
        
        System.out.println("correo nuevo");
        String correoNuevo=teclado.nextLine();
        r.setCorreo(correoNuevo);

    }

    public void eliminarUsuarios(ArrayList <Usuario> usuarios){
        
        System.out.println("posicion a eliminar");
        int posicion=teclado.nextInt();
        usuarios.remove(posicion);
    }
    
    public void modificarPersonajeNombre(Personaje p){
        
        System.out.println("nombre nuevo");
        String nombreNuevo=teclado.nextLine();
        p.setNombre(nombreNuevo);
    }
    
    public void modificarPersonajeDaño(Personaje p){
        
        System.out.println("daño nuevo");
        float dañoNuevo=teclado.nextFloat();
        p.setDaño(dañoNuevo);
    }
    
    public void modificarPersonajeVida(Personaje p){
        
        System.out.println("vida nuevo");
        float vidaNueva=teclado.nextFloat();
        p.setVida(vidaNueva);
    }
    
    public void modificarPersonajePrecio(Personaje p){
        
        System.out.println("precio nuevo");
        int precioNuevo=teclado.nextInt();
        p.setPrecio(precioNuevo);
    }
    
    public void verUsuarios(ArrayList <Registrado> registrados){
        
        String [][] tablaDeUsuarios = new String [registrados.size()][3];
        for (int i = 0; i < registrados.size(); i++  )  {
            Registrado r =(Registrado) registrados.get(i);
            tablaDeUsuarios[i][0] =r.getNombre();
            tablaDeUsuarios[i][1] =r.getCorreo();
            tablaDeUsuarios[i][2] =r.getContraseña();



            System.out.println(i+1);


            System.out.println(tablaDeUsuarios[i][0]);
            System.out.println(tablaDeUsuarios[i][1]);
            System.out.println(tablaDeUsuarios[i][2]);
        }      
    }
    
    public void verPersonajes(ArrayList <Personaje> personajes){
        
        String [][] tablaDePersonajes = new String [personajes.size()][3];
        for (int i = 0; i < personajes.size(); i++  )  {
            Personaje p =(Personaje) personajes.get(i);
            tablaDePersonajes[i][0] = p.getNombre();
            tablaDePersonajes[i][1] = Float.toString(p.getDaño());
            tablaDePersonajes[i][2] = Float.toString(p.getVida());
            tablaDePersonajes[i][3] = Integer.toString(p.getPrecio());



            System.out.println(i+1);

            System.out.println(tablaDePersonajes[i][0]);
            System.out.println(tablaDePersonajes[i][1]);
            System.out.println(tablaDePersonajes[i][2]);
            System.out.println(tablaDePersonajes[i][3]);
        }      
    }
    
   
    
    
    //Menú general de los administradores
    public void menuGrande(Juego j){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE ADMINSTRACIÓN");
            System.out.println("-------------------------");
            System.out.println("1.-Gestionar");
            System.out.println("2.-Ver");
            System.out.println("3.-Salir");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    menuGestionar(j);
                    break;
                case 2:
                    menuVer(j);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("ERORR: opciones del 1 al 3");
                    break;
            }
        }while(opcion < 3);
                          
    }
    
    //Menú general de gestionar Usuarios y personajes
    public void menuGestionar(Juego j){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE GESTIÓN");
            System.out.println("----------------");
            System.out.println("1.-Usuarios");
            System.out.println("2.-Personajes");
            System.out.println("3.-Volver");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    menuGestionarUsuarios(j);
                    break;
                case 2:
                    menuGestionarPersonaje(j);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("ERORR: opciones del 1 al 6");
                    break;
            }
        }while(opcion < 3);
    }
    
    //Menú general de ver
    public void menuVer(Juego j){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE VER");
            System.out.println("----------------");
            System.out.println("1.-Ver historial de partidas");
            System.out.println("2.-VEr estadísticas avanzadas");
            System.out.println("3.-Usuarios");
            System.out.println("4.-Personajes");
            System.out.println("5.-Volver");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    j.mostrarTodasPartidas();
                    break;
                case 2:
                    j.estadisticasAvanzadas();
                    break;
                case 3:
                    verUsuarios(j.getRegistrados());
                    break;
                case 4:
                    verPersonajes(j.getPersonajes());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("ERORR: opciones del 1 al 4");
                    break;
            }
        }while(opcion < 3);
        
    }
    
    //Menú general para gestionar usuarios
    public void menuGestionarUsuarios(Juego j){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE USUARIOS");
            System.out.println("----------------");
            System.out.println("1.-Modificar usuarios");
            System.out.println("2.-Eliminar usuarios");
            System.out.println("3.-Volver");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    menuModificarUsuarios(this.elegirRegistrado(j.getRegistrados()));
                    break;
                case 2:
                    j.eliminarRegistrado(this.elegirRegistrado(j.getRegistrados())); 
                    break;
                case 3:
                    break;
                default:
                    System.out.println("ERORR: opciones del 1 al 3");
                    break;
            }
        }while(opcion < 3);
    }
    
    public void menuGestionarPersonaje(Juego j){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ DE PERSONAJES");
            System.out.println("----------------");
            System.out.println("1.-Modificar nombre");
            System.out.println("2.-Modificar daño");
            System.out.println("3.-Modificar vida");
            System.out.println("4.-Volver");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    modificarPersonajeNombre(this.elegirPersonaje(j.getPersonajes()));
                    break;
                case 2:
                    modificarPersonajeDaño(this.elegirPersonaje(j.getPersonajes()));
                    break;
                case 3:
                    modificarPersonajeVida(this.elegirPersonaje(j.getPersonajes()));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("ERORR: opciones del 1 al 3");
                    break;
            }
        }while(opcion < 3);
    }
        
        
    
    //Menú para modificar los datos de usuario
    public void menuModificarUsuarios(Registrado r){
       Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENÚ MODIFICAR USUARIOS");
            System.out.println("-------------------------");
            System.out.println("1.-Modificar nombre");
            System.out.println("2.-Modificar contraseña");
            System.out.println("3.-Modificar e-mail");
            System.out.println("4.-Volver");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    modificarUsuarioNombre(r);
                    break;
                case 2:
                    modificarUsuarioContraseña(r);
                    break;
                case 3:
                    modificarUsuarioCorreo(r);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("ERORR: opciones del 1 al 3");
                    break;
            }
        }while(opcion<3);
                          
    }
    
    
    /*public Registrado menuEliminarUsario(Registrado r){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do{    
            System.out.println("ELEMINAR USARIOS");
            System.out.println("-----------------");
            System.out.println("1.-Eliminar usuario");
            System.out.println("2.-Volver");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    
                    break;
                case 2:
                    break;
                default:
                    System.out.println("ERORR: opciones del 1 al 2");
                    break;
            }
        }while(opcion<2);
        return Registrado;
    }*/
    
    
        
 }
    
    
    
    
    
