package Sequence;

/**
 *
 * @author jenniferbueso
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    public PantallaPrincipal() {
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Elementos/GameIcon.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonRegistro = new javax.swing.JLabel();
        BotonIniciarSesion = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sequence");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegistroMouseClicked(evt);
            }
        });
        jPanel1.add(BotonRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 350, 80));

        BotonIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonIniciarSesionMouseClicked(evt);
            }
        });
        jPanel1.add(BotonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 350, 80));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/PantallaPrincipal.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistroMouseClicked
        RegistroUsuarios registroUsuarios = new RegistroUsuarios();
        registroUsuarios.setVisible(true);
        dispose();
    }//GEN-LAST:event_BotonRegistroMouseClicked

    private void BotonIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonIniciarSesionMouseClicked
        IniciarSesion iniciarSesion = new IniciarSesion();
        iniciarSesion.setVisible(true);
        dispose();
    }//GEN-LAST:event_BotonIniciarSesionMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonIniciarSesion;
    private javax.swing.JLabel BotonRegistro;
    private javax.swing.JLabel Fondo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
