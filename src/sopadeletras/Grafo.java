/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

import org.graphstream.graph.Node;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author alexandraloynaz
 */
public class Grafo {
    private Graph grafo;

    public Grafo(MatrizTablero tablero) {
        System.setProperty("org.graphstream.ui", "swing");
        grafo = new SingleGraph("Sopa de Letras");
        grafo.setAttribute("ui.stylesheet", "node { fill-color: #EDD1BA; size: 25px; text-size: 20; }" +"edge { fill-color: gray; }");
        agregarNodos(tablero);
        agregarConexiones(tablero);
    }

    private void agregarNodos(MatrizTablero tablero) {
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 4; col++) {
                NodoTablero nodo = tablero.obtenerNodo(fila, col);
                String id = fila + "-" + col;
                Node node = grafo.addNode(id);
                node.setAttribute("ui.label", String.valueOf(nodo.getLetra()));
            }
        }
    }

    private void agregarConexiones(MatrizTablero tablero) {
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 4; col++) {
                NodoTablero actual = tablero.obtenerNodo(fila, col);
                NodoLSimple vecino = actual.getVecinos().getpFirst();
                while (vecino != null) {
                    NodoTablero vecinos1 = vecino.getDato();
                    String id1 = fila + "-" + col;
                    String id2 = vecinos1.getFila() + "-" + vecinos1.getColumna();
                    String edgeId = id1 + "-" + id2;

                    if (!id1.equals(id2) &&
                        grafo.getEdge(edgeId) == null &&
                        grafo.getEdge(id2 + "-" + id1) == null) {
                        grafo.addEdge(edgeId, id1, id2);
                    }

                    vecino = vecino.getpNext();
                }
            }
        }
    }

    public void mostrar() {
        grafo.display();
    
    
}
}
