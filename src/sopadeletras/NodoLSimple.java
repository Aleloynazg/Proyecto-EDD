/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 * Representa un nodod de una lista enlazada simple que almacena un NodoTablero
 * Cada nodo contiene un dato y un apuntador al siguiente nodo en la lista.
 * 
 * @author alexandraloynaz
 */
public class NodoLSimple {
    private NodoTablero dato; 
    private NodoLSimple pNext; 
/**
 * Constructor que crea un nuevo nodo con NodoTablero
 * @param dato el nodo del tablero que va a almacenar este nodo en la lista
 */
    public NodoLSimple(NodoTablero dato) {
        this.dato = dato;
        this.pNext = null;
    }

    /**
     * Obtiene el nodo tablero almacenado ese nodo
     * @return el NodoTablero almacenado
     */
    public NodoTablero getDato() {
        return dato;
    }

    /**
     * Establece el nodo del tablero para ese nodo
     * @param dato el nuevo Nodo Tablero a almacenar
     */
    public void setDato(NodoTablero dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el siguinete nodo en la lista
     * @return el siguiente NodoSimple en la lista, o null si es el último
     */
    public NodoLSimple getpNext() {
        return pNext;
    }

    /**
     * Establece el siguiente nodo en la lista.
     * @param pNext El nuevo nodo siguiente en esa lista.
     */
    public void setpNext(NodoLSimple pNext) {
        this.pNext = pNext;
    }
    
    
    
    
    
}
