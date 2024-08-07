package MetodosOrdenamiento;

public class Burbuja {
    //Clase que implementa el metodo de ordenamiento burbuja
    public static void main(String[] args) {
        int[] arreglo = {5, 4, 3, 2, 1};
        int auxiliar;
        boolean cambios = false;
        long inicio, fin;
        inicio = System.currentTimeMillis();
        while (true) {
            cambios = false;
            for (int i = 1; i < arreglo.length; i++) {
                if (arreglo[i] < arreglo[i - 1]) {
                    auxiliar = arreglo[i];
                    arreglo[i] = arreglo[i - 1];
                    arreglo[i - 1] = auxiliar;
                    cambios = true;
                }
            }
            if (cambios == false) {
                break;
            }
        }
        fin = System.currentTimeMillis();
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
        System.out.println((float)(fin - inicio)/1000 + " segundos");
        
    }
}
