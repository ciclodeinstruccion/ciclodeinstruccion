/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

/**
 *
 * @author alumno
 */
public abstract class Personaje {
    private String nombre;
    private float vida;
    private float daño;
    private int precio;

    public Personaje(String nombre, float vida, float daño, int precio) {
        this.nombre = nombre;
        this.vida = vida;
        this.daño = daño;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public void setDaño(float daño) {
        this.daño = daño;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public float getVida() {
        return vida;
    }

    public float getDaño() {
        return daño;
    }

    public int getPrecio() {
        return precio;
    }
    
    
}
