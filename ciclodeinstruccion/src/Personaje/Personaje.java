/**
 * Clase base de la que heredan asesino, tanque y fighter. Contiene un arraylist
 * de habilidades de tamaño 3
 */
package Personaje;

import ciclodeinstruccion.Habilidad;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public abstract class Personaje implements Comparable <Personaje>{
    private String nombre;
    private float vida;
    private float daño;
    private int precio;
    private String tipo;
    private ArrayList <Habilidad> habilidades;

    public Personaje(String nombre, float vida, float daño, int precio, String tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.daño = daño;
        this.precio = precio;
        this.tipo = tipo;
        this.habilidades=new ArrayList(3);
    }
    public Personaje(String nombre){
        this.nombre=nombre;
    }
    public void añadirHabilidad(Habilidad h){
        habilidades.add(h);
        habilidades.sort(null);
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo(){
        return tipo;
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

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }
    
    public void mostrarHabilidad(){
        for(Habilidad h:habilidades){
            System.out.println(h.getNombre());
        }
    }
    @Override
    public int compareTo(Personaje p) {
        return this.nombre.compareTo(p.nombre);
    }
}
