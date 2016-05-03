/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

import ciclodeinstruccion.Usuarios.Registrado;

/**
 *
 * @author alumno
 */
public class Partida {
    private Registrado jugador1;
    private Registrado jugador2;
    private MiPersonaje personaje1;
    private MiPersonaje personaje2;
    private Registrado ganador;
    private boolean finalizada;

    public Partida(Registrado jugador1, MiPersonaje personaje1) {
        this.jugador1 = jugador1;
        this.personaje1 = personaje1;
        this.finalizada=false;
    }
    
    public void unirsePartida(Registrado jugador2, MiPersonaje personaje2){
        this.jugador2=jugador2;
        this.personaje2=personaje2;
    }
    public void jugarPartida(){
        float vidaPersonaje1=personaje1.getVidaBase()+personaje1.getBonusVida()+jugador1.getVitalidad();
        float vidaPersonaje2=personaje2.getVidaBase()+personaje2.getBonusVida()+jugador2.getVitalidad();
        float dañoPersonaje1=personaje1.getDañoBase()+personaje1.getBonusDaño()+jugador1.getFuerza();
        float dañoPersonaje2=personaje2.getDañoBase()+personaje2.getBonusDaño()+jugador2.getFuerza();
        boolean bandera=true;
        
        while(vidaPersonaje1>0||vidaPersonaje2>0){
            if(bandera){
                boolean esquivar2;
                float armadura2;
                boolean critico1;
                vidaPersonaje2-=dañoPersonaje1+personaje1.elegirHabilidad(jugador1.getInteligencia()).getDaño();
            }
        }
    }
    public void mostrarDatos(){
        
    }
    
    
    
}
