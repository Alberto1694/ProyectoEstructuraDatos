/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class ListaParticipantes {
    private NodoDoble inicio;
    private NodoDoble fin;

    public ListaParticipantes() {
        inicio = null;
        fin = null;
    }
    //para agregar participante
    public void insertar(Participante p) {
        NodoDoble nuevo = new NodoDoble(p);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
    }

    public NodoDoble getInicio() {
        return inicio;
    }
    //para eliminar participante
    public void eliminar(String nombre) {
        NodoDoble actual = inicio;

        while (actual != null) {
            Participante p = (Participante) actual.getDato();

            if (p.getNombre().equalsIgnoreCase(nombre)) {

                if (actual == inicio) {
                    inicio = actual.getSiguiente();
                    if (inicio != null) inicio.setAnterior(null);
                } else if (actual == fin) {
                    fin = actual.getAnterior();
                    if (fin != null) fin.setSiguiente(null);
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return;
            }
            actual = actual.getSiguiente();
        }
    }
    
    public Participante buscarRecursivo(String nombre) {
        return buscarRecursivoAux(inicio, nombre);
    }
    
    private Participante buscarRecursivoAux(NodoDoble actual, String nombre) {
        if (actual == null) {
            return null;
        }
        
        Participante p = (Participante) actual.getDato();
        if (p.getNombre().equalsIgnoreCase(nombre)) {
            return p;
        }
        
        return buscarRecursivoAux(actual.getSiguiente(), nombre);
    }
}