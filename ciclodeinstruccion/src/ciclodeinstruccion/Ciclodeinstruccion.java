/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

import ciclodeinstruccion.Usuarios.Registrado;
import ciclodeinstruccion.Usuarios.Usuario;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Ciclodeinstruccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
        
        ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
        ArrayList <Personaje> personajes = new ArrayList <Personaje>();
        
        Registrado a = new Registrado (1,1,1,900,1,1,1,1,1, "a", "a", "a");
        Registrado b = new Registrado (1,2,1,1900,1,1,1,1,1, "b", "b", "b");
        
        Asesino p = new Asesino ("sonic", 50 ,30 ,50 , 50);
        Fighter f = new Fighter ("lucario", 100, 15, 10, 50);
    
        Habilidad h = new Habilidad ("hiper", 50, 10, 0);
        Habilidad h1 = new Habilidad ("sombra", 30, 5, 0);
        Habilidad h2 = new Habilidad ("excalibur", 20, 50, 0);
        
        p.añadirHabilidad(h);
        p.añadirHabilidad(h1);
        p.añadirHabilidad(h2);
        
        Habilidad g = new Habilidad ("patadavoladora", 50, 20, 0);
        Habilidad g1 = new Habilidad ("puñetazoBionico", 30, 20, 0);
        Habilidad g2 = new Habilidad ("roboEspecial", 20, 30, 0);
        
        f.añadirHabilidad(g);
        f.añadirHabilidad(g1);
        f.añadirHabilidad(g2);
        
        MiAsesino ma = new MiAsesino(1,1,1,1,1, p, 1);
        MiFighter mf = new MiFighter(2,2,2,2,2, f, 2);
        
        a.añadirPersonajes(ma);
        b.añadirPersonajes(mf);
        
        Partida partida = new Partida (a, ma);
        partida.unirsePartida(b, mf);
        
        a.mostrar();
        b.mostrar();
        
        p.mostrarHabilidad();
        f.mostrarHabilidad();
        
        
        partida.jugarPartida();
        partida.ver();
        
        a.mostrar();
        b.mostrar();
        
    }
    
}
