/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

/**
 *
 * @author Javier
 */
public class Habilidad implements Comparable<Habilidad>{
    
    private String nombre;
    private int porcentajeDeUso;
    private float daño;
    private float cura;

    public Habilidad(String nombre, int porcentajeDeUso, float daño, float cura) {
        this.nombre = nombre;
        this.porcentajeDeUso = porcentajeDeUso;
        this.daño = daño;
        this.cura = cura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPorcentajeDeUso() {
        return porcentajeDeUso;
    }

    public float getDaño() {
        return daño;
    }

    public float getCura() {
        return cura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPorcentajeDeUso(int porcentajeDeUso) {
        this.porcentajeDeUso = porcentajeDeUso;
    }

    public void setDaño(float daño) {
        this.daño = daño;
    }

    public void setCura(float cura) {
        this.cura = cura;
    }

    @Override
    public int compareTo(Habilidad h) {
        int diferencia;
        return diferencia=this.porcentajeDeUso-h.porcentajeDeUso;
        
    }
    
    
    
}
