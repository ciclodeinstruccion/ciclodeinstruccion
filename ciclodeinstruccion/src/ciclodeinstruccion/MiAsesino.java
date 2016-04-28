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
public class MiAsesino extends MiPersonaje{
    private Asesino personaje;
    private float bonusEsquivar;

    public MiAsesino(float bonusVida, float bonusDaño, int nivel, int experiencia,Asesino personaje,float bonusEsquivar) {
        super(bonusVida, bonusDaño, nivel, experiencia);
        this.personaje=personaje;
        this.bonusEsquivar=bonusEsquivar;
    }

    public Asesino getPersonaje() {
        return personaje;
    }

    public float getBonusEsquivar() {
        return bonusEsquivar;
    }

    public void setPersonaje(Asesino personaje) {
        this.personaje = personaje;
    }

    public void setBonusEsquivar(float bonusEsquivar) {
        this.bonusEsquivar = bonusEsquivar;
    }
    
}
