package Mezclas;

import java.io.*;


public class GenerarNumeros {
    public static void main(String[] args) {
        try{
            PrintStream writer = new PrintStream(new File("src/Mezclas/Archivos/Original2.txt"));
            int n = 1000;
            for (int i = 0; i < n; i++) {
                writer.println((int) (Math.random() * 1000)+1);
            }
            writer.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
