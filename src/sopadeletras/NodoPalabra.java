/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 * Representa un nodo de una lista enlazada que almacena una palabra y tiene un 
 * apuntador al nodo siguiente. 
 * @author alexandraloynaz
 */
public class NodoPalabra {
    private String palabra; 
    private boolean encontrada;
    private NodoPalabra pNext; 

    /**
     * Constructor que crea un nuevo nodo con la palabta especificada
     * @param palabra la palabra que almacenara el nodo
     */
    public NodoPalabra(String palabra) {
        this.palabra = palabra;
        this.encontrada = false;
        this.pNext = null;
    }

    /**
     * Obtiene la palabra almacenada en este nodo.
     * @return the palabra contenida en el nodo 
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * Establece una nueva palabra para este nodo.
     * @param palabra la nueva palabra a almacenar en este nodo.
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * Obtiene el nodo siguente en la lista
     * @return el nodo siguiente o null si es el último nodo
     */
    public NodoPalabra getpNext() {
        return pNext;
    }
    
    /**
     * Verifica si la palabra ya fue encontrada y buscada por el usuario. 
     * @param encontrada 
     */
    public boolean esEncontrada(){
        return encontrada;
    
    }
    public void setEncontrada(boolean encontrada){
    this.encontrada = encontrada;
    }

    /**
     * Establece el nodo siguiente en la lista.
     * @param pNext El Nodo que será el siguiente nodo
     */
    public void setpNext(NodoPalabra pNext) {
        this.pNext = pNext;
    }
    
    
}
