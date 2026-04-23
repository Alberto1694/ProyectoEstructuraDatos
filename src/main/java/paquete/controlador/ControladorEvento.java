/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.controlador;

import paquete.modelo.Evento;
import paquete.modelo.ListaEventos;
import paquete.modelo.Nodo;
import paquete.modelo.NodoDoble;
import paquete.modelo.Participante;
import paquete.modelo.Partido;
import paquete.modelo.Sistema;

/**
 *
 * @author maria
 */
public class ControladorEvento {
    private static ListaEventos lista;
    private static int siguienteIdEvento = 1;
    private static int siguienteIdParticipante = 1;
    private static int siguienteIdEquipo = 1;

    private static final Sistema persistencia = new Sistema("datos.json");
    private static boolean cargado = false;

    public ControladorEvento() {
        inicializar();
    }

    private void inicializar() {
        if (!cargado) {
            lista = persistencia.cargar();
            if (lista == null) {
                lista = new ListaEventos();
            }
            recalcularIds();
            cargado = true;
        }
    }

    public void agregarEvento(Evento e) {
        Evento nuevo = new Evento(siguienteIdEvento, e.getNombreEvento(), e.getFecha(), e.getUbicacion());
        lista.agregar(nuevo);
        siguienteIdEvento++;
        guardarCambios();
    }

    public Nodo getEventos() {
        return lista.getInicio();
    }

    public Evento buscarEvento(int id) {
        return lista.buscarPorId(id);
    }

    public void eliminarEvento(int id) {
        lista.eliminar(id);
        guardarCambios();
    }

    public boolean actualizarEvento(int id, String nombre, String fecha, String ubicacion) {
        Evento e = buscarEvento(id);
        if (e == null) {
            return false;
        }
        e.setNombreEvento(nombre);
        e.setFecha(fecha);
        e.setUbicacion(ubicacion);
        guardarCambios();
        return true;
    }

    public int generarIdParticipante() {
        int id = siguienteIdParticipante;
        siguienteIdParticipante++;
        return id;
    }

    public int generarIdEquipo() {
        int id = siguienteIdEquipo;
        siguienteIdEquipo++;
        return id;
    }

    public void guardarCambios() {
        persistencia.guardar(lista);
    }

    public String detalleEvento(int idEvento) {
        Evento e = buscarEvento(idEvento);
        if (e == null) {
            return "Evento no encontrado.";
        }

        String texto = e.resumen() + "\n\nParticipantes:\n";
        NodoDoble p = e.getListaParticipantes().getInicio();
        if (p == null) {
            texto += "Sin participantes.\n";
        }
        while (p != null) {
            Participante par = (Participante) p.getDato();
            String eq = "";
            if (par.getEquipo() != null) {
                eq = par.getEquipo().getNombreEquipo();
            }
            texto += par.getNombre() + " | Edad: " + par.getEdad() + " | Equipo: " + eq + "\n";
            p = p.getSiguiente();
        }

        texto += "\nCalendario:\n";
        Nodo c = e.getColaPartidos().getFrente();
        if (c == null) {
            texto += "Sin partidos programados.\n";
        }
        while (c != null) {
            Partido pa = (Partido) c.getDato();
            texto += pa.getEquipoLocal() + " vs " + pa.getEquipoVisitante() + " | " + pa.getFecha() + "\n";
            c = c.getSiguiente();
        }

        texto += "\nResultados:\n";
        Nodo r = e.getPilaResultados().getTope();
        if (r == null) {
            texto += "Sin resultados registrados.\n";
        }
        while (r != null) {
            Partido pr = (Partido) r.getDato();
            texto += pr.getEquipoLocal() + " " + pr.getPuntosLocal() + " - " + pr.getPuntosVisitante() + " " + pr.getEquipoVisitante() + "\n";
            r = r.getSiguiente();
        }

        return texto;
    }

    private void recalcularIds() {
        siguienteIdEvento = 1;
        siguienteIdParticipante = 1;
        siguienteIdEquipo = 1;

        Nodo ev = lista.getInicio();
        while (ev != null) {
            Evento e = (Evento) ev.getDato();
            if (e.getIdEvento() >= siguienteIdEvento) {
                siguienteIdEvento = e.getIdEvento() + 1;
            }

            NodoDoble p = e.getListaParticipantes().getInicio();
            while (p != null) {
                Participante part = (Participante) p.getDato();
                if (part.getIdParticipante() >= siguienteIdParticipante) {
                    siguienteIdParticipante = part.getIdParticipante() + 1;
                }
                if (part.getEquipo() != null && part.getEquipo().getIdEquipo() >= siguienteIdEquipo) {
                    siguienteIdEquipo = part.getEquipo().getIdEquipo() + 1;
                }
                p = p.getSiguiente();
            }

            ev = ev.getSiguiente();
        }
    }
}
