/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class Partido {

    private int idPartido;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String marcador;

    public Partido() {
    }

    public void crearPartido() {
        System.out.println("Partido creado");
    }

    public void registrarResultado() {
        System.out.println("Resultado registrado: " + marcador);
    }

    public void mostrarPartido() {
        System.out.println("ID Partido: " + idPartido);
        System.out.println("Equipo Local: " + equipoLocal);
        System.out.println("Equipo Visitante: " + equipoVisitante);
        System.out.println("Marcador: " + marcador);
    }
}