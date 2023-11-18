package Mezclas;

public class MezclaDirecta {
    public static void main(String[] args) {
        int[] arreglo = { 5, 4, 3, 2, 1 };
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);
        mezclaDirecta(arreglo);
        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arreglo);
    }
    public static void mezclaDirecta(int[] arreglo) {
        int n = arreglo.length;
        int[] auxiliar = new int[n];
        mezclaDirecta(arreglo, auxiliar, 0, n - 1);
    }
    private static void mezclaDirecta(int[] arreglo, int[] auxiliar, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int centro = (izquierda + derecha) / 2;
            mezclaDirecta(arreglo, auxiliar, izquierda, centro);
            mezclaDirecta(arreglo, auxiliar, centro + 1, derecha);
            mezcla(arreglo, auxiliar, izquierda, centro + 1, derecha);
        }
    }
    private static void mezcla(int[] arreglo, int[] auxiliar, int izquierda, int derecha, int derechaFin) {
        int izquierdaFin = derecha - 1;
        int k = izquierda;
        int num = derechaFin - izquierda + 1;
        while (izquierda <= izquierdaFin && derecha <= derechaFin) {
            if (arreglo[izquierda] <= arreglo[derecha]) {
                auxiliar[k++] = arreglo[izquierda++];
            } else {
                auxiliar[k++] = arreglo[derecha++];
            }
        }
        while (izquierda <= izquierdaFin) {
            auxiliar[k++] = arreglo[izquierda++];
        }
        while (derecha <= derechaFin) {
            auxiliar[k++] = arreglo[derecha++];
        }
        for (int i = 0; i < num; i++, derechaFin--) {
            arreglo[derechaFin] = auxiliar[derechaFin];
        }
    }
    public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

}
