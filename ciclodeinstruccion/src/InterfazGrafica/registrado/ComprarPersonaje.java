/**
 * Interfaz desde la que se compra un personaje
 */
package InterfazGrafica.registrado;

import MiPersonaje.MiAsesino;
import MiPersonaje.MiFighter;
import MiPersonaje.MiTanque;
import Personaje.Asesino;
import Personaje.Fighter;
import Personaje.Personaje;
import Personaje.Tanque;
import ciclodeinstruccion.Usuarios.Registrado;
import javax.swing.JOptionPane;
import BaseDeDatos.ConsultasBD;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.ToolTipManager;

public class ComprarPersonaje extends javax.swing.JDialog {

    /**
     * Creates new form ComprarPersonaje
     */
    private Personaje personaje;
    private Registrado registrado;
    private Tienda t;
    public ComprarPersonaje(java.awt.Frame parent, boolean modal, Registrado r, Personaje p,Tienda t) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();  
        this.setLocationRelativeTo(null);
        this.registrado=r;
        this.personaje=p;
        this.t=t;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comprar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        especial = new javax.swing.JLabel();
        labelEspecial = new javax.swing.JLabel();
        vida = new javax.swing.JLabel();
        daño = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        habilidad3 = new javax.swing.JLabel();
        habilidad1 = new javax.swing.JLabel();
        habilidad2 = new javax.swing.JLabel();
        imagenP = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/comprar_personaje.png"))); // NOI18N
        comprar.setBorder(null);
        comprar.setBorderPainted(false);
        comprar.setContentAreaFilled(false);
        comprar.setFocusPainted(false);
        comprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comprarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comprarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comprarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comprar(evt);
            }
        });
        getContentPane().add(comprar);
        comprar.setBounds(300, 600, 260, 65);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,200));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Tipo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 10, 70, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 70, 96, 40);

        tipo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tipo.setForeground(new java.awt.Color(255, 51, 51));
        tipo.setText("tipo");
        jPanel1.add(tipo);
        tipo.setBounds(310, 10, 250, 40);

        nombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 51, 51));
        nombre.setText("nombre");
        jPanel1.add(nombre);
        nombre.setBounds(310, 70, 250, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Precio");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 130, 75, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Vida");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 190, 52, 40);

        especial.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        especial.setForeground(new java.awt.Color(255, 51, 51));
        especial.setText("especial");
        jPanel1.add(especial);
        especial.setBounds(310, 310, 230, 40);

        labelEspecial.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelEspecial.setForeground(new java.awt.Color(255, 51, 51));
        labelEspecial.setText("Especial");
        jPanel1.add(labelEspecial);
        labelEspecial.setBounds(60, 310, 190, 40);

        vida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        vida.setForeground(new java.awt.Color(255, 51, 51));
        vida.setText("vida");
        jPanel1.add(vida);
        vida.setBounds(310, 190, 250, 40);

        daño.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        daño.setForeground(new java.awt.Color(255, 51, 51));
        daño.setText("daño");
        jPanel1.add(daño);
        daño.setBounds(310, 250, 250, 40);

        precio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        precio.setForeground(new java.awt.Color(255, 51, 51));
        precio.setText("precio");
        jPanel1.add(precio);
        precio.setBounds(310, 130, 250, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Daño");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 250, 62, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Habilidades");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 380, 138, 40);

        habilidad3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        habilidad3.setForeground(new java.awt.Color(255, 51, 51));
        habilidad3.setText("habilidad 3");
        jPanel1.add(habilidad3);
        habilidad3.setBounds(310, 460, 230, 30);

        habilidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        habilidad1.setForeground(new java.awt.Color(255, 51, 51));
        habilidad1.setText("habilidad 1");
        jPanel1.add(habilidad1);
        habilidad1.setBounds(310, 380, 230, 30);

        habilidad2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        habilidad2.setForeground(new java.awt.Color(255, 51, 51));
        habilidad2.setText("habilidad 2");
        jPanel1.add(habilidad2);
        habilidad2.setBounds(310, 420, 230, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(580, 30, 550, 530);

        imagenP.setText("jLabel7");
        imagenP.setMaximumSize(new java.awt.Dimension(300, 450));
        imagenP.setMinimumSize(new java.awt.Dimension(300, 450));
        imagenP.setPreferredSize(new java.awt.Dimension(300, 450));
        getContentPane().add(imagenP);
        imagenP.setBounds(160, 60, 300, 450);

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
        jButton1.setBounds(700, 600, 260, 65);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_normal.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comprar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comprar
        if(registrado.getOro()>personaje.getPrecio()){
            if(JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que quieres comprar este personaje?", "Comprar personaje", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE)==0){
                comprar.setEnabled(false);
                if(personaje instanceof Tanque){
                    Tanque t=(Tanque)personaje;
                    MiTanque mt=new MiTanque(0, 0, 1, 0, 0, t, 0);
                    registrado.añadirPersonajes(mt);
                    registrado.gastarPuntosOro(personaje.getPrecio());
                    ConsultasBD.instancia().modificarRegistrado(registrado);
                    ConsultasBD.instancia().añadirMiPersonaje(mt, registrado);
                }
                else if(personaje instanceof Asesino){
                    Asesino a=(Asesino)personaje;
                    MiAsesino ma=new MiAsesino(0, 0, 1, 0, 0, a, 0);
                    registrado.añadirPersonajes(ma);
                    registrado.gastarPuntosOro(personaje.getPrecio());
                    ConsultasBD.instancia().modificarRegistrado(registrado);
                    ConsultasBD.instancia().añadirMiPersonaje(ma, registrado);
                }
                if(personaje instanceof Fighter){
                    Fighter f=(Fighter)personaje;
                    MiFighter mf=new MiFighter(0, 0, 1, 0, 0, f, 0);
                    registrado.añadirPersonajes(mf);
                    registrado.gastarPuntosOro(personaje.getPrecio());
                    ConsultasBD.instancia().modificarRegistrado(registrado);
                    ConsultasBD.instancia().añadirMiPersonaje(mf, registrado);
                }
                JOptionPane.showMessageDialog(rootPane, "Personaje comprado con éxito", "Comprar personaje", JOptionPane.INFORMATION_MESSAGE);
                t.mostrar();
                this.setVisible(false);
                t.setVisible(true);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "No tienes oro sificiente para comprar este personaje", "Comprar personaje", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_comprar

    private void comprarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comprarMousePressed
        comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/comprar_personaje.png")));
    }//GEN-LAST:event_comprarMousePressed

    private void comprarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comprarMouseExited
        comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/comprar_personaje.png")));
    }//GEN-LAST:event_comprarMouseExited

    private void comprarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comprarMouseEntered
        comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/comprar_personaje.png")));
    }//GEN-LAST:event_comprarMouseEntered

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Pressed/volver.png")));
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        t.mostrar();
        this.setVisible(false);
        t.setVisible(true);
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Normal/volver.png")));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Hover/volver.png")));
    }//GEN-LAST:event_jButton1MouseEntered
    /**
     * Muestra la imagen del personaje y un panel en el lateral con información
     * sobre el mismo
     */
    public void mostrar(){
        this.daño.setText(Float.toString(personaje.getDaño()));
        this.vida.setText(Float.toString(personaje.getVida()));
        this.nombre.setText(personaje.getNombre());
        this.tipo.setText(personaje.getTipo());
        this.precio.setText(Integer.toString(personaje.getPrecio()));
        this.habilidad1.setText(personaje.getHabilidades().get(0).getNombre().toUpperCase());
        this.habilidad1.setToolTipText("<html><p width=\"250\">" +personaje.getHabilidades().get(0).getDescripcion()+"</p></html>");
        this.habilidad2.setText(personaje.getHabilidades().get(1).getNombre().toUpperCase());
        this.habilidad2.setToolTipText("<html><p width=\"250\">"+personaje.getHabilidades().get(1).getDescripcion()+"</p></html>");
        this.habilidad3.setText(personaje.getHabilidades().get(2).getNombre().toUpperCase());
        this.habilidad3.setToolTipText("<html><p width=\"250\">"+personaje.getHabilidades().get(2).getDescripcion()+"</p></html>");
        if(personaje instanceof Tanque){
            Tanque t=(Tanque)personaje;
            this.labelEspecial.setText("Armadura");
            this.especial.setText(Float.toString(t.getArmadura()));
        }
        else if(personaje instanceof Asesino){
            Asesino a=(Asesino)personaje;
            this.labelEspecial.setText("Esquivar");
            this.especial.setText(Float.toString(a.getEsquivar()));
        }
        if(personaje instanceof Fighter){
            Fighter f=(Fighter)personaje;
            this.labelEspecial.setText("Critico");
            this.especial.setText(Float.toString(f.getCritico()));
        }
        Image img=new ImageIcon(this.getClass().getResource("/Imagenes/Personajes/"+this.personaje.getNombre()+".jpg")).getImage();
        imagenP.setIcon(new ImageIcon(img));
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
            java.util.logging.Logger.getLogger(ComprarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComprarPersonaje dialog = new ComprarPersonaje(new javax.swing.JFrame(), true,null,null,null);
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
    private javax.swing.JButton comprar;
    private javax.swing.JLabel daño;
    private javax.swing.JLabel especial;
    private javax.swing.JLabel habilidad1;
    private javax.swing.JLabel habilidad2;
    private javax.swing.JLabel habilidad3;
    private javax.swing.JLabel imagenP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelEspecial;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel vida;
    // End of variables declaration//GEN-END:variables
}
