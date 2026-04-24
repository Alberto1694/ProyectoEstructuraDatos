/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.controlador;

import com.mycompany.proyectoestructuradatos.ProyectoEstructuraDatos;
import paquete.modelo.ListaParticipantes;
import paquete.modelo.NodoDoble;
import paquete.modelo.Participante;
import paquete.modelo.Equipo;
import java.io.*;
import paquete.modelo.Evento;

public class ControladorParticipante {

    private static ListaParticipantes lista;
    private final String archivo = "participantes.txt";

    public ControladorParticipante() {
        if (lista == null) {
            lista = new ListaParticipantes();
            cargarDesdeArchivo();
        }
    }

    public void agregarParticipante(Participante p) { // agrega los participantes, tambein hace una gestion para agreagrlo por el evento
        
        lista.insertar(p);
        guardarEnArchivo();
        
        ControladorEvento ce = new ControladorEvento();
        Evento evento = ce.buscarEvento(ProyectoEstructuraDatos.idEventoActual);
        
        if (evento!= null){
            evento.getListaParticipantes().insertar(p);
            ce.guardarCambios();
            
            
        }
        
    }

    public NodoDoble getParticipantes() {
        return lista.getInicio();
    }

    public void eliminarParticipante(String nombre) {
        lista.eliminar(nombre);
        guardarEnArchivo();
    }

    public Participante buscarParticipanteRecursivo(String nombre) {
        return lista.buscarRecursivo(nombre);
    }

    public int generarIdEquipo() {
        int mayor = 0;

        NodoDoble aux = lista.getInicio();

        while (aux != null) {
            Participante p = (Participante) aux.getDato();

            if (p.getEquipo() != null && p.getEquipo().getIdEquipo() > mayor) {
                mayor = p.getEquipo().getIdEquipo();
            }

            aux = aux.getSiguiente();
        }

        return mayor + 1;
    }

    private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            NodoDoble aux = lista.getInicio();

            while (aux != null) {
                Participante p = (Participante) aux.getDato();

                int idEquipo = 0;
                String nombreEquipo = "";

                if (p.getEquipo() != null) {
                    idEquipo = p.getEquipo().getIdEquipo();
                    nombreEquipo = p.getEquipo().getNombreEquipo();
                }

                bw.write(
                        p.getNombre() + "," +
                        p.getEdad() + "," +
                        idEquipo + "," +
                        nombreEquipo
                );

                bw.newLine();
                aux = aux.getSiguiente();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarDesdeArchivo() {
        try {
            File file = new File(archivo);

            if (!file.exists()) {
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(",");

                Participante p = new Participante();
                p.setNombre(partes[0]);
                p.setEdad(Integer.parseInt(partes[1]));

                Equipo equipo = new Equipo();

                if (partes.length >= 4) {
                    equipo.setIdEquipo(Integer.parseInt(partes[2]));
                    equipo.setNombreEquipo(partes[3]);
                } else {
                    equipo.setIdEquipo(generarIdEquipo());
                    equipo.setNombreEquipo(partes[2]);
                }

                p.setEquipo(equipo);
                lista.insertar(p);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}