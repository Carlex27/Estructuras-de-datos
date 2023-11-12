package EstruturaDeDatosNoLineales.HeapSort;



public class HeapSort {
    private int[] arreglo;
    public HeapSort(){
        arreglo= new int[99];
    }
    public HeapSort(int tam){
        arreglo= new int[tam];
    }
    public int[] getArreglo() {
        return arreglo;
    }
    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }
    public void insertar(int[] arreglo){   
        for(int i: arreglo){
            insertar(i);
        }
    }
    private void insertar(int valor){
        int pos=0;
        while (arreglo[pos]!=0){
            if (valor<arreglo[pos]){
                pos=pos*2+1;
            }else{
                pos=pos*2+2;
            }
        }
        arreglo[pos]=valor;
    }
}
