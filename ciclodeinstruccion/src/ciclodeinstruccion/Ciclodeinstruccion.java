/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

import MiPersonaje.MiAsesino;
import Personaje.Asesino;
import ciclodeinstruccion.Usuarios.Administrador;
import ciclodeinstruccion.Usuarios.Registrado;
import ciclodeinstruccion.Usuarios.Usuario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ciclodeinstruccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Juego juego=new Juego();
        Date funo=new Date(2000, 8, 8);
        Date fdos=new Date(2000, 8, 8);
        Date ftres=new Date(2000, 8, 8);


        Registrado uno = new Registrado(0, 1, 200, 0, 0, 0, 0, 0, 0, "a", "aa", "a",funo);
        Registrado dos = new Registrado(0, 1, 200, 0, 0, 0, 0, 0, 0, "b", "aa", "a",fdos);
        Registrado tres = new Registrado(0, 1, 200, 0, 0, 0, 0, 0, 0, "c", "aa", "aaaa",ftres);
        
        Administrador admin2 = new Administrador("admin", "admin", "admin");
        
        
        
        
        Asesino asesino1 = new Asesino("sonic", 50, 30, 50, 100);
        Asesino asesino2 = new Asesino("chuck Norris", 90, 10, 30, 120);
        Asesino asesino3 = new Asesino("golum", 70, 40, 30, 80);
        
        
        
        MiAsesino miAsesino1 = new MiAsesino(0, 0, 1, 0, 0, asesino1, 0);
        MiAsesino miAsesino2 = new MiAsesino(0, 0, 1, 0, 0, asesino2, 0);
        MiAsesino miAsesino3 = new MiAsesino(0, 0, 1, 0, 0, asesino3, 0);
        
        Habilidad sonic1 = new Habilidad("hipervelocidad", 50, 10, 0,"a");
        Habilidad sonic2 = new Habilidad("sombre", 30, 5, 30,"a");
        Habilidad sonic3 = new Habilidad("excalibur", 20, 50, 0,"a");
        
        asesino1.añadirHabilidad(sonic1);
        asesino1.añadirHabilidad(sonic2);
        asesino1.añadirHabilidad(sonic3);
        
        Habilidad chuck1 = new Habilidad("Ranger", 50, 50, 0,"a");
        Habilidad chuck2 = new Habilidad("Patada giratoria", 45, 60, 0,"a");
        Habilidad chuck3 = new Habilidad("La muerte no llama", 5, 1000, 0,"a");
        
        asesino2.añadirHabilidad(chuck1);
        asesino2.añadirHabilidad(chuck2);
        asesino2.añadirHabilidad(chuck3);
        juego.añadirPersonajes(asesino1);
        juego.añadirPersonajes(asesino2);
        uno.añadirPersonajes(miAsesino1);
        dos.añadirPersonajes(miAsesino2);
        
        Juego game = new Juego();
        
        juego.añadirRegistrado(uno);
        juego.añadirRegistrado(dos);
        juego.añadirRegistrado(tres);
        juego.añadirAdministrador(admin2);
        Partida partida = new Partida(1, uno, miAsesino1);
        /*partida.unirsePartida(dos, miAsesino2);
        
        
        juego.añadirPartida(partida);
        
        Partida partida1 = new Partida(2, uno, miAsesino1);
        //partida1.mostrarPartidasNoFinalizadas();
        
        juego.añadirPartida(partida1);
        
        /*game.añadirRegistrado(uno);
        game.buscarPartida((Registrado) game.iniciarSesion());
        partida.ver();
        
        
        Registrado registrado=null;
        Administrador admin=null;
        boolean bandera=true;
        int opcion=0;
        Scanner teclado=new Scanner(System.in);
        while(bandera){
            System.out.println("1.-Iniciar sesion.");
            System.out.println("2.-Registrarse.");
            System.out.println("3.-Salir.");
            System.out.println("Seleccione opcion: ");
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                case 1:
                    Usuario usuario=juego.iniciarSesion();
                    if(usuario instanceof Registrado){
                        registrado =(Registrado) usuario;
                        registrado.menu(juego);
                    }
                    else if(usuario instanceof Administrador){
                        admin=(Administrador) usuario;
                        admin.menuGrande(juego);
                    }
                break;
                case 2:
                    Registrado reg=juego.registrarse();
                    if(reg!=null){
                        registrado=reg;
                        registrado.menu(juego);
                    }
                break;
                case 3:
                    bandera=false;
                break;
            }
        }*/
        
    }
    
}
