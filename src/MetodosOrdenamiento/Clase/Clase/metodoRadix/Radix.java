package metodoRadix;

import java.util.Random;

public class Radix {


    public static void main(String[] args) {

        int[] vector = new int[500];
        //int []vector={345,721,420,572,836,467,672,194,365,236,891,746,431,834,247,529,216,389};
        generar(vector);
        imprimir(vector);
        System.out.println("\n\nOrdenamiento Radix: ");
        long inicio, fin;
        inicio = System.currentTimeMillis();
        radix(vector);
        fin = System.currentTimeMillis();
        System.out.println("\n Tiempo que se tardó el programa en ejecutarse: ");
        System.out.println(((float) (fin - inicio) / 1000) + " segundos");
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
            imprimirPrincipal(listaPrincipal);
            copiarAlVector(vector, listaPrincipal);
            imprimir(vector);
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

    private static void generar(int[] vector) {
        Random r = new Random();

        for (int i = 0; i < vector.length; i++) {
            vector[i] = r.nextInt(1000);
        }
    }


}