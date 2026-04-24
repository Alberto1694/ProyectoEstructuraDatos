/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package paquete.vista;

import javax.swing.table.DefaultTableModel;
import paquete.controlador.ControladorPartido;
import paquete.modelo.Nodo;
import paquete.modelo.Partido;

public class VistaClasificacion extends javax.swing.JFrame {

    private ControladorPartido controlador;

    public VistaClasificacion() {
        initComponents();
        controlador = new ControladorPartido(); // controlador para traer los resultados
        cargarClasificacion(); // carga la tabla apenas abre
    }

    // metodo que arma la tabla de clasificacion
    private void cargarClasificacion() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // limpia la tabla antes de llenarla

        // arreglos para guardar los datos de cada equipo
        String[] nombres = new String[100];
        int[] pj = new int[100]; // partidos jugados
        int[] pg = new int[100]; // ganados
        int[] pp = new int[100]; // perdidos
        int[] pts = new int[100]; // puntos

        int cantidad = 0; // cuantos equipos hay

        Nodo aux = controlador.getResultados(); // trae los resultados guardados

        // recorre todos los resultados
        while (aux != null) {

            Partido p = (Partido) aux.getDato();

            String local = p.getEquipoLocal();
            String visitante = p.getEquipoVisitante();

            int puntosLocal = p.getPuntosLocal();
            int puntosVisitante = p.getPuntosVisitante();

            // busca si el equipo local ya existe
            int posLocal = buscarEquipo(nombres, cantidad, local);

            // si no existe lo agrega
            if (posLocal == -1) {
                nombres[cantidad] = local;
                posLocal = cantidad;
                cantidad++;
            }

            // mismo proceso para visitante
            int posVisitante = buscarEquipo(nombres, cantidad, visitante);

            if (posVisitante == -1) {
                nombres[cantidad] = visitante;
                posVisitante = cantidad;
                cantidad++;
            }

            // suma partidos jugados
            pj[posLocal]++;
            pj[posVisitante]++;

            // logica de puntos
            if (puntosLocal > puntosVisitante) {
                pg[posLocal]++;
                pp[posVisitante]++;
                pts[posLocal] += 3;
            } else if (puntosVisitante > puntosLocal) {
                pg[posVisitante]++;
                pp[posLocal]++;
                pts[posVisitante] += 3;
            } else {
                // empate
                pts[posLocal]++;
                pts[posVisitante]++;
            }

            aux = aux.getSiguiente();
        }

        // ordena los equipos por puntos
        ordenar(nombres, pj, pg, pp, pts, cantidad);

        // mete los datos a la tabla
        for (int i = 0; i < cantidad; i++) {
            model.addRow(new Object[]{
                i + 1,
                nombres[i],
                pj[i],
                pg[i],
                pp[i],
                pts[i]
            });
        }
    }

    // busca si un equipo ya existe en el arreglo
    private int buscarEquipo(String[] nombres, int cantidad, String nombre) {

        for (int i = 0; i < cantidad; i++) {
            if (nombres[i].equals(nombre)) {
                return i;
            }
        }

        return -1;
    }

    // ordena los equipos por puntos (de mayor a menor)
    private void ordenar(String[] nombres, int[] pj, int[] pg, int[] pp, int[] pts, int cantidad) {

        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = i + 1; j < cantidad; j++) {

                if (pts[j] > pts[i]) {

                    // intercambia todo para mantener los datos correctos
                    String tempNombre = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = tempNombre;

                    int temp = pj[i];
                    pj[i] = pj[j];
                    pj[j] = temp;

                    temp = pg[i];
                    pg[i] = pg[j];
                    pg[j] = temp;

                    temp = pp[i];
                    pp[i] = pp[j];
                    pp[j] = temp;

                    temp = pts[i];
                    pts[i] = pts[j];
                    pts[j] = temp;
                }
            }
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnProgramasPartido = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        btnVolverMenu = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        btnEliminarParticipante2 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnProgramasPartido.setActionCommand("Agregar");
        btnProgramasPartido.setBackground(new java.awt.Color(51, 255, 51));
        btnProgramasPartido.setForeground(new java.awt.Color(255, 255, 255));
        btnProgramasPartido.setLabel("Actualizar Tabla");
        btnProgramasPartido.addActionListener(this::btnProgramasPartidoActionPerformed);

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        btnVolverMenu.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        btnVolverMenu.setLabel("Volver al Menu");
        btnVolverMenu.addActionListener(this::btnVolverMenuActionPerformed);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clasificación General");

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
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(btnVolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnEliminarParticipante2.setActionCommand("Eliminar Evento");
        btnEliminarParticipante2.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarParticipante2.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarParticipante2.setLabel("Cancelar");
        btnEliminarParticipante2.addActionListener(this::btnEliminarParticipante2ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pos", "Nombre", "PJ", "PG", "PP", "PTS"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnProgramasPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminarParticipante2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProgramasPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnEliminarParticipante2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProgramasPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramasPartidoActionPerformed
       cargarClasificacion();
    }//GEN-LAST:event_btnProgramasPartidoActionPerformed

    private void btnEliminarParticipante2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarParticipante2ActionPerformed
        // TODO add your handling code here: 
        this.dispose();
    }//GEN-LAST:event_btnEliminarParticipante2ActionPerformed

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
      
        new VistaMenuAdmin().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VistaClasificacion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnEliminarParticipante2;
    private java.awt.Button btnProgramasPartido;
    private java.awt.Button btnVolverMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
