/**
 * Interfaz gráfica que muestra una lista de todos los usuarios registrados
 */
package InterfazGrafica.administrador;

import BaseDeDatos.ConexionBD;
import ciclodeinstruccion.Usuarios.Administrador;
import BaseDeDatos.ConsultasBD;
import ciclodeinstruccion.Usuarios.Registrado;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;

public class VerUsuarios extends javax.swing.JDialog {

    /**
     * Creates new form VerUsuarios
     */
    private Administrador admin;
    private String cabecera []={"Nombre","Correo","Contraseña"};
    private DefaultTableModel tabla;
    private InicioAdministrador ia;
    
    public VerUsuarios(java.awt.Frame parent, boolean modal, Administrador admin, InicioAdministrador ia) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();  
        this.setLocationRelativeTo(null);
        this.admin=admin;
        this.ia=ia;
    }
    
    public void mostrar(java.awt.event.MouseEvent evt){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        masInformacion = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0,0));
        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane1MouseWheelMoved(evt);
            }
        });

        tablaUsuarios.setShowGrid(true);
        tablaUsuarios.setGridColor(Color.WHITE);
        tablaUsuarios.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));
        tablaUsuarios.setBackground(new java.awt.Color(0, 0, 0,130));
        tablaUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tablaUsuarios.setForeground(new java.awt.Color(255, 51, 51));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaUsuarios.setRowHeight(24);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 110, 1000, 340);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);

        masInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/mas_informacion.png"))); // NOI18N
        masInformacion.setBorder(null);
        masInformacion.setBorderPainted(false);
        masInformacion.setContentAreaFilled(false);
        masInformacion.setFocusPainted(false);
        masInformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                masInformacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                masInformacionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                masInformacionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                masInformacionMouseReleased(evt);
            }
        });
        masInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masInformacionActionPerformed(evt);
            }
        });
        getContentPane().add(masInformacion);
        masInformacion.setBounds(170, 550, 260, 65);

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
        volver.setBounds(830, 550, 260, 65);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/modificar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 550, 260, 65);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_normal.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseReleased
        this.setVisible(false);
        ia.setVisible(true);
    }//GEN-LAST:event_volverMouseReleased

    private void masInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masInformacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masInformacionActionPerformed

    private void masInformacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masInformacionMouseReleased
        if(tablaUsuarios.getSelectedRow()>-1){
            Registrado r = ConsultasBD.instancia().buscarRegistrado(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString());
            VerMasUsuarios vmu = new VerMasUsuarios(null, true, r,this);
            vmu.mostrar();
            this.setVisible(false);
            vmu.setVisible(true);
        }
    }//GEN-LAST:event_masInformacionMouseReleased

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        if(tablaUsuarios.getSelectedRow()>-1){
            
            Registrado r = ConsultasBD.instancia().buscarRegistrado(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString()); 
            ModificarRegistrado mr = new ModificarRegistrado(null, true, r,this);
            this.setVisible(false);
            mr.setVisible(true);
        }
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void masInformacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masInformacionMousePressed
        masInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/mas_informacion.png")));
    }//GEN-LAST:event_masInformacionMousePressed

    private void masInformacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masInformacionMouseExited
        masInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/mas_informacion.png")));
    }//GEN-LAST:event_masInformacionMouseExited

    private void masInformacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masInformacionMouseEntered
        masInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/mas_informacion.png")));
    }//GEN-LAST:event_masInformacionMouseEntered

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/modificar.png")));
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/modificar.png")));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/modificar.png")));
    }//GEN-LAST:event_jButton1MouseEntered

    private void volverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMousePressed
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/volver.png")));
    }//GEN-LAST:event_volverMousePressed

    private void volverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseExited
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/volver.png")));
    }//GEN-LAST:event_volverMouseExited

    private void volverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseEntered
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/volver.png")));
    }//GEN-LAST:event_volverMouseEntered

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        this.repaint();
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void jScrollPane1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane1MouseWheelMoved
        this.repaint();
    }//GEN-LAST:event_jScrollPane1MouseWheelMoved
    /**
     * Muestra una tabla con los datos de todos los usuarios
     */
    public void mostrar(){
        String [][] t=admin.tablaUsuarios();
        tabla=new DefaultTableModel(t, cabecera);
        tablaUsuarios.setModel(tabla);
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
            java.util.logging.Logger.getLogger(VerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerUsuarios dialog = new VerUsuarios(new javax.swing.JFrame(), true,null,null);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton masInformacion;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
