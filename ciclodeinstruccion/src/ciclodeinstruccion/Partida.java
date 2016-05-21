/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

import MiPersonaje.MiPersonaje;
import Personaje.Personaje;
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
    private MiPersonaje pGanador;
    private boolean finalizada;
    private ArrayList <String> texto;
    private final int EXP=100;//
    private final int ORO=200;
    private final int ORO_MEDIO=150;
    private float vidaPersonaje1;
    private float vidaPersonaje2;
    private int identificador;
    private static final int COSTE_PARTIDA=100;
    private int partidasJ1;
    private int partidasJ2;
    private final int LIMITE=10;
    

    public Partida(int identificador, Registrado jugador1, MiPersonaje personaje1) {
        this.identificador = identificador;
        this.jugador1 = jugador1;
        this.personaje1 = personaje1;
        this.finalizada=false;
        this.texto=new ArrayList();
        this.vidaPersonaje1=personaje1.getVidaBase()+personaje1.getBonusVida()+jugador1.getVitalidad();
        this.partidasJ1=this.jugador1.getPartidasJugadas();
        this.jugador1.gastarPuntosOro(COSTE_PARTIDA);
        this.jugador1.setPartidasJugadas(partidasJ1+1);
    }

    public Partida(int identificador, Registrado jugador1, Registrado jugador2, MiPersonaje personaje1, MiPersonaje personaje2, int partidasJ1, int partidasJ2, Registrado ganador, MiPersonaje pGanador) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.personaje1 = personaje1;
        this.personaje2 = personaje2;
        this.ganador = ganador;
        this.pGanador = pGanador;
        this.finalizada=true;
        this.identificador = identificador;
        this.partidasJ1 = partidasJ1;
        this.partidasJ2 = partidasJ2;
    }
    
    public void unirsePartida(Registrado jugador2, MiPersonaje personaje2){
        this.jugador2=jugador2;
        this.personaje2=personaje2;
        this.vidaPersonaje2=personaje2.getVidaBase()+personaje2.getBonusVida()+jugador2.getVitalidad();
        this.jugador2.gastarPuntosOro(COSTE_PARTIDA);
        this.partidasJ2=this.jugador2.getPartidasJugadas();
        this.jugador2.setPartidasJugadas(partidasJ2+1);
    }
    public void jugarPartida(){
        float dañoPersonaje1=personaje1.getDañoBase()+personaje1.getBonusDaño()+jugador1.getFuerza();
        float dañoPersonaje2=personaje2.getDañoBase()+personaje2.getBonusDaño()+jugador2.getFuerza();
        
        float vidaMax1=vidaPersonaje1;
        float vidaMax2=vidaPersonaje2;
        boolean bandera=true;
        texto.add(personaje1.getNombre()+" ("+jugador1.getNombre()+") con "+vidaPersonaje1+" puntos de vida y "+dañoPersonaje1+" puntos de daño contra "+personaje2.getNombre()+" ("+jugador2.getNombre()+") con "+vidaPersonaje2+" puntos de vida y "+dañoPersonaje2+" puntos de daño.");
        texto.add("Que comience la batalla.");
        while(vidaPersonaje1>0&&vidaPersonaje2>0){
            if(bandera){
                boolean esquivar2=personaje2.esquiva(jugador2.getEspecial());
                float armadura2=personaje2.armadura(jugador2.getEspecial());
                boolean critico1=personaje1.critico(jugador1.getEspecial());
                Habilidad habilidad=personaje1.elegirHabilidad(jugador1.getInteligencia());
                if(habilidad.getDaño()>0&&habilidad.getCura()==0){
                    this.hDaño(esquivar2, armadura2, critico1, habilidad, jugador1, jugador2, personaje1, personaje2, dañoPersonaje1);
                }
                else if(habilidad.getDaño()==0&&habilidad.getCura()>0){
                    this.hCura(habilidad, jugador1, personaje1, vidaMax1);
                }
                else{
                    this.hMixta(esquivar2, armadura2, critico1, habilidad, jugador1, jugador2, personaje1, personaje2, dañoPersonaje1, vidaMax1);
                }
                if(vidaPersonaje2>0){
                bandera=false;
                }
            }
            else{
                boolean esquivar1=personaje1.esquiva(jugador1.getEspecial());
                float armadura1=personaje1.armadura(jugador1.getEspecial());
                boolean critico2=personaje2.critico(jugador2.getEspecial());
                Habilidad habilidad=personaje2.elegirHabilidad(jugador2.getInteligencia());
                if(habilidad.getDaño()>0&&habilidad.getCura()==0){
                    this.hDaño(esquivar1, armadura1, critico2, habilidad, jugador2, jugador1, personaje2, personaje1, dañoPersonaje2);
                }
                else if(habilidad.getDaño()==0&&habilidad.getCura()>0){
                    this.hCura(habilidad, jugador2, personaje2, vidaMax2);
                }
                else{
                    this.hMixta(esquivar1, armadura1, critico2, habilidad, jugador2, jugador1, personaje2, personaje1, dañoPersonaje2, vidaMax2);
                }
                //if(vidaPersonaje1>0){
                bandera=true;
                //}
            }
            
        }
        if(vidaPersonaje1<=0){
                this.finalizarPartida(jugador2, personaje2);
                texto.add(jugador2.getNombre()+" es el ganador y gana "+EXP+" puntos de experiencia y "+this.oroGanado()+" de oro");
        }
        else{
                this.finalizarPartida(jugador1, personaje1);
                texto.add(jugador1.getNombre()+" es el ganador y gana "+EXP+" puntos de experiencia y "+this.oroGanado()+" de oro");
        }
        finalizada=true;
        this.ver();
    }
    public void mostrarDatos(){
        
    }
    public void hDaño(boolean esquivar, float armadura, boolean critico, Habilidad h, Registrado JAtaca, Registrado JDefiende, MiPersonaje PAtaca, MiPersonaje PDefiende, float dañoPAtaca){
        if(esquivar){
                    texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y "+PDefiende.getNombre()+"("+JDefiende.getNombre()+")"+" la esquivo y no recibio daño.");
                } 
        else{
            if(critico){
                float daño=2*(dañoPAtaca+h.getDaño());
                if(JAtaca==jugador1){   
                    vidaPersonaje2-=this.dañoRecibido(daño, armadura);    
                }
                else{
                    vidaPersonaje1-=this.dañoRecibido(daño, armadura);
                }
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" e hizo critico y realizo "+this.dañoRecibido(daño, armadura)+" de daño.");
            }
            else{
                float daño=(dañoPAtaca+h.getDaño());
                if(JAtaca==jugador1){   
                    vidaPersonaje2-=this.dañoRecibido(daño, armadura);    
                }
                else{
                    vidaPersonaje1-=this.dañoRecibido(daño, armadura);
                }
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y realizo "+this.dañoRecibido(daño, armadura)+" de daño.");
            }
        }
        if(JAtaca==jugador1){
            texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" tiene "+vidaPersonaje2+" puntos de vida.");
        }
        else{
            texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1+" puntos de vida.");
        }
    }
    
    public void hCura(Habilidad h, Registrado JAtaca, MiPersonaje PAtaca, float vidaMax){
        if(JAtaca==jugador1){
            if(vidaPersonaje1+h.getCura()<=vidaMax){
                vidaPersonaje1+=h.getCura();
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y se curo "+h.getCura()+" puntos de vida.");
            }
            else{
                float vidaCurada=vidaMax-vidaPersonaje1;
                vidaPersonaje1=vidaMax;
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y se curo "+vidaCurada+" puntos de vida.");
            }
            texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1+" puntos de vida.");
        }
        else{
            if(vidaPersonaje2+h.getCura()<=vidaMax){
                vidaPersonaje2+=h.getCura();
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y se curo "+h.getCura()+" puntos de vida.");
            }
            else{
                float vidaCurada=vidaMax-vidaPersonaje2;
                vidaPersonaje2=vidaMax;
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y se curo "+vidaCurada+" puntos de vida.");
            }
            texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" tiene "+vidaPersonaje2+" puntos de vida.");
        }
    }
    
    public void hMixta(boolean esquivar, float armadura, boolean critico, Habilidad h, Registrado JAtaca, Registrado JDefiende, MiPersonaje PAtaca, MiPersonaje PDefiende, float dañoPAtaca, float vidaMax){
        if(esquivar){
                    texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y "+PDefiende.getNombre()+"("+JDefiende.getNombre()+")"+" la esquivo y no recibio daño.");
                } 
        else{
            if(critico){
                float daño=2*(dañoPAtaca+h.getDaño());
                if(JAtaca==jugador1){   
                    vidaPersonaje2-=this.dañoRecibido(daño, armadura);    
                }
                else{
                    vidaPersonaje1-=this.dañoRecibido(daño, armadura);
                }
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" e hizo critico y realizo "+this.dañoRecibido(daño, armadura)+" de daño.");
            }
            else{
                float daño=(dañoPAtaca+h.getDaño());
                if(JAtaca==jugador1){   
                    vidaPersonaje2-=this.dañoRecibido(daño, armadura);    
                }
                else{
                    vidaPersonaje1-=this.dañoRecibido(daño, armadura);
                }
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y realizo "+this.dañoRecibido(daño, armadura)+" de daño.");
            }
        }
        if(JAtaca==jugador1){
            if(vidaPersonaje1+h.getCura()<=vidaMax){
                vidaPersonaje1+=h.getCura();
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" al utilizar "+h.getNombre()+" tambien se curo "+h.getCura()+" puntos de vida.");
            }
            else{
                float vidaCurada=vidaMax-vidaPersonaje1;
                vidaPersonaje1=vidaMax;
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" al utilizar "+h.getNombre()+" también se curo "+vidaCurada+" puntos de vida.");
            }
            texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" tiene "+vidaPersonaje2+" puntos de vida.");
            texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1+" puntos de vida.");
        }
        else{
            if(vidaPersonaje2+h.getCura()<=vidaMax){
                vidaPersonaje2+=h.getCura();
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" al utilizar "+h.getNombre()+" tambien se curo "+h.getCura()+" puntos de vida.");
            }
            else{
                float vidaCurada=vidaMax-vidaPersonaje2;
                vidaPersonaje2=vidaMax;
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" al utilizar "+h.getNombre()+" también se curo "+vidaCurada+" puntos de vida.");
            }
            texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1+" puntos de vida.");
            texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" tiene "+vidaPersonaje2+" puntos de vida.");
        }
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
        this.pGanador=personaje;
        ganador.aumentarExperiencia(EXP);
        ganador.aumentarOro(this.oroGanado());
        personaje.aumentarExperiencia(EXP);
    }
    public int oroGanado(){
        int oro=0;
        if(this.ganador.getNombre().equals(this.jugador1.getNombre())){
            if(this.partidasJ1<=LIMITE/2){
                oro=this.ORO;
            }
            else{
                oro=this.ORO_MEDIO;
            }
        }
        else{
            if(this.partidasJ1<=LIMITE/2){
                oro=this.ORO;
            }
            else{
                oro=this.ORO_MEDIO;
            }
        }
        return oro;
    }
    
    public void ver (){
        for (String s: texto){
            System.out.println(s);
        }
    }
    
    public void mostrarPartidasNoFinalizadas(){
        System.out.println("numero de partida: "+identificador);
        System.out.println("Jugador: "+jugador1.getNombre());
        System.out.println("Personaje: "+personaje1.getNombre());
    }
    
    public void mostrarPartidasFinalizadas(){
        System.out.println("numero de partida: "+identificador);
        System.out.println("Jugador: "+jugador1.getNombre()+"con personaje: "+personaje1.getNombre());
        System.out.println("jugador: "+jugador2.getNombre()+"con personaje: "+personaje2.getNombre());
        System.out.println("ganador: "+this.ganador.getNombre());
        
    }

    public int getIdentificador() {
        return identificador;
    }
 
    public Registrado getJugador1() {
        return jugador1;
    }

    public Registrado getJugador2() {
        return jugador2;
    }

    public MiPersonaje getPersonaje1() {
        return personaje1;
    }

    public MiPersonaje getPersonaje2() {
        return personaje2;
    }

    public static int getCOSTE_PARTIDA() {
        return COSTE_PARTIDA;
    }

    public Registrado getGanador() {
        return ganador;
    }

    public MiPersonaje getpGanador() {
        return pGanador;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public ArrayList<String> getTexto() {
        return texto;
    }
    
    
    public int getEXP() {
        return EXP;
    }

    public int getORO() {
        return ORO;
    }

    public float getVidaPersonaje1() {
        return vidaPersonaje1;
    }

    public float getVidaPersonaje2() {
        return vidaPersonaje2;
    }

    public void setJugador1(Registrado jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Registrado jugador2) {
        this.jugador2 = jugador2;
    }

    public void setPersonaje1(MiPersonaje personaje1) {
        this.personaje1 = personaje1;
    }

    public void setPersonaje2(MiPersonaje personaje2) {
        this.personaje2 = personaje2;
    }

    public void setGanador(Registrado ganador) {
        this.ganador = ganador;
    }

    public void setpGanador(MiPersonaje pGanador) {
        this.pGanador = pGanador;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public void setTexto(ArrayList<String> texto) {
        this.texto = texto;
    }

    public void setVidaPersonaje1(float vidaPersonaje1) {
        this.vidaPersonaje1 = vidaPersonaje1;
    }

    public void setVidaPersonaje2(float vidaPersonaje2) {
        this.vidaPersonaje2 = vidaPersonaje2;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setPartidasJ1(int partidasJ1) {
        this.partidasJ1 = partidasJ1;
    }

    public void setPartidasJ2(int partidasJ2) {
        this.partidasJ2 = partidasJ2;
    }
    
    
}
