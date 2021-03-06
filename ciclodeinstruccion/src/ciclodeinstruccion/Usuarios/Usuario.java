/**
 * Clase base de la que heredan registrado y administrador
 */
package ciclodeinstruccion.Usuarios;


public class Usuario implements Comparable <Usuario>{
    
    private String nombre;
    private String correo;
    private String contraseña;

    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    public Usuario(String nombre){
        this.nombre=nombre;
    }
    public void mostrarDatos(){
        System.out.println(nombre);
        System.out.println(correo);
        System.out.println(contraseña);
    }
        
    
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.nombre.compareTo(o.nombre);
    }

}
