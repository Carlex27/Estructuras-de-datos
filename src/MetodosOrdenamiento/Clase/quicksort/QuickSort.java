package MetodosOrdenamiento.Clase.quicksort;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] vector = new int[15];

        genera(vector);
        imprimir(vector);
        System.out.println("\n\nOrdenamiento QuickSort: ");
        quicksort(vector, 0, vector.length - 1);
        imprimir(vector);
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

    private static void genera(int[] vector) {
        Random r = new Random();

        for (int i = 0; i < vector.length; i++) {
            vector[i] = r.nextInt(101);
        }
    }
}


