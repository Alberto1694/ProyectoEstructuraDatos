/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class Evento {

    private int idEvento;
    private String nombreEvento;
    private String fecha;
    private String ubicacion;
    private ListaParticipantes listaParticipantes;
    private ColaDinamica colaPartidos;
    private PilaDinamica pilaResultados;

    public Evento() {
    }

    public void registrarEvento() {
        System.out.println("Evento registrado");
    }

    public void actualizarEvento() {
        System.out.println("Evento actualizado");
    }

    public void eliminarEvento() {
        System.out.println("Evento eliminado");
    }

    public void mostrarEvento() {
        System.out.println("ID Evento: " + idEvento);
        System.out.println("Nombre Evento: " + nombreEvento);
        System.out.println("Fecha: " + fecha);
        System.out.println("Ubicación: " + ubicacion);
    }
}
