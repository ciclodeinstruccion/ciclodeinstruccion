/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiPersonaje;

import ciclodeinstruccion.Habilidad;

/**
 *
 * @author alumno
 */
public interface MiPersonajeable {
    public boolean critico(int especial);
    
    public float getVidaBase();
    
    public float getDañoBase();
    
    public boolean esquiva(int especial);
    
    public float armadura(int especial);
    
    public Habilidad elegirHabilidad(int inteligencia);
    
    public String getNombre();
    
    public String getTipo();
}
