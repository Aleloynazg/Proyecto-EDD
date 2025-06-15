/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 * Representa el tablero de la sopa de letra como una matriz 4x4 de nodos. 
 * Cada nodo tiene una letra y sus conexiones con los nodos adyacentes.
 * Tamaño fijo de 4x4.
 * 
 * @author alexandraloynaz
 */
public class MatrizTablero {
    NodoTablero [][] matriz; 
/**
 * Constructor que inicializa la matriz cuadrada vacía y coloca el tamaño fijo del 4x4
 */
    public MatrizTablero() {
        matriz = new NodoTablero[4] [4]; 
        
    }
    /**
     * Coloca una lestra en una posición específica del tablero 
     * @param fila Fila de 0 a 3
     * @param columna columna de 0 a 3 
     * @param letra la letra a colocar
     */
    public void establecerNodo(int fila, int columna, char letra){
        if (fila >=0 && fila <= 3 && columna >=0 && columna <= 3){
            matriz[fila][columna]=new NodoTablero(letra, fila, columna);
    }
    
    }
    /**
     * Conecta cada nodo con sus vecinos adyacentes
     */
    public void conectarNodos(){
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                NodoTablero actual = matriz[fila][columna];
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <=1 ; j++) {
                        if(i==0 && j==0) continue; 
                        int vecinoFila = fila + i; 
                        int vecinoColumna = columna +j;
                        
                        if(vecinoFila>=0 && vecinoFila < 4 && vecinoColumna<4 && vecinoColumna>=0){
                        actual.insertarVecinos(matriz[vecinoFila][vecinoColumna]);
                        }
                    }
                }
                
            }
            
        }
    
    }
    /**
     * Obtiene un nodo específico del tablero
     * @param fila de 0 a 3
     * @param columna de 0 a 3 
     * @return  el nodo en esa posición o null si las coordenadas no son verdaderas
     */
    
    public NodoTablero obtenerNodo(int fila, int columna){
        if(fila >= 0 && fila < 4 && columna >=0 && columna <4){
            return matriz[fila][columna];}
        else{
            return null;}
        
        }
    
    
    
}
