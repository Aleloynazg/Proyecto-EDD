/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 * Clase con las primitivas de una lista enlazada y un entero que lleva la cuenta de la cantidad de nodos en la lista
 * @author alexandraloynaz
 */

public class ListaSimple {
    private NodoLSimple pFirst; 
    private int cont; 
/**
 * Constructor que inicializa una lista vacía
 */
    
    public ListaSimple() {
        this.pFirst = null;
        this.cont = 0;
    }
    /**
     * Inserta un nodo al inicio de la lista
     * @param nodo el nodo del tablero que se va a insertar
     */

    public void insertarInicio(NodoTablero nodo){
        NodoLSimple nuevo = new NodoLSimple(nodo); 
        nuevo.setpNext(getpFirst());
        setpFirst(nuevo); 
        cont++; }
    /**
     * Verifica si la lista esta vacía
     * @return true si esta vacía, false si no esta vacía
     */
    public boolean esVacia(){
       if(getpFirst() == null) {
           return true;}
       else{
        return false;
       }
    }
    /**
     * Elimina el ultimo elemento de una lista 
     */
    public void eliminarUltimo(){
    if(pFirst== null){
        return;}
    if(pFirst.getpNext()== null){
        pFirst = null;
        return;}
    NodoLSimple aux = pFirst;
    while(aux.getpNext().getpNext()!= null){
        aux = aux.getpNext();}
    aux.setpNext(null);
    
    
    
    }
    /**
     * Inserta un nodod al final de la lista
     * @param nodo el nodo del tablero que se va a insertar al final
     */
    public void insertarFinal(NodoTablero nodo){
        NodoLSimple  nuevo = new NodoLSimple(nodo); 
        if (esVacia()){
            setpFirst(nuevo);
        
        }
        else{
            NodoLSimple aux = getpFirst(); 
            while(aux.getpNext()!= null){
                aux = aux.getpNext(); 
        }
            aux.setpNext(nuevo);            
        }
            cont ++;  
    }
    /**
     * Busca el último nodo de la lista
     * @return el último nodo de la lista, o null si es vacía
     */
    public NodoLSimple buscarUltimo(){
        NodoLSimple  aux = pFirst; 
        if(pFirst == null){
            return null;}
        else{
            while(aux.getpNext()!= null){
            aux=aux.getpNext();
            }
            return aux;
            
        
        }
        
    }
    /**
     * Función para imprimir los datos de una lista. 
     */
    public void imprimir(){
    NodoLSimple aux = pFirst; 
    String palabra = "";
    while (aux!= null){
        palabra += aux.getDato().getLetra();
        aux=aux.getpNext();}
        System.out.println(palabra);
    }
    
    /**
     * Obtiene el primer nodo de la lista 
     * @return el primer nodo de la lista
     */
    public NodoLSimple getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista 
     * @param pFirst el nodo que se va a establecer como primero
     */
    public void setpFirst(NodoLSimple pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Obtiene el contador de nodos
     * @return la cantidad de nodos en esa lista
     */
    public int getCont() {
        return cont;
    }

    /**
     * Establece el contador de nodos 
     * @param cont el valor a establecer 
     */
    public void setCont(int cont) {
        this.cont = cont;
    }
   
}
