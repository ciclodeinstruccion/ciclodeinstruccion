/**
 * Clase utilizada para generar numeros aleatorios
 */
package ciclodeinstruccion;

import java.util.Random;

public class GeneradorAleatorios {
    public static int generarAleatorio(int tope){
        Random aleatorio= new Random();
        return aleatorio.nextInt(tope);
    }
}
