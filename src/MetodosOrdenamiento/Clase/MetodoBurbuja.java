
import java.util.Random;
import java.util.Scanner;
//Clase que contiene el metodo de ordenamiento burbuja
public class MetodoBurbuja {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Long inicio = 0L;
        Long fin = 0L;
        int[] vector;

        
        vector = GenerarAleatorio(5000);
        inicio = System.currentTimeMillis();
        ordenarBurbuja(vector);
        fin = System.currentTimeMillis();
        String duracion = "Tiempo que se tardó el programa en ejecutarse para 1000 elementos: " + ((float) (fin - inicio) / 1000) + " segundos";
        System.out.println(duracion);
    }

    public static int[] GenerarAleatorio(int tam) {
        Random numeroAzar = new Random();
        int[] v = new int[tam];
        for (int i = 0; i < tam; i++) {
            v[i] = numeroAzar.nextInt(5000) + 1;
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








