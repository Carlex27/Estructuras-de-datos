package TablaHash.Hotel;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;    
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    static Hotel hotel = new Hotel();
    public static void main(String[] args) {
        //hotel=cargarArchivo();
        menu();
        guardarArchivo(hotel);
    }
    public static void menu(){
        Scanner leer = new Scanner(System.in);
        boolean ban = true;
        do{
            System.out.println("1. Reservar");
            System.out.println("2. Consultar disponibilidad");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Buscar reserva");
            System.out.println("5. Imprimir reservas");
            System.out.println("6. Guardar archivo");
            System.out.println("7. Salir");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1://RESERVAR
                    hotel.reservar();
                    break;
                case 2://CONSULTAR DISPONIBILIDAD
                    hotel.consultarDisponibilidad();
                    break;
                case 3://CANCELAR RESERVA
                    hotel.cancelar();
                    break;
                case 4://BUSCAR RESERVA
                    hotel.buscarReserva();
                    break;
                case 5://IMPRIMIR RESERVAS
                    hotel.imprimirReservas();
                    break;
                case 6://GUARDAR ARCHIVO
                    guardarArchivo(hotel);
                    break;
                case 7://SALIR
                    System.out.println("Gracias por usar el programa");
                    ban=false;
                    break;
            }
        }while(ban);
    }
    
    public static void guardarArchivo(Hotel hotel){
        try{
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("src/TablaHash/Binarios/hotel.dat"));
            salida.writeObject(hotel);
            salida.close();
            System.out.println("Archivo guardado");
        }catch(Exception e){
            System.out.println("Error al guardar el archivo");
        }
    }
    public static Hotel cargarArchivo(){
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("src/TablaHash/Binarios/hotel.dat"));
            Hotel hotel = (Hotel)entrada.readObject();
            entrada.close();
            return hotel;
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo");
        }
        return null;
    }
}
