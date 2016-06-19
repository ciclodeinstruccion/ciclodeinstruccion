/**
 * Clase heredera de personaje
 */
package Personaje;

public class Asesino extends Personaje{
    private float esquivar;

    public Asesino(String nombre, float vida, float daño ,float esquivar, int precio, String tipo) {
        super(nombre, vida, daño, precio, tipo);
        this.esquivar=esquivar;
    }

    public float getEsquivar() {
        return esquivar;
    }

    public void setEsquivar(float esquivar) {
        this.esquivar = esquivar;
    }
    
    
}
