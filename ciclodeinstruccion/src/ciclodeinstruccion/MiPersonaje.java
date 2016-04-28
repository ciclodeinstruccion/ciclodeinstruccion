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
public abstract class MiPersonaje implements Personajeable{
    private float bonusVida;
    private float bonusDaño;
    private int nivel;
    private int experiencia;

    public MiPersonaje(float bonusVida, float bonusDaño, int nivel, int experiencia) {
        this.bonusVida = bonusVida;
        this.bonusDaño = bonusDaño;
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    public float getBonusVida() {
        return bonusVida;
    }

    public float getBonusDaño() {
        return bonusDaño;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setBonusVida(float bonusVida) {
        this.bonusVida = bonusVida;
    }

    public void setBonusDaño(float bonusDaño) {
        this.bonusDaño = bonusDaño;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
}
