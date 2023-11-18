package EstruturaDeDatosNoLineales.Grafos.Matriz;

import java.util.Scanner;

import static java.lang.System.in;

public class MatrizAdy_Ciudades {
    private int[][] tabla;
    private String[] nodos;

    public MatrizAdy_Ciudades(int tam) {
        tabla = new int[tam][tam];
        nodos = new String[tam];
        for (int i = 0; i < tam; i++)
            nodos[i] = leerNombres();

    }

    private String leerNombres() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nombre del nodo");
        in.close();
        return in.nextLine();
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

    public int[][] getTabla() {
        return tabla;
    }

    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }

    public String[] getNodos() {
        return nodos;
    }

    public void setNodos(String[] nodos) {
        this.nodos = nodos;
    }
}
