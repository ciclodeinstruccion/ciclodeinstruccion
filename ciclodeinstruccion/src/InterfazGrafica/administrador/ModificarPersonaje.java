/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica.administrador;

import Excepciones.ErrorDatos;
import Personaje.Asesino;
import Personaje.Fighter;
import Personaje.Personaje;
import Personaje.Tanque;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import BaseDeDatos.consultasBD;
import Excepciones.ErrorModificarPersonaje;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rubén
 */
public class ModificarPersonaje extends javax.swing.JDialog {

    /**
     * Creates new form ModificarPersonaje
     */
    Personaje personaje;
    public ModificarPersonaje(java.awt.Frame parent, boolean modal, Personaje p) {
        super(parent, modal);
        initComponents();
        this.personaje=p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        especialLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        vida = new javax.swing.JTextField();
        daño = new javax.swing.JTextField();
        especial = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        imgP = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jLabel1.setText("Vida");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(690, 140, 20, 14);

        jLabel2.setText("Daño");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(690, 200, 25, 14);

        especialLabel.setText("Especial");
        getContentPane().add(especialLabel);
        especialLabel.setBounds(690, 260, 38, 14);

        jLabel4.setText("Precio");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(690, 320, 29, 14);

        nombre.setText("Nombre");
        getContentPane().add(nombre);
        nombre.setBounds(690, 100, 37, 14);

        vida.setText("vida");
        getContentPane().add(vida);
        vida.setBounds(790, 140, 110, 40);

        daño.setText("daño");
        getContentPane().add(daño);
        daño.setBounds(790, 190, 110, 40);

        especial.setText("especial");
        getContentPane().add(especial);
        especial.setBounds(790, 250, 100, 50);

        precio.setText("precio");
        getContentPane().add(precio);
        precio.setBounds(790, 320, 110, 40);

        imgP.setMaximumSize(new java.awt.Dimension(300, 450));
        imgP.setMinimumSize(new java.awt.Dimension(300, 450));
        imgP.setPreferredSize(new java.awt.Dimension(300, 450));
        getContentPane().add(imgP);
        imgP.setBounds(150, 110, 300, 450);

        modificar.setText("Modificar");
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                modificarMouseReleased(evt);
            }
        });
        getContentPane().add(modificar);
        modificar.setBounds(700, 460, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseReleased
        float vida=this.vidaNueva();
        float daño=this.dañoNuevo();
        float especial=this.especialNuevo();
        int precio=this.precioNuevo();
        if(vida>0&&daño>0&&especial>0&&precio>0){
            personaje.setVida(vida);
            personaje.setDaño(daño);
            personaje.setPrecio(precio);
            if(personaje instanceof Tanque){
            Tanque t=(Tanque) personaje;
            t.setArmadura(especial);
            }
            else if(personaje instanceof Asesino){
                Asesino a=(Asesino) personaje;
                a.setEsquivar(especial);
            }
            else if(personaje instanceof Fighter){
                Fighter f=(Fighter) personaje;
                f.setCritico(especial);
            }
            JOptionPane.showMessageDialog(rootPane, "Personaje modificado", "Modificar personaje", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
        try {
            consultasBD.instancia().modificarPersonaje(this.personaje);
        } catch (ErrorModificarPersonaje ex) {
            Logger.getLogger(ModificarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_modificarMouseReleased
    public void mostrar(){
        nombre.setText(personaje.getNombre());
        vida.setText(Float.toString(personaje.getVida()));
        daño.setText(Float.toString(personaje.getDaño()));
        precio.setText(Integer.toString(personaje.getPrecio()));
        Image img=new ImageIcon(this.getClass().getResource("/Imagenes/Personajes/"+this.personaje.getNombre()+".jpg")).getImage();
        imgP.setIcon(new ImageIcon(img));
        if(personaje instanceof Tanque){
            Tanque t=(Tanque) personaje;
            especialLabel.setText("Armadura");
            especial.setText(Float.toString(t.getArmadura()));
        }
        else if(personaje instanceof Asesino){
            Asesino a=(Asesino) personaje;
            especialLabel.setText("Armadura");
            especial.setText(Float.toString(a.getEsquivar()));
        }
        else if(personaje instanceof Fighter){
            Fighter f=(Fighter) personaje;
            especialLabel.setText("Armadura");
            especial.setText(Float.toString(f.getCritico()));
        }
    }
    
    public float vidaNueva(){
        float vida=0;
        try{
            vida=Float.parseFloat(this.vida.getText());
            if (vida<=0){
                throw new ErrorDatos();
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "La vida no es correcta", "Modificar personaje", JOptionPane.WARNING_MESSAGE);
            vida=0;
        }
        return vida;
    }
    
    public float dañoNuevo(){
        float daño=0;
        try{
            daño=Float.parseFloat(this.daño.getText());
            if (daño<=0){
                throw new ErrorDatos();
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "El daño no es correcta", "Modificar personaje", JOptionPane.WARNING_MESSAGE);
            daño=0;
        }
        return daño;
    }
    
    public float especialNuevo(){
        float especial=0;
        try{
            especial=Float.parseFloat(this.especial.getText());
            if (especial<=0){
                throw new ErrorDatos();
            }           
        } catch (Exception e){
            if(personaje instanceof Tanque){              
                JOptionPane.showMessageDialog(rootPane, "La armadura no es correcta", "Modificar personaje", JOptionPane.WARNING_MESSAGE);
            }
            else if(personaje instanceof Asesino){
                JOptionPane.showMessageDialog(rootPane, "El esquivar no es correcta", "Modificar personaje", JOptionPane.WARNING_MESSAGE);
            }
            else if(personaje instanceof Fighter){
                JOptionPane.showMessageDialog(rootPane, "El critico no es correcta", "Modificar personaje", JOptionPane.WARNING_MESSAGE);          
            }
            especial=0;
        }
        return especial;  
    }
    
    public int precioNuevo(){
        int precio=0;
        try{
            precio=Integer.parseInt(this.precio.getText());
            if(precio<=0){
                throw new ErrorDatos();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "El precio no es correcta", "Modificar personaje", JOptionPane.WARNING_MESSAGE);
            precio=0;
        }
        return precio;
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
            java.util.logging.Logger.getLogger(ModificarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarPersonaje dialog = new ModificarPersonaje(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JTextField daño;
    private javax.swing.JTextField especial;
    private javax.swing.JLabel especialLabel;
    private javax.swing.JLabel imgP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton modificar;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField vida;
    // End of variables declaration//GEN-END:variables
}
