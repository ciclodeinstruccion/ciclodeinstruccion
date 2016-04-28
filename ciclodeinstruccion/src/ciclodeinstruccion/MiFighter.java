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
public class MiFighter extends MiPersonaje{
    private Fighter personaje;
    private float bonusCritico;

    public MiFighter(float bonusVida, float bonusDaño, int nivel, int experiencia, Fighter personaje, float bonusCritico) {
        super(bonusVida, bonusDaño, nivel, experiencia);
        this.personaje=personaje;
        this.bonusCritico=bonusCritico;
    }

    public Fighter getPersonaje() {
        return personaje;
    }

    public float getBonusCritico() {
        return bonusCritico;
    }

    public void setPersonaje(Fighter personaje) {
        this.personaje = personaje;
    }

    public void setBonusCritico(float bonusCritico) {
        this.bonusCritico = bonusCritico;
    }   
}
