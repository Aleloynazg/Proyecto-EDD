/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leerTXT;
import sopadeletras.MatrizTablero;
import sopadeletras.ListaPalabra;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Clase encargada de leer y procesar el archivo TXT para cargar las letras que iran en el tablero y el diccionario de palabras. 
 * @author alexandraloynaz
 */
public class Leertxt {
    private MatrizTablero tablero; 
    private ListaPalabra diccionario;
    private File archivo;

/**
 * Constructor que inicializa las estructuras de datos necesarias, 
 * Un tablero 4x4 vacío 
 * un diccionario de palabras vacío.
 *
 */
    public Leertxt() {
        this.tablero = new MatrizTablero();
        this.diccionario = new ListaPalabra();
    }
    /**
     * Permite al usuario seleccionar un archivo de tecto y cargar su contenido
     * @return true si el archivo se cargó con éxito, false si ocurrió algun error.
     */
    public boolean cargarArchivo(){
        JFileChooser selcArchivo = new JFileChooser();
        selcArchivo.setDialogTitle("Seleccionar archivo de texto");
        selcArchivo.setFileFilter(new FileNameExtensionFilter("Archivos TXT","txt"));
        int seleccion = selcArchivo.showOpenDialog(null);
     
        if (seleccion != JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null, "El archivo seleccionado no esta en formato txt o no funciona", "error", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        
            archivo = selcArchivo.getSelectedFile();
        return revisarArchivo(archivo);
    
    
    }
    
    
    /**
     * Procesa el archivo seleccionado y verifica su formato y contenido.
     * @param archivo EL archivo a procesar.
     * @return  true si el archivo se pudo cargar y tiene el formato correcto, false si ocurrió algun error.
     */
    private boolean revisarArchivo(File archivo){
        BufferedReader br = null;
        boolean tieneDiccionario= false; 
        boolean tieneTablero = false; 
//        boolean logrado = false; 
        try{
            br= new BufferedReader(new FileReader(archivo));
            String linea;
            boolean diccionario= false; 
            boolean tablero = false; 
            int filaAct=0;

            while((linea=br.readLine())!= null){
                linea = linea.trim();
                if(esVacio(linea)){
                    continue;
                }
                if(linea.replace("\uFEFF", "").equals("dic")|| linea.equals("dic")){
                    diccionario = true;
                    tieneDiccionario = true;

                    continue; // estoy poniendo los continue para que salte a las siguientes partes y no se quede validando si tablero o diccionario son true or false
                }
                else if(linea.equals("/dic")){
                    diccionario = false; 

                    continue;
                }
                else if(linea.equals("tab")){
                    tablero = true;
                    tieneTablero = true;
                    continue;
                }
                else if(linea.equals("/tab")){
                    tablero = false;

                    continue;}
                if (diccionario){

                    procesarDiccionario(linea);
                
                } else if(tablero){

                    filaAct=procesarTablero(linea,filaAct);
                    if(filaAct==-1){
                    return false;
                    }
                
                
            
            }
            
            }
            if(!tieneDiccionario ||!tieneTablero){
            return false;}
            else{
        return true;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error inesperado", "error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    /**
     * Agrega las palabras que no aparecen en el diccionario pero si en el tablero al TXT
     * @param palabra palabra que se desea agregar
     * @return true si la palabra fue agregada con éxito, false si no se logro agregar la palabra.
     */
    public boolean agregarPalabraAlDiccionario (String palabra){
        BufferedReader br = null;
        
    if(archivo == null){
        JOptionPane.showMessageDialog(null, "No se ha cargado ningun archivo o error inesperado", "error", JOptionPane.ERROR_MESSAGE);
        return false; 
    }
    try{
        br= new BufferedReader(new FileReader(archivo));
        String palabraNueva = "";
        String linea;
        boolean enDiccionario= false; 
        boolean palabraAgregada = false;
        while((linea = br.readLine())!= null){
        linea = linea.trim();
        if(linea.replace("\uFEFF", "").equals("dic")|| linea.equals("dic")){
            enDiccionario = true; 
            palabraNueva+= linea +"\n";
            continue;
        }
        if(enDiccionario && linea.equals("/dic")){
            if(!palabraAgregada){
            palabraNueva += palabra + "\n";
            palabraAgregada = true; 
            
            }
            enDiccionario = false; 
            palabraNueva += linea +"\n";
            continue;
            
            
        }
        palabraNueva += linea +"\n";
        
        
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false));
        bw.write(palabraNueva);
        bw.close();
        return true; 

        
    
    } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inesperado al actualizar el archivo", "error", JOptionPane.ERROR_MESSAGE);
        return false;
    }


    
    
    
}
    /**
     * Verifica si un objeto es vacio o nulo 
     * @param texto el objeto que se desea verificar.
     * @return true si es nulo, false si no es nulo.
     */
    public boolean esVacio(String texto){
            return texto == null|| texto.trim().equals(""); }
    
    
   /**
    * Procesa una palabra del diccionario, valida que cumpla con los requisitos antes de agregarla al diccionario. 
    * @param palabra La palabra que se desea procesar y agregar al diccionario. 
    */ 
    private void procesarDiccionario(String palabra){
        palabra = palabra.trim().toUpperCase();
        if(palabra.length()>=3 &&  soloLetras(palabra)){
            getDiccionario().insertarFinal(palabra);
        }
    }
    /**
     * Procesa la línea donde se encuentran las letras, debe contener exactamente 16 y las carga en la matriz 4x4 del tablero. 
     * @param linea la línea del archivo que contiene las letras del tablero. 
     * @param fila El número de fila actual. 
     * @return Siempre retorna 4 indicando que se completo el tablero. 
     * 
     */

    private int procesarTablero(String linea, int fila){
        String [] letras = linea.split(",");
        if(letras.length!=16){
            JOptionPane.showMessageDialog(null, "El tablero debe contener exactamente 16 letras y estas deben estar separadas por comas", "error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        for (int i = 0; i < 16; i++) {
            String letra = letras[i].trim(); 
            if (letra.length() != 1 || letra.charAt(0) < 'A' || letra.charAt(0) > 'Z'){
                return -1;}

                int filaactual = i/4;
                int columna = i%4;
                getTablero().establecerNodo(filaactual, columna, letra.charAt(0));
            
            
            }
            
        
        return 4;
    
    }
    
/**
 * Verifica que todas las letras de una palabra existan en el tablero, considerando la repetición de cada letras. 
 * @param palabra la Palabra a verificar. 
 * @return true si todas las letras existen en el tablero y con la frecuencia necesaria, false si eso no ocurre. 
 */
   private boolean enTablero(String palabra){
       palabra = palabra.toUpperCase();
       for (int i = 0; i < palabra.length(); i++) {
           char letra = palabra.charAt(i);
           int vecesEnPalabra= 0;
           for (int j = 0; j <= i; j++) {
               if(palabra.charAt(j)==letra){
                    vecesEnPalabra ++;}
               
           }
//           boolean encontrado = false; 
           int vecesEnTablero= 0;
           for (int fila = 0; fila < 4; fila++) {
               for (int columna = 0; columna < 4; columna++) {
                   if(getTablero().obtenerNodo(fila, columna).getLetra()==letra){
                       vecesEnTablero ++;
                   }
               }
           }
           if(vecesEnPalabra>vecesEnTablero){
               return false;
           }
           
       }
       return true;
   }
  
           
    
    
    
    /**
     * Verifica que una palabra tenga solo letras y que estas se encuntren entre A y Z 
     * @param palabra la palabra a validar
     * @return true si la palabra solo contiene letras, false si no contiene solo letras
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

    /**
     * Obtiene el tablero cargado. 
     * @return la MatrizTablero con las letras cargadas
     */
    public MatrizTablero getTablero() {
        return tablero;
    }

    /**
     * Establece el tablero a utilizar.
     * @param tablero el tablero a utilizar. 
     */
    public void setTablero(MatrizTablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Obtiene el diccionario a utilziar. 
     * @return el diccionario a asignar.
     */
    public ListaPalabra getDiccionario() {
        return diccionario;
    }

    /**
     * Establece el diccionario a utilizar 
     * @param diccionario el diccionario a asignar. 
     */
    public void setDiccionario(ListaPalabra diccionario) {
        this.diccionario = diccionario;
    }
    
}



    

