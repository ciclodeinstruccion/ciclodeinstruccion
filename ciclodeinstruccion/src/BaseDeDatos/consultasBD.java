/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import Excepciones.ErrorBorrarAdministrador;
import Excepciones.ErrorCrearAdministrador;
import Excepciones.ErrorCrearPersonaje;
import Personaje.Asesino;
import Personaje.Fighter;
import Personaje.Personaje;
import Personaje.Tanque;
import ciclodeinstruccion.Usuarios.Administrador;
import java.sql.SQLException;
import Excepciones.ErrorAñadirRegistrado;
import Excepciones.ErrorEliminarRegistrado;
import Excepciones.ErrorModificarPersonaje;
import MiPersonaje.MiAsesino;
import MiPersonaje.MiFighter;
import MiPersonaje.MiPersonaje;
import MiPersonaje.MiTanque;
import ciclodeinstruccion.Habilidad;
import ciclodeinstruccion.Juego;
import ciclodeinstruccion.Partida;
import ciclodeinstruccion.Usuarios.Registrado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
            if (rs.next()) {
                r = new Registrado(Integer.parseInt(rs.getString(13)),Integer.parseInt(rs.getString(5)),Integer.parseInt(rs.getString(12)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(7)),Integer.parseInt(rs.getString(8)),Integer.parseInt(rs.getString(11)),Integer.parseInt(rs.getString(9)),Integer.parseInt(rs.getString(10)),rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4));
                
   
                ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from miPersonaje where nombreDeUsuario='"+ (r.getNombre())+"'");
                
                while (rsi.next()) {
                    //Personaje p=juego.getPersonajes().get(juego.buscarPersonaje(rsi.getString(2)));
                    Personaje p=this.buscarPersonaje(rsi.getString(2));
                    if (p instanceof Tanque){
                        Tanque t=(Tanque) p;
                        r.añadirPersonajes(new MiTanque(Integer.parseInt(rsi.getString(3)),Integer.parseInt(rsi.getString(4)),Integer.parseInt(rsi.getString(6)),Integer.parseInt(rsi.getString(7)),Integer.parseInt(rsi.getString(8)),t,Integer.parseInt(rsi.getString(5))));
                    }
                    else if (p instanceof Asesino){
                        Asesino a=(Asesino) p;
                        r.añadirPersonajes(new MiAsesino(Integer.parseInt(rsi.getString(3)),Integer.parseInt(rsi.getString(4)),Integer.parseInt(rsi.getString(6)),Integer.parseInt(rsi.getString(7)),Integer.parseInt(rsi.getString(8)),a,Integer.parseInt(rsi.getString(5))));
                    }
                    else{
                        Fighter f=(Fighter) p;
                        r.añadirPersonajes(new MiFighter(Integer.parseInt(rsi.getString(3)),Integer.parseInt(rsi.getString(4)),Integer.parseInt(rsi.getString(6)),Integer.parseInt(rsi.getString(7)),Integer.parseInt(rsi.getString(8)),f,Integer.parseInt(rsi.getString(5))));
                    }
                }
            }           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public void añadirAdministradores(Administrador a) throws ErrorCrearAdministrador{
      
        
      try{
          ConexionBD.instancia().getStatement().execute(
          "INSERT INTO Administradores VALUES ('"+a.getNombre()+"','"+a.getCorreo()+"','"+a.getContraseña()+"')");
      } catch (SQLException e) {
          throw new ErrorCrearAdministrador();
      }  
    }

    public void añadirPersonajes(Personaje p) throws ErrorCrearPersonaje{
        
        float especial=0;
        
        if(p instanceof Tanque){
            Tanque t=(Tanque) p;
            especial=t.getArmadura();
        } else if(p instanceof Asesino){
            Asesino a=(Asesino) p;
            especial=a.getEsquivar();
        } else if(p instanceof Fighter){
            Fighter f=(Fighter) p;
            especial=f.getCritico();
        }
        
        
        try{
            ConexionBD.instancia().getStatement().execute(
            "INSERT INTO Personajes VALUES ('"+p.getNombre()+"',"+p.getVida()+","+p.getDaño()+","+p.getPrecio()+",'"+p.getTipo()+"',"+especial+")");
        }
        catch (SQLException e){
            throw new ErrorCrearPersonaje();
        }
    }

    public void borrarAdministrador(String nombre) throws ErrorBorrarAdministrador{
        
        try{
            ConexionBD.instancia().getStatement().execute(
            "DELETE FROM ADMINISTRADORES WHERE nombre='"+nombre+"'"
            );
        } catch(SQLException e){
            throw new ErrorBorrarAdministrador();
        } 
    }
    public Administrador buscarAministrador(String nombre){
        Administrador admin=null;
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM Administradores WHERE nombre='"+nombre+"')");
                
            if(rs.next()){
                admin=new Administrador(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        }    
        catch (SQLException e){
              
        }
        return admin;
    }
    public Personaje buscarPersonaje (String nombre){
        Personaje p=null;
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from Personajes where nombre='" + (nombre)+"'"              
                );
                 
            if (rs.next()) {
                if(rs.getString(5).equals("Tanque")){
                    p=new Tanque(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(4)),rs.getString(5));
                }
                else if(rs.getString(5).equals("Asesino")){
                    p=new Asesino(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(4)),rs.getString(5));
                }
                else{
                    p=new Fighter(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(4)),rs.getString(5));
                }
            
                ArrayList <Habilidad> Habilidades;
                Habilidades=this.buscarHabilidades(p);
                for (Habilidad h:Habilidades){
                    p.añadirHabilidad(h);
                }
            }           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public void modificarPersonaje(Personaje p) throws ErrorModificarPersonaje{
        
        float especial = 0;
        
        if(p instanceof Tanque){
            Tanque t=(Tanque) p;
            especial=t.getArmadura();
        } else if(p instanceof Asesino){
            Asesino a=(Asesino) p;
            especial=a.getEsquivar();
        } else if(p instanceof Fighter){
            Fighter f=(Fighter) p;
            especial=f.getCritico();
        }
        
        try {
            ConexionBD.instancia().getStatement().execute(
            "UPDATE Personajes SET vida='"+p.getVida()+"','daño='"+p.getDaño()+"','precio='"+p.getPrecio()+"','especial='"+especial+"WHERE nombre='"+p.getNombre()+"')");
        } catch (SQLException e){
            throw new ErrorModificarPersonaje();
        }
    }
    
    public ArrayList<Habilidad> buscarHabilidades(Personaje p) throws SQLException{
        
        ArrayList <Habilidad> habilidades = new ArrayList();
        
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM Habilidades WHERE nombrePersonaje='"+p.getNombre()+"')");
                
            while(rs.next()){
                Habilidad h = new Habilidad(rs.getString(1),Integer.parseInt(rs.getNString(2)),Integer.parseInt(rs.getNString(3)),Integer.parseInt(rs.getNString(4)),rs.getNString(5));
                habilidades.add(h);
            }
        }    
        catch (SQLException e){
              
        }
        
        return habilidades;
        
    }
    
    public void añadirMiPersonaje(MiPersonaje mp, Registrado r){
        
        float bonusEspecial = 0;
        
        if(mp instanceof MiTanque){
            MiTanque t = (MiTanque) mp;
        } else if(mp instanceof MiAsesino){
           MiAsesino a = (MiAsesino) mp; 
        } else if(mp instanceof MiFighter){
           MiFighter f = (MiFighter) mp;
        }
    
        try{
            ConexionBD.instancia().getStatement().execute("INSERT INTO miPersonaje VALUES ('"+r.getNombre()+"','"+mp.getNombre()+"','"+Float.toString(mp.getBonusVida())+"','"+Float.toString(mp.getBonusDaño())+"','"+Float.toString(bonusEspecial)+"','"+Integer.toString(mp.getNivel())+"','"+Integer.toString(mp.getExperiencia())+"','"+Integer.toString(mp.getPuntosNivel())+"')");
        } catch (SQLException e){
            
        }    
    }
    
    public void añadirHabilidad(Personaje p){
        


        
        


        for(Habilidad h:p.getHabilidades()){

            try{
                ConexionBD.instancia().getStatement().execute("INSERT INTO Habilidades VALUES ('"+h.getNombre()+"','"+Integer.toString(h.getPorcentajeDeUso())+"','"+Float.toString(h.getDaño())+"','"+Float.toString(h.getCura())+"','"+h.getDescripcion()+"','"+p.getNombre()+"')");
            } catch (SQLException e){

            }    
        }

    }


    public MiPersonaje buscarMiPersonaje(String nombre){
        MiPersonaje mp1 = null;
        
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM MiPersonaje WHERE nombreDePersonaje='"+nombre+"')");
                
            while(rs.next()){
                if(this.buscarPersonaje(rs.getNString(2)).getTipo().equalsIgnoreCase("Tanque")){
                    mp1=new MiTanque(Float.parseFloat(rs.getString(3)),Float.parseFloat(rs.getString(4)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(7)),Integer.parseInt(rs.getString(8)),(Tanque)this.buscarPersonaje(rs.getString(2)),Float.parseFloat(rs.getString(5)));
                } else if(this.buscarPersonaje(rs.getNString(2)).getTipo().equalsIgnoreCase("Asesino")){
                    mp1=new MiAsesino(Float.parseFloat(rs.getString(3)),Float.parseFloat(rs.getString(4)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(7)),Integer.parseInt(rs.getString(8)),(Asesino)this.buscarPersonaje(rs.getString(2)),Float.parseFloat(rs.getString(5)));
                } else if(this.buscarPersonaje(rs.getNString(2)).getTipo().equalsIgnoreCase("Tanque")){
                    mp1=new MiFighter(Float.parseFloat(rs.getString(3)),Float.parseFloat(rs.getString(4)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(7)),Integer.parseInt(rs.getString(8)),(Fighter)this.buscarPersonaje(rs.getString(2)),Float.parseFloat(rs.getString(5)));
                }
            }
        }    
        catch (SQLException e){
              
        }
        
        return mp1;
    }
    
     public void añadirPArtida(Partida p){
        
        try{
            ConexionBD.instancia().getStatement().execute("INSERT INTO Partida (jugador1, personaje1, nPartidas1, finalizada) VALUES('"+p.getJugador1().getNombre()+"','"+p.getPersonaje1().getNombre()+"','"+Integer.toString(p.getJugador1().getPartidasJugadas())+"','"+Boolean.toString(p.isFinalizada())+"')");
        }catch(SQLException e){
            
        }
    }
    
    public void unirsePartida(Partida p){
        
        try{
            ConexionBD.instancia().getStatement().execute("UPDATE SET jugador2='"+p.getJugador2().getNombre()+"',personaje2='"+p.getPersonaje2().getNombre()+"',nPArtidas2='"+Integer.toString(p.getJugador2().getPartidasJugadas())+"',ganador='"+p.getGanador().getNombre()+"',personajeGanador='"+p.getpGanador().getNombre()+"',finalizada='"+p.isFinalizada()+"' WHERE identificador='"+Integer.toString(p.getIdentificador())+"')");
        } catch(SQLException e){
            
        }
            
    }
    
    public ArrayList<Partida> buscarPartidasNoAcabadas(Registrado r){
        
        ArrayList <Partida> partidas = new ArrayList();
        
        try{
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT identificador, jugador1, personaje1 FROM Partidas WHERE jugador1!='"+r.getNombre()+"' && finalizada=false");
        
            while(rs.next()){
                Partida p = new Partida(Integer.parseInt(rs.getString(1)),this.buscarRegistrado(rs.getString(2)),this.buscarMiPersonaje(rs.getString(4)));  
                partidas.add(p);
            }
        
        } catch (SQLException e){
            
        }
        
        return partidas;
        
    }
    
    public ArrayList<Partida> buscarPartidasAcabadas(Registrado r){
        
        ArrayList <Partida> partidas = new ArrayList();
        
        try{
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM Partidas WHERE jugador1='"+r.getNombre()+"', || jugador2='"+r.getNombre()+"' && finalizada= true");
            while(rs.next()){
                Partida p = new Partida(Integer.parseInt(rs.getString(1)),this.buscarRegistrado(rs.getString(2)),this.buscarRegistrado(rs.getString(3)),this.buscarMiPersonaje(rs.getString(4)),this.buscarMiPersonaje(rs.getString(5)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(7)),this.buscarRegistrado(rs.getString(8)),this.buscarMiPersonaje(rs.getString(9)));
                partidas.add(p);
            }
        } catch(SQLException e){
            
        }
        
        return partidas;
    }
    
    public boolean encuentraRegistrado(String nombre, String contraseña){
        boolean encuentra=false;

        try {
            
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM Registrados WHERE nombre='"+nombre+"' and contraseña='"+contraseña+"'");
   
            if(rs.next()){
                encuentra=true;

            }
        }    
        catch (SQLException e){
              
        }
        return encuentra;
    }
    
    public boolean encuentraAdministrador(String nombre, String contraseña){
        boolean encuentra=false;
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM Administradores WHERE nombre='"+nombre+"' and contraseña='"+contraseña+"'");
                
            if(rs.next()){
                encuentra=true;
                System.out.println("adm");
            }
        }    
        catch (SQLException e){
              
        }
        return encuentra;
    }
    
    public void cargarPersonaje(Juego j){
      
        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from Personajes"              
                );
                 
            while (rs.next()) {
                if(rs.getString(5).equals("Tanque")){
                    Tanque p=new Tanque(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(4)),rs.getString(5));
                    j.añadirPersonajes(p);
                }
                else if(rs.getString(5).equals("Asesino")){
                    Asesino p=new Asesino(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(4)),rs.getString(5));
                    j.añadirPersonajes(p);
                }
                else{
                    Fighter p=new Fighter(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(4)),rs.getString(5));
                    j.añadirPersonajes(p);
                }
            
            }
            for(Personaje p:j.getPersonajes()){
                ArrayList <Habilidad> Habilidades;
                Habilidades=this.buscarHabilidades(p);
                for (Habilidad h:Habilidades){
                    p.añadirHabilidad(h);
            
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean existeNombre(String nombre){
        boolean encontrado=false;
        try {
            
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM Registrados WHERE nombre='"+nombre+"'");
   
            if(rs.next()){
                encontrado=true;

            }
            else{
                ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM Administradores WHERE nombre='"+nombre+"'");
                if(rsi.next()){
                    encontrado=true;

                }
            }
        }    
        catch (SQLException e){
              
        }
        return encontrado;
    }
    public boolean existeCorreo(String correo){
        boolean encontrado=false;
        try {
            
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM Registrados WHERE correo='"+correo+"'");
   
            if(rs.next()){
                encontrado=true;

            }
            else{
                ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM Administradores WHERE correo='"+correo+"'");
                if(rsi.next()){
                    encontrado=true;

                }
            }
        }    
        catch (SQLException e){
              
        }
        return encontrado;

    }

}
