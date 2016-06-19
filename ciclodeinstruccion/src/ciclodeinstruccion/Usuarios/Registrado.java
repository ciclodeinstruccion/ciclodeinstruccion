/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion.Usuarios;

import MiPersonaje.MiAsesino;
import MiPersonaje.MiFighter;
import MiPersonaje.MiPersonaje;
import MiPersonaje.MiTanque;
import Personaje.Personaje;
import ciclodeinstruccion.Juego;
import ciclodeinstruccion.Partida;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import BaseDeDatos.ConsultasBD;
import Personaje.Tanque;

/**
 *
 * @author alumno
 */
public class Registrado extends Usuario{
    

    private int nivel;
    private int oro;
    private int experiencia;
    private int vitalidad;
    private int fuerza;
    private int especial;
    private int inteligencia;
    private final int EXPERIENCIA_NECESARIA=1000;
    private static final int ORO_DIARIO=50;
    private int puntosNivel;
    private ArrayList <MiPersonaje> misPersonajes;
    private int partidasJugadas;
    private Date ultimaEntrada;
    private final static int LIMITE_PARTIDAS=10;
    

    public Registrado(int partidasJugadas, int nivel, int oro, int experiencia, int vitalidad, int fuerza, int especial, int inteligencia, int puntosNivel, String nombre, String correo, String contraseña,Date ultimaEntrada) {
        super(nombre, correo, contraseña);

        this.nivel = nivel;
        this.oro = oro;
        this.experiencia = experiencia;
        this.vitalidad = vitalidad;
        this.fuerza = fuerza;
        this.especial = especial;
        this.inteligencia = inteligencia;
        this.puntosNivel = puntosNivel;
        this.misPersonajes = new ArrayList();
        this.ultimaEntrada=ultimaEntrada;
        this.partidasJugadas=partidasJugadas;
             
    }
    public void login(){
        Date hoy=new Date();
        if(this.ultimaEntrada.getDay()!=hoy.getDay()){
            this.partidasJugadas=0;
            this.aumentarOro(ORO_DIARIO);
            this.ultimaEntrada=hoy;
        }
    }
    
    public Registrado(String nombre){
        super(nombre);
    }

    public void modificarVitalidad(){
        
        this.vitalidad++;
        this.gastarPuntosExp();
    }
    
    public void disminuirVidalidad(){
        this.vitalidad--;
        this.puntosNivel++;
    }
    
    public void modificarFuerza(){
        
        this.fuerza++;
        this.gastarPuntosExp();
    }
    
    public void disminuirFuerza(){
        this.fuerza--;
        this.puntosNivel++;
    }
    
    public void modificarEspecial(){
        
        this.especial++;
        this.gastarPuntosExp();
    }
    
    public void disminuirEspecial(){
        this.especial--;
        this.puntosNivel++;
    }
    
    public void modificarInteligencia(){
        
        this.inteligencia++;
        this.gastarPuntosExp();
    }
    
    public void disminuirInteligencia(){
        this.inteligencia--;
        this.puntosNivel++;
    }
    
    public void añadirPersonajes(MiPersonaje p){
        misPersonajes.add(p);
    }
    
    public void gastarPuntosExp(){
        puntosNivel--;
    }
    
    
    public void gastarPuntosOro(int oroGastado){
        oro-=oroGastado;    
    }
    
    public void aumentarExperiencia(int sumaExperiencia){
        
        experiencia+=sumaExperiencia;
        if (experiencia>=EXPERIENCIA_NECESARIA*nivel){
            experiencia = experiencia - EXPERIENCIA_NECESARIA * nivel;
            this.subirNivel();
        }
        
    }
    
