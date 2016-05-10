
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
    
    Scanner teclado = new Scanner(System.in);

    public Administrador(String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
    }
    public Administrador(String nombre){
        super(nombre);
    }
    
    public Registrado elegirRegistrado(ArrayList <Registrado> registrados){
        
        Scanner teclado = new Scanner(System.in);
        this.verUsuarios(registrados);
        System.out.println("escribe el numero del usuario ");
        int numero = teclado.nextInt();
        
        return registrados.get(numero);   
    }
    
    public Personaje elegirPersonaje(ArrayList <Personaje> personajes){
        
        Scanner teclado = new Scanner(System.in);
        this.verPersonajes(personajes);
        System.out.println("escribe el numero del personaje ");
        int numero = teclado.nextInt();
        
        return personajes.get(numero);   
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
    
    public void historialDePartidas(ArrayList <Partida> partidas){
        
        
       
    }
    
    public void verEstadisticasAvanzadas(ArrayList <Partida> partidas){
        
        
    }

    /*public void menuGrande(){
        
        boolean bandera = true;
        
        while (bandera=true){
            System.out.println("1 modificar nombre de usuario");
            System.out.println("2 modificar correo del usuario");
            System.out.println("3 modificar contraseña del usuario");
            System.out.println("4 ");
            System.out.println("5 eliminar erramientas");
            System.out.println("6 guardar las herramientas en binario");
            //System.out.println("7 guardar las ferreterias");
            System.out.println("8 modificar una herramienta");
            System.out.println("9 cargar herramientas desde binario");
            
            
            opcion=teclado.nextInt();
            teclado.hasNextLine();
            switch(opcion){
                case 1: f.añadirDatos();
                    break;
                //case 2: f.introducirFerreteria();
                    //break;
                case 3:
                    
                        System.out.println("1 mostrar ordenado por el precio");
                        System.out.println("2 mostrar ordenado por el nombre");
                        System.out.println("3 mostrar ordenado por marca y modelo");
                        System.out.println("4 mostrar sin ordenar");
                        
                        opcion1=teclado.nextInt();
                        teclado.nextLine();
                        switch(opcion1){
                            case 1: f.mostrarHerramientasOrdenadasPrecio();
                                break;
                            case 2: f.mostrarHerramientasOrdenadasNombre();
                                break;
                            case 3: f.mostrarHerramientasOrdenadasMarcaModelo();
                                break;
                            case 4: f.mostrar();
                                break;
                            
                                
                        }
                    
                    break;
                case 4: f1.mostrarferreteria();
                    break;
                case 5: f.elimiarHerramientas();
                    break;
                case 6: h.escribirEnBinario();
                    break;
                case 7: f.guardarFerreteria();
                    break;
                case 8: f.modificar();
                    break;
                case 9: f.cargarDesdeBinarioHerramientas();
                    break;
                default:
                    bandera=false;
            }   
        }*/
    }
    
    
    
