package EstruturaDeDatosNoLineales.Grafos.Matriz;

import java.util.Scanner;

import static java.lang.System.in;

import java.io.Serializable;

public class MatrizAdy_Ciudades implements Serializable{
    private int[][] tabla;
    private String[] nodos;
    private int tam;

    public MatrizAdy_Ciudades(int tam) {
        tabla = new int[tam][tam];
        nodos = new String[tam];
        this.tam = tam;
        for (int i = 0; i < tam; i++)
            nodos[i] = leerNombres();

    }

    private String leerNombres() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nombre del nodo");
        return in.nextLine(); 
    }

    public void llenar() {
        for (int ren = 0; ren < this.tam; ren++) {
            System.out.println("Conexiones del nodo: " + nodos[ren]);
            System.out.println("Escribe 1 si hay ó 0 si no hay conexión con los siguientes nodos: ");
            for (int col = 0; col < this.tam; col++) {
                System.out.println(nodos[col]);
                tabla[ren][col] = entrada();
            }
        }

    }

    public void imprimir() {
        for (int ren = 0; ren < this.tam; ren++) {
            System.out.print("\nEl Aeropuerto de " + nodos[ren] + " se conecta con: ");
            for (int col = 0; col < this.tam; col++)
                if (tabla[ren][col] == 1)
                    System.out.print(nodos[col] + ", ");
        }
    }
    public int ruta(){
        Scanner in = new Scanner(System.in);
        System.out.println("Aeropuerto de origen: ");
        String origen = in.nextLine();
        System.out.println("Aeropuerto de destino: ");
        String destino = in.nextLine();
        int saltos=contarSaltos(origen,destino);
        return saltos;
    }
    private int contarSaltos(String origen, String destino){
        int saltos=0;

        
        return saltos;
    }
    

    private int entrada() {
        Scanner lectura = new Scanner(in);
        int valor;
        do {
            valor = lectura.nextInt();
            if (valor < 0 || valor > 1)
                System.out.println("Valor fuera de rango, teclea 1 ó 0");
        } while (valor < 0 || valor > 1);
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
    public int getTam() {
        return tam;
    }
    public void setTam(int tam) {
        this.tam = tam;
    }
}
