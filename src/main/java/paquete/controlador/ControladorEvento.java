/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.controlador;

import paquete.modelo.Evento;
import paquete.modelo.ListaEventos;
import paquete.modelo.Nodo;
/**
 *
 * @author maria
 */
public class ControladorEvento {
    private static ListaEventos lista;
    private static int siguienteId = 1;
    
    public ControladorEvento(){
        if (lista == null) {
            lista = new ListaEventos();
        }
    }
    public void agregarEvento(Evento e){
        Evento nuevo = new Evento(siguienteId, e.getNombreEvento(), e.getFecha(), e.getUbicacion());
        lista.agregar(nuevo);
        siguienteId++;
    }
    public Nodo getEventos(){
        return lista.getInicio();
    }
    public void eliminarEvento(int id) {
    lista.eliminar(id);
}
}
