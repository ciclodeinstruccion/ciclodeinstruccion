/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import BaseDeDatos.*;
import Excepciones.ErrorConexionBD;
import InterfazGrafica.registrado.VerPartida;
import MiPersonaje.MiAsesino;
import MiPersonaje.MiFighter;
import MiPersonaje.MiTanque;
import Personaje.Asesino;
import Personaje.Fighter;
import Personaje.Personaje;
import Personaje.Tanque;
import ciclodeinstruccion.GeneradorAleatorios;
import ciclodeinstruccion.Partida;
import ciclodeinstruccion.Usuarios.Registrado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Rubén
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */

    public Inicio() {
        this.setUndecorated(true);
        initComponents();  
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sesion = new javax.swing.JButton();
        registrarse = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        probarJuego = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        sesion.setVisible(false);
        sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/iniciar_sesion.png"))); // NOI18N
        sesion.setBorder(null);
        sesion.setBorderPainted(false);
        sesion.setContentAreaFilled(false);
        sesion.setFocusPainted(false);
        sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sesionhover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sesionnormal(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iniciosesioncambio(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                iniciosesion(evt);
            }
        });
        sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sesionActionPerformed(evt);
            }
        });
        getContentPane().add(sesion);
        sesion.setBounds(520, 200, 260, 65);
        Timer timer = new Timer(0, taskPerformer);
        timer.setInitialDelay(5000);
        timer.setRepeats(false);
        timer.start();

        registrarse.setVisible(false);
        registrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/registrarse2.png"))); // NOI18N
        registrarse.setBorder(null);
        registrarse.setBorderPainted(false);
        registrarse.setContentAreaFilled(false);
        registrarse.setFocusPainted(false);
        registrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registrarsepressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                registrarse(evt);
            }
        });
        getContentPane().add(registrarse);
        registrarse.setBounds(520, 300, 260, 65);

        salir.setVisible(false);
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/salir.png"))); // NOI18N
        salir.setMaximumSize(new java.awt.Dimension(260, 65));
        salir.setMinimumSize(new java.awt.Dimension(260, 65));
        salir.setPreferredSize(new java.awt.Dimension(260, 65));
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                salirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                salirMouseReleased(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(520, 410, 260, 65);

        probarJuego.setVisible(false);
        probarJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/probar_juego.png"))); // NOI18N
        probarJuego.setBorderPainted(false);
        probarJuego.setContentAreaFilled(false);
        probarJuego.setFocusPainted(false);
        probarJuego.setMaximumSize(new java.awt.Dimension(260, 65));
        probarJuego.setMinimumSize(new java.awt.Dimension(260, 65));
        probarJuego.setPreferredSize(new java.awt.Dimension(260, 65));
        probarJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                probarJuegoMouseReleased(evt);
            }
        });
        getContentPane().add(probarJuego);
        probarJuego.setBounds(520, 100, 260, 65);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gif2.gif"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sesionActionPerformed

    private void iniciosesion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciosesion
        try {
            ConexionBD.crearConexion();
        } catch (ErrorConexionBD ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        IniciarSesion is=new IniciarSesion(this, true,this);
        is.setVisible(true);
    }//GEN-LAST:event_iniciosesion

    private void registrarse(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarse
        try {
            ConexionBD.crearConexion();
        } catch (ErrorConexionBD ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        Registrarse r=new Registrarse(this, true,this);
        r.setVisible(true);
    }//GEN-LAST:event_registrarse

    private void iniciosesioncambio(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciosesioncambio
        sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/iniciar_sesion.png")));
    }//GEN-LAST:event_iniciosesioncambio

    private void sesionhover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesionhover
        sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/iniciar_sesion.png")));
    }//GEN-LAST:event_sesionhover

    private void sesionnormal(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesionnormal
        sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/iniciar_sesion.png")));
    }//GEN-LAST:event_sesionnormal

    private void registrarsepressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarsepressed
        registrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/registrarse2.png")));
    }//GEN-LAST:event_registrarsepressed

    private void registrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseMouseEntered
        registrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/registrarse2.png")));
    }//GEN-LAST:event_registrarseMouseEntered

    private void registrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseMouseExited
        registrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/registrarse2.png")));
    }//GEN-LAST:event_registrarseMouseExited

    private void salirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseReleased
        System.exit(0);
    }//GEN-LAST:event_salirMouseReleased

    private void salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMousePressed
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/salir.png")));
    }//GEN-LAST:event_salirMousePressed

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/salir.png")));
    }//GEN-LAST:event_salirMouseExited

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/salir.png")));
    }//GEN-LAST:event_salirMouseEntered

    private void probarJuegoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_probarJuegoMouseReleased
        try {
            ConexionBD.crearConexion();
        } catch (ErrorConexionBD ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        Registrado r1= new Registrado(0, 1, 500, 0, 0, 0, 0, 0, 0, "Jero", "jero", "aaa", new Date());
        Registrado r2= new Registrado(0, 1, 500, 0, 0, 0, 0, 0, 0, "Jose Luis", "Jose Luis", "aaa", new Date());
        ArrayList <Personaje> personajes=consultasBD.instancia().todosLosPersonajes();
        Personaje p1=personajes.get(GeneradorAleatorios.generarAleatorio(9));
        Personaje p2=personajes.get(GeneradorAleatorios.generarAleatorio(9));
        Partida partida=null;
        if(p1 instanceof Tanque){
            Tanque t=(Tanque) p1;
            MiTanque mp=new MiTanque(0, 0, 1, 0, 0, t, 0);
            r1.añadirPersonajes(mp);
            partida=new Partida(1, r1, mp);
        }
        else if(p1 instanceof Asesino){
            Asesino a=(Asesino) p1;
            MiAsesino mp=new MiAsesino(0, 0, 1, 0, 0, a, 0);
            r1.añadirPersonajes(mp);
            partida=new Partida(1, r1, mp);
        }
        else if(p1 instanceof Fighter){
            Fighter f=(Fighter) p1;
            MiFighter mp=new MiFighter(0, 0, 1, 0, 0, f, 0);
            r1.añadirPersonajes(mp);
            partida=new Partida(1, r1, mp);
        }
        if(p2 instanceof Tanque){
            Tanque t=(Tanque) p2;
            MiTanque mp2=new MiTanque(0, 0, 1, 0, 0, t, 0);
            r2.añadirPersonajes(mp2);
            partida.unirsePartida(r2, mp2);
        }
        else if(p2 instanceof Asesino){
            Asesino a=(Asesino) p2;
            MiAsesino mp2=new MiAsesino(0, 0, 1, 0, 0, a, 0);
            r2.añadirPersonajes(mp2);
            partida.unirsePartida(r2, mp2);
        }
        else if(p2 instanceof Fighter){
            Fighter f=(Fighter) p2;
            MiFighter mp2=new MiFighter(0, 0, 1, 0, 0, f, 0);
            r2.añadirPersonajes(mp2);
            partida.unirsePartida(r2, mp2);
        }
        partida.jugarPartida();
        VerPartida vp=new VerPartida(this, true, partida, false, null, true, this,false,null);
        vp.mostrar();
        vp.setVisible(true);
    }//GEN-LAST:event_probarJuegoMouseReleased
    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            sesion.setVisible(true);
            registrarse.setVisible(true);
            salir.setVisible(true);
            probarJuego.setVisible(true);
            fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_normal.jpg")));
        }
    };
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton probarJuego;
    private javax.swing.JButton registrarse;
    private javax.swing.JButton salir;
    private javax.swing.JButton sesion;
    // End of variables declaration//GEN-END:variables
}
