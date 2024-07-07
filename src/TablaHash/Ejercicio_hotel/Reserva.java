package TablaHash.Ejercicio_hotel;

import java.io.Serializable;
import java.sql.Date;

public class Reserva implements Serializable {
    private int id;
    private String nombre; 
    Date fechaLlegada;
    Date fechaSalida;
    String tipoHabitacion;
    public Reserva(int id, String nombre, Date fechaLlegada, Date fechaSalida, String tipoHabitacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
    }
    public Reserva() {
        this.id = 0;
        this.nombre = "";
        this.fechaLlegada = null;
        this.fechaSalida = null;
        this.tipoHabitacion = "";
    }
    public void imprimir(){
        System.out.println("ID: "+id);
        System.out.println("Nombre: "+nombre);
        System.out.println("Fecha de llegada: "+fechaLlegada);
        System.out.println("Fecha de salida: "+fechaSalida);
        System.out.println("Tipo de habitacion: "+tipoHabitacion);
        System.out.println("---------------------------");
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public Date getFechaLlegada() {
        return fechaLlegada;
    }
    public Date getFechaSalida() {
        return fechaSalida;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
}
