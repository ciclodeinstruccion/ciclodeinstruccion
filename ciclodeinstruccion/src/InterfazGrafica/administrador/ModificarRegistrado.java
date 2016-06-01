/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica.administrador;

import BaseDeDatos.consultasBD;
import ciclodeinstruccion.Usuarios.Registrado;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class ModificarRegistrado extends javax.swing.JDialog {

    /**
     * Creates new form ModificarRegistrado
     */
    Registrado r;
    public ModificarRegistrado(java.awt.Frame parent, boolean modal, Registrado r) {
        super(parent, modal);
        this.r=r;
        initComponents();
        
    }
    
    public void mostrarPredeterminado(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modificar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreNuevo = new javax.swing.JTextField();
        correoNuevo = new javax.swing.JTextField();
        contraseñaNueva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        modificar.setText("Modificar");
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                modificarMouseReleased(evt);
            }
        });
        getContentPane().add(modificar);
        modificar.setBounds(390, 520, 75, 23);

        volver.setText("Volver");
        volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                volverMouseReleased(evt);
            }
        });
        getContentPane().add(volver);
        volver.setBounds(620, 530, 63, 23);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Nuevo nombre");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 10, 200, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Correo nuevo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 80, 180, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Contraseña nueva");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 150, 240, 60);

        nombreNuevo.setText(r.getNombre());
        nombreNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nombreNuevo);
        nombreNuevo.setBounds(310, 30, 260, 40);

        correoNuevo.setText(r.getCorreo());
        jPanel1.add(correoNuevo);
        correoNuevo.setBounds(310, 90, 260, 40);

        contraseñaNueva.setText(r.getContraseña());
        jPanel1.add(contraseñaNueva);
        contraseñaNueva.setBounds(310, 160, 260, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(250, 170, 630, 270);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_normal.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreNuevoActionPerformed

    private void modificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseReleased
        
        if(comprobarActu(nombreNuevo.getText(),correoNuevo.getText(),contraseñaNueva.getText())){
            if(nombreNuevo.getText()!=r.getNombre()){
                if(consultasBD.instancia().existeNombre(nombreNuevo.getText())==false){
                    String nombreViejo = r.getNombre();
                    r.setNombre(nombreNuevo.getText());
                    consultasBD.instancia().cambiarNombreRegistrado(r, nombreViejo);
                }
            }
            if(correoNuevo.getText()!=r.getCorreo()){ 
                if(!consultasBD.instancia().existeCorreo(correoNuevo.getText())){
                    r.setCorreo(correoNuevo.getText());
                    consultasBD.instancia().modificarRegistrado(r);
                }
            }    
            if(contraseñaNueva.getText()!=r.getContraseña()){
                r.setContraseña(contraseñaNueva.getText());
                consultasBD.instancia().modificarRegistrado(r);
            }
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_modificarMouseReleased

    private void volverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseReleased
        this.setVisible(false);
    }//GEN-LAST:event_volverMouseReleased

    public boolean comprobarActu(String nombre, String correo, String contraseña){
        boolean correcto=true;
        if(nombre.equals("")||correo.equals("")||contraseña.equals("")){
            correcto=false;
            JOptionPane.showMessageDialog(rootPane, "Los datos de registro no son válidos", "Registrarse", JOptionPane.WARNING_MESSAGE);
        }
        else if(consultasBD.instancia().existeNombre(nombre)){
            correcto=false;
            JOptionPane.showMessageDialog(rootPane, "Ya existe un usuario registrado con este nombre", "Registrarse", JOptionPane.WARNING_MESSAGE);
        }
        else if(consultasBD.instancia().existeCorreo(correo)){
            correcto=false;
            JOptionPane.showMessageDialog(rootPane, "Ya existe un usuario registrado con este correo", "Registrarse", JOptionPane.WARNING_MESSAGE);
        }
        else if(!correoValido(correo)){
            correcto=false;
            JOptionPane.showMessageDialog(rootPane, "El correo electrónico indicado no es válido", "Registrarse", JOptionPane.WARNING_MESSAGE);
        }
        return correcto;
    }
    
    public boolean correoValido(String correo){
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(correo);
        return matcher.matches();
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
            java.util.logging.Logger.getLogger(ModificarRegistrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarRegistrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarRegistrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarRegistrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarRegistrado dialog = new ModificarRegistrado(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JTextField contraseñaNueva;
    private javax.swing.JTextField correoNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombreNuevo;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}