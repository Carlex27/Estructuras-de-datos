package EstructuraDeDatos.CallCenter;

import EstructuraDeDatos.ColaEstatica.TipoCola;
import java.util.Timer;
import java.util.TimerTask;

public class CallCenter {

    public static void main(String[] args) {
        TipoCola operador1 = new TipoCola();
        TipoCola operador2 = new TipoCola();
        TipoCola operador3 = new TipoCola();
        Timer timer = new Timer();
        TimerTask agregarLlamadas = new TimerTask() {
            @Override
            public void run() {
                Llamada llamada = new Llamada((int)(Math.random()*755999999),(int)(Math.random()*300));
                try {
                    switch ((int) (Math.random() * 3)) {
                        case 0:
                            if(!operador1.estaLlena())
                                operador1.insertar(llamada);
                            break;
                        case 1:
                            if(!operador2.estaLlena())
                                operador2.insertar(llamada);
                            break;
                        case 2:
                            if(!operador3.estaLlena())
                                operador3.insertar(llamada);
                            break;
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        };
        TimerTask atenderLlamada = new TimerTask() {
            @Override
            public void run() {
                Llamada llamada;
                try {
                    if (!operador1.estaVacia()) {
                        llamada = (Llamada) operador1.quitar();
                        System.out.println("Operador 1, atendio la llamada del numero: " + llamada.numero +
                                " y duracion: " + llamada.duracion + " segundos.");
                        operador1.imprimirLlamdas();
                        System.out.println();
                    }
                    if (!operador2.estaVacia()) {
                        llamada = (Llamada) operador2.quitar();
                        System.out.println("Operador 2, atendio la llamada del numero: " + llamada.numero +
                                " y duracion: " + llamada.duracion + " segundos.");
                        operador2.imprimirLlamdas();
                        System.out.println();
                    }
                    if (!operador3.estaVacia()) {
                        llamada = (Llamada) operador3.quitar();
                        System.out.println("Operador 3, atendio la llamada del numero: " + llamada.numero +
                                " y duracion: " + llamada.duracion + " segundos. ");
                        operador3.imprimirLlamdas();
                        System.out.println();
                    }
                }catch (Exception e){
                    System.out.print(e.getMessage());
                }
            }
        };
        timer.schedule(agregarLlamadas,0,(int)(Math.random()*2000+500));
        timer.schedule(atenderLlamada,0,(int)(Math.random()*6000+3000));
    }
}
