/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion.Usuarios;

import MiPersonaje.MiPersonaje;
import Personaje.Personaje;
import ciclodeinstruccion.Juego;
import ciclodeinstruccion.Partida;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Registrado extends Usuario{
    
    private float horasJugadas;
    private int nivel;
    private int oro;
    private int experiencia;
    private int vitalidad;
    private int fuerza;
    private int especial;
    private int inteligencia;
    private final int EXPERIENCIA_NECESARIA=1000;
    private int puntosNivel;
    private ArrayList <MiPersonaje> misPersonajes;
    

    public Registrado(float horasJugadas, int nivel, int oro, int experiencia, int vitalidad, int fuerza, int especial, int inteligencia, int puntosNivel, String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
        this.horasJugadas = horasJugadas;
        this.nivel = nivel;
        this.oro = oro;
        this.experiencia = experiencia;
        this.vitalidad = vitalidad;
        this.fuerza = fuerza;
        this.especial = especial;
        this.inteligencia = inteligencia;
        this.puntosNivel = puntosNivel;
        this.misPersonajes = new ArrayList();
       
    }
    public Registrado(String nombre){
        super(nombre);
    }

    public void modificarVitalidad(){
        
        this.vitalidad++;
        this.gastarPuntosExp();
    }
    
    
    public void modificarFuerza(){
        
        this.fuerza++;
        this.gastarPuntosExp();
    }
    
    public void modificarEspecial(){
        
        this.especial++;
        this.gastarPuntosExp();
    }
    
    public void modificarInteligencia(){
        
        this.inteligencia++;
        this.gastarPuntosExp();
    }
    
    public void añadirPersonajes(MiPersonaje p){
        misPersonajes.add(p);
    }
    
    public void gastarPuntosExp(){
        puntosNivel--;
    }
    
    public void gastarPuntosOro(int oroGastado){
        
        if(this.oro>oroGastado){
            oro-=oroGastado;
        } else {
            System.out.println("no hay suficiente oro");
        }
    }
    
    public void aumentarExperiencia(int sumaExperiencia){
        
        experiencia+=sumaExperiencia;
        if (experiencia>=EXPERIENCIA_NECESARIA*nivel){
            experiencia = experiencia - EXPERIENCIA_NECESARIA * nivel;
            this.subirNivel();
        }
        
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
        
        oro+=orosumado;
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
    public float getHorasJugadas() {
        return horasJugadas;
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

    public void setHorasJugadas(float horasJugadas) {
        this.horasJugadas = horasJugadas;
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
