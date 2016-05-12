/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

import MiPersonaje.MiPersonaje;
import Personaje.Personaje;
import ciclodeinstruccion.Usuarios.Administrador;
import ciclodeinstruccion.Usuarios.Registrado;
import ciclodeinstruccion.Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Juego {
    private ArrayList <Registrado> registrados;
    private ArrayList <Administrador> administradores;
    private ArrayList <Partida> partidas;
    private ArrayList <Personaje> personajes;

    public Juego() {
        this.registrados = new ArrayList();
        this.administradores = new ArrayList();
        this.partidas = new ArrayList();
        this.personajes = new ArrayList();
    }
    
    public void añadirRegistrado(Registrado r){
        registrados.add(r);
    }
    
    public void añadirAdministrador(Administrador a){
        administradores.add(a);
    }
    
    public void añadirPartida(Partida p){
        partidas.add(p);
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
    public void eliminarRegistrado(Registrado r){
        registrados.remove(r);
    }
    
    
    public void añadirPersonajes(Personaje personaje){
        personajes.add(personaje);
    }
    

    public ArrayList<Registrado> getRegistrados() {
        return registrados;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }


    public void setRegistrados(ArrayList<Registrado> registrados) {
        this.registrados = registrados;
    }

    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    
    public Usuario iniciarSesion(){
        Scanner teclado=new Scanner(System.in);
        String nombreUsuario;
        String contraseña;
        Usuario usuario=null;
        System.out.println("Introduce nombre de usuario:");
        nombreUsuario=teclado.nextLine();
        System.out.println("Introduce contraseña:");
        contraseña=teclado.nextLine();
        int regist=this.buscarRegistrado(nombreUsuario);
        int admin=this.buscarAdministrador(nombreUsuario);
        if(regist>=0){
            if(registrados.get(regist).getContraseña().equals(contraseña)){
                usuario=registrados.get(regist);
            }
        }
        else if(admin>=0){
            if(administradores.get(admin).getContraseña().equals(contraseña)){
                usuario=administradores.get(admin);
            }
        }
        else{
            System.out.println("Nombre de usuario o contraseña no validos");
        }
        return usuario;
    }
    
    public Registrado registrarse(){
        Registrado usuario=null;
        String nombreUsuario;
        String correo;
        String contraseña;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduzca nombre de usuario: ");
        nombreUsuario=teclado.nextLine();
        if(this.buscarRegistrado(nombreUsuario)<0&&this.buscarAdministrador(nombreUsuario)<0){
            System.out.println("Introduce correo: ");
            correo=teclado.nextLine();
            System.out.println("Introduce contraseña: ");
            contraseña=teclado.nextLine();
            Registrado r=new Registrado(0,0,500,0,0,0,0,0,0,nombreUsuario,correo,contraseña);
            usuario=r;
            System.out.println("REGISTRADO CON EXITO");
            this.añadirRegistrado(r);
        }
        else{
            System.out.println("El usuario ya existe.");
        }
        return usuario;
    }
    
    public int buscarRegistrado(String nombre){
        registrados.sort(null);
        int inicio=0;
        int fin=registrados.size()-1;
        int medio;
        int posicion=-1;
        
        while (inicio<=fin){
            Registrado r=new Registrado(nombre);
            medio=(inicio+fin)/2;
            if ((registrados.get(medio).compareTo(r))<0){
                inicio=medio+1;
            }
            else if((registrados.get(medio).compareTo(r))>0){
                fin=medio-1;
            }
            else{
                posicion=medio;
                inicio=fin+1;
            }
        }
        return posicion;
    }
    public int buscarAdministrador(String nombre){
        administradores.sort(null);
        int inicio=0;
        int fin=administradores.size()-1;
        int medio;
        int posicion=-1;
        
        while (inicio<=fin){
            Administrador a=new Administrador(nombre);
            medio=(inicio+fin)/2;
            if ((administradores.get(medio).compareTo(a))<0){
                inicio=medio+1;
            }
            else if((administradores.get(medio).compareTo(a))>0){
                fin=medio-1;
            }
            else{
                posicion=medio;
                inicio=fin+1;
            }
        }
        return posicion;
    }
    public void buscarPartida(Registrado r){
        Scanner teclado=new Scanner(System.in);
        ArrayList <Partida> partidas=new ArrayList();
        for(Partida p:this.partidas){
            if(!p.getJugador1().getNombre().equals(r.getNombre()) && !p.isFinalizada()){
                partidas.add(p);
            }
        }
        for(Partida p: partidas){
            System.out.println(partidas.indexOf(p)+1);
            p.mostrarPartidasNoFinalizadas();
        }
        System.out.println("Seleccione partida: ");
        int partida;
        partida=teclado.nextInt();
        teclado.nextLine();
        
        Partida jugar=partidas.get(partida-1);
        jugar.unirsePartida(r, r.elegirPersonaje());
        jugar.jugarPartida();
        
    }
   
    public void mostrarTodasPartidas(){
        for (Partida p:partidas){
            System.out.println(p.getJugador1().getNombre()+" jugo con "+p.getPersonaje1());
            System.out.println(p.getJugador2().getNombre()+" jugo con "+p.getPersonaje2());
            System.out.println(p.getTexto());
        }    
    }
    
    
    
    public void historialPartidas(Registrado r){
        
        Scanner a = new Scanner(System.in);
        
        int opcion;
        
        ArrayList <Partida> partidas=new ArrayList();
        
        for(Partida p:partidas){
            if(p.getJugador1().getNombre().equals(r.getNombre())&&p.isFinalizada()){
                
                partidas.add(p);
            }
        }  
    
        for(Partida p:partidas){
            System.out.println(partidas.indexOf(p)+1);
            p.mostrarPartidasFinalizadas();
        }
        
        System.out.println("seleciona partida: ");
        opcion=a.nextInt();
        Partida jugar=partidas.get(opcion-1);
    
        jugar.ver();
    }
    
    public float calcularWinratio(String s){
        float winratio=0;
        ArrayList <Partida> finalizadas;
        int numeropartidas=0;
        int ganadas=0;
        for(Partida p:partidas){
            if(p.getPersonaje1().getNombre().equals(s)){
                numeropartidas++;
            }
            if(p.getPersonaje2().getNombre().equals(s)){
                numeropartidas++;
            }
            if(p.getpGanador().getNombre().equals(s)){
                ganadas++;
            }
        }
        if(numeropartidas==0){
            winratio=0;
        }
        else{
            winratio=(ganadas/numeropartidas)*100;
        }
        return winratio;
    }
    
    public void estadisticasAvanzadas(){
  
        for(Personaje p:this.personajes){
            System.out.println((personajes.indexOf(p)+1)+"."+p.getNombre()+":"+this.calcularWinratio(p.getNombre()));
        }
        
    }
}
