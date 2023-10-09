package EstructuraDeDatos;

import EstructuraDeDatos.CallCenter.Llamada;

public class TipoCola {
    private int frente, ultimo;
    private static final int MAX = 4;
    private Object[] cola;

    public TipoCola() {
        cola = new Object[MAX + 1];
        frente = -1;
        ultimo = -1;
    }

    public void insertar(Object NuevoElem) throws Exception {
        if (estaLlena())
            throw new Exception("No hay espacios disponibles");
        else {
            if (estaVacia()) {
                frente = ultimo = 0;
            } else if (ultimo == MAX)
                ultimo = 0;
            else
                ultimo++;
            cola[ultimo] = NuevoElem;
        }
    }

    public Object quitar() throws Exception {
        Object elemento;

        if (estaVacia())
            throw new Exception("No hay datos haciendo fila");
        else {
            elemento = cola[frente];
            cola[frente] = null;
            if (frente == ultimo) {
                frente = ultimo = -1;
            } else if (frente == MAX)
                frente = 0;
            else
                frente++;
        }
        return elemento;
    }

    public boolean estaVacia() {
        return (frente == -1 && ultimo == -1);
    }

    public boolean estaLlena() {
        return ((frente == 0 && ultimo == MAX) || (frente == ultimo + 1));
    }

    public void imprimir() {
        System.out.println("Posición de frente: " + frente + " ultimo: " + ultimo);
        System.out.print("Elementos haciendo fila: ");
        for (int i = 0; i <= MAX; i++)
            System.out.print(cola[i] + ",");
        System.out.println();
    }
    public void imprimirLlamdas() {
        System.out.println("Posición de frente: " + frente + " ultimo: " + ultimo);
        System.out.print("Elementos haciendo fila: ");
        for (int i = 0; i <= MAX; i++) {
            if(cola[i]!=null){
                Llamada llamada=(Llamada)cola[i];
                System.out.print("(Numero: "+llamada.numero+ "),");
            }else
                System.out.print("null,");
        }
        System.out.println();
    }
}
