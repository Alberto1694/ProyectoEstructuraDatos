/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.controlador;
import paquete.modelo.ListaParticipantes;
import paquete.modelo.NodoDoble;
import paquete.modelo.Participante;
import paquete.modelo.Equipo;
import java.io.*;
/**
 *
 * @author maria
 */
public class ControladorParticipante {
    private static ListaParticipantes lista;
    private final String archivo = "participantes.txt";

    public ControladorParticipante() {
        if (lista==null){
            lista = new ListaParticipantes();
            cargarDesdeArchivo(); 
        }
}

    public void agregarParticipante(Participante p) {
        lista.insertar(p);
        guardarEnArchivo();
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
    
    //para persistencia de datos (guardar y cargar en txt)
    private void guardarEnArchivo() {
    try (BufferedWriter bw = new BufferedWriter (new FileWriter(archivo))){
       
        NodoDoble aux = lista.getInicio();
        while (aux != null) {
            Participante p = (Participante) aux.getDato();
            bw.write(p.getNombre() + "," + p.getEdad() + "," + p.getEquipo().getNombreEquipo());
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
            Participante p = new Participante();
            p.setNombre(partes[0]);
            p.setEdad(Integer.parseInt(partes[1]));
            Equipo equipo = new Equipo();
            equipo.setNombreEquipo(partes[2]);
            p.setEquipo(equipo);
            lista.insertar(p);
        }
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
