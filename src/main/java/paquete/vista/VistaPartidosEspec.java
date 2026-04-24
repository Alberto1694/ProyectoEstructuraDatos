/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package paquete.vista;

import javax.swing.table.DefaultTableModel;
import paquete.vista.VistaPrincipal;
import paquete.controlador.ControladorPartido;
import paquete.modelo.Partido;
import paquete.modelo.Nodo;
import paquete.controlador.ControladorParticipante;
import paquete.modelo.NodoDoble;
import paquete.modelo.Participante;

public class VistaPartidosEspec extends javax.swing.JFrame {
    private ControladorPartido controlador;
    private ControladorParticipante controladorParticipante; 
       
    public VistaPartidosEspec() {
        initComponents();
        controlador = new ControladorPartido();
        controladorParticipante = new ControladorParticipante();
        mostrarPartidos();
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
 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnVolverMenu = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEventos = new javax.swing.JTable();
        btnActualizarEvento1 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        btnVolverMenu.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        btnVolverMenu.setLabel("Volver al Menu");
        btnVolverMenu.addActionListener(this::btnVolverMenuActionPerformed);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Calendario de Partidos");

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

        btnActualizarEvento1.setActionCommand("Actualizar Evento");
        btnActualizarEvento1.setBackground(new java.awt.Color(0, 102, 255));
        btnActualizarEvento1.setEnabled(false);
        btnActualizarEvento1.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarEvento1.setLabel("Actualizar");
        btnActualizarEvento1.addActionListener(this::btnActualizarEvento1ActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnVolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(btnActualizarEvento1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(btnVolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarEvento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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

    private void btnActualizarEvento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEvento1ActionPerformed
       
    }//GEN-LAST:event_btnActualizarEvento1ActionPerformed

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
        
        new VistaEspectador().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverMenuActionPerformed

 public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> new VistaPartidosEspec().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEventos;
    private java.awt.Button btnActualizarEvento1;
    private java.awt.Button btnVolverMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
