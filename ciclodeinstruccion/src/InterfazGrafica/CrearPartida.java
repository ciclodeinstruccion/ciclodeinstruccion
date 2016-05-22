/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import ciclodeinstruccion.Partida;
import ciclodeinstruccion.Usuarios.Registrado;
import javax.swing.table.DefaultTableModel;
import BaseDeDatos.consultasBD;
import javax.swing.JOptionPane;

/**
 *
 * @author Rubén
 */
public class CrearPartida extends javax.swing.JDialog {

    /**
     * Creates new form CrearPartida
     */
    String cabecera []={"Nombre","Tipo","Vida","Daño","Especial","Nivel","Experiencia","Puntos de nivel"};
    DefaultTableModel tabla;
    Registrado registrado;
    public CrearPartida(java.awt.Frame parent, boolean modal, Registrado r) {
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
        Seleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(tablaMisPersonajes);

        Seleccionar.setText("Seleccionar");
        Seleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                crearPartida(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(Seleccionar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(Seleccionar)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearPartida(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearPartida
        if(tablaMisPersonajes.getSelectedRow()>-1){
            if(registrado.getOro()<Partida.getCOSTE_PARTIDA()){
                JOptionPane.showMessageDialog(rootPane, "No tienes oro sificiente para crear la partida", "Crear partida", JOptionPane.WARNING_MESSAGE);
            }
            else if(JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que quieres crear la partida?", "Crear partida", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE)==0){
                Seleccionar.setEnabled(false);
                Partida p=new Partida(consultasBD.instancia().identificadorPartida()+1, registrado, consultasBD.instancia().buscarMiPersonaje(tablaMisPersonajes.getValueAt(tablaMisPersonajes.getSelectedRow(), 0).toString(), registrado));
                consultasBD.instancia().añadirPArtida(p);
                p.comprarPartida();
                consultasBD.instancia().modificarRegistrado(registrado);
                JOptionPane.showMessageDialog(rootPane, "Partida creada con éxito", "Crear partida", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            }
        }    
    }//GEN-LAST:event_crearPartida
    public void mostrar(){
        tabla=new DefaultTableModel(this.registrado.tablaMisPersonajes(), cabecera);
        tablaMisPersonajes.setModel(tabla); 
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
            java.util.logging.Logger.getLogger(CrearPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearPartida dialog = new CrearPartida(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JButton Seleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMisPersonajes;
    // End of variables declaration//GEN-END:variables
}
