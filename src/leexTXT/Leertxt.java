/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leexTXT;
import sopadeletras.MatrizTablero;
import sopadeletras.ListaSimple;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author alexandraloynaz
 */
public class Leertxt {
    private MatrizTablero tablero; 
    private ListaSimple diccionario;
/**
 * Constructor
 */
    public Leertxt() {
        this.tablero = tablero;
        this.diccionario = diccionario;
    }
    /**
     * 
     * @return true si se logro cargar el archivo con exito
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
        boolean logrado = false; 
        try{
            br= new BufferedReader(new FileReader(archivo));
            String linea;
            boolean diccionario= false; 
            boolean tablero = false; 
            int fila = 0;
            while((linea=br.readLine())!= null){
                linea = linea.trim();
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
                
            
            }
                    
        return true;
        } catch (Exception e){
        JOptionPane.showMessageDialog(null, "Error inesperado", "error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    
    
    
}
}
