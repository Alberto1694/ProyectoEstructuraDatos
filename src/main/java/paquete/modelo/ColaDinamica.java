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

    public ColaDinamica() {
        frente = null;
        fin = null;
    }

    public void encolar(Partido p) {
        Nodo nuevo = new Nodo(p);
        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public Partido desencolar() {
        if (frente == null) return null;
        Partido dato = (Partido) frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return dato;
    }

    public Nodo getFrente() {
        return frente;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
