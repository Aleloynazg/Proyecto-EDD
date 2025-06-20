/*
 * Click nbfs://nbhost/imFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

import sopadeletras.ColaBFS;
import sopadeletras.ListaSimple;
import sopadeletras.MatrizTablero;
import sopadeletras.NodoTablero;

/**
 *Clase que implementa la búsqueda DFS O BFS, para encontrar la palabra en un 
 * tablero. 
 * @author alexandraloynaz
 */
public class BuscarPalabra {
    private MatrizTablero tablero; 
/**
 * Constructor que inicializa la búsqueda con un tablero específico.
 * @param tablero el tablero de la sopa de letra donde se buscarán las palabras.
 */
    public BuscarPalabra(MatrizTablero tablero) {
        this.tablero = tablero;
    }
    /**
     * Busca una palabra en el tablero usando DFS
     * @param palabra la palabta a buscar en el tablero
     * @return true si la palabra se encuentra en el tablero, false en caso 
     * contrario.
     */
    public boolean existePalabraDFS(String palabra){
        if(palabra== null){return false;}
        palabra = palabra.toUpperCase(); 
        char primeraLetra=palabra.charAt(0);
            for (int fila = 0; fila < 4; fila++) {
                for (int columna = 0; columna < 4; columna++) {
                    NodoTablero nodo = tablero.obtenerNodo(fila, columna);
                    if(nodo.getLetra()== primeraLetra){
                       boolean [][] visitados = new boolean[4][4];
                        if(buscarDFS(nodo,palabra,0,visitados)){
                            return true;
                        }
                    }
                }
            }
            return false;
    }
    /**
     * Método recursivo para la busqueda DFS.
     * @param nodo el nodo que se está evaluando.
     * @param palabra la palabra completa que se esta buscando.
     * @param ind el índice de la letra que se está comparando.
     * @param visitados Matriz que registra los nodos ya visitados.
     * @return true si se encuentra la plabra a partir de ese nodo, false si es 
     * contrario.
     */
    private boolean buscarDFS(NodoTablero nodo, String palabra, int ind, boolean[][] visitados) {
        if(ind == palabra.length()){
            return true;}
        int fila = nodo.getFila(); 
        int columna = nodo.getColumna();
        if(visitados[fila][columna]||nodo.getLetra()!=palabra.charAt(ind)){
            return false; 
        }
        visitados[fila][columna]= true;
        
        NodoLSimple actual = nodo.getVecinos().getpFirst();
        
        while(actual != null){
            // debo ponerlo entre parentesis para que si se guarde ya que NodoTablero guarda es un object
            NodoTablero vecino = (NodoTablero) actual.getDato();
        if (buscarDFS(vecino, palabra,ind +1,visitados)){
            return true;
    
    }
        actual = actual.getpNext(); 
        }
        visitados[fila][columna] = false; 
        return false; 
        }
        
///**
// * Busca una palabra en el tablero usando BFS
// * @param palabra la palabra a buscar en el tablero
// * @return true si la palabra si se encuntra en el tablero, false si no.
// */   
//    public boolean existePalabraBFS(String palabra){
//        if(palabra== null){return false;}
//        palabra = palabra.toUpperCase(); 
//        char primeraLetra=palabra.charAt(0);
//            for (int fila = 0; fila < 4; fila++) {
//                for (int columna = 0; columna < 4; columna++) {
//                    NodoTablero nodo = tablero.obtenerNodo(fila, columna);
//                    if(nodo.getLetra()== primeraLetra){
//                        if(buscarBFS(nodo,palabra)){
//                            return true;
//                        }
//                    }
//                }
//            }
//            return false;
//    } 
//    
//    
//
///**
// * Método para la busqueda BFS
// * @param inicio nodo inicial desde donde comenzar la busqueda
// * @param palabra la palabra que se esta buscando
// * @return  true si la palabra se encuntra, false en casa contrario. 
// */
//    private boolean buscarBFS(NodoTablero inicio, String palabra){
public ListaSimple BFSInicio(String palabra){
    ColaBFS cola = new ColaBFS();
    palabra = palabra.toUpperCase(); 
    char primeraLetra=palabra.charAt(0);
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                NodoTablero nodo = tablero.obtenerNodo(fila, columna);
                if(nodo.getLetra()== primeraLetra){
                   nodo.setVisitado(true);
                   cola.queue(nodo, null, null, 0);
                   ListaSimple resultado = BFS(cola, palabra);
                   this.tablero.limpiar();
                   if(resultado!=null){return resultado;}
                }
                }
        }
        return null;
}


public ListaSimple BFS(ColaBFS cola, String palabra){
    NodoCola nodo = cola.dequeue();
    if(nodo==null){
        return null;
    }
    int ind = nodo.getPosicion();
    NodoTablero Letra = nodo.getDato().getDato();
    if(ind == palabra.length() - 1){
        nodo.getPalabra().insertarFinal(Letra);
        return nodo.getPalabra();
    }
    ListaSimple adyacentes = Letra.getVecinos();
    NodoLSimple aux = adyacentes.getpFirst();
    while(aux!=null){
        if(aux.getDato().isVisitado()==false && aux.getDato().getLetra()==palabra.charAt(ind + 1)){
            aux.getDato().setVisitado(true);
            cola.queue(aux.getDato(), nodo.getPalabra(), Letra, ind + 1);
        }
        aux = aux.getpNext();
    }
    ListaSimple l = BFS(cola, palabra);
    return l;
}
}
//
//
//
//}
//    
//    
//    
//    
//    
//    
//    }
    
    
    