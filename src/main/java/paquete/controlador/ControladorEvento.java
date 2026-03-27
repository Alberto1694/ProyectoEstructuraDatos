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
    private ListaEventos lista;
    
    public ControladorEvento(){
        lista = new ListaEventos();
    }
    public void agregarEvento(Evento e){
        lista.agregar(e);
    }
    public Nodo getEventos(){
        return lista.getInicio();
    }
    public void eliminarEvento(int id) {
    lista.eliminar(id);
}
}
