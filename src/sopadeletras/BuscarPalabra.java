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
/**
 * Busca una palabra en el tablero utilizando un algoritmo DFS
 * @param palabra la palabra a buscar en el tablero.
 * @return una ListaSimple que contiene la secuencia de nodos que forman a esa palabra o null si la palabra no esta en el tablero
 */
    public ListaSimple rutaDFS(String palabra){
        if(palabra == null || palabra.length()<3){
            return null;}
        palabra = palabra.toUpperCase();
         char primeraLetra=palabra.charAt(0);
            for (int fila = 0; fila < 4; fila++) {
                for (int columna = 0; columna < 4; columna++) {
                   NodoTablero nodo = tablero.obtenerNodo(fila, columna);
                   if(nodo.getLetra() == primeraLetra){
                   boolean [][] visitados = new boolean[4][4];
                   ListaSimple ruta = new ListaSimple();
                   if(buscarRutaDFS(nodo,palabra,0,visitados,ruta)){
                   return ruta;}}
                }

    }
            return null;
    }
    /**
     * Método recursivo que implementa la búsqueda por DFS para encontrar la palabra en el tablero y cosntruir la ruta de nodos
     * @param nodo el nodo actual que esta siendo evaluado
     * @param palabra la palabra completa que se está buscando
     * @param indice la posición actual en la palabra (la letra) que se es está verificando.
     * @param visitados matriz que registra que nodos ya han sido verificados
     * @param ruta Lista que almacena la secuencia de nodos de la ruta
     * @return true si se encontró la palabra completa a partir de ese nodo, false si no e puedo completar la palabra
     */
    public boolean buscarRutaDFS(NodoTablero nodo, String palabra, int indice, boolean [][] visitados, ListaSimple ruta){
        int fila = nodo.getFila();
        int columna = nodo.getColumna();
        if(indice == palabra.length()){
        return true;
        }
        if (visitados[fila][columna]||nodo.getLetra()!=palabra.charAt(indice)){
            return false;}
        visitados[fila][columna]=true;
        ruta.insertarFinal(nodo);
        NodoLSimple actual = nodo.getVecinos().getpFirst();
        while(actual != null){
            NodoTablero aux = actual.getDato();
            if(buscarRutaDFS(aux,palabra,indice+1,visitados,ruta)){
                return true;}
            actual = actual.getpNext();
        }
        visitados [fila][columna]=false;
        ruta.eliminarUltimo();
        return false;

    }
    /**
 * Implementa un algoritmo de Búsqueda en Amplitud (BFS) para encontrar una palabra específica en un tablero de letras.
 *
 * @param cola La cola BFS que contiene los nodos a explorar, representando posibles caminos en el tablero.
 * @param palabra La palabra objetivo que se está buscando en el tablero.
 * @return Una ListaSimple que contiene los NodosTablero que forman la palabra encontrada, o null si la palabra no se encuentra o la cola se vacía.
 * @autor Corina lynch
 */
    
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

    
    
    