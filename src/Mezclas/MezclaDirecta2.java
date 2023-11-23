package Mezclas;
import java.io.*;
//Clase que contiene el metodo de ordenamiento mezcla directa
public class MezclaDirecta2 {
    public static void main(String[] args) {
        int[] arreglo = leerArchivo ("src/Mezclas/Archivos/Archivo1.txt");
    }
    public static int[] leerArchivo(String archivo) {
        int[] arreglo = new int[1000];
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                arreglo[i] = Integer.parseInt(linea);
                i++;
            }
            br.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return arreglo;
    }
}
