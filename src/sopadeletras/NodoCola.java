/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 *
 * @author corinalynch
 */

public class NodoCola {
    private NodoLSimple dato;
    private NodoCola pNext;
    private ListaSimple palabra;
    private int posicion;

    
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
