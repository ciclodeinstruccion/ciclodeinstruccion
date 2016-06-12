/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica.registrado;

import ciclodeinstruccion.Usuarios.Registrado;
import org.jfree.data.category.DefaultCategoryDataset;
import BaseDeDatos.consultasBD;
import MiPersonaje.MiPersonaje;
import Personaje.Personaje;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import BaseDeDatos.*;
import ciclodeinstruccion.Partida;

/**
 *
 * @author Rubén
 */
public class Estadisticas extends javax.swing.JDialog {

    /**
     * Creates new form Estadisticas
     */
    Registrado registrado;
    DefaultTableModel tablaClasi;
    String [] cabecera={"Nombre","Nivel","Partidas ganadas"};
    String cabecera1 []={"Identificador","Jugador 1","Personaje 1","Jugador 2","Personaje 2","Jugador ganador","Personaje ganador"};
    DefaultTableModel tablaHistorial;
    InicioRegistrado ir;
    public Estadisticas(java.awt.Frame parent, boolean modal, Registrado r, InicioRegistrado ir) {
        super(parent, modal);
        initComponents();
        this.registrado=r;
        this.ir=ir;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volver = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHisto = new javax.swing.JTable();
        ver = new javax.swing.JButton();
        barritas = new javax.swing.JPanel();
        chuckNorris = new javax.swing.JButton();
        barrasPersonajes = new javax.swing.JPanel();
        donkeyKong = new javax.swing.JButton();
        gollum = new javax.swing.JButton();
        lucario = new javax.swing.JButton();
        luigi = new javax.swing.JButton();
        maBaracus = new javax.swing.JButton();
        mario = new javax.swing.JButton();
        samus = new javax.swing.JButton();
        sonic = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        tarta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/volver.png"))); // NOI18N
        volver.setBorder(null);
        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.setFocusPainted(false);
        volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                volverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                volverMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                volverMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                volverMouseReleased(evt);
            }
        });
        getContentPane().add(volver);
        volver.setBounds(460, 50, 260, 65);

        jPanel2.setLayout(null);

        tablaHisto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaHisto);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(90, 50, 454, 360);

        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/ver_partida.png"))); // NOI18N
        ver.setBorder(null);
        ver.setBorderPainted(false);
        ver.setContentAreaFilled(false);
        ver.setFocusPainted(false);
        ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                verMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ver(evt);
            }
        });
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        jPanel2.add(ver);
        ver.setBounds(650, 120, 260, 65);

        jTabbedPane1.addTab("Historial partidas", jPanel2);

        barritas.setLayout(null);

        chuckNorris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Chuck Norris.png"))); // NOI18N
        chuckNorris.setBorder(null);
        chuckNorris.setBorderPainted(false);
        chuckNorris.setContentAreaFilled(false);
        chuckNorris.setFocusPainted(false);
        chuckNorris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuckNorrisActionPerformed(evt);
            }
        });
        barritas.add(chuckNorris);
        chuckNorris.setBounds(30, 10, 100, 100);

        barrasPersonajes.setLayout(new java.awt.BorderLayout());
        barritas.add(barrasPersonajes);
        barrasPersonajes.setBounds(0, 120, 1140, 370);

        donkeyKong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Donkey Kong.png"))); // NOI18N
        donkeyKong.setBorder(null);
        donkeyKong.setBorderPainted(false);
        donkeyKong.setContentAreaFilled(false);
        donkeyKong.setFocusPainted(false);
        donkeyKong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donkeyKongActionPerformed(evt);
            }
        });
        barritas.add(donkeyKong);
        donkeyKong.setBounds(150, 10, 100, 100);

        gollum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Gollum.png"))); // NOI18N
        gollum.setBorderPainted(false);
        gollum.setContentAreaFilled(false);
        gollum.setFocusPainted(false);
        gollum.setMaximumSize(new java.awt.Dimension(100, 100));
        gollum.setMinimumSize(new java.awt.Dimension(100, 100));
        gollum.setPreferredSize(new java.awt.Dimension(100, 100));
        gollum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gollumActionPerformed(evt);
            }
        });
        barritas.add(gollum);
        gollum.setBounds(270, 10, 100, 100);

        lucario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Lucario.png"))); // NOI18N
        lucario.setBorder(null);
        lucario.setBorderPainted(false);
        lucario.setContentAreaFilled(false);
        lucario.setFocusPainted(false);
        lucario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lucarioActionPerformed(evt);
            }
        });
        barritas.add(lucario);
        lucario.setBounds(390, 10, 100, 100);

        luigi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Luigi.png"))); // NOI18N
        luigi.setBorder(null);
        luigi.setBorderPainted(false);
        luigi.setContentAreaFilled(false);
        luigi.setFocusPainted(false);
        luigi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luigiActionPerformed(evt);
            }
        });
        barritas.add(luigi);
        luigi.setBounds(510, 10, 100, 100);

        maBaracus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/M. A. Baracus.png"))); // NOI18N
        maBaracus.setBorder(null);
        maBaracus.setBorderPainted(false);
        maBaracus.setContentAreaFilled(false);
        maBaracus.setFocusPainted(false);
        maBaracus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maBaracusActionPerformed(evt);
            }
        });
        barritas.add(maBaracus);
        maBaracus.setBounds(630, 10, 100, 100);

        mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Mario.png"))); // NOI18N
        mario.setBorder(null);
        mario.setBorderPainted(false);
        mario.setContentAreaFilled(false);
        mario.setFocusPainted(false);
        mario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marioActionPerformed(evt);
            }
        });
        barritas.add(mario);
        mario.setBounds(750, 10, 100, 100);

        samus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Samus.png"))); // NOI18N
        samus.setBorder(null);
        samus.setBorderPainted(false);
        samus.setContentAreaFilled(false);
        samus.setFocusPainted(false);
        samus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samusActionPerformed(evt);
            }
        });
        barritas.add(samus);
        samus.setBounds(870, 10, 100, 100);

        sonic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Sonic.png"))); // NOI18N
        sonic.setBorder(null);
        sonic.setBorderPainted(false);
        sonic.setContentAreaFilled(false);
        sonic.setFocusPainted(false);
        sonic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sonicActionPerformed(evt);
            }
        });
        barritas.add(sonic);
        sonic.setBounds(990, 10, 100, 100);

        jTabbedPane1.addTab("Estadisticas de mis personajes", barritas);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 250));

        tabla.setBackground(new java.awt.Color(255, 255, 245));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1);

        jTabbedPane1.addTab("Clasificación general", jPanel1);

        tarta.setLayout(null);
        jTabbedPane1.addTab("Ganadas/Perdidas", tarta);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(100, 150, 1140, 520);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_normal.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chuckNorrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuckNorrisActionPerformed
        this.mostrar("Chuck Norris");
    }//GEN-LAST:event_chuckNorrisActionPerformed

    private void donkeyKongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donkeyKongActionPerformed
        this.mostrar("Donkey Kong");
    }//GEN-LAST:event_donkeyKongActionPerformed

    private void lucarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lucarioActionPerformed
        this.mostrar("Lucario");
    }//GEN-LAST:event_lucarioActionPerformed

    private void gollumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gollumActionPerformed
        this.mostrar("Gollum");
    }//GEN-LAST:event_gollumActionPerformed

    private void luigiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luigiActionPerformed
        this.mostrar("Luigi");
    }//GEN-LAST:event_luigiActionPerformed

    private void maBaracusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maBaracusActionPerformed
        this.mostrar("M. A. Baracus");
    }//GEN-LAST:event_maBaracusActionPerformed

    private void marioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marioActionPerformed
        this.mostrar("Mario");
    }//GEN-LAST:event_marioActionPerformed

    private void samusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samusActionPerformed
        this.mostrar("Samus");
    }//GEN-LAST:event_samusActionPerformed

    private void sonicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sonicActionPerformed
        this.mostrar("Sonic");
    }//GEN-LAST:event_sonicActionPerformed

    private void verMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMouseEntered
        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/ver_partida.png")));
    }//GEN-LAST:event_verMouseEntered

    private void verMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMouseExited
        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/ver_partida.png")));
    }//GEN-LAST:event_verMouseExited

    private void verMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMousePressed
        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/ver_partida.png")));
    }//GEN-LAST:event_verMousePressed

    private void ver(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver
        if(ver.isEnabled()){
           if(tablaHisto.getSelectedRow()>-1){
                ver.setEnabled(false);
                Partida p= consultasBD.instancia().buscarUnaPartidaFinalizadaPorId(Integer.parseInt(tablaHisto.getValueAt(tablaHisto.getSelectedRow(), 0).toString()));
                VerPartida vp=new VerPartida(null, true, p, false, null, false, null, true, this);
                vp.mostrar();
                this.setVisible(false);
                vp.setVisible(true);
            } 
        }        
    }//GEN-LAST:event_ver

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verActionPerformed

    private void volverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseEntered
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/volver.png")));
    }//GEN-LAST:event_volverMouseEntered

    private void volverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseExited
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/volver.png")));
    }//GEN-LAST:event_volverMouseExited

    private void volverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMousePressed
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/volver.png")));
    }//GEN-LAST:event_volverMousePressed

    private void volverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseReleased
        this.setVisible(false);
    }//GEN-LAST:event_volverMouseReleased
    public void mostrar(String nombre){
        ArrayList <Personaje> personajes=new ArrayList();
        personajes=consultasBD.instancia().todosLosPersonajes();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        MiPersonaje mp=this.registrado.getMisPersonajes().get(this.registrado.buscarMiPersonaje(nombre));
        for(Personaje p:personajes){
            int jugadas=consultasBD.instancia().jugadasMiPersonaje1(registrado, mp, p.getNombre())+consultasBD.instancia().jugadasMiPersonaje2(registrado, mp, p.getNombre());
            int ganadas=consultasBD.instancia().ganadasMiPersonaje1(registrado, mp, p.getNombre())+consultasBD.instancia().ganadasMiPersonaje2(registrado, mp, p.getNombre());
            dataset.addValue(jugadas-ganadas, "Perdidas", p.getNombre());
            dataset.addValue(ganadas, "Ganadas", p.getNombre());
        }
        JFreeChart aa = ChartFactory.createBarChart3D(nombre, "", "Partidas", dataset);
        CategoryPlot p = aa.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel pan = new ChartPanel(aa);
        barrasPersonajes.add(pan, BorderLayout.CENTER);
        barrasPersonajes.validate();
    }
    public void mostrar2(){
        int jugadas=consultasBD.instancia().jugadasJ1(registrado)+consultasBD.instancia().jugadasJ2(registrado);
        int ganadas=consultasBD.instancia().partidasGanadas(registrado);
        DefaultPieDataset pie= new DefaultPieDataset();
        pie.setValue("Ganadas", ganadas);
        pie.setValue("Perdidas", jugadas-ganadas);
        JFreeChart queso= ChartFactory.createPieChart3D("Paridas ganadas y perdidas", pie, true, true, Locale.FRENCH);
        PiePlot3D p=(PiePlot3D) queso.getPlot();
        ChartPanel pan= new ChartPanel(queso);
        tarta.add(pan,BorderLayout.CENTER);
        tarta.validate();
    }
    
    public void mostrar3(){
        tablaClasi = new DefaultTableModel(consultasBD.instancia().clasificacion(), cabecera);
        tabla.setModel(tablaClasi);
        if(registrado.buscarMiPersonaje("Chuck Norris")==-1){
            this.chuckNorris.setEnabled(false);
        }
        if(registrado.buscarMiPersonaje("Donkey Kong")==-1){
            this.donkeyKong.setEnabled(false);
        }
        if(registrado.buscarMiPersonaje("Gollum")==-1){
            this.gollum.setEnabled(false);
        }
        if(registrado.buscarMiPersonaje("Lucario")==-1){
            this.lucario.setEnabled(false);
        }
        if(registrado.buscarMiPersonaje("Luigi")==-1){
            this.luigi.setEnabled(false);
        }
        if(registrado.buscarMiPersonaje("M. A. Baracus")==-1){
            this.maBaracus.setEnabled(false);
        }
        if(registrado.buscarMiPersonaje("Mario")==-1){
            this.mario.setEnabled(false);
        }
        if(registrado.buscarMiPersonaje("Samus")==-1){
            this.samus.setEnabled(false);
        }
        if(registrado.buscarMiPersonaje("Sonic")==-1){
            this.sonic.setEnabled(false);
        }
    }
    
    public void mostrar4(){
        
        tablaHistorial=new DefaultTableModel(this.registrado.tablaHistorialPartidas(), cabecera1);
        tablaHisto.setModel(tablaHistorial);
        ver.setEnabled(true);
    }
    
    
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
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Estadisticas dialog = new Estadisticas(new javax.swing.JFrame(), true,null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barrasPersonajes;
    private javax.swing.JPanel barritas;
    private javax.swing.JButton chuckNorris;
    private javax.swing.JButton donkeyKong;
    private javax.swing.JButton gollum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lucario;
    private javax.swing.JButton luigi;
    private javax.swing.JButton maBaracus;
    private javax.swing.JButton mario;
    private javax.swing.JButton samus;
    private javax.swing.JButton sonic;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaHisto;
    private javax.swing.JPanel tarta;
    private javax.swing.JButton ver;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
