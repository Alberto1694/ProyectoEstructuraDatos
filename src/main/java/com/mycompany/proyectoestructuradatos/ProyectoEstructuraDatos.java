package com.mycompany.proyectoestructuradatos;

import paquete.modelo.GrafoEquipos;
import paquete.vista.VistaPrincipal;

public class ProyectoEstructuraDatos {

    public static GrafoEquipos grafo = new GrafoEquipos();

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            new VistaPrincipal().setVisible(true);
        });
    }
}
