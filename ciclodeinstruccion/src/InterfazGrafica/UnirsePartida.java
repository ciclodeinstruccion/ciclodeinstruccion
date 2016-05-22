/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import BaseDeDatos.consultasBD;
import ciclodeinstruccion.Partida;
import ciclodeinstruccion.Usuarios.Registrado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rubén
 */
public class UnirsePartida extends javax.swing.JDialog {

    /**
     * Creates new form UnirsePartida
     */
    String cabecera []={"Identificador","Jugador","Personaje","Nivel de la partida"};
    DefaultTableModel tabla;
    String cabecera2 []={"Nombre","Tipo","Vida","Daño","Especial","Nivel","Experiencia","Puntos de nivel"};
    DefaultTableModel tabla2;
    Registrado registrado;
    public UnirsePartida(java.awt.Frame parent, boolean modal, Registrado r) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMisPersonajes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPartidas = new javax.swing.JTable();
        unirse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaMisPersonajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMisPersonajes);

        jScrollPane2.setViewportView(tablaPartidas);

        unirse.setText("Unirse");
        unirse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                unirse(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(unirse)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unirse)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unirse(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unirse
         if(tablaMisPersonajes.getSelectedRow()>-1 && tablaPartidas.getSelectedRow()>-1){
            if(registrado.getOro()<Partida.getCOSTE_PARTIDA()){
                JOptionPane.showMessageDialog(rootPane, "No tienes oro sificiente para unirte a la partida", "Unirse a partida", JOptionPane.WARNING_MESSAGE);
            }
            else if(JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que quieres unirte a esta partida?", "Unirse a partida", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE)==0){
                unirse.setEnabled(false);
                Partida p=consultasBD.instancia().buscarUnaPartidaUnirsePorId(Integer.parseInt(tablaPartidas.getValueAt(tablaPartidas.getSelectedRow(), 0).toString()));
                p.unirsePartida(registrado, consultasBD.instancia().buscarMiPersonaje(tablaMisPersonajes.getValueAt(tablaMisPersonajes.getSelectedRow(), 0).toString(), registrado));
                consultasBD.instancia().modificarRegistrado(registrado);
                p.jugarPartida();
                consultasBD.instancia().unirsePartida(p);
                consultasBD.instancia().modificarRegistrado(p.getGanador());
                consultasBD.instancia().modificarMiPersonaje(p.getpGanador(), p.getGanador());
                VerPartida vp=new VerPartida(null, true, p);
                vp.mostrar();
                this.setVisible(false);
                vp.setVisible(true);
            }
         }
    }//GEN-LAST:event_unirse
    public void mostrar(){
        tabla2=new DefaultTableModel(this.registrado.tablaMisPersonajes(), cabecera2);
        tablaMisPersonajes.setModel(tabla2);
        tabla=new DefaultTableModel(this.registrado.tablaUnirseAPartida(), cabecera);
        tablaPartidas.setModel(tabla);
        
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
            java.util.logging.Logger.getLogger(UnirsePartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnirsePartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnirsePartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnirsePartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UnirsePartida dialog = new UnirsePartida(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaMisPersonajes;
    private javax.swing.JTable tablaPartidas;
    private javax.swing.JButton unirse;
    // End of variables declaration//GEN-END:variables
}