    public int buscarMiPersonaje(String nombre){
        misPersonajes.sort(null);
        int inicio=0;
        int fin=misPersonajes.size()-1;
        int medio;
        int posicion=-1;
        
        while (inicio<=fin){
            Tanque t=new Tanque(nombre);
            MiTanque mt =new MiTanque(0, 0, 0, 0, 0, t, 0);
            medio=(inicio+fin)/2;
            if ((misPersonajes.get(medio).compareTo(mt))<0){
                inicio=medio+1;
            }
            else if((misPersonajes.get(medio).compareTo(mt))>0){
                fin=medio-1;
            }
            else{
                posicion=medio;
                inicio=fin+1;
            }
        }
        return posicion;
    }
    public void mostrarPersonajes(){
        
        String [][] tablaDeMisPersonajes = new String [misPersonajes.size()][3];
        for (int i = 0; i < misPersonajes.size(); i++  )  {
            MiPersonaje mp =(MiPersonaje) misPersonajes.get(i);
            tablaDeMisPersonajes[i][0] = mp.getNombre();
            tablaDeMisPersonajes[i][1] = Float.toString(mp.getDañoBase()+mp.getBonusDaño()+this.fuerza);
            tablaDeMisPersonajes[i][2] = Float.toString(mp.getVidaBase()+mp.getBonusVida()+this.vitalidad);
            System.out.println(i+1);
            System.out.println(tablaDeMisPersonajes[i][0]);
            System.out.println(tablaDeMisPersonajes[i][1]);
            System.out.println(tablaDeMisPersonajes[i][2]);
        }      
        
         
    }
    
    public String[][] tablaMisPersonajes(){
        String arrayPersonajes[][]=new String [misPersonajes.size()][8];
        for(int i=0;i<arrayPersonajes.length;i++){
            arrayPersonajes[i][0]=misPersonajes.get(i).getNombre();
            arrayPersonajes[i][1]=misPersonajes.get(i).getTipo();
            arrayPersonajes[i][2]=Float.toString(misPersonajes.get(i).getVidaBase()+misPersonajes.get(i).getBonusVida());
            arrayPersonajes[i][3]=Float.toString(misPersonajes.get(i).getDañoBase()+misPersonajes.get(i).getBonusDaño());
            if (misPersonajes.get(i) instanceof MiTanque){
                MiTanque t=(MiTanque) misPersonajes.get(i);
                arrayPersonajes[i][4]=Float.toString(t.getPersonaje().getArmadura()+t.getBonusArmadura());
            }
            else if (misPersonajes.get(i) instanceof MiAsesino){
                MiAsesino a=(MiAsesino) misPersonajes.get(i);
                arrayPersonajes[i][4]=Float.toString(a.getPersonaje().getEsquivar()+a.getBonusEsquivar());
            }
            else if (misPersonajes.get(i) instanceof MiFighter){
                MiFighter f=(MiFighter) misPersonajes.get(i);
                arrayPersonajes[i][4]=Float.toString(f.getPersonaje().getCritico()+f.getBonusCritico());
            }
            arrayPersonajes[i][5]=Integer.toString(misPersonajes.get(i).getNivel());
            arrayPersonajes[i][6]=Integer.toString(misPersonajes.get(i).getExperiencia());
            arrayPersonajes[i][7]=Integer.toString(misPersonajes.get(i).getPuntosNivel());
        }
        return arrayPersonajes;
    }
    
    public String [][] tablaUnirseAPartida(){
        ArrayList <Partida> jugables=new ArrayList();
        jugables=ConsultasBD.instancia().buscarPartidasUnirte(this);
        String arrayPartidas[][]=new String [jugables.size()][4];
        for(int i=0;i<arrayPartidas.length;i++){
            arrayPartidas[i][0]=Integer.toString(jugables.get(i).getIdentificador());
            arrayPartidas[i][1]=jugables.get(i).getJugador1().getNombre();
            arrayPartidas[i][2]=jugables.get(i).getPersonaje1().getNombre();
            arrayPartidas[i][3]=Integer.toString(jugables.get(i).getJugador1().getNivel()+jugables.get(i).getPersonaje1().getNivel());
        }
        return arrayPartidas;
    }
    
