
package ciclodeinstruccion;

public class Habilidad implements Comparable<Habilidad>{
    
    private String nombre;
    private int porcentajeDeUso;
    private float daño;
    private float cura;
    private String descripcion;

    public Habilidad(String nombre, int porcentajeDeUso, float daño, float cura, String descripcion) {
        this.nombre = nombre;
        this.porcentajeDeUso = porcentajeDeUso;
        this.daño = daño;
        this.cura = cura;
        this.descripcion=descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPorcentajeDeUso() {
        return porcentajeDeUso;
    }

    public float getDaño() {
        return daño;
    }

    public float getCura() {
        return cura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPorcentajeDeUso(int porcentajeDeUso) {
        this.porcentajeDeUso = porcentajeDeUso;
    }

    public void setDaño(float daño) {
        this.daño = daño;
    }

    public void setCura(float cura) {
        this.cura = cura;
    }

    @Override
    public int compareTo(Habilidad h) {
        int diferencia;
        return diferencia=h.porcentajeDeUso-this.porcentajeDeUso;
        
    }
    
    
    
}
