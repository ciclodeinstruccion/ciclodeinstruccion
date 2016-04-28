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

    public MiTanque(float bonusVida, float bonusDaño, int nivel, int experiencia,Tanque personaje,float bonusArmadura) {
        super(bonusVida, bonusDaño, nivel, experiencia);
        this.personaje=personaje;
        this.bonusArmadura=bonusArmadura;
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
