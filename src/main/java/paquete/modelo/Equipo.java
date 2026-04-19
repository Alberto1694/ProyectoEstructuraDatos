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
    private int partidosJugados;
    private int victorias;
    private int derrotas;
    private int puntos;

    public Equipo() {
        this(0, "", "", 0);
    }

    public Equipo(int idEquipo, String nombreEquipo, String entrenador, int cantidadJugadores) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.entrenador = entrenador;
        this.cantidadJugadores = cantidadJugadores;
        this.partidosJugados = 0;
        this.victorias = 0;
        this.derrotas = 0;
        this.puntos = 0;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarVictoria() {
        partidosJugados++;
        victorias++;
        puntos += 3;
    }

    public void sumarDerrota() {
        partidosJugados++;
        derrotas++;
    }

    public void reiniciarEstadisticas() {
        partidosJugados = 0;
        victorias = 0;
        derrotas = 0;
        puntos = 0;
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

    @Override
    public String toString() {
        return nombreEquipo;
    }
}
