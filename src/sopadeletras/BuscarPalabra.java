/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 *
 * @author alexandraloynaz
 */
public class BuscarPalabra {
    private MatrizTablero tablero; 

    public BuscarPalabra(MatrizTablero tablero) {
        this.tablero = tablero;
    }
    /**
     * 
     * @param palabra
     * @return 
     */
    public boolean existePalabra(String palabra){
        if(palabra== null){return false;}
        palabra = palabra.toUpperCase(); 
        char primeraLetra=palabra.charAt(0);
            for (int fila = 0; fila < 4; fila++) {
                for (int columna = 0; columna < 4; columna++) {
                    NodoTablero nodo = tablero.obtenerNodo(fila, columna);
                    if(nodo.getLetra()== primeraLetra){
                        if(buscarDFS(nodo,palabra,0,new boolean[4][4])){
                            return true;
                        }
                    }
                }
            }
            return false;
    }
    /**
     * 
     * @param nodo
     * @param palabra
     * @param ind
     * @param visitados
     * @return 
     */
    private boolean buscarDFS(NodoTablero nodo, String palabra, int ind, boolean[][] visitados) {
        if(ind== palabra.length()){
            return true;}
        if(nodo == null|| visitados[nodo.getFila()][nodo.getColumna()]||nodo.getLetra()!=palabra.charAt(ind)){
            return false; 
        }
        visitados[nodo.getFila()][nodo.getColumna()]= true;
        NodoLSimple actual = nodo.getVecinos().getpFirst();
        
        while(actual != null){
            NodoTablero vecino = (NodoTablero) actual.getDato();
        if (buscarDFS(vecino, palabra,ind +1,visitados)){
            return true;
    
    }
        actual = actual.getpNext(); 
        }
        visitados[nodo.getFila()][nodo.getColumna()] = false; 
        return false; 
        }
        
    
    }
    
    
    

