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
    private int golesLocales; 
    private int golesVisitantes; 

    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocales = 0;
        this.golesVisitantes = 0;
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

    public int getGolesLocales() {
        return golesLocales;
    }

    public void setGolesLocales(int golesLocales) {
        this.golesLocales = golesLocales;
    }

    public int getGolesVisitantes() {
        return golesVisitantes;
    }

    public void setGolesVisitantes(int golesVisitantes) {
        this.golesVisitantes = golesVisitantes;
    }
    
    public void resultado(int golesLocales, int golesVisitantes){
        
        this.golesLocales = golesLocales;
        this.golesVisitantes = golesVisitantes;
    }

    @Override
    public String toString() {
        return equipoLocal + "VS" + equipoVisitante +
                "Resultado"+ golesLocales + "-" + golesVisitantes;
        
    }
    
}
