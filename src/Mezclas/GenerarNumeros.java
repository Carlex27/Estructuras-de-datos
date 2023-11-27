package Mezclas;

import java.io.BufferedWriter;
import java.io.*;


public class GenerarNumeros {
    public static void main(String[] args) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Mezclas/Archivos/Original2.txt"));
            int n = 1000;
            for (int i = 0; i < n; i++) {
                writer.write((int) (Math.random() * 1000) + " ");
            }
            writer.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
