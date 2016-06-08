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
    public Estadisticas(java.awt.Frame parent, boolean modal, Registrado r) {
        super(parent, modal);
        initComponents();
        this.registrado=r;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tarta = new javax.swing.JPanel();
        barritas = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        barrasPersonajes = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jTabbedPane1.addTab("Ganadas/Perdidas", tarta);

        barritas.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Chuck Norris.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        barritas.add(jButton1);
        jButton1.setBounds(30, 10, 100, 100);

        barrasPersonajes.setLayout(new java.awt.BorderLayout());
        barritas.add(barrasPersonajes);
        barrasPersonajes.setBounds(0, 120, 1140, 370);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Donkey Kong.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        barritas.add(jButton2);
        jButton2.setBounds(150, 10, 100, 100);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Gollum.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        barritas.add(jButton3);
        jButton3.setBounds(270, 10, 100, 100);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Lucario.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        barritas.add(jButton4);
        jButton4.setBounds(390, 10, 100, 100);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Luigi.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        barritas.add(jButton5);
        jButton5.setBounds(510, 10, 100, 100);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/M. A. Baracus.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        barritas.add(jButton6);
        jButton6.setBounds(630, 10, 100, 100);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Mario.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        barritas.add(jButton7);
        jButton7.setBounds(750, 10, 100, 100);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Samus.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        barritas.add(jButton8);
        jButton8.setBounds(870, 10, 100, 100);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PjCaras/Sonic.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        barritas.add(jButton9);
        jButton9.setBounds(990, 10, 100, 100);

        jTabbedPane1.addTab("Estadisticas de mis personajes", barritas);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 130));

        tabla.setBackground(new java.awt.Color(255, 255, 245));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1);

        jTabbedPane1.addTab("Clasificación general", jPanel1);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(100, 150, 1140, 520);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_normal.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.mostrar("Chuck Norris");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.mostrar("Donkey Kong");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.mostrar("Lucario");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.mostrar("Gollum");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.mostrar("Luigi");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.mostrar("M. A. Baracus");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.mostrar("Mario");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.mostrar("Samus");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.mostrar("Sonic");
    }//GEN-LAST:event_jButton9ActionPerformed
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
                Estadisticas dialog = new Estadisticas(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JPanel tarta;
    // End of variables declaration//GEN-END:variables
}
