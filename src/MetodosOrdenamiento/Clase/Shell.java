package MetodosOrdenamiento.Clase;

import java.io.FileWriter;
import java.util.Random;

public class Shell {
    public static void main(String[] args) {
        System.out.println("\nOrdenamiento Shell: ");
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
        ordenar(vector, vector.length);
        fin = System.currentTimeMillis();
        String duracion = "Tiempo que se tardó el programa en ejecutarse para " +tam+ " elementos: " + ((double) (fin - inicio) / 1000) + " segundos";
        System.out.println(duracion);
        guardarArchivo(duracion);
    }
    public static void guardarArchivo(String duracion){
        try {
            FileWriter archivo = new FileWriter("src/MetodosOrdenamiento/Duraciones/DuracionShell.txt", true);
            archivo.write(duracion + "\r\n");
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    private static void ordenar(int[] vector, int n) {
        int inicio, fin, j, tam, movimientos, pasadas;
        tam = n;
        while (tam > 1) {
			/*Este ciclo  va haciendo las particiones y obliga a que se comparen
			las parejas de los subgrupos.*/
            tam = tam / 2;
            
            if (n % tam == 0)
                pasadas = n / tam - 1;
            else
                pasadas = n / tam;
            for (int k = pasadas; k > 0; k--) {
                //Este ciclo sirve para que se revisen varias veces los subconjuntos
                // hasta que queden ordenados
                inicio = 0;
                fin = tam - 1;
                movimientos = 0;
                while (inicio < n) {
                    //Este ciclo sirve para comparar todos los subconjuntos del vector
                    for (int i = inicio; i <= fin && (j = i + tam) < n; i++) {
                        //Este for sirve para comparar dos subconjuntos del arreglo
                        if (j < n && vector[i] > vector[j]) {
                            intercambio(vector, i, j);
                            movimientos++;
                        }
                    }
                    inicio = inicio + tam;
                    fin = fin + tam;
                }
                if (movimientos == 0) break;
            }
            
        }
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
