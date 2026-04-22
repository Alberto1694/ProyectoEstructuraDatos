package com.mycompany.proyectoestructuradatos;

import paquete.modelo.GrafoEquipos;
import paquete.modelo.Equipo;
import paquete.vista.VistaGrafo;

public class ProyectoEstructuraDatos {

    // grafo global para usar en vistas
    public static GrafoEquipos grafo = new GrafoEquipos();

    public static void main(String[] args) {

        // crea equipos
        Equipo e1 = new Equipo(1, "Real Madrid", "Ancelotti", 25);
        Equipo e2 = new Equipo(2, "Barcelona", "Xavi", 24);
        Equipo e3 = new Equipo(3, "PSG", "Luis Enrique", 23);
        Equipo e4 = new Equipo(4, "Bayern", "Tuchel", 26);

        // agregar al grafo
        grafo.agregarEquipo(e1);
        grafo.agregarEquipo(e2);
        grafo.agregarEquipo(e3);
        grafo.agregarEquipo(e4);

        // conectar equipos
        grafo.conectarEquipos(e1, e2);
        grafo.conectarEquipos(e1, e3);
        grafo.conectarEquipos(e2, e4);

        // abrir ventana del grafo
        java.awt.EventQueue.invokeLater(() -> {
            new VistaGrafo().setVisible(true);
        });
    }
}
