package Mezclas;

import java.io.*;
import java.util.Scanner;

public class MezclaNatural {
    public static void main(String[] args) {
        try {
            File archivo = new File("src/Mezclas/Archivos/Original2.txt");
            ordenamientoMezclaNatural(archivo);
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
                    try (Scanner input = new Scanner(archivo);
                        PrintWriter output1 = new PrintWriter(aux1);
                        PrintWriter output2 = new PrintWriter(aux2)) {

                        if (input.hasNextInt()) {
                            int prev = input.nextInt();
                            output1.println(prev);
                            boolean outputTo1 = true;

                            while (input.hasNextInt()) {
                                int current = input.nextInt();
                                if (current < prev) {
                                    outputTo1 = !outputTo1;
                                    fin = false;
                                }
                                if (outputTo1) {
                                    output1.println(current);
                                } else {
                                    output2.println(current);
                                }
                                prev = current;
                            }
                        }
                    }

                    try (PrintWriter output = new PrintWriter(archivo);
                        Scanner input1 = new Scanner(aux1);
                        Scanner input2 = new Scanner(aux2)) {

                        if (input1.hasNextInt() && input2.hasNextInt()) {
                            int num1 = input1.nextInt();
                            int num2 = input2.nextInt();

                            while (true) {
                                if (num1 < num2) {
                                    output.println(num1);
                                    if (input1.hasNextInt()) {
                                        num1 = input1.nextInt();
                                    } else {
                                        output.println(num2);
                                        break;
                                    }
                                } else {
                                    output.println(num2);
                                    if (input2.hasNextInt()) {
                                        num2 = input2.nextInt();
                                    } else {
                                        output.println(num1);
                                        break;
                                    }
                                }
                            }
                        }

                        while (input1.hasNextInt()) {
                            output.println(input1.nextInt());
                        }

                        while (input2.hasNextInt()) {
                            output.println(input2.nextInt());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}