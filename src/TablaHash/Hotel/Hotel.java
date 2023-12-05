package TablaHash.Hotel;

import java.io.Serializable;
import java.sql.Date;
import java.util.Scanner;
import TablaHash.TablaHash;

public class Hotel implements Serializable{
    int suiteGrand=2;
    int suiteEjecutivas=10;
    int triples=20;
    int dobles=32;
    int sencillas=36;
    TablaHash tablaHash;
    //constructor
    public Hotel() {
        tablaHash = new TablaHash();
    }
    //Metodo que consulta la disponibilidad de habitaciones
    public void consultarDisponibilidad(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el tipo de habitacion: ");
        String tipoHabitacion = leer.nextLine();
        try {
            System.out.println("Fecha de llegada");
            System.out.println("Formato de fecha: yyyy-mm-dd");
            Date fechaLlegada = Date.valueOf(leer.nextLine());
            
        } catch (Exception e) {
            System.out.println("Se coloco una fecha invalida");
            return;
        }

        boolean disponible = consultarDisponibilidad(tipoHabitacion);

        if(disponible){
            System.out.println("Hay habitaciones disponibles");
        }else{
            System.out.println("No hay habitaciones disponibles");
        }
    }
    //Metodo que reserva una habitacion
    public void reservar(){
        Reserva reserva = crearReserva();
        if(reserva!=null){
            tablaHash.insertar(reserva);
        }
    }

    //crear reserva
    private Reserva crearReserva(){
        //variables
        Reserva reserva = null;
        Scanner leer = new Scanner(System.in);
        Scanner leer2 = new Scanner(System.in);
        //Leer datos
        System.out.println("Ingrese su nombre: ");
        String nombre = leer.nextLine();
        try{
            System.out.println("Formato de fecha: yyyy-mm-dd");
            System.out.println("Ingrese su fecha de llegada: ");
            Date fechaLlegada = Date.valueOf(leer2.nextLine());
            System.out.println("Ingrese su fecha de salida: ");
            Date fechaSalida = Date.valueOf(leer2.nextLine());

            System.out.println("Ingrese el tipo de habitacion: ");
            mostrarHabitaciones();
            String tipoHabitacion = leer.nextLine();

            //Consultar disponibilidad
            if(consultarDisponibilidad(tipoHabitacion)){
                //Crear ID
                int id = tablaHash.asignarID(nombre, fechaLlegada);
                System.out.println("Reserva exitosa");
                actualizarDisponibilidad(tipoHabitacion, '-');
                reserva = new Reserva(id, nombre, fechaLlegada, fechaSalida, tipoHabitacion);
            }else{
                System.out.println("No hay habitaciones disponibles");
                reserva=null;
            }

        }catch(IllegalArgumentException e){
            System.out.println("Se coloco una fecha invalida");
            reserva=null;
        }
        return reserva;
    }
    //Buscar Reserva
    public void buscarReserva(){
        Scanner leer = new Scanner (System.in);
        Scanner leer2 = new Scanner (System.in);
        System.out.println("Buscando reserva");
        System.out.println("Ingrese el nombre de la persona que hizo la reserva: ");
        String nombre = leer.nextLine();
        try {
            System.out.println("Ingrese la fecha de llegada. Formato: yyyy-mm-dd");
            Date fechaLlegada = Date.valueOf(leer2.nextLine());
            int id = tablaHash.asignarID(nombre, fechaLlegada);
            if(tablaHash.getReservas()[id]!=null){
                Reserva reserva = tablaHash.getReservas()[id];
                reserva.imprimir();
            }else{ 
                System.out.println("No se encontro la reserva");
            }
        } catch (Exception e) {
            System.out.println("Se coloco una fecha invalida");
        }
    }
    //cancelar reserva
    public void cancelar(){
        Scanner leer = new Scanner (System.in);
        Scanner leer2 = new Scanner (System.in);
        System.out.println("Cancelando reserva");
        System.out.println("Ingrese el nombre de la persona que hizo la reserva: ");
        String nombre = leer.nextLine();
        try {
            System.out.println("Ingrese la fecha de llegada. Formato: yyyy-mm-dd");
            Date fechaLlegada = Date.valueOf(leer2.nextLine());
            int id = tablaHash.asignarID(nombre, fechaLlegada);
            if(tablaHash.getReservas()[id]!=null){
                Reserva reserva = tablaHash.getReservas()[id];
                actualizarDisponibilidad(reserva.getTipoHabitacion(), '+');
                tablaHash.getReservas()[id]=null;
                System.out.println("Reserva cancelada");
            }else{ 
                System.out.println("No se encontro la reserva");
            }
        } catch (Exception e) {
            System.out.println("Se coloco una fecha invalida");
        }
    }
    //Imprimir reservas
    public void imprimirReservas(){
         boolean ban = false;
        for(int i = 0; i < tablaHash.getReservas().length; i++){
            if(tablaHash.getReservas()[i]!=null){
                tablaHash.getReservas()[i].imprimir();
                ban = true;
            }
        }
        if(!ban){
            System.out.println("No hay reservas");
        }
    }
    //mostrar habitaciones
    private void mostrarHabitaciones(){
        System.out.println("Suite Grand: "+suiteGrand);
        System.out.println("Suite Ejecutivas: "+suiteEjecutivas);
        System.out.println("Triples: "+triples);
        System.out.println("Dobles: "+dobles);
        System.out.println("Sencillas: "+sencillas);
    }
    //actualizar disponibilidad
    private void actualizarDisponibilidad(String tipoHabitacion,char operacion){
        tipoHabitacion = tipoHabitacion.toLowerCase();
        tipoHabitacion=tipoHabitacion.replace(" ", "");
        if (operacion == '+') {
            switch(tipoHabitacion){
                case "suitegrand"->{
                    suiteGrand++;
                }
                case "suiteejecutivas"->{
                    suiteEjecutivas++;
                } 
                case "triples"->{
                    triples++;
                }
                case "dobles"->{
                    dobles++;
                }
                case "sencillas"->{
                    sencillas++;
                }  
            }
        }else {
            switch(tipoHabitacion){
                case "suitegrand"->{
                    suiteGrand--;
                }
                case "suiteejecutivas"->{
                    suiteEjecutivas--;
                } 
                case "triples"->{
                    triples--;
                }
                case "dobles"->{
                    dobles--;
                }
                case "sencillas"->{
                    sencillas--;
                }  
            }
        }
        
    }
    //consultar disponibilidad
    private boolean consultarDisponibilidad(String tipoHabitacion){
        boolean disponible = false;
        tipoHabitacion = tipoHabitacion.toLowerCase();
        tipoHabitacion=tipoHabitacion.replace(" ", "");
        switch(tipoHabitacion){
            case "suitegrand"->{
                if(suiteGrand>0){
                    disponible = true;
                }
            }
            case "suiteejecutivas"->{
                if(suiteEjecutivas>0){
                    disponible = true;
                }
            } 
            case "triples"->{
                if(triples>0){
                    disponible = true;
                }
            }
            case "dobles"->{
                if(dobles>0){
                    disponible = true;
                }
            }
            case "sencillas"->{
                if(sencillas>0){
                    disponible = true;
                }
            } 
            default -> {
                System.out.println("Tipo de habitacion invalido");
            }
        }
        return disponible;
    }
}
