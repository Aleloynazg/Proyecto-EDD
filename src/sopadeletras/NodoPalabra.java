/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 *
 * @author alexandraloynaz
 */
public class NodoPalabra {
    private String palabra; 
    private NodoPalabra pNext; 

    /**
     * Constructor
     * @param palabra
     * @param pNext 
     */
    public NodoPalabra(String palabra) {
        this.palabra = palabra;
        this.pNext = null;
    }

    /**
     * @return the palabra
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * @param palabra the palabra to set
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * @return the pNext
     */
    public NodoPalabra getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoPalabra pNext) {
        this.pNext = pNext;
    }
    
    
}
