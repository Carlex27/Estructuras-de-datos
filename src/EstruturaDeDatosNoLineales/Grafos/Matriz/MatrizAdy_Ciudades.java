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
        System.out.println();
    }
    public void ruta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Aeropuerto de origen: ");
        String origen = leer.nextLine();
        System.out.println("Aeropuerto de destino: ");
        String destino = leer.nextLine();
        imprimirRuta(origen, destino);
        leer.close();
    }
    public void imprimirRuta(String origen, String destino) {
        int origenIndice = EncontrarIndice(origen);
        int destinoIndice = EncontrarIndice(destino);

        if (origenIndice == -1 || destinoIndice == -1) {
            System.out.println("No se encontró el origen o el destino en la lista de nodos.");
            return;
        }

        Elemento[][] dijkstra = new Elemento[this.tam][2];
        for (int i = 0; i < this.tam; i++) {
            dijkstra[i][0] = new Elemento(Integer.MAX_VALUE, 0); // Inicializar distancias con valor infinito
            dijkstra[i][1] = new Elemento();
        }

        dijkstra[origenIndice][0].setDistancia(0); // Establecer distancia del origen a 0

        // Implementar el algoritmo Dijkstra
        for (int i = 0; i < this.tam; i++) {
            int nodoActual = obtenerNodoConMenorDistancia(dijkstra);
            dijkstra[nodoActual][1].setVisitado(true);

            // Actualizar las distancias de los nodos adyacentes no visitados
            for (int j = 0; j < this.tam; j++) {
                if (!dijkstra[j][1].getVisitado() && tabla[nodoActual][j] == 1) {
                    int distancia = dijkstra[nodoActual][0].getDistancia() + 1; // Considerar que cada conexión tiene una distancia de 1
                    if (distancia < dijkstra[j][0].getDistancia()) {
                        dijkstra[j][0].setDistancia(distancia);
                        dijkstra[j][0].setAnterior(nodoActual);
                    }
                }
            }
        }

        // Imprimir la ruta desde el origen hasta el destino
        int nodoActual = destinoIndice;
        String ruta = nodos[nodoActual];
        while (nodoActual != origenIndice) {
            nodoActual = dijkstra[nodoActual][0].getAnterior();
            ruta = nodos[nodoActual] + " -> " + ruta;
        }

        System.out.println("Ruta desde " + origen + " hasta " + destino + ": " + ruta);
    }

    private int obtenerNodoConMenorDistancia(Elemento[][] dijkstra) {
        int minDistancia = Integer.MAX_VALUE;
        int nodoMinDistancia = -1;
        for (int i = 0; i < this.tam; i++) {
            if (!dijkstra[i][1].getVisitado() && dijkstra[i][0].getDistancia() < minDistancia) {
                minDistancia = dijkstra[i][0].getDistancia();
                nodoMinDistancia = i;
            }
        }
        return nodoMinDistancia;
    }
    private int EncontrarIndice(String nombre){
        int indice=0;
        for(int i=0;i<this.tam;i++){
            if(nodos[i].equalsIgnoreCase(nombre)){
                indice=i;
                break;
            }
        }
        return indice;
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
