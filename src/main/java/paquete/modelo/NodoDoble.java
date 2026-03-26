/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class NodoDoble 
{
    private Object dato; 
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }


    
    
}
