package Mezclas;
import java.io.*;
public class MezclaDirecta {
    public static void main(String[] args) {
        String entrada = "ArrayDesordenado.txt";
        String salida = "ArrayOrdenado.txt";
        Long inicio, fin;
        int[] arreglo = leerArchivo(entrada);
        inicio = System.currentTimeMillis();
        int[] arreglOrdenado = mezclaDirecta(arreglo);
        fin = System.currentTimeMillis();
        //int[] arreglOrdenado = generarArray(1000);
        escribirArchivo(arreglOrdenado, salida);
        guardarTiempo(inicio, fin);
    }
    
    public static int[] mezclaDirecta(int[] arreglo) {
        int i,j,k;
        if(arreglo.length>1){
            //Partimos el arreglo en dos
            int nElementosIzq=arreglo.length/2;
            int nElementosDer=arreglo.length-nElementosIzq;
            int arregloIzq[]=new int[nElementosIzq];
            int arregloDer[]=new int[nElementosDer];
            //Copiamos los elementos de la parte primera al arreglo izquierdo
            for(i=0;i<nElementosIzq;i++){
                arregloIzq[i]=arreglo[i];
            }
            //Copiamos los elementos de la parte segunda al arreglo derecho
            for(i=nElementosIzq;i<nElementosIzq+nElementosDer;i++){
                arregloDer[i-nElementosIzq]=arreglo[i];
            }
            //Recursividad
            arregloIzq=mezclaDirecta(arregloIzq);
            arregloDer=mezclaDirecta(arregloDer);
            i=0; j=0; k=0;
            while(arregloIzq.length!=j && arregloDer.length!=k){
                if(arregloIzq[j]<arregloDer[k]){
                    arreglo[i]=arregloIzq[j];
                    i++;
                    j++;
                }else{
                    arreglo[i]=arregloDer[k];
                    i++;
                    k++;
                }
            }  
            //Arreglo final
            while(arregloIzq.length!=j){
                arreglo[i]=arregloIzq[j];
                i++;
                j++;
            }
            while(arregloDer.length!=k){
                arreglo[i]=arregloDer[k];
                i++;
                k++;
            }
            
        }
        return arreglo;
    }
    
    public static int[] leerArchivo(String nombre) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Mezclas/Archivos/"+nombre));
            String line = reader.readLine();
            String[] numbers = line.split(" ");
            int[] arreglo = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arreglo[i] = Integer.parseInt(numbers[i]);
            }
            reader.close();
            return arreglo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void escribirArchivo(int[] arreglo, String nombre) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Mezclas/Archivos/"+nombre));
            for (int i = 0; i < arreglo.length; i++) {
                writer.write(arreglo[i] + " ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[] generarArray(int tam){
        int[] arreglo = new int[tam];
        for (int i = 0; i < tam; i++) {
            arreglo[i] = (int) (Math.random() * 1000);
        }
        return arreglo;
    }
    public static void guardarTiempo(Long inicio, Long fin){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Mezclas/Duracion/TiemposMezclaDirecta.txt", true));
            writer.write("Tiempo de ejecucion: " + ((double) (fin - inicio) / 1000) + " segundos");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}


