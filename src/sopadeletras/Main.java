/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopadeletras;
import leerTXT.Leertxt;

/**
 *
 * @author alexandraloynaz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Leertxt lector = new Leertxt();
        if(lector.cargarArchivo()){
            System.out.println("Archivo cargado ");}

        System.out.println("La matriz");

        MatrizTablero tablero = lector.getTablero();
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 4; col++) {
                char letra = tablero.obtenerNodo(fila, col).getLetra();
                System.out.print(letra+"");
            }
            System.out.println("");
            
            
        }

        tablero.conectarNodos();
        
        
        
        
        
        
        
        
        
        
        
}
}


