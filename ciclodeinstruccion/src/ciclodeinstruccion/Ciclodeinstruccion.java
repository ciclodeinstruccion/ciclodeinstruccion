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
import java.util.ArrayList;
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
        
        Registrado uno = new Registrado(0, 1, 200, 0, 0, 0, 0, 0, 0, "a", "aa", "a");
        Registrado dos = new Registrado(0, 1, 200, 0, 0, 0, 0, 0, 0, "b", "aa", "a");
        Registrado tres = new Registrado(0, 1, 200, 0, 0, 0, 0, 0, 0, "c", "aa", "aaaa");
        
        Administrador admin = new Administrador("admin", "admin", "admin");
        
        Asesino asesino1 = new Asesino("sonic", 50, 30, 50, 100);
        Asesino asesino2 = new Asesino("chuck Norris", 90, 10, 30, 120);
        Asesino asesino3 = new Asesino("golum", 70, 40, 30, 80);
        
        MiAsesino miAsesino1 = new MiAsesino(0, 0, 1, 0, 0, asesino1, 0);
        MiAsesino miAsesino2 = new MiAsesino(0, 0, 1, 0, 0, asesino2, 0);
        MiAsesino miAsesino3 = new MiAsesino(0, 0, 1, 0, 0, asesino3, 0);
        
        Habilidad sonic1 = new Habilidad("hipervelocidad", 50, 10, 0);
        Habilidad sonic2 = new Habilidad("sombre", 30, 5, 30);
        Habilidad sonic3 = new Habilidad("excalibur", 20, 50, 0);
        
        asesino1.añadirHabilidad(sonic1);
        asesino1.añadirHabilidad(sonic2);
        asesino1.añadirHabilidad(sonic3);
        
        Habilidad chuck1 = new Habilidad("Ranger", 50, 50, 0);
        Habilidad chuck2 = new Habilidad("Patada giratoria", 45, 60, 0);
        Habilidad chuck3 = new Habilidad("La muerte no llama", 5, 1000, 0);
        
        asesino2.añadirHabilidad(chuck1);
        asesino2.añadirHabilidad(chuck2);
        asesino2.añadirHabilidad(chuck3);
        
        uno.añadirPersonajes(miAsesino1);
        dos.añadirPersonajes(miAsesino2);
        
        Juego game = new Juego();
        
        game.añadirRegistrado(uno);
        game.añadirRegistrado(dos);
        game.añadirRegistrado(tres);
        
        Partida partida = new Partida(1, uno, miAsesino1);
        /*partida.unirsePartida(dos, miAsesino2);*/
        
        
        game.añadirPartida(partida);
        
        Partida partida1 = new Partida(2, uno, miAsesino1);
        //partida1.mostrarPartidasNoFinalizadas();
        
        game.añadirPartida(partida1);
        
        game.añadirRegistrado(uno);
        game.buscarPartida((Registrado) game.iniciarSesion());
        partida.ver();
        
        
    }
    
}
