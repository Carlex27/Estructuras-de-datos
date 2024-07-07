package NoLineales.Grafos.Matriz;
import java.util.Scanner;

import static java.lang.System.*;

public class MatrizAdyacencia {
    int[][] tabla;
    char[] nodos;

    public MatrizAdyacencia(int tam) {
        tabla = new int[tam][tam];
        nodos = new char[tam];
        for (int i = 0; i < tam; i++)
            nodos[i] = (char) (65 + i);
    }

    public void llenar(int tam) {
        for (int ren = 0; ren < tam; ren++) {
            System.out.println("Conexiones del nodo: " + nodos[ren]);
            System.out.println("Escribe 1 si hay ó 0 si no hay conexión con los siguientes nodos: ");
            for (int col = 0; col < tam; col++) {
                System.out.println(nodos[col]);
                tabla[ren][col] = entrada();
            }
        }

    }

    public void imprimir(int tam) {
        for (int ren = 0; ren < tam; ren++) {
            System.out.print("\nEl nodo " + nodos[ren] + " se conecta con: ");
            for (int col = 0; col < tam; col++)
                if (tabla[ren][col] == 1)
                    System.out.print(nodos[col] + " ");

        }
    }

    private int entrada() {
        Scanner lectura = new Scanner(in);
        int valor;

        do {
            valor = lectura.nextInt();
            if (valor < 0 || valor > 1)
                System.out.println("Valor fuera de rango, teclea 1 ó 0");
        } while (valor < 0 || valor > 1);
        lectura.close();
        return valor;

    }
    
}
