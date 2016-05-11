/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion.Usuarios;

import MiPersonaje.MiPersonaje;
import Personaje.Personaje;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Registrado extends Usuario{
    
    private float horasJugadas;
    private int nivel;
    private int oro;
    private int experiencia;
    private int vitalidad;
    private int fuerza;
    private int especial;
    private int inteligencia;
    private final int EXPERIENCIA_NECESARIA=1000;
    private int puntosNivel;
    private ArrayList <MiPersonaje> misPersonajes;
    

    public Registrado(float horasJugadas, int nivel, int oro, int experiencia, int vitalidad, int fuerza, int especial, int inteligencia, int puntosNivel, String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
        this.horasJugadas = horasJugadas;
        this.nivel = nivel;
        this.oro = oro;
        this.experiencia = experiencia;
        this.vitalidad = vitalidad;
        this.fuerza = fuerza;
        this.especial = especial;
        this.inteligencia = inteligencia;
        this.puntosNivel = puntosNivel;
        this.misPersonajes = new ArrayList();
       
    }
    public Registrado(String nombre){
        super(nombre);
    }

    public void modificarVitalidad(){
        
        this.vitalidad++;
        this.gastarPuntosExp();
    }
    
    
    
    public void modificarFuerza(){
        
        this.fuerza++;
        this.gastarPuntosExp();
    }
    
    public void modificarEspecial(){
        
        this.especial++;
        this.gastarPuntosExp();
    }
    
    public void modificarInteligencia(){
        
        this.inteligencia++;
        this.gastarPuntosExp();
    }
    
    public void añadirPersonajes(MiPersonaje p){
        misPersonajes.add(p);
    }
    
    /*public void verHistorialDePartidas(listaDePartidas){
        
    }
    
    public void verRepeticion (listaDePartidas){
        
    }*/
    
    public void gastarPuntosExp(){
        puntosNivel--;
    }
    
    public void gastarPuntosOro(int oroGastado){
        
        if(this.oro>oroGastado){
            oro-=oroGastado;
        } else {
            System.out.println("no hay suficiente oro");
        }
    }
    
    public void aumentarExperiencia(int sumaExperiencia){
        
        experiencia+=sumaExperiencia;
        if (experiencia>=EXPERIENCIA_NECESARIA*nivel){
            experiencia = experiencia - EXPERIENCIA_NECESARIA * nivel;
            this.subirNivel();
        }
        
    }
    
    public void mostrarPersonajes(){
        
        String [][] tablaDeMisPersonajes = new String [misPersonajes.size()][3];
        for (int i = 0; i < misPersonajes.size(); i++  )  {
            MiPersonaje mp =(MiPersonaje) misPersonajes.get(i);
            tablaDeMisPersonajes[i][0] = mp.getNombre();
            tablaDeMisPersonajes[i][1] = Float.toString(mp.getDañoBase()+mp.getBonusDaño()+this.fuerza);
            tablaDeMisPersonajes[i][2] = Float.toString(mp.getVidaBase()+mp.getBonusVida()+this.vitalidad);
            System.out.println(i+1);
            System.out.println(tablaDeMisPersonajes[i][0]);
            System.out.println(tablaDeMisPersonajes[i][1]);
            System.out.println(tablaDeMisPersonajes[i][2]);
        }      
        
         
    }
    public MiPersonaje elegirPersonaje(){
        Scanner teclado =new Scanner(System.in);
        MiPersonaje elegido;
        this.mostrarPersonajes();
        int opcion;
        System.out.println("Seleccione numero del personaje");
        opcion=teclado.nextInt();
        teclado.nextLine();
        elegido=misPersonajes.get(opcion-1);
        return elegido;
    }
    
    public void aumentarOro(int orosumado){
        
        oro+=orosumado;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("oro "+oro);
        System.out.println("experiencia "+this.experiencia);
        System.out.println("puntos de subir "+this.puntosNivel);
    }
    
    public void subirNivel(){
        nivel++;
        puntosNivel++;
    }
    public void unirsePartida(){
        
    }
    public float getHorasJugadas() {
        return horasJugadas;
    }

    public int getNivel() {
        return nivel;
    }

    public int getOro() {
        return oro;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getEspecial() {
        return especial;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setHorasJugadas(float horasJugadas) {
        this.horasJugadas = horasJugadas;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setEspecial(int especial) {
        this.especial = especial;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
    
    

    
    
    
    
    
    
}
