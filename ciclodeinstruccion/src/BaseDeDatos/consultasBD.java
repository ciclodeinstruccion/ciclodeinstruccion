/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

/**
 *
 * @author alumno
 */
public class consultasBD {
    static consultasBD instancia = null;
    
    public consultasBD(){
        
    }
    
    public static consultasBD instancia() {
        if (instancia == null) {
            instancia = new consultasBD();
        }
        
        return instancia;
    }
    

}
