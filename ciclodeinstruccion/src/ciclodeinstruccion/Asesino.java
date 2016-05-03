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
public class Asesino extends Personaje{
    private float esquivar;

    public Asesino(String nombre, float vida, float daño, int precio, float esquivar) {
        super(nombre, vida, daño, precio);
        this.esquivar=esquivar;
    }

    public float getEsquivar() {
        return esquivar;
    }

    public void setEsquivar(float esquivar) {
        this.esquivar = esquivar;
    }
    
    
}
