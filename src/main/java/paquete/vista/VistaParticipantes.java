package paquete.vista;

import javax.swing.table.DefaultTableModel;
import paquete.vista.VistaPrincipal;
import paquete.controlador.ControladorParticipante;
import paquete.modelo.Participante;
import paquete.modelo.NodoDoble;
import paquete.modelo.Equipo;

public class VistaParticipantes extends javax.swing.JFrame {
    private ControladorParticipante controlador;
    
   
    
    public VistaParticipantes() {
    initComponents();
    controlador = new ControladorParticipante();
    mostrarParticipantes();
}

    private void mostrarParticipantes() {
    DefaultTableModel model = (DefaultTableModel) TablaEventos.getModel();
    model.setRowCount(0);
    NodoDoble aux = controlador.getParticipantes();
    while (aux != null) {
        Participante p = (Participante) aux.getDato();
        model.addRow(new Object[]{
            p.getNombre(),
            p.getEdad(),
            p.getEquipo().getNombreEquipo()
        });
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
        nombreParticipante = new javax.swing.JTextField();
        edadParticipante = new javax.swing.JTextField();
        equipoParticipante = new javax.swing.JTextField();
        btnAgregarParticipante = new java.awt.Button();
        TabParticipantes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnEliminarParticipante = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        btnVolverMenu = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEventos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Edad:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Equipo:");

        nombreParticipante.addActionListener(this::nombreParticipanteActionPerformed);

        equipoParticipante.addActionListener(this::equipoParticipanteActionPerformed);

        btnAgregarParticipante.setActionCommand("Agregar");
        btnAgregarParticipante.setBackground(new java.awt.Color(51, 255, 51));
        btnAgregarParticipante.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarParticipante.setLabel("Agregar Participantes");
        btnAgregarParticipante.addActionListener(this::btnAgregarParticipanteActionPerformed);

        TabParticipantes.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        TabParticipantes.setText("Lista de Participantes");

        btnEliminarParticipante.setActionCommand("Eliminar Evento");
        btnEliminarParticipante.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarParticipante.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarParticipante.setLabel("Eliminar Participante");
        btnEliminarParticipante.addActionListener(this::btnEliminarParticipanteActionPerformed);

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        btnVolverMenu.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        btnVolverMenu.setLabel("Volver al Menu");
        btnVolverMenu.addActionListener(this::btnVolverMenuActionPerformed);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestionar Participantes");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(TabParticipantes))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnAgregarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(153, 153, 153)
                                        .addComponent(btnEliminarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(72, 72, 72)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(nombreParticipante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(edadParticipante, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(equipoParticipante, javax.swing.GroupLayout.Alignment.LEADING))))))
                        .addGap(0, 300, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edadParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(equipoParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabParticipantes)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
        );

        TablaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Edad", "Equipo"
            }
        ));
        jScrollPane2.setViewportView(TablaEventos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreParticipanteActionPerformed
        String nombre = nombreParticipante.getText();
    
        String edadTexto = edadParticipante.getText();
        String nombreEquipo = equipoParticipante.getText();

        if (nombre.isEmpty() || edadTexto.isEmpty() || nombreEquipo.isEmpty()) {
            System.out.println("Debe llenar todos los campos");
            return;
        }

        try {
             int edad = Integer.parseInt(edadTexto);

        
             Equipo equipo = new Equipo();
             equipo.setIdEquipo(controlador.generarIdEquipo());
             equipo.setNombreEquipo(nombreEquipo);

            Participante p = new Participante();
            p.setNombre(nombre);
            p.setEdad(edad);
            p.setEquipo(equipo);

            controlador.agregarParticipante(p);

            mostrarParticipantes();

            nombreParticipante.setText("");
            edadParticipante.setText("");
            equipoParticipante.setText("");

            System.out.println("Participante agregado");

        } catch (NumberFormatException e) {
                System.out.println("La edad debe ser un numero");
        }
    }//GEN-LAST:event_nombreParticipanteActionPerformed

    private void btnAgregarParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarParticipanteActionPerformed
        String nombre = nombreParticipante.getText();
        String edadTexto = edadParticipante.getText();
        String nombreEquipo = equipoParticipante.getText();

        if (nombre.isEmpty() || edadTexto.isEmpty() || nombreEquipo.isEmpty()) {
           System.out.println("Debe llenar todos los campos");
        return;
        }

        try {
            int edad = Integer.parseInt(edadTexto);

        
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(controlador.generarIdEquipo());
            equipo.setNombreEquipo(nombreEquipo);

            Participante p = new Participante();
            p.setNombre(nombre);
            p.setEdad(edad);
            p.setEquipo(equipo);

            controlador.agregarParticipante(p);

            mostrarParticipantes();

            nombreParticipante.setText("");
            edadParticipante.setText("");
            equipoParticipante.setText("");

            System.out.println("Participante agregado");

        } catch (NumberFormatException e) {
            System.out.println("La edad debe ser un numero");
        }


    }//GEN-LAST:event_btnAgregarParticipanteActionPerformed

    private void btnEliminarParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarParticipanteActionPerformed
      int fila = TablaEventos.getSelectedRow();

    if (fila == -1) return;

    String nombre = TablaEventos.getValueAt(fila, 0).toString();

    controlador.eliminarParticipante(nombre);

    mostrarParticipantes();
    }//GEN-LAST:event_btnEliminarParticipanteActionPerformed

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
      
        new VistaMenuAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    private void equipoParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipoParticipanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipoParticipanteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VistaParticipantes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TabParticipantes;
    private javax.swing.JTable TablaEventos;
    private java.awt.Button btnAgregarParticipante;
    private java.awt.Button btnEliminarParticipante;
    private java.awt.Button btnVolverMenu;
    private javax.swing.JTextField edadParticipante;
    private javax.swing.JTextField equipoParticipante;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nombreParticipante;
    // End of variables declaration//GEN-END:variables
}
