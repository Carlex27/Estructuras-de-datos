package Threads.CallCenter;

import java.util.Timer;
import java.util.TimerTask;

public class Operador extends Thread {
    TipoCola cola= new TipoCola();
    Timer timer = new Timer();
    TimerTask agregarLlamada = new TimerTask() {
            @Override
            public void run() {
                int numero = (int)(Math.random()*755999999);
                int duracion= (int)(Math.random()*300);
                Llamada llamada = new Llamada(numero, duracion);
                try{
                    cola.insertar(llamada);
                    System.out.println("-------------------------------------------");
                    System.out.print("Se agrego la llamada,");
                    System.out.println(" Numero: " + numero + " al operador: " + getName());
                    System.out.println("-------------------------------------------");
                }catch(Exception e){
                   
                }
            }
        };
    TimerTask atenderLlamada = new TimerTask() {
        @Override
        public void run() {
            try {
                Llamada llamada = (Llamada)cola.quitar();
                sleep(llamada.getDuracion());
                System.out.println();
                System.out.println("-------------------------------------------");
                System.out.println("Operador: " +getName()+ ", atendio al numero: " + llamada.getNumero());
                System.out.println("Duracion: " + llamada.getDuracion() + " Segundos");
                System.out.println("-------------------------------------------");
                cola.imprimirLlamdas();
                System.out.println("-------------------------------------------");
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    };
    public Operador(String nombre){
        setName(nombre);
    }
    public void run(){
        timer.schedule(agregarLlamada,0,(int)(Math.random()*2000+500));
        timer.schedule(atenderLlamada,0,(int)(Math.random()*6000+3000));
    }
    
}
