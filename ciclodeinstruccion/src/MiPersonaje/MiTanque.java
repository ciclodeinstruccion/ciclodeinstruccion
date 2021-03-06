/**
 * Clase heredera de mipersonaje que contiene un objeto tanque
 */
package MiPersonaje;

import Personaje.Tanque;
import ciclodeinstruccion.GeneradorAleatorios;
import ciclodeinstruccion.Habilidad;

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
    public void disminuirArmadura(){
        this.bonusArmadura-=AUMENTAR_ARMADURA;
        this.aumentarPuntosNivel();
    }
    public Tanque getPersonaje() {
        return personaje;
    }

    public float getBonusArmadura() {
        return bonusArmadura;
    }
    
    public String getTipo(){
        return personaje.getTipo();
    }

    public void setPersonaje(Tanque personaje) {
        this.personaje = personaje;
    }

    public void setBonusArmadura(float bonusArmadura) {
        this.bonusArmadura = bonusArmadura;
    }
    public float getVidaBase(){
        return personaje.getVida();
    }
    public boolean critico(int especial){
        return false;
    }
    public float armadura(int especial){
        return personaje.getArmadura()+this.bonusArmadura+especial;
    }
    public boolean esquiva(int especial){
        return false;
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
