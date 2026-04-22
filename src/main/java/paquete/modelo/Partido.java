/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author maria
 */
public class Partido {
    private String equipoLocal; 
    private String equipoVisitante; 
    private int puntosLocal;
    private int puntosVisitante;
    private String fecha;

    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

   public String getGanador() {

        if (puntosLocal > puntosVisitante) {
            return equipoLocal;
        } else if (puntosVisitante > puntosLocal) {
            return equipoVisitante;
        } else {
            return "Empate";
        }
    }

    @Override
    public String toString() {
        return "Partido{" + "equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", puntosLocal=" + puntosLocal + ", puntosVisitante=" + puntosVisitante + ", fecha=" + fecha + '}';
    }
    


    
}
