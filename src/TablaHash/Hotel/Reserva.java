package TablaHash.Hotel;

public class Reserva {
    private int id;
    private String nombre; 
    String fechaLlegada;
    String fechaSalida;
    String tipoHabitacion;
    public Reserva(int id, String nombre, String fechaLlegada, String fechaSalida, String tipoHabitacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
    }
    public Reserva() {
        this.id = 0;
        this.nombre = "";
        this.fechaLlegada = "";
        this.fechaSalida = "";
        this.tipoHabitacion = "";
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getFechaLlegada() {
        return fechaLlegada;
    }
    public String getFechaSalida() {
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
    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
}
