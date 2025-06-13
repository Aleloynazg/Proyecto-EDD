/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 * Representa un nodo en el tablero de la sopa de lestras. 
 * Cada nodo contiene una letra, su posición y una lista que tiene sus nodos vecinos
 * @author alexandraloynaz
 */
public class NodoTablero {
    private char letra; 
    private int fila; 
    private int columna; 
    private boolean visitado; 
    private ListaSimple vecinos; 
/**
 * Constructor para generar un nodo nuevo
 * @param letra letra que va a contener ese nodo
 * @param fila posición horizontal en el tablero
 * @param columna posición vertical en el tablero
 * @param visitado revisa si ya ese nodo fue visitado en la busqueda
 * @param vecinos lista con sus nodos vecinos
 */  
    
    public NodoTablero(char letra, int fila, int columna, boolean visitado, ListaSimple vecinos) {
        this.letra = letra;
        this.fila = fila;
        this.columna = columna;
        this.visitado = false;
        this.vecinos = new ListaSimple();
    }
    /**
     * Agrega un nodo vecino a la lista de adyacencia. 
     * 
     * @param n El nodo que se va a agregar 
     */
    public void insertarVecinos(NodoTablero n){
        vecinos.insertarFinal(n);
    
    }

    /**
     * Obtiene la letra almacenada en ese nodo.
     * @return la letra del nodo 
     */
    public char getLetra() {
        return letra;
    }

    /**
     * Establece la letra de ese nodo
     * @param letra la nueva letra asignada
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }

    /**
     * Obtiene la posición horizontal del nodo en el tablero.
     * @return número de fila entre 0 y 3
     */
    public int getFila() {
        return fila;
    }

    /**
     * Establece la posición horizontal del nodo 
     * @param fila la nueva posición horizontal de ese nodo
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Obtiene la posición vertical del nodo en el tablero.
     * @return número de columna entre 0 y 3
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Establece la posición horizontal del nodo 
     * 
     * @param columna la nueva posición vertical de ese nodo
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Verifica si el nodo ha sido visitado durante la búsqueda
     * 
     * @return the visitado si el nodo fue visitado, false si no ha sido visitado
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     * Establece el estado del nodo (visitado o no)
     * 
     * @param visitado true para marcar como visitado, false para desmarcar 
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     * Obtiene la lista de nodos vecinos
     * 
     * @return ListaSimple conteniendo los nodos adyacentes
     */
    public ListaSimple getVecinos() {
        return vecinos;
    }

    /**
     * Reemplaza la lista de nodos vecinos 
     * 
     * @param vecinos una nueva ListaSimple de nodos adyacentes
     */
    public void setVecinos(ListaSimple vecinos) {
        this.vecinos = vecinos;
    }
    
    
}
