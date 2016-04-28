/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion.Usuarios;

/**
 *
 * @author alumno
 */
public class Registrados extends Usuarios{
    
    private float horasJugadas;
    private int nivel;
    private int oro;
    private int experiencia;
    private int vitalidad;
    private int fuerza;
    private int especial;
    private int inteligencia;

    public Registrados(float horasJugadas, int nivel, int oro, int experiencia, int vitalidad, int fuerza, int especial, int inteligencia, String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
        this.horasJugadas = horasJugadas;
        this.nivel = nivel;
        this.oro = oro;
        this.experiencia = experiencia;
        this.vitalidad = vitalidad;
        this.fuerza = fuerza;
        this.especial = especial;
        this.inteligencia = inteligencia;
    }

    public void modificarVitalidad(){
        
    }
    
    public void modificarFuerza(){
        
    }
    
    public void modificarEspecial(){
        
    }
    
    public void modificarInteligencia(){
        
    }
    
    public void comprarPersonaje(){
        
    }
    
    public void mejorarPersonaje(Personaje p ){
        
    }
    
    public void verHistorialDePartidas(listaDePartidas){
        
    }
    
    public void verRepeticion (listaDePartidas){
        
    }
    
    public void subirNivel(){
        
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
