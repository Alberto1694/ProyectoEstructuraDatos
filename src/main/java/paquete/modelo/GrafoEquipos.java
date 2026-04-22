/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

/**
 *
 * @author Derek
 */
public class GrafoEquipos {
    // aqui se guardan todos los equipos como una lista enlazada
    private Nodo listaVertices;
    private int cantidadEquipos;

    public GrafoEquipos() {
        this.listaVertices = null;
        this.cantidadEquipos = 0;
    }

    // mete un equipo nuevo al grafo
    public void agregarEquipo(Equipo e) {
        // cada vertice es un arreglo de 2: el equipo y sus conexiones
        Object[] vertice = new Object[2];
        vertice[0] = e;
        vertice[1] = null;

        Nodo nuevo = new Nodo(vertice);
        nuevo.setSiguiente(listaVertices);
        listaVertices = nuevo;
        cantidadEquipos++;
    }

    // busca un equipo dentro del grafo por su id
    private Nodo buscarVertice(int idEquipo) {
        Nodo actual = listaVertices;
        while (actual != null) {
            Object[] vertice = (Object[]) actual.getDato();
            Equipo eq = (Equipo) vertice[0];
            if (eq.getIdEquipo() == idEquipo) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // une dos equipos, o sea que jugaron entre ellos
    public void conectarEquipos(Equipo A, Equipo B) {
        Nodo verticeA = buscarVertice(A.getIdEquipo());
        Nodo verticeB = buscarVertice(B.getIdEquipo());

        // si alguno no existe no hace nada
        if (verticeA == null || verticeB == null) {
            return;
        }

        // le agrega B como rival de A
        Object[] datosA = (Object[]) verticeA.getDato();
        Nodo nuevaConA = new Nodo(B);
        nuevaConA.setSiguiente((Nodo) datosA[1]);
        datosA[1] = nuevaConA;

        // le agrega A como rival de B
        Object[] datosB = (Object[]) verticeB.getDato();
        Nodo nuevaConB = new Nodo(A);
        nuevaConB.setSiguiente((Nodo) datosB[1]);
        datosB[1] = nuevaConB;
    }

    // dice si no hay ningun equipo todavia
    public boolean estaVacia() {
        return listaVertices == null;
    }

    // revisa si dos equipos ya jugaron
    public boolean existeConexion(int idA, int idB) {
        Nodo vertice = buscarVertice(idA);
        if (vertice == null) {
            return false;
        }
        Object[] datos = (Object[]) vertice.getDato();
        Nodo conexion = (Nodo) datos[1];

        while (conexion != null) {
            Equipo eq = (Equipo) conexion.getDato();
            if (eq.getIdEquipo() == idB) {
                return true;
            }
            conexion = conexion.getSiguiente();
        }
        return false;
    }

    // imprime contra quien ha jugado un equipo
    public void mostrarEquiposConectados(int idEquipo) {
        Nodo vertice = buscarVertice(idEquipo);
        if (vertice == null) {
            System.out.println("Equipo no existe");
            return;
        }
        Object[] datos = (Object[]) vertice.getDato();
        Equipo equipo = (Equipo) datos[0];
        Nodo conexion = (Nodo) datos[1];

        System.out.println("Rivales de " + equipo.getNombreEquipo() + ":");
        boolean tiene = false;
        while (conexion != null) {
            Equipo eq = (Equipo) conexion.getDato();
            System.out.println("  - " + eq.getNombreEquipo());
            tiene = true;
            conexion = conexion.getSiguiente();
        }
        if (!tiene) {
            System.out.println("  No ha jugado con nadie");
        }
    }

    // cuenta con cuantos equipos ha jugado
    public int cantidadDeConexiones(int idEquipo) {
        Nodo vertice = buscarVertice(idEquipo);
        if (vertice == null) {
            return -1;
        }
        Object[] datos = (Object[]) vertice.getDato();
        Nodo conexion = (Nodo) datos[1];

        int contador = 0;
        while (conexion != null) {
            contador++;
            conexion = conexion.getSiguiente();
        }
        return contador;
    }

    // imprime todo el grafo completo
    public void mostrarGrafo() {
        Nodo actual = listaVertices;
        while (actual != null) {
            Object[] datos = (Object[]) actual.getDato();
            Equipo equipo = (Equipo) datos[0];
            Nodo conexion = (Nodo) datos[1];

            System.out.print(equipo.getNombreEquipo() + " -> ");
            boolean tiene = false;
            while (conexion != null) {
                Equipo eq = (Equipo) conexion.getDato();
                if (tiene) {
                    System.out.print(", ");
                }
                System.out.print(eq.getNombreEquipo());
                tiene = true;
                conexion = conexion.getSiguiente();
            }
            if (!tiene) {
                System.out.print("(solo)");
            }
            System.out.println();
            actual = actual.getSiguiente();
        }
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }
}
