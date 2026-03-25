/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class Participante {

    private int idParticipante;
    private String nombre;
    private int edad;
    private Equipo equipo;

    public Participante() {
    }

    public void registrarParticipante() {
        System.out.println("Participante registrado");
    }

    public void actualizarParticipante() {
        System.out.println("Participante actualizado");
    }

    public void eliminarParticipante() {
        System.out.println("Participante eliminado");
    }

    public void mostrarParticipante() {
        System.out.println("ID Participante: " + idParticipante);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Equipo: " + equipo);
    }
}
