/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.controlador;
import paquete.modelo.ColaDinamica;
import paquete.modelo.PilaDinamica;
import paquete.modelo.Nodo;
import paquete.modelo.Partido;
import java.io.*;
/**
 *
 * @author maria
 */
public class ControladorPartido {
    private static ColaDinamica cola;
    private static PilaDinamica pilaResultados;
    private static boolean datosCargados = false;
    private final String archivo = "partidos.txt";
    private final String archivoResultados = "resultados.txt";
     

    public ControladorPartido() {
        if (!datosCargados) {
            if (cola == null) {
                cola = new ColaDinamica();
            }
            if (pilaResultados == null) {
                pilaResultados = new PilaDinamica();
            }
            cargarDesdeArchivo();
            cargarResultados();
            datosCargados = true;
        } else {
            if (cola == null) {
                cola = new ColaDinamica();
            }
            if (pilaResultados == null) {
                pilaResultados = new PilaDinamica();
            }
        }
    }

    public void agregarPartido(Partido p) {
        cola.encolar(p);
        guardarEnArchivo();
    }

    public Nodo getPartidos() {
        return cola.getFrente();
    }

    public Partido desencolar() {
        Partido p = cola.desencolar();
          if (p != null) {
            pilaResultados.apilar(p);
            guardarResultados();
        }
        guardarEnArchivo();
        return p;
    }
    public Nodo getResultados() {
        return pilaResultados.getTope();
    }
    
    public void registrarResultado(Partido p) {
        pilaResultados.apilar(p);
        guardarResultados();
    }
    
    private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            Nodo aux = cola.getFrente();
            while (aux != null) {
                Partido p = (Partido) aux.getDato();
                bw.write(
                    p.getEquipoLocal() + "," +
                    p.getEquipoVisitante() + "," +
                    p.getFecha()
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
            if (!file.exists()) return;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                Partido p = new Partido(partes[0], partes[1]);
                p.setFecha(partes[2]);
                cola.encolar(p);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void guardarResultados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoResultados))) {
            Nodo aux = pilaResultados.getTope();
            while (aux != null) {
                Partido p = (Partido) aux.getDato();
                bw.write(
                    p.getEquipoLocal() + "," +
                    p.getEquipoVisitante() + "," +
                    p.getPuntosLocal() + "," +
                    p.getPuntosVisitante()
                );
                bw.newLine();
                aux = aux.getSiguiente();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void cargarResultados() {
        try {
            File file = new File(archivoResultados);
            if (!file.exists()) return;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                Partido p = new Partido(partes[0], partes[1]);
                p.setPuntosLocal(Integer.parseInt(partes[2]));
                p.setPuntosVisitante(Integer.parseInt(partes[3]));
                pilaResultados.apilar(p);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
