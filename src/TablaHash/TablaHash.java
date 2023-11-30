package TablaHash;
import java.util.Date;

import TablaHash.Hotel.Reserva;

public class TablaHash {
    private final int TAM_TABLA = 50;
    private Reserva[] reservas = new Reserva[TAM_TABLA];
    public TablaHash() {
        
    }
    public int asignar(String nombre, Date fechallegada) {
        int id = 0;
        for(int i = 0; i < nombre.length(); i++){
            id += nombre.charAt(i);
        }
        
        return id;
    }
    private
    //SETTERS Y GETTERS
    public Reserva[] getReservas() {
        return reservas;
    }
    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }
}
