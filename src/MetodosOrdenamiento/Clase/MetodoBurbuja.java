package MetodosOrdenamiento.Clase;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
//Clase que contiene el metodo de ordenamiento burbuja
public class MetodoBurbuja {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vector=new int[1000];
        guardarDuracion(vector,vector.length);
        vector=new int[2000];
        guardarDuracion(vector, vector.length);
        vector=new int[3000];
        guardarDuracion(vector, vector.length);
        vector=new int[4000];
        guardarDuracion(vector, vector.length);
        vector=new int[5000];
        guardarDuracion(vector, vector.length);
    }
    public static void guardarDuracion(int[] vector,int tam){
        Long inicio = 0L;
        Long fin = 0L;
        vector=GenerarAleatorio(tam);
        inicio = System.currentTimeMillis();
        ordenarBurbuja(vector);
        fin = System.currentTimeMillis();
        String duracion = "Tiempo que se tardó el programa en ejecutarse para " +tam+ " elementos: " + ((double) (fin - inicio) / 1000) + " segundos";
        System.out.println(duracion);
        guardarArchivo(duracion);
    }
    public static void guardarArchivo(String duracion){
        try {
            FileWriter archivo = new FileWriter("src/MetodosOrdenamiento/Duraciones/DuracionBurbuja.txt", true);
            archivo.write(duracion + "\r\n");
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    public static int[] GenerarAleatorio(int tam) {
        Random numeroAzar = new Random();
        int[] v = new int[tam];
        for (int i = 0; i < tam; i++) {
            v[i] = numeroAzar.nextInt(tam) + 1;
        }
        return v;
    }

    public static void ordenarBurbuja(int[] v) {
        int auxiliar;
        for (int j = v.length-2; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                if (v[i] > v[i + 1]) {
                    auxiliar = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = auxiliar;
                }
            }
        }

    }

    public static void imprimirVector(int[] v) {
        for (int i = 0; i <= v.length; i++) {
            System.out.print(v[i] + ",");
        }
    }

    public static void buscar(int[] v) {
        int buscarValor;

        int i;
        boolean encontrado;

        System.out.println("\nDame el valor a buscar:");
        buscarValor = leer.nextInt();
        i = 0;
        encontrado = false;
        while (i <= 9 && !encontrado) {
            if (buscarValor == v[i])
                encontrado = true;
            i++;
        }
        if (encontrado)
            System.out.println("El elemento si se encuentra dentro del vector");
        else
            System.out.println("El elemento no se encuentra");
    }
}








