package EstruturaDeDatosNoLineales.HeapSort;

public class UsoHeapsort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arreglo = {1,2,3};
        heapSort.insertar(arreglo);
        System.out.println("Arreglo ordenado");
        for (int i: heapSort.getArreglo()){
            if(i!=0)
            System.out.print(i+" ");
        }
    }
}
