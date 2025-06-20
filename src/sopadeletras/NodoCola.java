/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 * Clase que representa un nodo dentro de una cola utilizada en algoritmos de Búsqueda en Amplitud (BFS).
 * Cada `NodoCola` encapsula la información necesaria para rastrear el progreso de la búsqueda de una palabra
 * en un tablero de letras.
 * @autor Corina Lynch
 */

public class NodoCola {
    private NodoLSimple dato;
    private NodoCola pNext;
    private ListaSimple palabra;
    private int posicion;
    
     /**
     * Constructor para inicializar un nuevo `NodoCola`.
     * Este constructor realiza una copia profunda de la lista `palabra` proporcionada para asegurar
     * que cada camino de búsqueda sea independiente y las modificaciones no afecten a otros caminos.
     *
     * @param nodo El `NodoTablero` que este `NodoCola` representará como la letra actual en la búsqueda.
     * @param palabra La `ListaSimple` que contiene las letras anteriores que ya forman parte de la palabra.
     * @param posicion La posición (índice) de la letra actual (`nodo`) dentro de la palabra objetivo.
     * @autor Corina Lynch
     */

    
    public NodoCola(NodoTablero nodo, ListaSimple palabra, int posicion){
    dato = new NodoLSimple(nodo);
    this.palabra = new ListaSimple();
    this.posicion = posicion;
    NodoLSimple aux = palabra.getpFirst();
    while(aux!=null){
        this.palabra.insertarFinal(aux.getDato());
        aux = aux.getpNext();
    }    
    
    }
    /**
     * @return the dato
     */
    public NodoLSimple getDato() {
        return dato;
    }

    /**
     * @return the pNext
     */
    public NodoCola getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoCola pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the palabra
     */
    public ListaSimple getPalabra() {
        return palabra;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }
}