    public String [][] tablaHistorialPartidas(){
        ArrayList <Partida> historial=new ArrayList();
        historial=ConsultasBD.instancia().buscarPartidasAcabadas(this);
        String arrayPartidas[][]=new String [historial.size()][7];
        for(int i=0;i<arrayPartidas.length;i++){
            arrayPartidas[i][0]=Integer.toString(historial.get(i).getIdentificador());
            arrayPartidas[i][1]=historial.get(i).getJugador1().getNombre();
            arrayPartidas[i][2]=historial.get(i).getPersonaje1().getNombre();
            arrayPartidas[i][3]=historial.get(i).getJugador2().getNombre();
            arrayPartidas[i][4]=historial.get(i).getPersonaje2().getNombre();
            arrayPartidas[i][5]=historial.get(i).getGanador().getNombre();
            arrayPartidas[i][6]=historial.get(i).getpGanador().getNombre();
        }
        return arrayPartidas;
    }
    
    public String [][] tablaPersonajesComprables(){
        ArrayList <Personaje> comprables=new ArrayList();
        comprables=ConsultasBD.instancia().buscarPersonajesComprables(this);
        String arrayComprables[][]=new String [comprables.size()][3];
        for(int i=0;i<arrayComprables.length;i++){
            arrayComprables[i][0]=comprables.get(i).getTipo();
            arrayComprables[i][1]=comprables.get(i).getNombre();
            arrayComprables[i][2]=Integer.toString(comprables.get(i).getPrecio());
        }
        return arrayComprables;
    }
    
    public MiPersonaje elegirPersonaje(){
        Scanner teclado =new Scanner(System.in);
        MiPersonaje elegido;
        this.mostrarPersonajes();
        int opcion;
        System.out.println("Seleccione numero del personaje");
        opcion=teclado.nextInt();
        teclado.nextLine();
        elegido=misPersonajes.get(opcion-1);
        return elegido;
    }
    
    public void aumentarOro(int orosumado){
        
        this.oro=this.oro+orosumado;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("oro "+oro);
        System.out.println("experiencia "+this.experiencia);
        System.out.println("puntos de subir "+this.puntosNivel);
    }
    
    public void subirNivel(){
        nivel++;
        puntosNivel++;
    }
    
    public Partida crearPartida(Juego j){
        
        Scanner teclado = new Scanner(System.in);
        
        Partida p;
        
        System.out.println("elige un personaje");
        
        p = new Partida ((j.getPartidas().size()+1),this, this.elegirPersonaje());
        j.añadirPartida(p);
        return p; 
        
    }
    public void unirsePartida(Juego j){
        j.buscarPartida(this);
    }
    public void modificarUsuarioNombre(){
        
        Scanner teclado = new Scanner (System.in);
        
        System.out.println("nombre nuevo");
        String nombreNuevo=teclado.nextLine();

        this.setNombre(nombreNuevo);  
    }
    
    public void modificarUsuarioContraseña(){
        
        Scanner teclado = new Scanner (System.in);
        
        System.out.println("contraseña nuevo");
        String contraseñaNueva=teclado.nextLine();
        this.setContraseña(contraseñaNueva);
    }
    
