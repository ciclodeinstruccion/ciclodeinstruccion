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
public class MiTanque extends MiPersonaje{
    private Tanque personaje;
    private float bonusArmadura;
    private final float AUMENTAR_ARMADURA=1;

    public MiTanque(float bonusVida, float bonusDaño, int nivel, int experiencia,int puntosNivel,Tanque personaje,float bonusArmadura) {
        super(bonusVida, bonusDaño, nivel, experiencia,puntosNivel);
        this.personaje=personaje;
        this.bonusArmadura=bonusArmadura;
    }
    public void aumentarArmadura(){
        this.bonusArmadura+=AUMENTAR_ARMADURA;
        this.gastarPuntosNivel();
    }
    public Tanque getPersonaje() {
        return personaje;
    }

    public float getBonusArmadura() {
        return bonusArmadura;
    }

    public void setPersonaje(Tanque personaje) {
        this.personaje = personaje;
    }

    public void setBonusArmadura(float bonusArmadura) {
        this.bonusArmadura = bonusArmadura;
    }
    
}
