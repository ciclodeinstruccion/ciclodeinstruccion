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
    private final float AUMENTAR_ESQUIVAR=1;

    public MiAsesino(float bonusVida, float bonusDaño, int nivel, int experiencia,int puntosNivel,Asesino personaje,float bonusEsquivar) {
        super(bonusVida, bonusDaño, nivel, experiencia,puntosNivel);
        this.personaje=personaje;
        this.bonusEsquivar=bonusEsquivar;
    }
    public void aumentarEsquivar(){
        this.bonusEsquivar+=AUMENTAR_ESQUIVAR;
        this.gastarPuntosNivel();
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
    
    public float getVidaBase(){
        return personaje.getVida();
    }
    public boolean critico(){
        return false;
    }
    public float armadura(){
        return 0;
    }
    public boolean esquiva(){
        boolean esquivar=false;
        int random=GeneradorAleatorios.generarAleatorio(100);
        if(random<personaje.getEsquivar()+this.bonusEsquivar){
            esquivar=true;
        }
        return esquivar;
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
    public float getDañoBase(){
        return personaje.getDaño();
    }
    
}
