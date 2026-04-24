/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.proyectoestructuradatos;

import paquete.modelo.GrafoEquipos;
import paquete.vista.VistaPrincipal;

public class ProyectoEstructuraDatos {

    public static GrafoEquipos grafo = new GrafoEquipos();// Seria el grafo, para vistaGrafo
    public static int idEventoActual = 1; // evento que se usa

    public static void main(String[] args) {
        // Se inicia en la pestalla vistaPrincipal
        java.awt.EventQueue.invokeLater(() -> {
            new VistaPrincipal().setVisible(true);
        });
    }
}


// recordatorio, creo que ya borre los datos quemados de los Txt, pero si todavia le salen, solo van y lo eliminan en la carpeta original, creo que ya no debe de salir.