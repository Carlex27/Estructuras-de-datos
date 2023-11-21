package EstruturaDeDatosNoLineales.Grafos.Matriz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UsoMatriz {
    public static void main(String[] args) {
        //Matriz de adyacencia
        //MatrizAdy_Ciudades matriz = new MatrizAdy_Ciudades(7);
        //matriz.llenar();
        MatrizAdy_Ciudades matriz = cargarArchivo();
        matriz.imprimir();
        matriz.ruta();
        guardarArchivo(matriz);
    }
   
    //METODO QUE GUARDA LOS DATOS EN UN ARCHIVO BINARIO
    public static void guardarArchivo(MatrizAdy_Ciudades matriz){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("GrafoAeropuertos.txt"));
            salida.writeObject(matriz);
            salida.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //METODO QUE CARGA LOS DATOS DEL ARCHIVO BINARIO
    public static MatrizAdy_Ciudades cargarArchivo(){
        try{
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("GrafoAeropuertos.txt"));
            MatrizAdy_Ciudades matriz;
            matriz=(MatrizAdy_Ciudades) entrada.readObject();       
            entrada.close();
            return matriz;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
