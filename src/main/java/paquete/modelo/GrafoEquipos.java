


package paquete.modelo;

public class GrafoEquipos {

    private Nodo listaVertices;
    private int cantidadEquipos;

    public GrafoEquipos() {
        this.listaVertices = null;
        this.cantidadEquipos = 0;
    }

    public void agregarEquipo(Equipo e) {
        if (existeEquipo(e.getIdEquipo())) {
            return;
        }

        Object[] vertice = new Object[2];
        vertice[0] = e;
        vertice[1] = null;

        Nodo nuevo = new Nodo(vertice);
        nuevo.setSiguiente(listaVertices);
        listaVertices = nuevo;
        cantidadEquipos++;
    }

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

    public boolean existeEquipo(int idEquipo) {
        return buscarVertice(idEquipo) != null;
    }

    public void conectarEquipos(Equipo A, Equipo B) {

        if (existeConexion(A.getIdEquipo(), B.getIdEquipo())) {
            return;
        }

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

    public boolean estaVacia() {
        return listaVertices == null;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void dibujarGrafo(javax.swing.JPanel panel) {

        if (estaVacia()) {
            return;
        }

        java.awt.Graphics g = panel.getGraphics();

        int ancho = panel.getWidth();
        int alto = panel.getHeight();

        g.setColor(java.awt.Color.WHITE);
        g.fillRect(0, 0, ancho, alto);

        int total = cantidadEquipos;

        int centroX = ancho / 2;
        int centroY = alto / 2;

        int radio = Math.min(centroX, centroY) - 60;

        int[] posX = new int[total];
        int[] posY = new int[total];
        Equipo[] equipos = new Equipo[total];

        Nodo actual = listaVertices;
        int i = 0;

        while (actual != null) {
            Object[] datos = (Object[]) actual.getDato();
            Equipo eq = (Equipo) datos[0];

            equipos[i] = eq;

            double angulo = 2 * Math.PI * i / total;

            posX[i] = (int) (centroX + radio * Math.cos(angulo));
            posY[i] = (int) (centroY + radio * Math.sin(angulo));

            i++;
            actual = actual.getSiguiente();
        }

        g.setColor(java.awt.Color.GRAY);

        for (int a = 0; a < total; a++) {
            for (int b = a + 1; b < total; b++) {
                if (existeConexion(equipos[a].getIdEquipo(), equipos[b].getIdEquipo())) {
                    g.drawLine(posX[a], posY[a], posX[b], posY[b]);
                }
            }
        }

        for (int j = 0; j < total; j++) {

            g.setColor(new java.awt.Color(0, 102, 204));
            g.fillOval(posX[j] - 30, posY[j] - 30, 60, 60);

            g.setColor(java.awt.Color.BLACK);
            g.drawOval(posX[j] - 30, posY[j] - 30, 60, 60);

            g.setColor(java.awt.Color.WHITE);
            g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));

            String nombre = equipos[j].getNombreEquipo();
            int anchoTexto = g.getFontMetrics().stringWidth(nombre);

            g.drawString(nombre, posX[j] - anchoTexto / 2, posY[j] + 4);
        }
    }
}