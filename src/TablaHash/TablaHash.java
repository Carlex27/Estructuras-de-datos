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
        Long inicio = System.currentTimeMillis();
        nombre=nombre.toLowerCase();
        nombre=nombre.replace(" ","");
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
        id = verificarID(id, nombre, fechallegada);
        Long fin = System.currentTimeMillis();
        String tiempo = "Tiempo en asignar ID: "+(fin-inicio)+" milisegundos";
        guardarTiempo(tiempo);
        return id;
    }
    //Verificar si el id esta ocupado
    private int verificarID(int id, String nombre, Date fechallegada){
        if(reservas[id] != null){
            String nombre2 = reservas[id].getNombre();
            nombre2 = nombre2.toLowerCase();
            nombre2=nombre2.replace(" ","");
            if (nombre.equals(nombre2)) {
                return id;
            }else{
                id = segundoHash(id,nombre);
            }
        }
       
        return id;
    }

    private void guardarTiempo(String tiempo){
        try{
            java.io.FileWriter fw = new java.io.FileWriter("src/TablaHash/Binarios/tiempos.txt", true);
            fw.write(tiempo+"\n");
            fw.close();
        }catch(Exception e){
            System.out.println("Error al guardar el tiempo");
        }
    }
    public int segundoHash(int id,String nombre){
        int i = 0;
        while(reservas[id] != null){
            String nombre2 = reservas[id].getNombre();
            nombre2 = nombre2.toLowerCase();
            id = (id + i*i) % TAM_TABLA;
            i++;
            if (nombre.equals(nombre2)) {
                return id;
            }
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
