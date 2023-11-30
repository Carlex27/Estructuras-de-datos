package TablaHash;
import java.util.Date;
import java.io.Serializable;
import java.util.Calendar;

import TablaHash.Hotel.Reserva;

public class TablaHash implements Serializable {
    private final int TAM_TABLA = 50;
    private Reserva[] reservas = new Reserva[TAM_TABLA];
    public TablaHash() {
        
    }
    public int asignarID(String nombre, Date fechallegada) {
        int id = 0;
        for(int i = 0; i < nombre.length(); i++){
            id += nombre.charAt(i);
        }
        //Se crea un objeto Calendar con la fecha de llegada
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechallegada);

        //Se obtiene el dia, mes y año de la fecha de llegada y se suma al id
        id += cal.get(Calendar.DAY_OF_MONTH);
        id += cal.get(Calendar.MONTH);
        id += cal.get(Calendar.YEAR);

        //Se obtiene el modulo del id con el tamaño de la tabla
        id = id % TAM_TABLA;
        if(reservas[id] != null){
            //Si la posicion de la tabla ya esta ocupada, se busca la siguiente posicion disponible
            id=segundoHash(id);
        }
        return id;
    }
    public int segundoHash(int id){
        int i = 0;
        while(reservas[id] != null){
            id = (id + i*i) % TAM_TABLA;
            i++;
        }
        return id;
    }
    public void insertar(Reserva reserva){
        int id = reserva.getId();
        reservas[id] = reserva;
    }
    //SETTERS Y GETTERS
    public Reserva[] getReservas() {
        return reservas;
    }
    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }
}
