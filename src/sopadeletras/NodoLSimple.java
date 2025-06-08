/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 * 
 * @author alexandraloynaz
 */
public class NodoLSimple {
    private String dato; 
    private NodoLSimple pNext; 

    public NodoLSimple(String dato) {
        this.dato = dato;
        this.pNext = null;
    }

    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     * @return the pNext
     */
    public NodoLSimple getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoLSimple pNext) {
        this.pNext = pNext;
    }
    
    
    
    
    
}
