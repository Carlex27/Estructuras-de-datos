package EstructuraDeDatos.CallCenter.CallCenterUli;
import EstructuraDeDatos.ColaEstatica.TipoCola;

import java.util.Timer;
import java.util.TimerTask;

public class CallCenterUli {
    static TipoCola operador1 = new TipoCola();
    static TipoCola operador2 = new TipoCola();
    static TipoCola operador3 = new TipoCola();
    public static void main(String[] args) {
        try {
            operador1.insertar((int) (Math.random() * 1000));
            int llamada = (int)operador1.quitar();
            System.out.println("Operador 1 atendio al numero: " + llamada + " con duracion " + (int) (Math.random() * 300) + "SEG");
        }catch (Exception e){

        }

    }
}
