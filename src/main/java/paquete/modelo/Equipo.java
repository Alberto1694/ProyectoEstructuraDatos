/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class Equipo {

    private int idEquipo;
    private String nombreEquipo;
    private String entrenador;
    private int cantidadJugadores;

    public Equipo() {
    }

    public void registrarEquipo() {
        System.out.println("Equipo registrado");
    }

    public void eliminarEquipo() {
        System.out.println("Equipo eliminado");
    }

    public void mostrarEquipo() {
        System.out.println("ID Equipo: " + idEquipo);
        System.out.println("Nombre Equipo: " + nombreEquipo);
        System.out.println("Entrenador: " + entrenador);
        System.out.println("Cantidad de jugadores: " + cantidadJugadores);
    }
}
