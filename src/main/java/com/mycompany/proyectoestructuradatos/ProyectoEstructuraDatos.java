package com.mycompany.proyectoestructuradatos;
 
import paquete.vista.VistaPrincipal;
import paquete.modelo.GrafoEquipos;
import paquete.modelo.Equipo;
 
/**
 *
 * @author maria
 */
public class ProyectoEstructuraDatos {
 
    // el grafo se guarda aqui para que cualquier vista lo pueda usar
    public static GrafoEquipos grafo;
 
    public static void main(String[] args) {
 
        // creamos el grafo
        grafo = new GrafoEquipos();
 
        // creamos los equipos
        Equipo eq1 = new Equipo(1, "Equipo 1", "DT 1", 11);
        Equipo eq2 = new Equipo(2, "Equipo 2", "DT 2", 11);
        Equipo eq3 = new Equipo(3, "Equipo 3", "DT 3", 11);
        Equipo eq4 = new Equipo(4, "Equipo 4", "DT 4", 11);
        Equipo eq5 = new Equipo(5, "Equipo 5", "DT 5", 11);
        Equipo eq6 = new Equipo(6, "Equipo 6", "DT 6", 11);
        Equipo eq7 = new Equipo(7, "Equipo 7", "DT 7", 11);
        Equipo eq8 = new Equipo(8, "Equipo 8", "DT 8", 11);
 
        // los metemos al grafo
        grafo.agregarEquipo(eq1);
        grafo.agregarEquipo(eq2);
        grafo.agregarEquipo(eq3);
        grafo.agregarEquipo(eq4);
        grafo.agregarEquipo(eq5);
        grafo.agregarEquipo(eq6);
        grafo.agregarEquipo(eq7);
        grafo.agregarEquipo(eq8);
 
        // conectamos los que ya jugaron (los partidos de VistaPartidos)
        grafo.conectarEquipos(eq1, eq8);
        grafo.conectarEquipos(eq2, eq7);
        grafo.conectarEquipos(eq3, eq6);
        grafo.conectarEquipos(eq4, eq5);
 
        // abrimos la ventana principal
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }
}
 
