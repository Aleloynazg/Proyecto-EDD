/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras;

/**
 *
 * @author corinalynch
 */
public class ColaBFS {
    private NodoCola cabeza;
    private int size;
    
    public ColaBFS(){
        cabeza = null;
        size = 0;
    }
    
    public void queue(NodoTablero dato, ListaSimple palabra, NodoTablero letraAnterior, int posicion){
        ListaSimple NuevaPalabra = new ListaSimple();
        if(palabra!=null){
            NodoLSimple aux = palabra.getpFirst();
            while(aux!=null){
                NuevaPalabra.insertarFinal(aux.getDato());
                aux=aux.getpNext();
            }
        }
        if(letraAnterior!=null){
            NuevaPalabra.insertarFinal(letraAnterior);
        }
        NodoCola nodo = new NodoCola(dato, NuevaPalabra, posicion);

        if(size==0){
            cabeza = nodo;
        }else{
            NodoCola aux = cabeza;
            while(aux.getpNext()!=null){
                aux = aux.getpNext();
            }
            aux.setpNext(nodo);
        }                
       size++;
    }
    
    public NodoCola dequeue(){
    if(size==0){
        return null;
    }
    NodoCola nodo = cabeza;
    cabeza = cabeza.getpNext();
    size--;
    return nodo;
    }

}