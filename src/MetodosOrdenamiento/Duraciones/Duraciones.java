package MetodosOrdenamiento.Duraciones;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Duraciones {
    public static void main(String[] args) {
        System.out.println("Duraciones de los métodos de ordenamiento: ");
        System.out.println("\nMetodo Burbuja:\n ");
        imprimirDuracion("DuracionBurbuja"); 
        System.out.println("\nMetodo QuickSort:\n ");
        imprimirDuracion("DuracionQuickSort");
        System.out.println("\nMetodo Shell:\n ");
        imprimirDuracion("DuracionShell");
        System.out.println("\nMetodo Radix:\n ");
        imprimirDuracion("DuracionRadix");

    }
    public static void imprimirDuracion(String ruta){
        try {
                File file = new File("src/MetodosOrdenamiento/Duraciones/"+ruta+".txt");
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se encontró.");
            }
    }
}

        
