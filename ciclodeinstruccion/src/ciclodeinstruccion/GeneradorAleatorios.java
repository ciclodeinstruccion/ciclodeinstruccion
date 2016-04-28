/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclodeinstruccion;

import java.util.Random;

/**
 *
 * @author alumno
 */
public class GeneradorAleatorios {
    public static int generarAleatorio(int tope){
        Random aleatorio= new Random();
        return aleatorio.nextInt(tope);
    }
}
