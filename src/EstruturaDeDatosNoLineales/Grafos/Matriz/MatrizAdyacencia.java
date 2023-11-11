package EstruturaDeDatosNoLineales.Grafos.Matriz;

public class MatrizAdyacencia {
    int [][] tabla;
    char[]nodos;
    public MatrizAdyacencia(int tam){
        tabla=new int [tam][tam];
        nodos=new char[tam];
        for(int i=0;i<tam;i++){
            nodos[i]=(char)(65+i);
        }
    }
    public void llenar(int tam){
        for(int ren=0;ren<tam;ren++){
            System.out.println("Conecciones del nodo: " + nodos[ren]);
            System.out.println("Escribe 1 si  hay o 0 si no hay conexion");
            for(int col=0;col<tam; col++){

            }
        }
    }
    
}
