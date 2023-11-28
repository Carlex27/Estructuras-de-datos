package Mezclas;
import java.io.*;
import java.util.Scanner;

//Clase que contiene el metodo de ordenamiento mezcla directa
public class MezclaDirecta {
    public static void main(String[] args) {
        try {
            File archivo = new File("src/Mezclas/Archivos/Original1.txt");
            Long inicio = System.currentTimeMillis();
            mezclaDirecta(archivo,1000);
            long fin = System.currentTimeMillis();
            String duracion = "Tiempo que se tardó el programa en ejecutarse para 1000 elementos: " + ((double) (fin - inicio) / 1000) + " segundos";
            guardarArchivo(duracion);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void mezclaDirecta(File archivo,int N){
        File aux1 = new File("src/Mezclas/Archivos/Archivo1.txt");
        File aux2 = new File("src/Mezclas/Archivos/Archivo2.txt");
        int PARTICION = 1;
        while(PARTICION < N ){
            divide(archivo, aux1, aux2, PARTICION);
            mezclar(archivo, aux1, aux2, PARTICION);
            PARTICION *=2;
        }
    }
    private static void divide(File archivo,File aux1,File aux2,int PARTICION){
        try{
            Scanner entrada = new Scanner(archivo);
            PrintStream F1 = new PrintStream(aux1);
            PrintStream F2 = new PrintStream(aux2);
            while (entrada.hasNextInt()) {
                int k=0;
                while((k<PARTICION) && entrada.hasNextInt()){
                    int NUM = entrada.nextInt();
                    F1.println(NUM);
                    k++;
                }
                int L=0;
                while(L<PARTICION && entrada.hasNextInt()){
                    int NUM = entrada.nextInt();
                    F2.println(NUM);
                    L++;
                }
            }
            entrada.close();
            F1.close();
            F2.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void mezclar(File archivo, File aux1, File aux2, int PARTICION) {
        try {
            Scanner F1 = new Scanner(aux1);
            Scanner F2 = new Scanner(aux2);
            PrintStream salida = new PrintStream(archivo);
            int NUM1 = 0;
            int NUM2 = 0;
            boolean B1 = true;
            boolean B2 = true;
            if (F1.hasNextInt()) {
                NUM1 = F1.nextInt();
                B1 = false;
            }
            if (F2.hasNextInt()) {
                NUM2 = F2.nextInt();
                B2 = false;
            }
            while ((F1.hasNextInt() || !B1) && (F2.hasNextInt() || !B2)) {
                int K = 0;
                int L = 0;
                while ((K < PARTICION && !B1) && (L < PARTICION && !B2)) {
                    if (NUM1 <= NUM2) {
                        salida.println(NUM1);
                        K++;
                        if (F1.hasNextInt()) {
                            NUM1 = F1.nextInt();
                        } else {
                            B1 = true;
                        }
                    } else {
                        salida.println(NUM2);
                        L++;
                        if (F2.hasNextInt()) {
                            NUM2 = F2.nextInt();
                        } else {
                            B2 = true;
                        }
                    }
                }
                while (K < PARTICION && !B1) {
                    salida.println(NUM1);
                    K++;
                    if (F1.hasNextInt()) {
                        NUM1 = F1.nextInt();
                    } else {
                        B1 = true;
                    }
                }
                while (L < PARTICION && !B2) {
                    salida.println(NUM2);
                    L++;
                    if (F2.hasNextInt()) {
                        NUM2 = F2.nextInt();
                    } else {
                        B2 = true;
                    }
                }
            }
            while (F1.hasNextInt() || !B1) {
                salida.println(NUM1);
                if (F1.hasNextInt()) {
                    NUM1 = F1.nextInt();
                } else {
                    B1 = true;
                }
            }
            while (F2.hasNextInt() || !B2) {
                salida.println(NUM2);
                if (F2.hasNextInt()) {
                    NUM2 = F2.nextInt();
                } else {
                    B2 = true;
                }
            }
            F1.close();
            F2.close();
            salida.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void guardarArchivo(String duracion){
        try {
            FileWriter archivo = new FileWriter("src/Mezclas/Duracion/DuracionMezclaDirecta.txt", true);
            archivo.write(duracion + "\n");
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}
