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
        listaParticipantes = new ListaParticipantes();
        colaPartidos = new ColaDinamica();
        pilaResultados = new PilaDinamica();
    }

    public Evento(int idEvento, String nombreEvento, String fecha, String ubicacion) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.listaParticipantes = new ListaParticipantes();
        this.colaPartidos = new ColaDinamica();
        this.pilaResultados = new PilaDinamica();
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ListaParticipantes getListaParticipantes() {
        return listaParticipantes;
    }

    public ColaDinamica getColaPartidos() {
        return colaPartidos;
    }

    public PilaDinamica getPilaResultados() {
        return pilaResultados;
    }

    public String resumen() {
        return "ID: " + idEvento + " | " + nombreEvento + " | Fecha: " + fecha + " | Ubicación: " + ubicacion;
    }
}
