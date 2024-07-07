package NoLineales.Grafos.Matriz;

import java.util.ArrayList;
import java.util.Collections;
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
    // Método para leer el nombre de los nodos
    private String leerNombres() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nombre del nodo");
        return in.nextLine(); 
    }
    // Método para llenar la matriz
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
    // Método para imprimir la matriz
    public void imprimir() {
        for (int ren = 0; ren < this.tam; ren++) {
            System.out.print("\nEl Aeropuerto de " + nodos[ren] + " se conecta con: ");
            for (int col = 0; col < this.tam; col++)
                if (tabla[ren][col] == 1)
                    System.out.print(nodos[col] + ", ");
        }
        System.out.println();
    }
    // Método para buscar la ruta más corta entre dos nodos
    public void ruta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Aeropuerto de origen: ");
        String origen = leer.nextLine();
        System.out.println("Aeropuerto de destino: ");
        String destino = leer.nextLine();
        imprimirRuta(origen, destino);
        leer.close();
    }
    // Método para imprimir la ruta más corta entre dos nodos
    private void imprimirRuta(String origen, String destino) {
        int origenIndice = EncontrarIndice(origen);
        int destinoIndice = EncontrarIndice(destino);

        if (origenIndice == -1 || destinoIndice == -1) {
            System.out.println("No se encontró el origen o el destino en la lista de nodos.");
            return;
        }

        // Implementar algoritmo de Dijkstra
        int[] distancias = new int[this.tam];
        int[] previos = new int[this.tam];
        boolean[] visitados = new boolean[this.tam];

        // Inicializar distancias y previos
        for (int i = 0; i < this.tam; i++) {
            distancias[i] = Integer.MAX_VALUE;
            previos[i] = -1;
        }
        
        distancias[origenIndice] = 0;
        
        for (int i = 0; i < this.tam; i++) {
            // Encontrar el nodo no visitado con la distancia más corta
            int u = -1;
            for (int j = 0; j < this.tam; j++) {
                // Si no se ha visitado y (no se ha encontrado nodo o distancia más corta)
                if (!visitados[j] && (u == -1 || distancias[j] < distancias[u])) {
                    u = j;
                }
            }
            // Si no se encontró un nodo no visitado, terminar
            if (distancias[u] == Integer.MAX_VALUE) {
                break; // Todos los nodos restantes son inalcanzables
            }

            visitados[u] = true;
            // Actualizar distancias de los nodos adyacentes
            for (int j = 0; j < this.tam; j++) {
                // Si hay una conexión y no se ha visitado
                int v = tabla[u][j];
                if (v != 0 && distancias[u] + v < distancias[j]) {
                    distancias[j] = distancias[u] + v;
                    previos[j] = u;
                }
            }
        }
        // Imprimir la ruta
        if (previos[destinoIndice] == -1) {
            System.out.println("No hay ruta desde " + origen + " hasta " + destino);
        } else {
            // Construir la ruta
            ArrayList<String> ruta = new ArrayList<>();
            // Agregar el destino
            for (int u = destinoIndice; u != -1; u = previos[u]) {
                ruta.add(nodos[u]);
            }
            // Imprimir la ruta
            Collections.reverse(ruta);
            System.out.println("Ruta desde " + origen + " hasta " + destino + ": " + String.join(" -> ", ruta));
        }
    }
    // Busca el índice de un nodo por su nombre
    private int EncontrarIndice(String nombre) {
        int indice = 0;
        for (int i = 0; i < this.tam; i++) {
            if (nodos[i].equalsIgnoreCase(nombre)) {
                indice = i;
                break;
            }
        }
        return indice;
    }
    // Método para validar la entrada de datos
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
    //Setters y getters
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
