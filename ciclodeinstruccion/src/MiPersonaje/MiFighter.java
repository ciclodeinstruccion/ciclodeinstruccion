/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiPersonaje;

import MiPersonaje.MiPersonaje;
import Personaje.Fighter;
import ciclodeinstruccion.GeneradorAleatorios;
import ciclodeinstruccion.Habilidad;

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
    public float getVidaBase(){
        return personaje.getVida();
    }
    
    public float armadura(int especial){
        return 0;
    }
    public boolean esquiva(int especial){
        return false;
    }
    public Habilidad elegirHabilidad(int inteligencia){
        Habilidad elegida;
        int random=GeneradorAleatorios.generarAleatorio(100+inteligencia);
        if (random<personaje.getHabilidades().get(0).getPorcentajeDeUso()){
            elegida=personaje.getHabilidades().get(0);
        }
        else if (random<personaje.getHabilidades().get(0).getPorcentajeDeUso()+personaje.getHabilidades().get(1).getPorcentajeDeUso()){
            elegida=personaje.getHabilidades().get(1);
        }
        else{
            elegida=personaje.getHabilidades().get(2);
        }
        return elegida;
    }
    public boolean critico(int especial){
        boolean critico = false;
        int random=GeneradorAleatorios.generarAleatorio(100);
        if (random<personaje.getCritico()+bonusCritico+especial){
            critico = true;
        }
        return critico;
    }
    public float getDañoBase(){
        return personaje.getDaño();
    }
    public String getNombre(){
        return this.personaje.getNombre();
    }
}
