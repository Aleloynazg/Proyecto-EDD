/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 *
 * @author alexandraloynaz
 */
public class ListaPalabra {
    private NodoPalabra pFirst; 
    private int cont; 

    public ListaPalabra(NodoPalabra pFirst, int cont) {
        this.pFirst = pFirst;
        this.cont = cont;
    }
    /**
     * 
     * @param palabra 
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
     * @param nodo el nodo del tablero que se va a insertar al final
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
     * Busca el último nodo de la lista
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
     * @return the pFirst
     */
    public NodoPalabra getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoPalabra pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the cont
     */
    public int getCont() {
        return cont;
    }

    /**
     * @param cont the cont to set
     */
    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
}
