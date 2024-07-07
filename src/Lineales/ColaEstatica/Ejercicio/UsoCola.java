package Lineales.ColaEstatica.Ejercicio;

import Lineales.ColaEstatica.TipoCola;

public class UsoCola {
    public static void main(String[] args) {
        TipoCola Fila;
        int aux;
        Fila = new TipoCola();
        try {
            for (int i = 1; i <= 5; i++)
                Fila.insertar(i);
            Fila.imprimir();
            for (int i = 1; i <= 3; i++) {
                aux = (int) Fila.quitar();
                System.out.println(aux + " Fue sacado de la fila");
            }
            Fila.imprimir();
            for (int i = 6; i <= 8; i++)
                Fila.insertar(i);
            Fila.imprimir();
        } catch (Exception Error) {
            System.err.println("Excepción" + Error);
        }
    }
}
