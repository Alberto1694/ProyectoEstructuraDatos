package paquete.vista;

import paquete.vista.VistaParticipantes;
import paquete.vista.VistaPartidos;
import paquete.vista.VistaResultados;
import paquete.vista.VistaEventos;

public class VistaMenuAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaMenuAdmin.class.getName());
    
    public VistaMenuAdmin() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btClasificacion = new javax.swing.JToggleButton();
        btParticipantes = new javax.swing.JToggleButton();
        btGrafo = new javax.swing.JToggleButton();
        btCerrar = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        btResultados = new javax.swing.JToggleButton();
        btPartidos = new javax.swing.JToggleButton();
        btnEventos = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menú Administrador");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel2)
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel3.setText("Bienvenido:");

        btClasificacion.setBackground(new java.awt.Color(0, 102, 204));
        btClasificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btClasificacion.setForeground(new java.awt.Color(255, 255, 255));
        btClasificacion.setText("Tabla Clasificación");
        btClasificacion.addActionListener(this::btClasificacionActionPerformed);

        btParticipantes.setBackground(new java.awt.Color(0, 102, 204));
        btParticipantes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btParticipantes.setForeground(new java.awt.Color(255, 255, 255));
        btParticipantes.setText("Gestión Participantes");
        btParticipantes.addActionListener(this::btParticipantesActionPerformed);

        btGrafo.setBackground(new java.awt.Color(0, 102, 204));
        btGrafo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btGrafo.setForeground(new java.awt.Color(255, 255, 255));
        btGrafo.setText("Ver Grafo");

        btCerrar.setBackground(new java.awt.Color(255, 0, 0));
        btCerrar.setText("Cerrar Sesión");
        btCerrar.addActionListener(this::btCerrarActionPerformed);

        btResultados.setBackground(new java.awt.Color(0, 102, 204));
        btResultados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btResultados.setForeground(new java.awt.Color(255, 255, 255));
        btResultados.setText("Registrar Resultados");
        btResultados.addActionListener(this::btResultadosActionPerformed);

        btPartidos.setBackground(new java.awt.Color(0, 102, 204));
        btPartidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btPartidos.setForeground(new java.awt.Color(255, 255, 255));
        btPartidos.setText("Gestión Partidos");
        btPartidos.addActionListener(this::btPartidosActionPerformed);

        btnEventos.setBackground(new java.awt.Color(0, 102, 204));
        btnEventos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEventos.setForeground(new java.awt.Color(255, 255, 255));
        btnEventos.setText("Gestión Eventos");
        btnEventos.setMaximumSize(new java.awt.Dimension(159, 27));
        btnEventos.setMinimumSize(new java.awt.Dimension(159, 27));
        btnEventos.setPreferredSize(new java.awt.Dimension(159, 27));
        btnEventos.addActionListener(this::btnEventosActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btResultados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btClasificacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPartidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEventos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClasificacionActionPerformed
      
        new VistaClasificacion().setVisible(true);
    }//GEN-LAST:event_btClasificacionActionPerformed

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        
        dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void btParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParticipantesActionPerformed

        new VistaParticipantes().setVisible(true);
    }//GEN-LAST:event_btParticipantesActionPerformed

    private void btResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResultadosActionPerformed
      
        new VistaResultados().setVisible(true);
    }//GEN-LAST:event_btResultadosActionPerformed

    private void btPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPartidosActionPerformed
      
        new VistaPartidos().setVisible(true);
    }//GEN-LAST:event_btPartidosActionPerformed

    private void btnEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventosActionPerformed
         new VistaEventos().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnEventosActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new VistaMenuAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btCerrar;
    private javax.swing.JToggleButton btClasificacion;
    private javax.swing.JToggleButton btGrafo;
    private javax.swing.JToggleButton btParticipantes;
    private javax.swing.JToggleButton btPartidos;
    private javax.swing.JToggleButton btResultados;
    private javax.swing.JToggleButton btnEventos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
