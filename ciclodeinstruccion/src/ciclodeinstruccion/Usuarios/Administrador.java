/**
 * Clase heredera de administrador
 */
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
import BaseDeDatos.ConsultasBD;
import Personaje.Asesino;
import Personaje.Fighter;
import Personaje.Tanque;

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
        usuarios=ConsultasBD.instancia().todosRegistrados();
        String arrayUsuarios [][]=new String [usuarios.size()][3];
        for(int i=0; i<arrayUsuarios.length;i++){
            arrayUsuarios[i][0]=usuarios.get(i).getNombre();
            arrayUsuarios[i][1]=usuarios.get(i).getCorreo();
            arrayUsuarios[i][2]=usuarios.get(i).getContraseña();
        }
        return arrayUsuarios;
    }
    
    public String [][] tablaEstadisticas(){
        ArrayList <String> nombres =new ArrayList();
        nombres=ConsultasBD.instancia().nombreTodosPersonajes();
        String nombresPj []=new String [nombres.size()];
        float winratio [][]=new float [nombres.size()][nombres.size()];
        for(int i=0;i<nombresPj.length;i++){
            nombresPj[i]=nombres.get(i);
        }
        String nombresPj2 []=nombresPj;
        
        for(int i=0;i<nombresPj.length;i++){
            for(int j=0;j<nombresPj2.length;j++){
                float pJugadas=ConsultasBD.instancia().partidasJugadas2Personajes(nombresPj[i], nombresPj2[j]) + ConsultasBD.instancia().partidasJugadas2Personajes(nombresPj2[j], nombresPj[i]);
                float pGanadas=ConsultasBD.instancia().partidasGanadasPersonaje(nombresPj[i], nombresPj2[j], nombresPj[i]) + ConsultasBD.instancia().partidasGanadasPersonaje(nombresPj2[j], nombresPj[i], nombresPj[i]);
                if(pJugadas==0){
                    winratio[i][j]=0;
                }
                else{
                    winratio[i][j]=(pGanadas/pJugadas)*100;
                }
            }
        }
        
        float ganadasTotales []=new float [nombres.size()];
        int jugadasTotales []=new int [nombres.size()];
        for(int i=0;i<ganadasTotales.length;i++){
            float pJugadasT=ConsultasBD.instancia().partidasJugadas1Personaje1(nombresPj[i])+ConsultasBD.instancia().partidasJugadas1Personaje2(nombresPj[i]);
            jugadasTotales[i]=(int)pJugadasT;
            float pGanadasT=ConsultasBD.instancia().partidasGanadas1Personaje(nombresPj[i]);
            if(pJugadasT==0){
                ganadasTotales[i]=0;
            }
            else{
                ganadasTotales[i]=(pGanadasT/pJugadasT)*100;
            }
        }
        
        String estadisticas [][]=new String[winratio.length][winratio.length+3];
        for(int i=0;i<estadisticas.length;i++){
            for(int j=0;j<estadisticas[i].length;j++){
                if(j==0){
                    estadisticas[i][j]= nombresPj[i];
                }
                else if(j==estadisticas[i].length-1){
                    estadisticas[i][j]= Float.toString(ganadasTotales[i]);
                }
                else if(j==estadisticas[i].length-2){
                    estadisticas[i][j]=Integer.toString(jugadasTotales[i]);
                }
                else{
                    estadisticas[i][j]=Float.toString(winratio[i][j-1]);
                }
            }
        }
        return estadisticas;
    }
    
    public String [] cabeceraEstadisticas(){
        ArrayList <String> nombres =new ArrayList();
        nombres=ConsultasBD.instancia().nombreTodosPersonajes();
        String nombresPj []=new String [nombres.size()+3];
        nombresPj[0]="PERSONAJES";
        nombresPj[nombresPj.length-2]="P.TOTALES";
        nombresPj[nombresPj.length-1]="% TOTAL";
        for (int i=1;i<nombresPj.length-2;i++){
            nombresPj[i]=nombres.get(i-1);
        }
        return nombresPj;
    }
    
    public String [][] tablaPersonajes(){
        ArrayList <Personaje> personajes=new ArrayList();
        personajes=ConsultasBD.instancia().todosLosPersonajes();
        String pj [][]= new String [personajes.size()][6];
        
        for (int i=0; i<pj.length;i++){
            pj[i][0]=personajes.get(i).getNombre();
            pj[i][1]=Float.toString(personajes.get(i).getVida());
            pj[i][2]=Float.toString(personajes.get(i).getDaño());
            pj[i][3]=Integer.toString(personajes.get(i).getPrecio());
            if(personajes.get(i) instanceof Tanque){
                pj[i][4]="Tanque";
                Tanque t=(Tanque) personajes.get(i);
                pj[i][5]=Float.toString(t.getArmadura());
            }
            else if(personajes.get(i) instanceof Asesino){
                pj[i][4]="Asesino";
                Asesino a=(Asesino) personajes.get(i);
                pj[i][5]=Float.toString(a.getEsquivar());
            }
            else if(personajes.get(i) instanceof Fighter){
                pj[i][4]="Fighter";
                Fighter f=(Fighter) personajes.get(i);
                pj[i][5]=Float.toString(f.getCritico());
            }
        }
        return pj;
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
    public String [][] tablaHistorialPartidas(){
        ArrayList <Partida> historial=new ArrayList();
        historial=ConsultasBD.instancia().todasLasPartidas();
        String arrayPartidas[][]=new String [historial.size()][7];
        
        for(int i=0;i<arrayPartidas.length;i++){
            arrayPartidas[i][0]=Integer.toString(historial.get(i).getIdentificador());
            arrayPartidas[i][1]=historial.get(i).getJugador1().getNombre();
            arrayPartidas[i][2]=historial.get(i).getPersonaje1().getNombre();
            arrayPartidas[i][3]=historial.get(i).getJugador2().getNombre();
            arrayPartidas[i][4]=historial.get(i).getPersonaje2().getNombre();
            arrayPartidas[i][5]=historial.get(i).getGanador().getNombre();
            arrayPartidas[i][6]=historial.get(i).getpGanador().getNombre();
        }
        return arrayPartidas;
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
    
    
    
    
    
