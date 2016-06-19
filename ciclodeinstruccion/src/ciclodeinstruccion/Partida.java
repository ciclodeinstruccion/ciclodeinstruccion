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
    private ArrayList <Float> vidaJ1;
    private ArrayList <Float> vidaJ2;
    private ArrayList <Boolean> criticoj1;
    private ArrayList <Boolean> criticoj2;
    private ArrayList <Boolean> esquivarj1;
    private ArrayList <Boolean> esquivarj2;
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
    private float vidamax1;
    private float vidamax2;
    

    public Partida(int identificador, Registrado jugador1, MiPersonaje personaje1) {
        this.identificador = identificador;
        this.jugador1 = jugador1;
        this.personaje1 = personaje1;
        this.finalizada=false;
        this.vidaJ1=new ArrayList();
        this.vidaJ2=new ArrayList();
        this.criticoj1=new ArrayList();
        this.criticoj2=new ArrayList();
        this.esquivarj1=new ArrayList();
        this.esquivarj2=new ArrayList();
        this.texto=new ArrayList();
        this.vidaPersonaje1=personaje1.getVidaBase()+personaje1.getBonusVida()+jugador1.getVitalidad();
        this.partidasJ1=this.jugador1.getPartidasJugadas()+1;
        this.vidamax1=this.vidaPersonaje1;
    }
    public Partida(int identificador, Registrado jugador1, MiPersonaje personaje1, int partidasJ1) {
        this.identificador = identificador;
        this.jugador1 = jugador1;
        this.personaje1 = personaje1;
        this.finalizada=false;
        this.texto=new ArrayList();
        this.vidaJ1=new ArrayList();
        this.vidaJ2=new ArrayList();
        this.criticoj1=new ArrayList();
        this.criticoj2=new ArrayList();
        this.esquivarj1=new ArrayList();
        this.esquivarj2=new ArrayList();
        this.vidaPersonaje1=personaje1.getVidaBase()+personaje1.getBonusVida()+jugador1.getVitalidad();
        this.partidasJ1=partidasJ1;
        this.vidamax1=this.vidaPersonaje1;
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
        this.vidaPersonaje1=personaje1.getVidaBase()+personaje1.getBonusVida()+jugador1.getVitalidad();
        this.vidaPersonaje2=personaje2.getVidaBase()+personaje2.getBonusVida()+jugador2.getVitalidad();
        this.vidamax2=this.vidaPersonaje2;
        this.vidamax1=this.vidaPersonaje1;
    }
    
    /**
     * metodo que se usa cuando un registrado crea una partida
     */
    
    
    public void comprarPartida(){
        this.jugador1.setPartidasJugadas(partidasJ1);
        this.jugador1.gastarPuntosOro(COSTE_PARTIDA);
    }
    
    /**
     * metodo para cuando un registrado quiere unirse a una partida ya creada
     * @param jugador2 jugador que se une a la partida  
     * @param personaje2 su personaje
     */
    public void unirsePartida(Registrado jugador2, MiPersonaje personaje2){
        this.jugador2=jugador2;
        this.personaje2=personaje2;
        this.vidaPersonaje2=personaje2.getVidaBase()+personaje2.getBonusVida()+jugador2.getVitalidad();
        this.jugador2.gastarPuntosOro(COSTE_PARTIDA);
        this.jugador2.setPartidasJugadas(this.jugador2.getPartidasJugadas()+1);
        this.partidasJ2=this.jugador2.getPartidasJugadas();
        this.vidamax2=this.vidaPersonaje2;
    }
    
    /**
     * metodo con el que se juega la partida
     */
    public void jugarPartida(){
        float dañoPersonaje1=personaje1.getDañoBase()+personaje1.getBonusDaño()+jugador1.getFuerza();
        float dañoPersonaje2=personaje2.getDañoBase()+personaje2.getBonusDaño()+jugador2.getFuerza();
        
        float vidaMax1=vidaPersonaje1;
        float vidaMax2=vidaPersonaje2;
        boolean bandera=true;
        texto.add(personaje1.getNombre()+" ("+jugador1.getNombre()+") con "+vidaPersonaje1+" puntos de vida y "+dañoPersonaje1+" puntos de daño contra ");
        vidaJ1.add(vidaPersonaje1);
        vidaJ2.add(vidaPersonaje2);
        criticoj1.add(false);
        criticoj2.add(false);
        esquivarj1.add(false);
        esquivarj2.add(false);
        texto.add(personaje2.getNombre()+" ("+jugador2.getNombre()+") con "+vidaPersonaje2+" puntos de vida y "+dañoPersonaje2+" puntos de daño.");
        vidaJ1.add(vidaPersonaje1);
        vidaJ2.add(vidaPersonaje2);
        criticoj1.add(false);
        criticoj2.add(false);
        esquivarj1.add(false);
        esquivarj2.add(false);
        texto.add("¡Que comience la batalla!.");
        vidaJ1.add(vidaPersonaje1);
        vidaJ2.add(vidaPersonaje2);
        criticoj1.add(false);
        criticoj2.add(false);
        esquivarj1.add(false);
        esquivarj2.add(false);
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
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
        }
        else{
                this.finalizarPartida(jugador1, personaje1);
                texto.add(jugador1.getNombre()+" es el ganador y gana "+EXP+" puntos de experiencia y "+this.oroGanado()+" de oro");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
        }
        finalizada=true;
        this.ver();
    }
    public void mostrarDatos(){
        
    }
    public void hDaño(boolean esquivar, float armadura, boolean critico, Habilidad h, Registrado JAtaca, Registrado JDefiende, MiPersonaje PAtaca, MiPersonaje PDefiende, float dañoPAtaca){
        if(esquivar){
                    texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y "+PDefiende.getNombre()+"("+JDefiende.getNombre()+")"+" la esquivo y no recibio daño.");
                    vidaJ1.add(vidaPersonaje1);
                    vidaJ2.add(vidaPersonaje2);
                    criticoj1.add(false);
                    criticoj2.add(false);
                    if(JAtaca==jugador1){
                        esquivarj1.add(false);
                        esquivarj2.add(true);
                    }
                    else{
                        esquivarj2.add(false);
                        esquivarj1.add(true);
                    }
            } 
        else{
            if(critico){
                float daño=2*(dañoPAtaca+h.getDaño());
                if(JAtaca==jugador1){   
                    vidaPersonaje2-=this.dañoRecibido(daño, armadura);
                    criticoj1.add(true);
                    criticoj2.add(false);
                }
                else{
                    vidaPersonaje1-=this.dañoRecibido(daño, armadura);
                    criticoj1.add(false);
                    criticoj2.add(true);
                }
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" e hizo critico y realizo "+this.dañoRecibido(daño, armadura)+" de daño.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                esquivarj1.add(false);
                esquivarj2.add(false);
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
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
        }
        if(JAtaca==jugador1){
            texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" tiene "+vidaPersonaje2+" puntos de vida.");
            vidaJ1.add(vidaPersonaje1);
            vidaJ2.add(vidaPersonaje2);
            criticoj1.add(false);
            criticoj2.add(false);
            esquivarj1.add(false);
            esquivarj2.add(false);
        }
        else{
            texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1+" puntos de vida.");
            vidaJ1.add(vidaPersonaje1);
            vidaJ2.add(vidaPersonaje2);
            criticoj1.add(false);
            criticoj2.add(false);
            esquivarj1.add(false);
            esquivarj2.add(false);
        }
    }
    
    public void hCura(Habilidad h, Registrado JAtaca, MiPersonaje PAtaca, float vidaMax){
        if(JAtaca==jugador1){
            if(vidaPersonaje1+h.getCura()<=vidaMax){
                vidaPersonaje1+=h.getCura();
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y se curo "+h.getCura()+" puntos de vida.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
            else{
                float vidaCurada=vidaMax-vidaPersonaje1;
                vidaPersonaje1=vidaMax;
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y se curo "+vidaCurada+" puntos de vida.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
            texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1+" puntos de vida.");
            vidaJ1.add(vidaPersonaje1);
            vidaJ2.add(vidaPersonaje2);
            criticoj1.add(false);
            criticoj2.add(false);
            esquivarj1.add(false);
            esquivarj2.add(false);
        }
        else{
            if(vidaPersonaje2+h.getCura()<=vidaMax){
                vidaPersonaje2+=h.getCura();
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y se curo "+h.getCura()+" puntos de vida.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
            else{
                float vidaCurada=vidaMax-vidaPersonaje2;
                vidaPersonaje2=vidaMax;
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y se curo "+vidaCurada+" puntos de vida.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
            texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" tiene "+vidaPersonaje2+" puntos de vida.");
            vidaJ1.add(vidaPersonaje1);
            vidaJ2.add(vidaPersonaje2);
            criticoj1.add(false);
            criticoj2.add(false);
            esquivarj1.add(false);
            esquivarj2.add(false);
        }
    }
    
    public void hMixta(boolean esquivar, float armadura, boolean critico, Habilidad h, Registrado JAtaca, Registrado JDefiende, MiPersonaje PAtaca, MiPersonaje PDefiende, float dañoPAtaca, float vidaMax){
        if(esquivar){
                    texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" y "+PDefiende.getNombre()+"("+JDefiende.getNombre()+")"+" la esquivo y no recibio daño.");
                    vidaJ1.add(vidaPersonaje1);
                    vidaJ2.add(vidaPersonaje2);
                    criticoj1.add(false);
                    criticoj2.add(false);
                    if(JAtaca==jugador1){
                        esquivarj1.add(false);
                        esquivarj2.add(true);
                    }
                    else{
                        esquivarj1.add(true);
                        esquivarj2.add(false);
                    }
                } 
        else{
            if(critico){
                float daño=2*(dañoPAtaca+h.getDaño());
                if(JAtaca==jugador1){   
                    vidaPersonaje2-=this.dañoRecibido(daño, armadura);
                    criticoj1.add(true);
                    criticoj2.add(false);
                }
                else{
                    vidaPersonaje1-=this.dañoRecibido(daño, armadura);
                    criticoj1.add(false);
                    criticoj2.add(true);
                }
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" uso "+h.getNombre()+" e hizo critico y realizo "+this.dañoRecibido(daño, armadura)+" de daño.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                esquivarj1.add(false);
                esquivarj2.add(false);
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
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
        }
        if(JAtaca==jugador1){
            if(vidaPersonaje1+h.getCura()<=vidaMax){
                vidaPersonaje1+=h.getCura();
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" al utilizar "+h.getNombre()+" tambien se curo "+h.getCura()+" puntos de vida.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
            else{
                float vidaCurada=vidaMax-vidaPersonaje1;
                vidaPersonaje1=vidaMax;
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" al utilizar "+h.getNombre()+" también se curo "+vidaCurada+" puntos de vida.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
            texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" tiene "+vidaPersonaje2+" puntos de vida.");
            vidaJ1.add(vidaPersonaje1);
            vidaJ2.add(vidaPersonaje2);
            criticoj1.add(false);
            criticoj2.add(false);
            esquivarj1.add(false);
            esquivarj2.add(false);
            texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1+" puntos de vida.");
            vidaJ1.add(vidaPersonaje1);
            vidaJ2.add(vidaPersonaje2);
            criticoj1.add(false);
            criticoj2.add(false);
            esquivarj1.add(false);
            esquivarj2.add(false);
        }
        else{
            if(vidaPersonaje2+h.getCura()<=vidaMax){
                vidaPersonaje2+=h.getCura();
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" al utilizar "+h.getNombre()+" tambien se curo "+h.getCura()+" puntos de vida.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
            else{
                float vidaCurada=vidaMax-vidaPersonaje2;
                vidaPersonaje2=vidaMax;
                texto.add(PAtaca.getNombre()+"("+JAtaca.getNombre()+")"+" al utilizar "+h.getNombre()+" también se curo "+vidaCurada+" puntos de vida.");
                vidaJ1.add(vidaPersonaje1);
                vidaJ2.add(vidaPersonaje2);
                criticoj1.add(false);
                criticoj2.add(false);
                esquivarj1.add(false);
                esquivarj2.add(false);
            }
            texto.add(personaje1.getNombre()+"("+jugador1.getNombre()+")"+" tiene "+vidaPersonaje1+" puntos de vida.");
            vidaJ1.add(vidaPersonaje1);
            vidaJ2.add(vidaPersonaje2);
            criticoj1.add(false);
            criticoj2.add(false);
            esquivarj1.add(false);
            esquivarj2.add(false);
            texto.add(personaje2.getNombre()+"("+jugador2.getNombre()+")"+" tiene "+vidaPersonaje2+" puntos de vida.");
            vidaJ1.add(vidaPersonaje1);
            vidaJ2.add(vidaPersonaje2);
            criticoj1.add(false);
            criticoj2.add(false);
            esquivarj1.add(false);
            esquivarj2.add(false);
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
        if(ganador.getNombre().equals(this.jugador1.getNombre())){
            this.jugador1.aumentarExperiencia(EXP);
            this.jugador1.aumentarOro(this.oroGanado());
            this.jugador1.getMisPersonajes().get(this.jugador1.buscarMiPersonaje(this.personaje1.getNombre())).aumentarExperiencia(EXP);
            this.personaje1.aumentarExperiencia(EXP);
            this.ganador=this.jugador1;
            this.pGanador=this.personaje1;
        }
        else {
            this.jugador2.aumentarExperiencia(EXP);
            this.jugador2.aumentarOro(this.oroGanado());
            this.jugador2.getMisPersonajes().get(this.jugador2.buscarMiPersonaje(this.personaje2.getNombre())).aumentarExperiencia(EXP);
            this.personaje2.aumentarExperiencia(EXP);
            this.ganador=this.jugador2;
            this.pGanador=this.personaje2;
        }
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
            if(this.partidasJ2<=LIMITE/2){
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

    public ArrayList<Float> getVidaJ1() {
        return vidaJ1;
    }

    public ArrayList<Float> getVidaJ2() {
        return vidaJ2;
    }

    public float getVidamax1() {
        return vidamax1;
    }

    public float getVidamax2() {
        return vidamax2;
    }

    public ArrayList<Boolean> getCriticoj1() {
        return criticoj1;
    }

    public ArrayList<Boolean> getCriticoj2() {
        return criticoj2;
    }

    public ArrayList<Boolean> getEsquivarj1() {
        return esquivarj1;
    }

    public ArrayList<Boolean> getEsquivarj2() {
        return esquivarj2;
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

    public void setCriticoj1(ArrayList<Boolean> criticoj1) {
        this.criticoj1 = criticoj1;
    }

    public void setCriticoj2(ArrayList<Boolean> criticoj2) {
        this.criticoj2 = criticoj2;
    }

    public void setEsquivarj1(ArrayList<Boolean> esquivarj1) {
        this.esquivarj1 = esquivarj1;
    }

    public void setEsquivarj2(ArrayList<Boolean> esquivarj2) {
        this.esquivarj2 = esquivarj2;
    }

    public void setVidaJ1(ArrayList<Float> vidaJ1) {
        this.vidaJ1 = vidaJ1;
    }

    public void setVidaJ2(ArrayList<Float> vidaJ2) {
        this.vidaJ2 = vidaJ2;
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
