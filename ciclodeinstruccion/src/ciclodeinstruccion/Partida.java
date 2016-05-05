/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

import ciclodeinstruccion.Usuarios.Registrado;
import java.util.ArrayList;

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
    private ArrayList <String> texto;
    private final int EXP=100;
    private final int ORO=100;

    public Partida(Registrado jugador1, MiPersonaje personaje1) {
        this.jugador1 = jugador1;
        this.personaje1 = personaje1;
        this.finalizada=false;
        this.texto=new ArrayList();
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
                boolean esquivar2=personaje2.esquiva(jugador2.getEspecial());
                float armadura2=personaje2.armadura(jugador2.getEspecial());
                boolean critico1=personaje1.critico(jugador1.getEspecial());
                Habilidad habilidad=personaje1.elegirHabilidad(jugador1.getInteligencia());
                if(esquivar2){
                    texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" uso "+habilidad.getNombre()+" y "+personaje2.getNombre()+"("+jugador2.getNombre()+")"+" la esquivo y no recibio daño.");
                } else{
                    if(critico1){
                        vidaPersonaje2-=this.dañoRecibido(2*dañoPersonaje1, armadura2);
                        texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" uso "+habilidad.getNombre()+" e hizo critico y realizo "+this.dañoRecibido(2*dañoPersonaje1, armadura2)+".");
                    }
                    else{
                        vidaPersonaje2-=this.dañoRecibido(dañoPersonaje1, armadura2);
                        texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" uso "+habilidad.getNombre()+" y realizo "+this.dañoRecibido(2*dañoPersonaje1, armadura2)+".");
                    }
                }
                texto.add(personaje2.getNombre()+" tiene "+vidaPersonaje2);
                bandera=false;
            }
            else{
                boolean esquivar1=personaje1.esquiva(jugador1.getEspecial());
                float armadura1=personaje1.armadura(jugador1.getEspecial());
                boolean critico2=personaje2.critico(jugador2.getEspecial());
                Habilidad habilidad=personaje2.elegirHabilidad(jugador2.getInteligencia());
                if(esquivar1){
                    texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" uso "+habilidad.getNombre()+" y "+personaje1.getNombre()+"("+jugador1.getNombre()+")"+" la esquivo y no recibio daño.");
                } else{
                    if(critico2){
                        vidaPersonaje1-=this.dañoRecibido(2*dañoPersonaje2, armadura1);
                        texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" uso "+habilidad.getNombre()+" e hizo critico y realizo "+this.dañoRecibido(2*dañoPersonaje2, armadura1)+".");
                    }
                    else{
                        vidaPersonaje1-=this.dañoRecibido(dañoPersonaje2, armadura1);
                        texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" uso "+habilidad.getNombre()+" y realizo "+this.dañoRecibido(2*dañoPersonaje2, armadura1)+".");
                    }
                }
                texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1);
                bandera=true;
            }
            
        }
        if(vidaPersonaje1<=0){
                this.finalizarPartida(jugador2, personaje2);
                texto.add(jugador2.getNombre()+" es el ganador y gana "+EXP+" puntos de experiencia y "+ORO+" de oro");
        }
        else{
                this.finalizarPartida(jugador1, personaje1);
                texto.add(jugador1.getNombre()+" es el ganador y gana "+EXP+" puntos de experiencia y "+ORO+" de oro");
        }
    }
    public void mostrarDatos(){
        
    }
    
    public float dañoRecibido(float daño, float armadura){
        float dañoRecibido;
        if(armadura>daño){
            dañoRecibido=0;
        } 
        else{
            dañoRecibido=daño-armadura;
        }
        return dañoRecibido;
    }
    
    public void finalizarPartida(Registrado ganador, MiPersonaje personaje){
        this.ganador=ganador;
        ganador.aumentarExperiencia(EXP);
        ganador.aumentarOro(ORO);
        personaje.aumentarExperiencia(EXP);
    }
}
