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
    /**
 * Agrega un nuevo elemento a la cola BFS. Este método construye una nueva lista que representa
 * el camino de la palabra formado hasta el momento, incluyendo la letra anterior, y encola un
 * NodoCola con la información del nodo actual, la palabra construida y la posición en la palabra objetivo.
 *
 * @param dato El NodoTablero actual que se está procesando y se añadirá al camino.
 * @param palabra La ListaSimple que contiene los NodosTablero que forman la palabra hasta la letra anterior. Puede ser null si es el inicio de la búsqueda.
 * @param letraAnterior El NodoTablero de la letra que precede directamente al 'dato' actual en el camino de la palabra. Puede ser null si 'dato' es la primera letra.
 * @param posicion La posición indexada (0-basada) del 'dato' actual dentro de la palabra objetivo.
 * @autor corina Lynch 
 */
    
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
        
        /** Se establece el padre del 'dato' antes de crear el NodoCola
        * ahora letraAnterior' es el NodoTablero desde el cual llegamos a 'dato'
        * */
        
        if (letraAnterior != null) {
            dato.setPadre(letraAnterior);
        } else {
            dato.setPadre(null); // Si no hay letra anterior, es el nodo inicial
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
    /**
 * Elimina y retorna el primer NodoCola de la cola. Este método sigue el principio FIFO (Primero en Entrar, Primero en Salir).
 *
 * @return El NodoCola en la cabeza de la cola, o null si la cola está vacía.
 * @autor corina Lynch 
 */
    
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