    public void modificarUsuarioCorreo(){
        
        Scanner teclado = new Scanner (System.in);
        
        System.out.println("correo nuevo");
        String correoNuevo=teclado.nextLine();
        this.setCorreo(correoNuevo);

    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public static int getLIMITE_PARTIDAS() {
        return LIMITE_PARTIDAS;
    }
    

    public int getNivel() {
        return nivel;
    }

    public int getOro() {
        return oro;
    }

    public ArrayList<MiPersonaje> getMisPersonajes() {
        return misPersonajes;
    }
    
    public int getExperiencia() {
        return experiencia;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getEspecial() {
        return especial;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getPuntosNivel() {
        return puntosNivel;
    }

    public Date getUltimaEntrada() {
        return ultimaEntrada;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setEspecial(int especial) {
        this.especial = especial;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
    
    public void menu(Juego juego){
        
        Scanner teclado = new Scanner (System.in);
        
        int opcion;
        
        do{
            System.out.println("MENÚ Regis");
            System.out.println("-------------------------");
            System.out.println("1.-Ver tus personajes");
            System.out.println("2.-ver tus cosas");
            System.out.println("3.-gestionar tus puntos para los personajes");
            System.out.println("4.-gestionar tu configuracion de usuario");
            System.out.println("5.-crear partida");
            System.out.println("6.-unirse a una partida");
            System.out.println("7.-comprar personaje");
            System.out.println("8.-ver historial de partidas");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    
                    this.mostrarPersonajes();
                    
                    break;
                    
                case 2:
                    
                    this.mostrarDatos();
                    
                    break;
                    
                case 3:
                    
                    this.menuAtributosPersonajes(juego);
                    
                    break;
                    
                case 4:
                    
                    this.menuAtributosUsuario(juego);
                    
                    break;
                    
                case 5:
                    
                    this.crearPartida(juego);
                    
                    break;
                    
                case 6:
                    
                    juego.buscarPartida(this);
                    
                    break;
                    
                case 7:
                    
                    juego.comprarPersonaje(this);
                    
                    break;
                    
                case 8:
                    
                    juego.historialPartidas(this);
                    
                    break;
                    
                default:
                    System.out.println("ERORR: opciones del 1 al 8");
                    break;
            }
        }while(opcion<9);
    }
    
    public void menuAtributosPersonajes(Juego juego){
        
        Scanner teclado = new Scanner (System.in);
        
        int opcion;
        
        do{
            System.out.println("MENÚ Atributos para los personajes");
            System.out.println("-------------------------");
            System.out.println("1.-puntos que tines que nes para usar");
            System.out.println("2.-aumentar la vitalidad un punto");
            System.out.println("3.-aumentar la fuerza un punto");
            System.out.println("4.-aumentar la inteligencia un punto");
            System.out.println("4.-aumentar el especial un punto");
            System.out.println("5.-mostrar los atributos totales");
            System.out.println("6.-volver atras");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    
                    System.out.println(this.puntosNivel);
                    
                    break;
                    
                case 2:
                    
                    this.modificarVitalidad();
                    
                    break;
                    
                case 3:
                    
                    this.modificarFuerza();
                    
                    break;
                    
                case 4:
                    
                    this.modificarInteligencia();
                    
                    break;
                    
                case 5:
                    
                    this.modificarEspecial();
                    
                    break;
                    
                case 6: 
                    
                    this.menu(juego);
                    
                default:
                    System.out.println("error opciones del 1 al 6");
                    break;
            }
        }while(opcion<7);
    }
    
    public void menuAtributosUsuario(Juego juego){
        
        Scanner teclado = new Scanner (System.in);
        
        int opcion;
        
        do{
            System.out.println("MENÚ configuracion de la cuenta");
            System.out.println("-------------------------");
            System.out.println("1.-cambiar tu nombre");
            System.out.println("2.-cambiar la contraseña");
            System.out.println("3.-cambiar el correo");
            System.out.println("4.-volver atras");
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            teclado.hasNextLine();
           
            switch(opcion){
                case 1:
                    
                    this.modificarUsuarioNombre();
                    
                    break;
                    
                case 2:
                    
                    this.modificarUsuarioContraseña();
                    
                    break;
                    
                case 3:
                    
                    this.modificarUsuarioCorreo();
                    
                    break;
                    
                case 4:
                    
                    this.menu(juego);
                    
                    break;
                    
                default:
                    
                    System.out.println("error opciones del 1 al 4");
                    
                    break;
            }
        }while(opcion<5);
    }
    
    
    
    
}
