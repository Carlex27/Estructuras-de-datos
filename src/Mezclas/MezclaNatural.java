package Mezclas;

import java.io.*;
import java.util.Scanner;

public class MezclaNatural {
    public static void main(String[] args) {
        try {
            File archivo = new File("src/Mezclas/Archivos/Original2.txt");
            Long inicio = System.currentTimeMillis();
            ordenamientoMezclaNatural(archivo);
            long fin = System.currentTimeMillis();
            String duracion = "Tiempo que se tardó el programa en ejecutarse para 1000 elementos: " + ((double) (fin - inicio) / 1000) + " segundos";
            guardarArchivo(duracion);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
        
    public static void ordenamientoMezclaNatural(File archivo) {
            try {
                File aux1 = new File("src/Mezclas/Archivos/Archivo1.txt");
                File aux2 = new File("src/Mezclas/Archivos/Archivo2.txt");
                boolean fin = false;
                while (!fin) {
                    fin = true;
                    Scanner entrada = new Scanner(archivo);
                    PrintWriter arch1 = new PrintWriter(aux1);
                    PrintWriter arch2 = new PrintWriter(aux2);
                        if (entrada.hasNextInt()) {
                            int previo = entrada.nextInt();
                            arch1.println(previo);
                            boolean salida1 = true;

                            while (entrada.hasNextInt()) {
                                int actual = entrada.nextInt();
                                if (actual < previo) {
                                    salida1 = !salida1;
                                    fin = false;
                                }
                                if (salida1) {
                                    arch1.println(actual);
                                } else {
                                    arch2.println(actual);
                                }
                                previo = actual;
                            }
                        }
                        arch1.close();
                        arch2.close();
                        entrada.close();

                    PrintWriter salida = new PrintWriter(archivo);
                    Scanner Larch1 = new Scanner(aux1);
                    Scanner Larch2 = new Scanner(aux2);

                        if (Larch1.hasNextInt() && Larch2.hasNextInt()) {
                            int num1 = Larch1.nextInt();
                            int num2 = Larch2.nextInt();

                            while (true) {
                                if (num1 < num2) {
                                    salida.println(num1);
                                    if (Larch1.hasNextInt()) {
                                        num1 = Larch1.nextInt();
                                    } else {
                                        salida.println(num2);
                                        break;
                                    }
                                } else {
                                    salida.println(num2);
                                    if (Larch2.hasNextInt()) {
                                        num2 = Larch2.nextInt();
                                    } else {
                                        salida.println(num1);
                                        break;
                                    }
                                }
                            }
                        }

                        while (Larch1.hasNextInt()) {
                            salida.println(Larch1.nextInt());
                        }

                        while (Larch2.hasNextInt()) {
                            salida.println(Larch2.nextInt());
                        }
                        salida.close();
                        Larch1.close();
                        Larch2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void guardarArchivo(String duracion){
            try {
                FileWriter archivo = new FileWriter("src/Mezclas/Duracion/DuracionMezclaNatural.txt", true);
                archivo.write(duracion + "\n");
                archivo.close();
            } catch (Exception e) {
                System.out.println("Error al escribir");
            }
        }
}