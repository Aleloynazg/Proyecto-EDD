/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

import javax.swing.JOptionPane;

/**
 * Clase de lista enlazada con sus primitivas
 * @author alexandraloynaz
 */
public class ListaPalabra {
    private NodoPalabra pFirst; 
    private int cont; 
/**
 * Constructor de la lista, inicializa la lista vacía.
 */
    public ListaPalabra() {
        this.pFirst = null;
        this.cont = 0;
    }
    /**
     * Inserta una palabra al inicio de la lista.
     * @param palabra  la palabra a insertar 
     */
    public void insertarInicio(String palabra){
        NodoPalabra nuevo = new NodoPalabra(palabra); 
        nuevo.setpNext(getpFirst());
        setpFirst(nuevo); 
        cont ++; }
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
     * Inserta un nodo al final de la lista
     * @param palabra el nodo del tablero que se va a insertar al final
     */
    public void insertarFinal(String palabra){
        NodoPalabra  nuevo = new NodoPalabra(palabra); 
        if (esVacia()){
            setpFirst(nuevo);
        
        }
        else{
            NodoPalabra aux = getpFirst(); 
            while(aux.getpNext()!= null){
                aux = aux.getpNext(); 
        }
            aux.setpNext(nuevo);            
        }
            cont++ ;  
    }
    
    /**
     * Busca y retorna el último nodo de la lista
     * @return el último nodo de la lista, o null si es vacía
     */
    public NodoPalabra buscarUltimo(){
        NodoPalabra  aux = getpFirst(); 
        if(getpFirst() == null){
            return null;}
        else{
            while(aux.getpNext()!= null){
            aux=aux.getpNext();
            }
            return aux;
            
        }
        
    }
    /**
     * Muestra todas las palabras que se encuentran en el diccionario.
     * 
     * @return todas las palabras del diccionario y les coloca un check a las que ya fueron encontradas.  
     */
    public String mostrar(){
        String palabra = "";
    NodoPalabra aux=getpFirst(); 
    if(aux==null){
        return "el diccionario esta vacio";
    }
    while(aux!=null){
        palabra += aux.getPalabra();
        if(aux.esEncontrada()){
            palabra += "✅"; 
        }
        palabra += "\n";
        aux = aux.getpNext();
    }
    return palabra;   
    }
    
    /**
     * Cambia el encontrada a verdadero si la palabra se encuntra en el tablero
     * @param palabra la palabra que se esta buscando.
     */
    public void marcarEncontrada(String palabra){
        NodoPalabra aux = getpFirst();
        while(aux!= null){
        if(aux.getPalabra().equals(palabra)){
            aux.setEncontrada(true);
            return;
            
        }
        aux=aux.getpNext();
        }
    }
    
    /**
     * Cuenta cuantas palabras ya han sido encontradas
     * @return el numero de palabras que ya fueron encontradas
     */
    public int contarEncontradas(){
        int contador = 0; 
        NodoPalabra aux = getpFirst(); 
        while (aux!= null){
        if(aux.esEncontrada()){
            contador ++;
        } aux = aux.getpNext();
        }
    return contador;
    }
    
    /**
     * Reinicia las palabras encontradas para volver a comenzar la sopa de letras
     */
    public void reiniciarEncontradas(){
        NodoPalabra aux = getpFirst(); 
        while(aux!= null){
        aux.setEncontrada(false);
        aux = aux.getpNext();}
    
    
    }
    /**
     * Busca una palabra para ver si se encuentra dentro de la lista.
     * @param palabra palabra que se desea buscar
     * @return true si se encuentra en el diccionario (la lista), false si no se encuentra 
     */
    public boolean enDiccionario(String palabra){
    NodoPalabra aux = getpFirst(); 
    while(aux!= null){
        if(aux.getPalabra().equals(palabra.toUpperCase())){
            return true; 
        }
        else{
        aux=aux.getpNext();
        }
    
    }
    
        return false; 
    }

    /**
     * Obtiene el primer nodo de la lista.
     * @return pFirst el primer nodo de la lista.
     */
    public NodoPalabra getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista
     * @param pFirst el nodo a establecer como primero
     */
    public void setpFirst(NodoPalabra pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Obtiene el contador de elementos de la lista.
     * @return la cantidad de elementos en la lista.
     */
    public int getCont() {
        return cont;
    }

    /**
     * Establece el contador de elementos de la lista
     * @param cont el Valor a estableces como contador
     */
    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
}
