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
    private final float AUMENTAR_CRITICO=1;

    public MiFighter(float bonusVida, float bonusDaño, int nivel, int experiencia,int puntosNivel, Fighter personaje, float bonusCritico) {
        super(bonusVida, bonusDaño, nivel, experiencia,puntosNivel);
        this.personaje=personaje;
        this.bonusCritico=bonusCritico;
    }
    public void aumentarCritico(){
        this.bonusCritico+=this.AUMENTAR_CRITICO;
        this.gastarPuntosNivel();
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
    
    public boolean critico(){
        boolean critico = false;
        int random=GeneradorAleatorios.generarAleatorio(100);
        if (random<personaje.getCritico()+bonusCritico){
            critico = true;
        }
        return critico;
    }
    
}
