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
 * Obtiene el {@code NodoLSimple} que encapsula el {@code NodoTablero} (la letra) asociado a este nodo de la cola.
 *@Corina lynch
 * @return El {@code NodoLSimple} que contiene el dato principal de este {@code NodoCola}.
 */
    public NodoLSimple getDato() {
        return dato;
    }

   /**
 * Obtiene el siguiente nodo en la cola.
 *@autor Corina lynch
 * @return El siguiente {@code NodoCola} en la secuencia de la cola.
 */
    public NodoCola getpNext() {
        return pNext;
    }

   /**
 * Establece el siguiente nodo en la cola.
 *@autor Corina lynch 
 * @param pNext El {@code NodoCola} que se establecerá como el siguiente en la secuencia.
 */
    public void setpNext(NodoCola pNext) {
        this.pNext = pNext;
    }
/**
 * Obtiene la {@code ListaSimple} que representa la palabra construida hasta el punto actual de este nodo.
 *@autor corina lynch
 * @return La {@code ListaSimple} que contiene los {@code NodoTablero} que forman la palabra.
 */
    public ListaSimple getPalabra() {
        return palabra;
    }

    /**
 * Obtiene la posición (índice) de la letra que este nodo representa dentro de la palabra objetivo.
 *@autor Corina lynch
 * @return Un entero que indica la posición de la letra.
 */
    public int getPosicion() {
        return posicion;
    }
}
