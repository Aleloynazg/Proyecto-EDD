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
    private int cont; // puse el contador porque siento que nos puede servir mas adelante

    public ListaSimple( int cont) {
        this.pFirst = null;
        this.cont = 0;
    }

    public void insertarInicio(String letra){
        NodoLSimple nuevo = new NodoLSimple(letra); 
        nuevo.setpNext(getpFirst());
        setpFirst(nuevo); 
        setCont(getCont() + 1); }
    
    public boolean esVacia(){
       if( getpFirst() == null) {
           return true;}
       else{
        return false;
       }
    }
    public void insertarFinal(String letra){
        NodoLSimple  nuevo = new NodoLSimple(letra); 
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
        setCont(getCont() + 1);  }
    
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
     * @return the pFirst
     */
    public NodoLSimple getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoLSimple pFirst) {
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

