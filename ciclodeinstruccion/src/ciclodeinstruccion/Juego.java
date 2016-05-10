/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

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
    private ArrayList <Partida> finalizadas;
    private ArrayList <Partida> noFinalizada;

    public Juego() {
        this.registrados = new ArrayList();
        this.administradores = new ArrayList();
        this.finalizadas = new ArrayList();
        this.noFinalizada = new ArrayList();
    }
    
    public void añadirRegistrado(Registrado r){
        registrados.add(r);
    }
    
    public void añadirAdministrador(Administrador a){
        administradores.add(a);
    }
    
    public void añadirPNofinalizada(Partida p){
        noFinalizada.add(p);
    }
    
    public void añadirPFinalizada(Partida p){
        noFinalizada.add(p);
    }

    public ArrayList<Registrado> getRegistrados() {
        return registrados;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public ArrayList<Partida> getFinalizadas() {
        return finalizadas;
    }

    public ArrayList<Partida> getNoFinalizada() {
        return noFinalizada;
    }

    public void setRegistrados(ArrayList<Registrado> registrados) {
        this.registrados = registrados;
    }

    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    public void setFinalizadas(ArrayList<Partida> finalizadas) {
        this.finalizadas = finalizadas;
    }

    public void setNoFinalizada(ArrayList<Partida> noFinalizada) {
        this.noFinalizada = noFinalizada;
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
        for(Partida p:noFinalizada){
            if(!p.getJugador1().getNombre().equals(r.getNombre())){
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
        
    }
   
    
}
