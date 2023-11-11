package EstruturaDeDatosNoLineales.Grafos.Enlazados;
import java.util.Scanner;

public class Operaciones {
    NodoPrincipal primero,ultimo;
    public Operaciones() {
        primero = ultimo = null;
    }

    public void listaPrincipal(int tam) {

        NodoPrincipal nuevo;
        String nombre = "";

        for (int i = 1; i <= tam; i++) {
            Scanner leer= new Scanner(System.in);
            System.out.println("Dime el nombre de la ciudad");
            nombre= leer.nextLine();
            nuevo = new NodoPrincipal(nombre);
            if (primero == null)
                primero = ultimo = nuevo;// cuando se crea al primer elemento de la lista (si la lista está vacía)
            else {
                ultimo.setAbajo(nuevo);
                ultimo = nuevo;
            }
        }
    }

    public void imprimir() {
        NodoPrincipal recorre;
        recorre = primero;
        while (recorre != null) {
            System.out.println("\nEl nodo " + recorre.getNombre() + " se conecta con: ");
            imprimirSublista(recorre.getProx());
            recorre = recorre.getAbajo();
        }
    }

    public void imprimirSublista(NodoSublista recorre) {
        while (recorre != null) {
            System.out.print(recorre.getNombre() + " ");
            recorre = recorre.getSig();
        }
    }

    public void sublista() {
        NodoPrincipal recorre;
        recorre = primero;
        while (recorre != null) {
            System.out.println("Conexiones del nodo " + recorre.getNombre());
            recorre.setProx(crearSublista());
            recorre = recorre.getAbajo();
        }
    }

    public NodoSublista crearSublista() {
        String letra;
        char opcion;
        NodoSublista inicio = null;
        NodoSublista nuevo;
        do {
            System.out.println("Nodo con el que se conecta: ");
            letra = leerNombre();
            nuevo = new NodoSublista(letra);
            if (inicio != null)
                nuevo.setSig(inicio);
            inicio = nuevo;
            System.out.println("¿Continuamos con el mismo nodo? s/n");
            opcion = leerLetra();
        } while (opcion != 'n' && opcion != 'N');
        return inicio;

    }

    public String leerNombre() {
        Scanner in = new Scanner(System.in);
        String nombre="";
        try {
            nombre = in.nextLine();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nombre;
    }
    public char leerLetra() {
        Scanner in = new Scanner(System.in);
        char letra = 'A';
        try {
            letra = in.next().charAt(0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return letra;
    }
}
