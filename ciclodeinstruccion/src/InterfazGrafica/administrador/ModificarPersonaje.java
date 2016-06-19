/**
 * Interfaz gráfica desde la que se modifican los datos de un personaje
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
import BaseDeDatos.ConsultasBD;
import Excepciones.ErrorModificarPersonaje;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificarPersonaje extends javax.swing.JDialog {

    /**
     * Creates new form ModificarPersonaje
     */
    private Personaje personaje;
    private VerPersonajes vp;
    public ModificarPersonaje(java.awt.Frame parent, boolean modal, Personaje p,VerPersonajes vp) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();  
        this.setLocationRelativeTo(null);
        this.personaje=p;
        this.vp=vp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgP = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        especialLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        vida = new javax.swing.JTextField();
        daño = new javax.swing.JTextField();
        especial = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        nombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        imgP.setMaximumSize(new java.awt.Dimension(300, 450));
        imgP.setMinimumSize(new java.awt.Dimension(300, 450));
        imgP.setPreferredSize(new java.awt.Dimension(300, 450));
        getContentPane().add(imgP);
        imgP.setBounds(190, 90, 300, 450);

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/modificar.png"))); // NOI18N
        modificar.setMaximumSize(new java.awt.Dimension(260, 65));
        modificar.setMinimumSize(new java.awt.Dimension(260, 65));
        modificar.setPreferredSize(new java.awt.Dimension(260, 65));
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modificarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                modificarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                modificarMouseReleased(evt);
            }
        });
        getContentPane().add(modificar);
        modificar.setBounds(300, 600, 260, 65);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,180));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Daño");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 130, 70, 70);

        especialLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        especialLabel.setForeground(new java.awt.Color(255, 51, 51));
        especialLabel.setText("Especial");
        jPanel1.add(especialLabel);
        especialLabel.setBounds(70, 210, 130, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Precio");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 270, 110, 60);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Vida");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 70, 60, 50);

        vida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        vida.setForeground(new java.awt.Color(255, 51, 51));
        vida.setText("vida");
        jPanel1.add(vida);
        vida.setBounds(230, 70, 110, 40);

        daño.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        daño.setForeground(new java.awt.Color(255, 51, 51));
        daño.setText("daño");
        jPanel1.add(daño);
        daño.setBounds(230, 140, 110, 40);

        especial.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        especial.setForeground(new java.awt.Color(255, 51, 51));
        especial.setText("especial");
        jPanel1.add(especial);
        especial.setBounds(230, 210, 110, 40);

        precio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        precio.setForeground(new java.awt.Color(255, 51, 51));
        precio.setText("precio");
        jPanel1.add(precio);
        precio.setBounds(230, 280, 110, 40);

        nombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 51, 51));
        nombre.setText("Nombre");
        jPanel1.add(nombre);
        nombre.setBounds(130, 20, 130, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(660, 100, 430, 400);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/volver.png"))); // NOI18N
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
        getContentPane().add(jButton1);
        jButton1.setBounds(740, 600, 260, 65);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_normal.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1280, 720);

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
            vp.mostrar();
            this.setVisible(false);
            vp.setVisible(true);
        }
        try {
            ConsultasBD.instancia().modificarPersonaje(this.personaje);
        } catch (ErrorModificarPersonaje ex) {
            Logger.getLogger(ModificarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_modificarMouseReleased

    private void modificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMousePressed
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/iniciar_sesion.png")));
    }//GEN-LAST:event_modificarMousePressed

    private void modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseExited
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/iniciar_sesion.png")));
    }//GEN-LAST:event_modificarMouseExited

    private void modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseEntered
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/iniciar_sesion.png")));
    }//GEN-LAST:event_modificarMouseEntered

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        this.setVisible(false);
        vp.setVisible(true);
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/volver.png")));
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/volver.png")));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/volver.png")));
    }//GEN-LAST:event_jButton1MouseEntered
    /**
     * Muestra los datos del personaje a modificar
     */
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
    /**
     * Comprueba si la vida es correcta. Retorna 0 si no lo es
     * @return vida
     */
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
    /**
     * Comprueba si el daño es correcto.Retorna 0 si no lo es
     * @return daño
     */
    public float dañoNuevo(){
        float daño=0;
        try{
            daño=Float.parseFloat(this.daño.getText());
            if (daño<=0){
                throw new ErrorDatos();
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "El daño no es correcto", "Modificar personaje", JOptionPane.WARNING_MESSAGE);
            daño=0;
        }
        return daño;
    }
    /**
     * Comprueba si el atributo espeial es correcto. Retorna 0 si no lo es
     * @return especial
     */
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
    /**
     * Comprueba si el precio es correcto. Retorna 0 si no lo es
     * @return precio
     */
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
                ModificarPersonaje dialog = new ModificarPersonaje(new javax.swing.JFrame(), true,null,null);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modificar;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField vida;
    // End of variables declaration//GEN-END:variables
}
