
package Vista;

import Controlador.ControladorUICT;
import Controlador.variableEstaticaCont;
import Vista.Ventanas.VtnNuevoTrabajador;

public class Menú extends javax.swing.JFrame {


    public Menú() {
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAdminPuestos = new javax.swing.JLabel();
        lblRetribución = new javax.swing.JLabel();
        lblCostoTiempo = new javax.swing.JLabel();
        lblNomina = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblAdminPuestos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminPuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/menu/Adm_Puestos.png"))); // NOI18N
        lblAdminPuestos.setText("Administración de Puestos");
        lblAdminPuestos.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        lblAdminPuestos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdminPuestos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAdminPuestos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblAdminPuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminPuestosMouseClicked(evt);
            }
        });

        lblRetribución.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRetribución.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/menu/322464-128.png"))); // NOI18N
        lblRetribución.setText("Retribución");
        lblRetribución.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        lblRetribución.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRetribución.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRetribución.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblRetribución.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRetribuciónMouseClicked(evt);
            }
        });

        lblCostoTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCostoTiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/menu/Costo_Tiempo.png"))); // NOI18N
        lblCostoTiempo.setText("Control de Tiempo");
        lblCostoTiempo.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        lblCostoTiempo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCostoTiempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCostoTiempo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblCostoTiempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCostoTiempoMouseClicked(evt);
            }
        });

        lblNomina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/menu/nomina.png"))); // NOI18N
        lblNomina.setText("Nómina");
        lblNomina.setToolTipText("");
        lblNomina.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        lblNomina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNomina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNomina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblNomina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNominaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(117, 117, 117));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Funciones de los Recursos Humanos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdminPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRetribución, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(166, 166, 166)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCostoTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRetribución, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCostoTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdminPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void lblAdminPuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminPuestosMouseClicked

    }//GEN-LAST:event_lblAdminPuestosMouseClicked

    private void lblRetribuciónMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRetribuciónMouseClicked

    }//GEN-LAST:event_lblRetribuciónMouseClicked

    private void lblCostoTiempoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoTiempoMouseClicked
        variableEstaticaCont variableEstaticaCont = new variableEstaticaCont();
        variableEstaticaCont.procesoServicios=true;
        IUControlTiempos controlTiempos = new IUControlTiempos();
        VtnNuevoTrabajador vtnNuevoTrabajador = new VtnNuevoTrabajador();
        ControladorUICT  control = new ControladorUICT(controlTiempos);
        controlTiempos.setVisible(true);
    }//GEN-LAST:event_lblCostoTiempoMouseClicked

    private void lblNominaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNominaMouseClicked
        Nomina_View nomina_View = new Nomina_View();
        nomina_View.setVisible(true);
    }//GEN-LAST:event_lblNominaMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdminPuestos;
    private javax.swing.JLabel lblCostoTiempo;
    private javax.swing.JLabel lblNomina;
    private javax.swing.JLabel lblRetribución;
    // End of variables declaration//GEN-END:variables
}
