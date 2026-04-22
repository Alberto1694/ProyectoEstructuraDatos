/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
/*
Se utilizará para programar partidos.
Funcionará bajo principio FIFO.
El primer partido programado será el primero en jugarse.
*/
public class ColaDinamica {

    private Nodo frente;
    private Nodo fin;
    private int tamanio;

    public ColaDinamica() {
        frente = null;
        fin = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Object dato) {

        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        tamanio++;
    }

    public Object desencolar() {

        if (estaVacia()) {
            return null;
        }

        Object dato = frente.getDato();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        tamanio--;
        return dato;
    }

    public Object verFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getDato();
    }

    public int getTamanio() {
        return tamanio;
    }

    public void imprimirCola() {

        Nodo aux = frente;

        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }
}
