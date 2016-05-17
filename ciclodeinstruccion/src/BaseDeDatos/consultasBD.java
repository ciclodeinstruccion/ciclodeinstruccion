/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import Excepciones.ErrorAñadirRegistrado;
import Excepciones.ErrorEliminarRegistrado;
import ciclodeinstruccion.Usuarios.Registrado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
    
    public void añadirRegistrado(Registrado r) throws ErrorAñadirRegistrado{
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        try {
            ConexionBD.instancia().getStatement().execute(
                "insert into Registrados values ('" +
                r.getNombre() + "', '" + r.getCorreo()+ "', '" +r.getContraseña()+ "', '" + sdf.format(r.getUltimaEntrada())+ "', " +
                Integer.toString(r.getNivel())+","+Integer.toString(r.getExperiencia())+","+Integer.toString(r.getVitalidad())+","+Integer.toString(r.getFuerza())+","+
                Integer.toString(r.getInteligencia())+","+ Integer.toString(r.getPuntosNivel())+","+Integer.toString(r.getEspecial())+","+Integer.toString(r.getOro())+","+
                Integer.toString(r.getPartidasJugadas())+")"               
                );
            
        } catch (SQLException e) {
            throw new ErrorAñadirRegistrado();
        }
    }
    public void eliminarRegistrado(Registrado r) throws ErrorEliminarRegistrado{
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from Resgistrados where nombre='" + 
                    r.getNombre()+"'"
                            );
            ConexionBD.instancia().getStatement().execute(
                    "delete from miPersonaje where nombreDeUsuario='" + 
                    r.getNombre()+"'"
                            );
            
        } catch (SQLException e) {
            throw new ErrorEliminarRegistrado();
        }
    }
    public Registrado buscarRegistrado(String nombre){
        Registrado r=null;
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from Registrados where nombre='" + (nombre)+"'"              
                );
                 
            /*if (rs.next()) {
                r = new Registrado(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),Integer.parseInt(rs.getString(5)));
                
                
                ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from herramientas where razonSocial='"+ (razon)+"'");
            
                while (rsi.next()) {
                    f.añadirHerramienta(new Herramienta(rsi.getString(2),rsi.getString(3),rsi.getString(4),rsi.getInt(5),rsi.getInt(6),rsi.getInt(7)));
                }
            } */           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}