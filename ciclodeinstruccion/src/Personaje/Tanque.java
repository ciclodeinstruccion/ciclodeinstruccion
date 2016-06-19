/**
 * Clase heredera de personaje
 */
package Personaje;

import Personaje.Personaje;

public class Tanque extends Personaje{
    private float armadura;

    public Tanque(String nombre, float vida, float daño, float armadura, int precio, String tipo ) {
        super(nombre, vida, daño, precio, tipo);
        this.armadura=armadura;
    }
    public Tanque(String nombre){
        super(nombre);
    }
    public float getArmadura() {
        return armadura;
    }

    public void setArmadura(float armadura) {
        this.armadura = armadura;
    }
    
}
