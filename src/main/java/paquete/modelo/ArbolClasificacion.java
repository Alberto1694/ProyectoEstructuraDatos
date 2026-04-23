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
        texto += nodo.equipo.getNombreEquipo()
            + "|" + nodo.equipo.getPartidosJugados()
            + "|" + nodo.equipo.getVictorias()
            + "|" + nodo.equipo.getDerrotas()
            + "|" + nodo.equipo.getPuntos()
            + "\n";
        texto = recorrerDesc(nodo.izquierda, texto);
        return texto;
    }

    public boolean estaVacia() {
        return raiz == null;
    }   
  
}
