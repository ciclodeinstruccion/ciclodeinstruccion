/**
 * Clase heredera de personaje
 */
package Personaje;

public class Fighter extends Personaje {

    private float Critico;
    

    public Fighter(String nombre, float vida, float daño,float Critico, int precio, String tipo) {
        super(nombre, vida, daño, precio, tipo);
        this.Critico = Critico;
    }

    public float getCritico() {
        return Critico;
    }

    public void setCritico(float Critico) {
        this.Critico = Critico;
    }
    
    
    
    
    
    
    
    
}
