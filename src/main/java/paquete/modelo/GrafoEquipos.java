package paquete.modelo;
 
/**
 *
 * @author maria
 */
public class GrafoEquipos {
    // aqui se guardan todos los equipos en una lista enlazada
    private Nodo listaVertices;
    private int cantidadEquipos;
 
    public GrafoEquipos() {
        this.listaVertices = null;
        this.cantidadEquipos = 0;
    }
 
    // mete un equipo nuevo al grafo
    public void agregarEquipo(Equipo e) {
        Object[] vertice = new Object[2];
        vertice[0] = e;
        vertice[1] = null;
 
        Nodo nuevo = new Nodo(vertice);
        nuevo.setSiguiente(listaVertices);
        listaVertices = nuevo;
        cantidadEquipos++;
    }
 
    // busca donde esta un equipo por su id
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
 
    // une dos equipos, quiere decir que jugaron entre ellos
    public void conectarEquipos(Equipo A, Equipo B) {
        Nodo verticeA = buscarVertice(A.getIdEquipo());
        Nodo verticeB = buscarVertice(B.getIdEquipo());
 
        if (verticeA == null || verticeB == null) {
            return;
        }
 
        Object[] datosA = (Object[]) verticeA.getDato();
        Nodo nuevaConA = new Nodo(B);
        nuevaConA.setSiguiente((Nodo) datosA[1]);
        datosA[1] = nuevaConA;
 
        Object[] datosB = (Object[]) verticeB.getDato();
        Nodo nuevaConB = new Nodo(A);
        nuevaConB.setSiguiente((Nodo) datosB[1]);
        datosB[1] = nuevaConB;
    }
 
    // dice si no hay ningun equipo
    public boolean estaVacia() {
        return listaVertices == null;
    }
 
    // revisa si dos equipos ya jugaron entre ellos
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
 
    // dibuja el grafo en el panel que le pasemos
    public void dibujarGrafo(javax.swing.JPanel panel) {
        if (estaVacia()) {
            return;
        }
 
        java.awt.Graphics g = panel.getGraphics();
        int ancho = panel.getWidth();
        int alto = panel.getHeight();
 
        // limpia el panel
        g.setColor(java.awt.Color.WHITE);
        g.fillRect(0, 0, ancho, alto);
 
        int total = cantidadEquipos;
        int centroX = ancho / 2;
        int centroY = alto / 2;
        int radio = Math.min(centroX, centroY) - 60;
 
        // guarda las posiciones de cada equipo
        int[] posX = new int[total];
        int[] posY = new int[total];
        Equipo[] equiposArray = new Equipo[total];
 
        // pone cada equipo en circulo
        Nodo actual = listaVertices;
        int indice = 0;
        while (actual != null) {
            Object[] datos = (Object[]) actual.getDato();
            Equipo equipo = (Equipo) datos[0];
            equiposArray[indice] = equipo;
 
            double angulo = 2 * Math.PI * indice / total - Math.PI / 2;
            posX[indice] = (int) (centroX + radio * Math.cos(angulo));
            posY[indice] = (int) (centroY + radio * Math.sin(angulo));
 
            indice++;
            actual = actual.getSiguiente();
        }
 
        // dibuja las lineas entre los que jugaron
        g.setColor(java.awt.Color.GRAY);
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (existeConexion(equiposArray[i].getIdEquipo(), equiposArray[j].getIdEquipo())) {
                    g.drawLine(posX[i], posY[i], posX[j], posY[j]);
                }
            }
        }
 
        // dibuja los circulos con los nombres
        for (int i = 0; i < total; i++) {
            g.setColor(new java.awt.Color(0, 102, 204));
            g.fillOval(posX[i] - 30, posY[i] - 30, 60, 60);
 
            g.setColor(java.awt.Color.BLACK);
            g.drawOval(posX[i] - 30, posY[i] - 30, 60, 60);
 
            g.setColor(java.awt.Color.WHITE);
            g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
            String nombre = equiposArray[i].getNombreEquipo();
            int textoAncho = g.getFontMetrics().stringWidth(nombre);
            g.drawString(nombre, posX[i] - textoAncho / 2, posY[i] + 4);
        }
    }
 
    public int getCantidadEquipos() {
        return cantidadEquipos;
    }
}
