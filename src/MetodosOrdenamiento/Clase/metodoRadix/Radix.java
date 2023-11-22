package MetodosOrdenamiento.Clase.metodoRadix;

import java.io.FileWriter;
import java.util.Random;

public class Radix {


    public static void main(String[] args) {
        System.out.println("\nOrdenamiento Radix: ");
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
        radix(vector);
        fin = System.currentTimeMillis();
        String duracion = "Tiempo que se tardó el programa en ejecutarse para " +tam+ " elementos: " + ((double) (fin - inicio) / 1000) + " segundos";
        System.out.println(duracion);
        guardarArchivo(duracion);
    }
    public static void guardarArchivo(String duracion){
        try {
            FileWriter archivo = new FileWriter("src/MetodosOrdenamiento/Duraciones/DuracionRadix.txt", true);
            archivo.write(duracion + "\r\n");
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    private static void radix(int[] vector) {
        Elemento[] listaPrincipal;

        listaPrincipal = new Elemento[10];
        for (int i = 0; i <= 9; i++) //Inicializa vector
        {
            Elemento casilla = new Elemento(0);
            listaPrincipal[i] = casilla;
        }
        //Repartir los elementos por la lista principal
        for (int cifra = 0; cifra <= 2; cifra++) {
           // for (int i = 0; i < vector.length; i++) {
            for (int numero : vector) {
                int PotDiez = (int) Math.pow(10, cifra);
                int j = (numero / PotDiez) % 10;
                Elemento nuevo = new Elemento(numero);
                if (listaPrincipal[j].Sig == null) {//Se inserta en la sublista
                    listaPrincipal[j].setSig(nuevo);
                } else {
                    Elemento recorre;
                    recorre = listaPrincipal[j].Sig;//getSig();//recorre toma la dirección del primero de la sublista
                    while (recorre.Sig != null)
                        recorre = recorre.Sig;
                    recorre.Sig = nuevo;
                }

            }
            copiarAlVector(vector, listaPrincipal);
            iniciaPrincipal(listaPrincipal);
        }
    }


    private static void iniciaPrincipal(Elemento[] listaPrincipal) {
        for (Elemento elemento : listaPrincipal) {
            elemento.setSig(null);
        }

    }

    private static void copiarAlVector(int[] vector, Elemento[] listaPrincipal) {

        int j = -1;
        for (Elemento elemento : listaPrincipal) {
            if (elemento.getSig() != null) {
                Elemento inicio = elemento.getSig();
                while (inicio != null) {
                    j++;
                    vector[j] = inicio.num;
                    inicio = inicio.Sig;
                }
            }
        }
    }

    private static void imprimirPrincipal(Elemento[] listaPrincipal) {
        for (int i = 0; i < listaPrincipal.length; i++) {
            if (listaPrincipal[i].getSig() != null) {
                System.out.print("\nIndice " + i + ": ");
                Elemento inicio = listaPrincipal[i].getSig();
                while (inicio != null) {
                    System.out.print(inicio.num + ", ");
                    inicio = inicio.Sig;
                }
            }
        }
    }


    private static void imprimir(int[] vector) {
        System.out.print("\nLos elementos del vector son:");
        for (int num : vector)
            System.out.print(num + ", ");
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