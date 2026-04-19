/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class ArbolClasificacion {
    
    private class NodoClasificacion {
        private Equipo equipo;
        private NodoClasificacion izquierda;
        private NodoClasificacion derecha;

        NodoClasificacion(Equipo equipo) {
            this.equipo = equipo;
        }
    }

    private NodoClasificacion raiz;

    public ArbolClasificacion() {
        raiz = null;
    }

    public void agregar(Equipo e) {
        if (e == null) {
            return;
        }
        raiz = insertar(raiz, e);
    }

    private NodoClasificacion insertar(NodoClasificacion actual, Equipo e) {
        if (actual == null) {
            return new NodoClasificacion(e);
        }

        if (esMenor(e, actual.equipo)) {
            actual.izquierda = insertar(actual.izquierda, e);
        } else if (esMayor(e, actual.equipo)) {
            actual.derecha = insertar(actual.derecha, e);
        } else {
            actual.equipo = e;
        }
        return actual;
    }

    public void actualizar(Equipo e) {
        eliminar(e);
        agregar(e);
    }

    public void eliminar(Equipo e) {
        if (e == null) {
            return;
        }
        raiz = eliminar(raiz, e);
    }

    private NodoClasificacion eliminar(NodoClasificacion actual, Equipo e) {
        if (actual == null) {
            return null;
        }

        if (esMenor(e, actual.equipo)) {
            actual.izquierda = eliminar(actual.izquierda, e);
            return actual;
        }

        if (esMayor(e, actual.equipo)) {
            actual.derecha = eliminar(actual.derecha, e);
            return actual;
        }

        if (actual.izquierda == null) {
            return actual.derecha;
        }
        if (actual.derecha == null) {
            return actual.izquierda;
        }

        NodoClasificacion sucesor = minimo(actual.derecha);
        actual.equipo = sucesor.equipo;
        actual.derecha = eliminar(actual.derecha, sucesor.equipo);
        return actual;
    }

    private NodoClasificacion minimo(NodoClasificacion nodo) {
        NodoClasificacion actual = nodo;
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual;
    }

    private boolean esMenor(Equipo a, Equipo b) {
        if (a.getVictorias() < b.getVictorias()) {
            return true;
        }
        if (a.getVictorias() > b.getVictorias()) {
            return false;
        }
        return a.getNombreEquipo().compareToIgnoreCase(b.getNombreEquipo()) < 0;
    }

    private boolean esMayor(Equipo a, Equipo b) {
        if (a.getVictorias() > b.getVictorias()) {
            return true;
        }
        if (a.getVictorias() < b.getVictorias()) {
            return false;
        }
        return a.getNombreEquipo().compareToIgnoreCase(b.getNombreEquipo()) > 0;
    }

    public String recorrerDesc() {
        return recorrerDesc(raiz, "");
    }

    private String recorrerDesc(NodoClasificacion nodo, String texto) {
        if (nodo == null) {
            return texto;
        }
        texto = recorrerDesc(nodo.derecha, texto);
        texto += nodo.equipo.getNombreEquipo() + " - Victorias: " + nodo.equipo.getVictorias() + "\n";
        texto = recorrerDesc(nodo.izquierda, texto);
        return texto;
    }

    public boolean estaVacia() {
        return raiz == null;
    }   
  
}
