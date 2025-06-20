/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

import org.graphstream.graph.Node;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 * Clase donde se utiliza GraphStream y se genera el grafo
 * @author alexandraloynaz
 */
public class Grafo {
    private Graph grafo;
/**
 * Constructor que inicializa grafo con sus letras y conexiones.
 * @param tablero el tablero 4x4 que contiene sus letras
 */
    public Grafo(MatrizTablero tablero) {
        System.setProperty("org.graphstream.ui", "swing");
        grafo = new SingleGraph("Sopa de Letras");
        grafo.setAttribute("ui.stylesheet", "node { fill-color: #EDD1BA; size: 25px; text-size: 20; }" +"edge { fill-color: gray; }");
        agregarNodos(tablero);
        agregarConexiones(tablero);
    }
    /**
     * Agrega los nodos al grafo a partir del tablero, cada uno con su letra y se posiciona según su ubicacion en la matriz.
     * @param tablero el tablero que contiene las letras representadas como nodos
     */

    private void agregarNodos(MatrizTablero tablero) {
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 4; col++) {
                NodoTablero nodo = tablero.obtenerNodo(fila, col);
                String posicion = fila + "-" + col;
                Node node = grafo.addNode(posicion);
                node.setAttribute("ui.label", String.valueOf(nodo.getLetra()));
            }
        }
    }
/**
 * Establece las conexiones entre los nodos del tablero. Cada uno tiene maximo 8 nodos vecinos. 
 * @param tablero el tablero que contiene las letras representadas como nodos
 */
    private void agregarConexiones(MatrizTablero tablero) {
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 4; col++) {
                NodoTablero actual = tablero.obtenerNodo(fila, col);
                NodoLSimple vecino = actual.getVecinos().getpFirst();
                while (vecino != null) {
                    NodoTablero vecinos1 = vecino.getDato();
                    String posicionActual = fila + "-" + col;
                    String posicionVecino = vecinos1.getFila() + "-" + vecinos1.getColumna();
                    String conexion = posicionActual + "-" + posicionVecino;
                    if (!posicionActual.equals(posicionVecino) &&
                        grafo.getEdge(conexion) == null &&
                        grafo.getEdge(posicionVecino + "-" + posicionActual) == null) {
                        grafo.addEdge(conexion, posicionActual, posicionVecino);
                    }

                    vecino = vecino.getpNext();
                }
            }
        }
    }
/**
 * Muestra la representación gráfica y visual del grafo.
 */
    public void mostrarGrafo() {
        grafo.display();
    
    
}
    public void mostrarPalabra(ListaSimple palabra){
        limpiar();
        NodoLSimple letra = palabra.getpFirst();
        NodoTablero nodo;
        Node n;
        String clave;
        while(letra!=null){
            nodo = letra.getDato();
            clave = Integer.toString(nodo.getFila()) + "-" + Integer.toString(nodo.getColumna());
            n = grafo.getNode(clave);
            if(n!=null){
                n.setAttribute("ui.style", "fill-color: purple;");
            }
            letra = letra.getpNext();
        }
    }
    
    public void limpiar(){
        for(Node n : grafo){
            n.setAttribute("ui.style", "fill-color: #EDD1BA;");
        }
    }
}