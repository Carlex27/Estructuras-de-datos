package MetodosOrdenamiento;
//Clase que implementa el metodo de ordenamiento QuickSort
public class QuickSort {
    //Metodo main
    public static void main(String[] args) {
        int[] arreglo = {5, 4, 3, 2, 1};
        quickSort(arreglo, 0, arreglo.length - 1);
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }        
    }
    //Metodo que implementa el ordenamiento QuickSort
    public static void quickSort(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quickSort(arreglo, izquierda, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, derecha);
        }
    }
    //Metodo que implementa la particion del arreglo
    public static int particion(int[] arreglo, int izquierda, int derecha) {
        int pivote = arreglo[derecha];
        int i = (izquierda - 1);
        for (int j = izquierda; j < derecha; j++) {
            if (arreglo[j] < pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[derecha];
        arreglo[derecha] = temp;
        return i + 1;
    }
}
