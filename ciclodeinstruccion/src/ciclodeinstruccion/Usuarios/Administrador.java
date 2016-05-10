
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
    
    
    
