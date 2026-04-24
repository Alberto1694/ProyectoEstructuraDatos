/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author alberto
 */
public class Sistema {
    private final String ruta;

    public Sistema(String ruta) {
        this.ruta = ruta;
    }

    public void guardar(ListaEventos lista) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write(generarJson(lista));
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListaEventos cargar() {
        try {
            File f = new File(ruta);
            if (!f.exists()) {
                return new ListaEventos();
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            String texto = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea;
            }
            br.close();

            if (texto.trim().isEmpty()) {
                return new ListaEventos();
            }

            Parser parser = new Parser(texto);
            return parser.parsearEventos();
        } catch (Exception e) {
            e.printStackTrace();
            return new ListaEventos();
        }
    }

    private String generarJson(ListaEventos lista) {
        String json = "{\"eventos\":[";
        Nodo actualEvento = lista.getInicio();

        while (actualEvento != null) {
            Evento ev = (Evento) actualEvento.getDato();
            json += "{";
            json += "\"id\":" + ev.getIdEvento() + ",";
            json += "\"nombre\":\"" + escapar(ev.getNombreEvento()) + "\",";
            json += "\"fecha\":\"" + escapar(ev.getFecha()) + "\",";
            json += "\"ubicacion\":\"" + escapar(ev.getUbicacion()) + "\",";

            json += "\"participantes\":[";
            NodoDoble p = ev.getListaParticipantes().getInicio();
            while (p != null) {
                Participante part = (Participante) p.getDato();
                json += "{";
                json += "\"id\":" + part.getIdParticipante() + ",";
                json += "\"nombre\":\"" + escapar(part.getNombre()) + "\",";
                json += "\"edad\":" + part.getEdad() + ",";
                String eq = "";
                if (part.getEquipo() != null) {
                    eq = part.getEquipo().getNombreEquipo();
                }
                json += "\"equipo\":\"" + escapar(eq) + "\"";
                json += "}";
                if (p.getSiguiente() != null) json += ",";
                p = p.getSiguiente();
            }
            json += "],";

            json += "\"partidosPendientes\":[";
            Nodo pp = ev.getColaPartidos().getFrente();
            while (pp != null) {
                Partido partido = (Partido) pp.getDato();
                json += "{";
                json += "\"local\":\"" + escapar(partido.getEquipoLocal()) + "\",";
                json += "\"visitante\":\"" + escapar(partido.getEquipoVisitante()) + "\",";
                json += "\"fecha\":\"" + escapar(partido.getFecha()) + "\"";
                json += "}";
                if (pp.getSiguiente() != null) json += ",";
                pp = pp.getSiguiente();
            }
            json += "],";

            json += "\"resultados\":[";
            Nodo r = ev.getPilaResultados().getTope();
            while (r != null) {
                Partido partido = (Partido) r.getDato();
                json += "{";
                json += "\"local\":\"" + escapar(partido.getEquipoLocal()) + "\",";
                json += "\"visitante\":\"" + escapar(partido.getEquipoVisitante()) + "\",";
                json += "\"fecha\":\"" + escapar(partido.getFecha()) + "\",";
                json += "\"p1\":" + partido.getPuntosLocal() + ",";
                json += "\"p2\":" + partido.getPuntosVisitante();
                json += "}";
                if (r.getSiguiente() != null) json += ",";
                r = r.getSiguiente();
            }
            json += "]";
            json += "}";
            if (actualEvento.getSiguiente() != null) json += ",";
            actualEvento = actualEvento.getSiguiente();
        }

        json += "]}";
        return json;
    }

