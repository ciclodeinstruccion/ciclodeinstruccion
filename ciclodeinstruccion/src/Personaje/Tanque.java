/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personaje;

import Personaje.Personaje;

/**
 *
 * @author alumno
 */
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
