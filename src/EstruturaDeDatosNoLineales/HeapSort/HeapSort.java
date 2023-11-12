package EstruturaDeDatosNoLineales.HeapSort;

import java.util.Scanner;

public class HeapSort {
    private int[] arreglo;
    private int tamanio;
    public HeapSort(){
        arreglo=new int[99];
        tamanio=0;
    }
    public HeapSort(int n){
        arreglo=new int[n];
        tamanio=0;
    }

    public int[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }

    private int getTamanio() {
        return tamanio;
    }

    private void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    //Metodo para ordenar el vector
    private void ordenar() {
       
        for (int i = tamanio - 1; i >= 0; i--) {
            
            int temp = arreglo[0];
            arreglo[0] = arreglo[i];
            arreglo[i] = temp;
    
            heapDown(i, 0);
        }
    }
    
    
    private void heapDown(int n, int i) {
        int max = i; 
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
    
        if (leftChild < n && arreglo[leftChild] > arreglo[max])
            max = leftChild;
    
        if (rightChild < n && arreglo[rightChild] > arreglo[max])
            max = rightChild;
    
        if (max != i) {
            // intercambiar
            int swap = arreglo[i];
            arreglo[i] = arreglo[max];
            arreglo[max] = swap;
            heapDown(n, max);
        }
    }


    //Metodo que inserta los elementos en un arreglo
    public void insertar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la cantidad de elementos a insertar");
        int n = sc.nextInt();
        int j = getTamanio();
            for (int i = 0; i < n; i++) {
                System.out.println("Dime el elemento a insertar");
                arreglo[j] = sc.nextInt();
                heapUp(j);
                j++;
            }
        sc.close();
        setTamanio(j);
        ordenar();
    }
    //Metodo que comprueba si el padre es mayor que el hijo
    private void heapUp(int i) {
        int padre = (i - 1) / 2;
        int temp = arreglo[i];
            while (i > 0 && arreglo[padre] < temp) {
                arreglo[i] = arreglo[padre];
                i = padre;
                padre = (i - 1) / 2;
            }
        arreglo[i] = temp;
    }
    public void imprimir(){
        for (int i = 0; i < getTamanio(); i++) {
            System.out.print(arreglo[i]+" ");
        }
    }
}