    private String escapar(String t) {
        if (t == null) return "";
        String out = "";
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '"') out += "\\\"";
            else if (c == '\\') out += "\\\\";
            else out += c;
        }
        return out;
    }

    private static class Parser {
        private final String s;
        private int i;

        Parser(String s) {
            this.s = s;
            this.i = 0;
        }

        ListaEventos parsearEventos() {
            ListaEventos lista = new ListaEventos();
            consumir('{');
            leerClave("eventos");
            consumir(':');
            consumir('[');

            if (ver() != ']') {
                while (true) {
                    Evento ev = parsearEvento();
                    lista.agregar(ev);
                    if (ver() == ',') {
                        i++;
                    } else {
                        break;
                    }
                }
            }

            consumir(']');
            consumir('}');
            return lista;
        }

        private Evento parsearEvento() {
            consumir('{');
            leerClave("id");
            consumir(':');
            int id = leerInt();
            consumir(',');

            leerClave("nombre");
            consumir(':');
            String nombre = leerString();
            consumir(',');

            leerClave("fecha");
            consumir(':');
            String fecha = leerString();
            consumir(',');

            leerClave("ubicacion");
            consumir(':');
            String ubicacion = leerString();
            consumir(',');

            Evento ev = new Evento(id, nombre, fecha, ubicacion);

            leerClave("participantes");
            consumir(':');
            consumir('[');
            if (ver() != ']') {
                while (true) {
                    Participante p = parsearParticipante();
                    ev.getListaParticipantes().insertar(p);
                    if (ver() == ',') i++;
                    else break;
                }
            }
            consumir(']');
            consumir(',');

            leerClave("partidosPendientes");
            consumir(':');
            consumir('[');
            if (ver() != ']') {
                while (true) {
                    Partido p = parsearPartidoPendiente();
                    ev.getColaPartidos().encolar(p);
                    if (ver() == ',') i++;
                    else break;
                }
            }
            consumir(']');
            consumir(',');

            leerClave("resultados");
            consumir(':');
            consumir('[');
            ColaDinamica temporal = new ColaDinamica();
            if (ver() != ']') {
                while (true) {
                    Partido p = parsearResultado();
                    temporal.encolar(p);
                    if (ver() == ',') i++;
                    else break;
                }
            }
            consumir(']');
            consumir('}');

            pasarColaAPilaRec(temporal, ev.getPilaResultados());
            return ev;
        }

        private Participante parsearParticipante() {
            consumir('{');
            leerClave("id");
            consumir(':');
            int id = leerInt();
            consumir(',');
            leerClave("nombre");
            consumir(':');
            String nombre = leerString();
            consumir(',');
            leerClave("edad");
            consumir(':');
            int edad = leerInt();
            consumir(',');
            leerClave("equipo");
            consumir(':');
            String equipo = leerString();
            consumir('}');

            Participante p = new Participante();
            p.setIdParticipante(id);
            p.setNombre(nombre);
            p.setEdad(edad);
            Equipo eq = new Equipo();
            eq.setNombreEquipo(equipo);
            p.setEquipo(eq);
            return p;
        }

        private Partido parsearPartidoPendiente() {
            consumir('{');
            leerClave("local");
            consumir(':');
            String l = leerString();
            consumir(',');
            leerClave("visitante");
            consumir(':');
            String v = leerString();
            consumir(',');
            leerClave("fecha");
            consumir(':');
            String f = leerString();
            consumir('}');

            Partido p = new Partido(l, v);
            p.setFecha(f);
            return p;
        }

        private Partido parsearResultado() {
            consumir('{');
            leerClave("local");
            consumir(':');
            String l = leerString();
            consumir(',');
            leerClave("visitante");
            consumir(':');
            String v = leerString();
            consumir(',');
            leerClave("fecha");
            consumir(':');
            String f = leerString();
            consumir(',');
            leerClave("p1");
            consumir(':');
            int p1 = leerInt();
            consumir(',');
            leerClave("p2");
            consumir(':');
            int p2 = leerInt();
            consumir('}');

            Partido p = new Partido(l, v);
            p.setFecha(f);
            p.setPuntosLocal(p1);
            p.setPuntosVisitante(p2);
            return p;
        }

        private void pasarColaAPilaRec(ColaDinamica cola, PilaDinamica pila) {
            Partido p = cola.desencolar();
            if (p == null) return;
            pasarColaAPilaRec(cola, pila);
            pila.apilar(p);
        }

        private void leerClave(String esperada) {
            String k = leerString();
            if (!esperada.equals(k)) {
                throw new RuntimeException("Clave esperada: " + esperada + ", recibida: " + k);
            }
        }

        private char ver() {
            saltar();
            if (i >= s.length()) return '\0';
            return s.charAt(i);
        }

        private void consumir(char c) {
            saltar();
            if (i >= s.length() || s.charAt(i) != c) {
                throw new RuntimeException("Esperado '" + c + "'");
            }
            i++;
        }

        private void saltar() {
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') i++;
                else break;
            }
        }

        private String leerString() {
            consumir('"');
            String out = "";
            while (i < s.length()) {
                char c = s.charAt(i++);
                if (c == '"') break;
                if (c == '\\' && i < s.length()) {
                    char n = s.charAt(i++);
                    if (n == '"') out += '"';
                    else if (n == '\\') out += '\\';
                    else out += n;
                } else {
                    out += c;
                }
            }
            return out;
        }

        private int leerInt() {
            saltar();
            String n = "";
            if (ver() == '-') {
                n += '-';
                i++;
            }
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    n += c;
                    i++;
                } else {
                    break;
                }
            }
            if (n.length() == 0 || "-".equals(n)) return 0;
            return Integer.parseInt(n);
        }
    }
}
