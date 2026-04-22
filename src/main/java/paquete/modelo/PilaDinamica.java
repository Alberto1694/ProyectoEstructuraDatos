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
Se utilizará para almacenar resultados.
Funcionará bajo principio LIFO.
El resultado más reciente será el primero en mostrarse.
*/
public class PilaDinamica {

    private Nodo tope;

    // Constructor
    public PilaDinamica() {
        tope = null;
    }
    //get y set

    public Nodo getTope() {
        return tope;
    }

    public void setTope(Nodo tope) {
        this.tope = tope;
    }
    

    // Apilar
    public void apilar(Partido p) {

        Nodo nuevo = new Nodo(p);

        nuevo.setSiguiente(tope);

        tope = nuevo;
    }

    // Desapilar
    public Partido desapilar() {

        if (estaVacia()) {
            return null;
        }

        Partido dato = (Partido) tope.getDato();

        tope = tope.getSiguiente();

        return dato;
    }

    // Ver tope
    public Partido verTope() {

        if (estaVacia()) {
            return null;
        }

        return (Partido) tope.getDato();
    }

    // Verificar si está vacía
    public boolean estaVacia() {

        if (tope == null) {
            return true;
        } else {
            return false;
        }
    }

    // Contar elementos
    public int contar() {

        int contador = 0;

        Nodo actual = tope;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }

}
