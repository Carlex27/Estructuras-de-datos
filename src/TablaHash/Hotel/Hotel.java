package TablaHash.Hotel;

import java.io.Serializable;
import java.sql.Date;
import java.util.Scanner;

public class Hotel implements Serializable{
    int suiteGrand=2;
    int suiteEjecutivas=10;
    int triples=20;
    int dobles=32;
    int sencillas=36;
    
    Reserva[] reservas= new Reserva[50];
    //constructor
    public Hotel() {

    }
    //metodos hash
    private int obtenerHash(String nombre, Date fechallegada){
        int id = 0;
        
        if(reservas[id]!=null){
            id = segundoHash(id);
        }
        return id;
    }
    private int segundoHash(int id){
        

        return id;
    }
    public void reservar(){
        Reserva reserva = crearReserva();

    }

    public void cancelar(){

    }

    private boolean consultarDisponibilidad(String tipoHabitacion){
        boolean disponible = false;
        tipoHabitacion = tipoHabitacion.toLowerCase();
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
        }
        return disponible;
    }
    private Reserva crearReserva(){
        //variables
        Reserva reserva = null;
        Scanner leer = new Scanner(System.in);
        Scanner leer2 = new Scanner(System.in);
        //Leer datos
        System.out.println("Ingrese su nombre: ");
        String nombre = leer.nextLine();
        System.out.println("Ingrese su fecha de llegada: ");
        Date fechaLlegada = Date.valueOf(leer2.nextLine());
        System.out.println("Ingrese su fecha de salida: ");
        Date fechaSalida = Date.valueOf(leer2.nextLine());
        System.out.println("Ingrese el tipo de habitacion: ");
        String tipoHabitacion = leer.nextLine();
        //Consultar disponibilidad
        if(consultarDisponibilidad(tipoHabitacion)){
            //Crear ID
            int id = obtenerHash(nombre, fechaLlegada);
            System.out.println("Reserva exitosa");
            actualizarDisponibilidad(tipoHabitacion, '-');
            reserva = new Reserva(id, nombre, fechaLlegada, fechaSalida, tipoHabitacion);
        }else{
            System.out.println("No hay habitaciones disponibles");
        }
        return reserva;
    }
    public void actualizarDisponibilidad(String tipoHabitacion,char operacion){
        tipoHabitacion = tipoHabitacion.toLowerCase();
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
}
