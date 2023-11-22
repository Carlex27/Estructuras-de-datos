package MetodosOrdenamiento.Clase;

import java.io.FileWriter;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("\nOrdenamiento QuickSort: ");
        int[] vector = new int[2000];
        guardarDuracion(vector, vector.length);
        vector = new int[3000];
        guardarDuracion(vector, vector.length);
        vector = new int[4000];
        guardarDuracion(vector, vector.length);

    }
    public static void guardarDuracion(int[] vector,int tam){
        Long inicio = 0L;
        Long fin = 0L;
        vector=genera(tam);
        inicio = System.currentTimeMillis();
        quicksort(vector, 0, vector.length - 1);
        fin = System.currentTimeMillis();
        String duracion = "Tiempo que se tardó el programa en ejecutarse para " +tam+ " elementos: " + ((double) (fin - inicio) / 1000) + " segundos";
        System.out.println(duracion);
        guardarArchivo(duracion);
    }
    public static void guardarArchivo(String duracion){
        try {
            FileWriter archivo = new FileWriter("src/MetodosOrdenamiento/Duraciones/DuracionQuickSort.txt", true);
            archivo.write(duracion + "\r\n");
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
    private static void quicksort(int[] vector, int izquierda, int derecha) {
        int i, j, pivote;

        pivote = vector[(izquierda + derecha) / 2];
        i = izquierda;
        j = derecha;
        do {
            while (vector[i] < pivote)
                i++;
            while (vector[j] > pivote)
                j--;
            if (i <= j) {
                intercambio(vector, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (izquierda < j)
            quicksort(vector, izquierda, j);
        if (i < derecha)
            quicksort(vector, i, derecha);
    }


    private static void intercambio(int[] vector, int i, int j) {
        int aux;

        aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }

    private static void imprimir(int[] vector) {
        System.out.print("\nLos elementos del vector son:");
        for (int j : vector) {
            System.out.print(j + ", ");
        }
    }

    private static int[] genera(int tam) {
        Random r = new Random();
        int[] vector = new int[tam];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = r.nextInt(vector.length)+1;
        }
        return vector;
    }
}


