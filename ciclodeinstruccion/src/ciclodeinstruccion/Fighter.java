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
public class Fighter extends Personaje {

    private float Critico;
    

    public Fighter(String nombre, float vida, float daño,float Critico, int precio) {
        super(nombre, vida, daño, precio);
        this.Critico = Critico;
    }

    public float getCritico() {
        return Critico;
    }

    public void setCritico(float Critico) {
        this.Critico = Critico;
    }
    
    
    
    
    
    
    
    
}
