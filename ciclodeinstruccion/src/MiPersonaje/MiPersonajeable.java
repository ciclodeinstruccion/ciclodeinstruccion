/**
 * Interfaz que implementa mipersonaje y que incluye los método necesario para poder 
 * aplicar polimorfismo en los métodos de jugar las partidas
 */
package MiPersonaje;

import ciclodeinstruccion.Habilidad;

public interface MiPersonajeable {
    public boolean critico(int especial);
    
    public float getVidaBase();
    
    public float getDañoBase();
    
    public boolean esquiva(int especial);
    
    public float armadura(int especial);
    
    public Habilidad elegirHabilidad(int inteligencia);
    
    public String getNombre();
    
    public String getTipo();
}
