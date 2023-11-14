package EstruturaDeDatosNoLineales.Grafos.Matriz;

public class UsoMatriz {
    public static void main(String[] args) {
        //Matriz de adyacencia
        MatrizAdy_Ciudades matriz = new MatrizAdy_Ciudades(4);
        matriz.llenar(4);
        matriz.imprimir(4);
        
    }
}
