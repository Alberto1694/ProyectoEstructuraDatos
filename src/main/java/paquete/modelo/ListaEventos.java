/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class ListaEventos {
    private Nodo inicio;
    private Nodo fin;
    
    public ListaEventos(){
        inicio = null;
        fin = null;
    }

    public void agregar(Evento e) {
        Nodo nuevo = new Nodo(e);
        if (inicio==null) {
            inicio=nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    public Nodo getInicio(){
        return inicio;
    }

    public void eliminar(int id) {
    if (inicio == null) return;

    if (((Evento)inicio.getDato()).getIdEvento() == id) {
        inicio = inicio.getSiguiente();
        if (inicio == null) fin = null;
        return;
    }
    Nodo actual = inicio;
    Nodo anterior = null;
    while (actual != null) {
        Evento e = (Evento) actual.getDato();
        if (e.getIdEvento() == id) {
            anterior.setSiguiente(actual.getSiguiente());
            if (actual == fin) {
                fin = anterior;
            }
            return;
        }
        anterior = actual;
        actual = actual.getSiguiente();
    }
}

    public boolean estaVacia() {
        return inicio == null;
    }    
}
