/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leexTXT;
import sopadeletras.MatrizTablero;
import sopadeletras.ListaPalabra;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
//import sopadeletras.NodoTablero;
//import sopadeletras.NodoLSimple;

/**
 * 
 * @author alexandraloynaz
 */
public class Leertxt {
    private MatrizTablero tablero; 
    private ListaPalabra diccionario;

/**
 * Constructor
 */
    public Leertxt() {
        this.tablero = new MatrizTablero();
        this.diccionario = new ListaPalabra();
    }
    /**
     * Permite al usuario seleccionar y cargar un archivo
     * @return true si se logro cargar el archivo con exito, false si hubo algun error
     */
    public boolean cargarArchivo(){
        JFileChooser selcArchivo = new JFileChooser();
        selcArchivo.setDialogTitle("Seleccionar archivo de texto");
        selcArchivo.setFileFilter(new FileNameExtensionFilter("Archivos TXT","txt"));
        int seleccion = selcArchivo.showOpenDialog(null);
     
        if (seleccion != JFileChooser.APPROVE_OPTION){
            System.out.println("El archivo seleccionado no esta en formato txt o no funciona");
            return false; 
        }
        
        File archivo = selcArchivo.getSelectedFile();
        return revisarArchivo(archivo);
    
    
    }
    /**
     * Revisa que el archivo agregado cumpla con el orden necesario
     * @param archivo
     * @return 
     */
    private boolean revisarArchivo(File archivo){
        BufferedReader br = null;
//        boolean logrado = false; 
        try{
            br= new BufferedReader(new FileReader(archivo));
            String linea;
            boolean diccionario= false; 
            boolean tablero = false; 
            int fila = 0;
            while((linea=br.readLine())!= null){
                linea = linea.trim();
                if(esVacio(linea)){
                    continue;
                }
                if(linea.equals("dic")){
                    diccionario = true;
                    continue; // estoy poniendo los continue para que salte a las siguientes partes y no se quede validando si tablero o diccionario son true or false
                }
                else if(linea.equals("/dic")){
                    diccionario = false; 
                    continue;
                }
                else if(linea.equals("tab")){
                    tablero = true;
                    continue;
                }
                else if(linea.equals("\tab")){
                    tablero = false;
                    continue;}
                if (diccionario){
                    procesarDiccionario(linea);
                
                } else if(tablero){
                fila = procesarTablero(linea,fila);
                }
                
            
            }
            tablero.
                    
        return true;
        } catch (Exception e){
        JOptionPane.showMessageDialog(null, "Error inesperado", "error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
        
    
    
}
    public boolean esVacio(Object texto){
            return texto == null; }
    
    
   /**
    * 
    * @param palabra 
    */ 
    private void procesarDiccionario(String palabra){
        palabra = palabra.trim().toUpperCase();
        if(palabra.length()>=3 && enTablero(palabra)&& soloLetras(palabra)){
            diccionario.insertarFinal(palabra);
        }
    }
    /**
     * 
     * @param linea
     * @param fila
     * @return 
     */
    private int procesarTablero(String linea, int fila){
        String [] letras = linea.split(",");
        if(letras.length!=16){
            JOptionPane.showMessageDialog(null, "El tablero debe contener exactamente 16 letras y estas deben estar separadas por comas", "error", JOptionPane.ERROR_MESSAGE);
            return fila;
        }
        for (int i = 0; i < 16; i++) {
            String letra = letras[i]; 
            if(!esVacia(letra))
            
        }
        
    
    }
    

        
    
    
    
    /**
     * Verifica que la palabra que se desea agregar sean solo letras y que estas se encuntren entre A y Z 
     * @param palabra la palabra que se desea evaluar
     * @return true si solo contiene letras, false si no contiene solo letras
     */
    private boolean soloLetras(String palabra){
        for (int i = 0; i < palabra.length(); i++) {
                char letra = palabra.charAt(i); 
                if(letra<'A' || letra>'Z'){
                    return false; 
                }
        }
        return true;

    }
}


    

