package paquete.vista;

import javax.swing.table.DefaultTableModel;
import paquete.vista.VistaPrincipal;
import paquete.controlador.ControladorPartido;
import paquete.modelo.Partido;
import paquete.modelo.Nodo;
import paquete.controlador.ControladorParticipante;
import paquete.modelo.NodoDoble;
import paquete.modelo.Participante;

public class VistaPartidos extends javax.swing.JFrame {
    private ControladorPartido controlador;
    private ControladorParticipante controladorParticipante; 
       
    public VistaPartidos() {
        initComponents();
        controlador = new ControladorPartido();
        controladorParticipante = new ControladorParticipante();
        mostrarPartidos();
        mostrarParticipantes();
    }
    //datos quemados de prueba
    /*private void cargarDatos() {
        DefaultTableModel model = (DefaultTableModel) TablaEventos.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{"Equipo 1", "Equipo 8", "2026-04-05"});
        model.addRow(new Object[]{"Equipo 2", "Equipo 7", "2026-04-06"});
        model.addRow(new Object[]{"Equipo 3", "Equipo 6", "2026-04-07"});
        model.addRow(new Object[]{"Equipo 4", "Equipo 5", "2026-04-08"});

        jComboBox1.removeAllItems();
        jComboBox1.addItem("Equipo 1");
        jComboBox1.addItem("Equipo 2");
        jComboBox1.addItem("Equipo 3");
        jComboBox1.addItem("Equipo 4");

        jComboBox2.removeAllItems();
        jComboBox2.addItem("Equipo 8");
        jComboBox2.addItem("Equipo 7");
        jComboBox2.addItem("Equipo 6");
        jComboBox2.addItem("Equipo 5");

        TlParticipante.setText("2026-04-05");
    }*/
    private void mostrarPartidos() {
        DefaultTableModel model = (DefaultTableModel) TablaEventos.getModel();
        model.setRowCount(0);
        Nodo aux = controlador.getPartidos();
        while (aux != null) {
            Partido p = (Partido) aux.getDato();
            model.addRow(new Object[]{
                p.getEquipoLocal(),
                p.getEquipoVisitante(),
                p.getFecha()
            });
            aux = aux.getSiguiente();
            }
        }
    private void mostrarParticipantes() {
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        NodoDoble aux = controladorParticipante.getParticipantes();
        while (aux != null) {
            Participante p = (Participante) aux.getDato();
            jComboBox1.addItem(p.getEquipo().getNombreEquipo());
            jComboBox2.addItem(p.getEquipo().getNombreEquipo());
            aux = aux.getSiguiente();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TlParticipante = new javax.swing.JTextField();
        btnProgramasPartido = new java.awt.Button();
        btnActualizarEvento1 = new java.awt.Button();
        TabParticipantes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEventos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnEliminarParticipante = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        btnVolverMenu = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        BtnJugarPartido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Participantes 1:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Participantes 2:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Fecha:");

        btnProgramasPartido.setActionCommand("Agregar");
        btnProgramasPartido.setBackground(new java.awt.Color(51, 255, 51));
        btnProgramasPartido.setForeground(new java.awt.Color(255, 255, 255));
        btnProgramasPartido.setLabel("Programar");
        btnProgramasPartido.addActionListener(this::btnProgramasPartidoActionPerformed);

        btnActualizarEvento1.setActionCommand("Actualizar Evento");
        btnActualizarEvento1.setBackground(new java.awt.Color(0, 102, 255));
        btnActualizarEvento1.setEnabled(false);
        btnActualizarEvento1.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarEvento1.setLabel("Actualizar");
        btnActualizarEvento1.addActionListener(this::btnActualizarEvento1ActionPerformed);

        TabParticipantes.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        TabParticipantes.setText("Calendario de Partidos");

        TablaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Equipo Local", "Equipo Visitante", "Fecha"
            }
        ));
        TablaEventos.setToolTipText("");
        jScrollPane2.setViewportView(TablaEventos);

        btnEliminarParticipante.setActionCommand("Eliminar Evento");
        btnEliminarParticipante.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarParticipante.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarParticipante.setLabel("Eliminar");
        btnEliminarParticipante.addActionListener(this::btnEliminarParticipanteActionPerformed);

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        btnVolverMenu.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        btnVolverMenu.setLabel("Volver al Menu");
        btnVolverMenu.addActionListener(this::btnVolverMenuActionPerformed);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestion de Partidos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnVolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(btnVolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        BtnJugarPartido.setBackground(new java.awt.Color(255, 153, 255));
        BtnJugarPartido.setForeground(new java.awt.Color(255, 255, 255));
        BtnJugarPartido.setText("Jugar Partido");
        BtnJugarPartido.addActionListener(this::BtnJugarPartidoActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(btnProgramasPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TlParticipante, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, 175, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnActualizarEvento1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addComponent(btnEliminarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addComponent(BtnJugarPartido))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(311, 311, 311)
                                .addComponent(TabParticipantes)))
                        .addGap(0, 165, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TlParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProgramasPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarEvento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnJugarPartido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TabParticipantes)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProgramasPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramasPartidoActionPerformed
    String local = jComboBox1.getSelectedItem().toString();
    String visitante = jComboBox2.getSelectedItem().toString();
    String fecha = TlParticipante.getText();

    Partido p = new Partido(local, visitante);
    p.setFecha(fecha);

    controlador.agregarPartido(p);

    mostrarPartidos();
    }//GEN-LAST:event_btnProgramasPartidoActionPerformed

    private void btnActualizarEvento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEvento1ActionPerformed
       
    }//GEN-LAST:event_btnActualizarEvento1ActionPerformed

    private void btnEliminarParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarParticipanteActionPerformed
    Partido eliminado = controlador.desencolar();

    if (eliminado != null) {
        System.out.println("Se jugó/eliminó: " 
            + eliminado.getEquipoLocal() + " vs " 
            + eliminado.getEquipoVisitante());
    }
    mostrarPartidos();
    }//GEN-LAST:event_btnEliminarParticipanteActionPerformed

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
        
        new VistaMenuAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    private void BtnJugarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJugarPartidoActionPerformed
    Partido jugado = controlador.desencolar();
    if (jugado != null) {
        System.out.println("Se jugó: " + jugado.getEquipoLocal() + " vs " + jugado.getEquipoVisitante());
    }
    mostrarPartidos();
    }//GEN-LAST:event_BtnJugarPartidoActionPerformed

 public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> new VistaPartidos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnJugarPartido;
    private javax.swing.JLabel TabParticipantes;
    private javax.swing.JTable TablaEventos;
    private javax.swing.JTextField TlParticipante;
    private java.awt.Button btnActualizarEvento1;
    private java.awt.Button btnEliminarParticipante;
    private java.awt.Button btnProgramasPartido;
    private java.awt.Button btnVolverMenu;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
