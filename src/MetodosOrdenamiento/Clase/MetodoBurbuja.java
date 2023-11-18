
import java.util.Random;
import java.util.Scanner;

public class MetodoBurbuja {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vector = new int[10];

        GenerarAleatorio(vector);
        System.out.println("Vector antes de ordenar: ");
        imprimirVector(vector);
        ordenarBurbuja(vector);
        System.out.println("\nVector ordenado: ");
        imprimirVector(vector);
        buscar(vector);
    }

    public static void GenerarAleatorio(int[] v) {
        Random numeroAzar = new Random();
        for (int i = 0; i <= 9; i++) {
            v[i] = numeroAzar.nextInt(9) + 1;
        }
    }

    public static void ordenarBurbuja(int[] v) {
        int auxiliar;
        for (int j = 8; j >= 0; j--) {
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
        for (int i = 0; i <= 9; i++) {
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








