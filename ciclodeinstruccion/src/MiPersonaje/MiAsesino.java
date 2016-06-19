/**
 * Clase heredera de mipersonaje que contiene un objeto asesino
 */
package MiPersonaje;

import Personaje.Asesino;
import ciclodeinstruccion.GeneradorAleatorios;
import ciclodeinstruccion.Habilidad;

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
    public void disminuirEsquivar(){
        this.bonusEsquivar-=AUMENTAR_ESQUIVAR;
        this.aumentarPuntosNivel();
    }
    public Asesino getPersonaje() {
        return personaje;
    }

    public float getBonusEsquivar() {
        return bonusEsquivar;
    }
    
    public String getTipo(){
        return personaje.getTipo();
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
    public boolean critico(int especial){
        return false;
    }
    public float armadura(int especial){
        return 0;
    }
    public boolean esquiva(int especial){
        boolean esquivar=false;
        int random=GeneradorAleatorios.generarAleatorio(100);
        if(random<personaje.getEsquivar()+this.bonusEsquivar+especial){
            esquivar=true;
        }
        return esquivar;
    }
    /**
     * metodo que calcula una habilidad de forma aleatoria
     * @param inteligencia del registrado
     * @return la habilidad
     */
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
    public String getNombre(){
        return this.personaje.getNombre();
    }
}
