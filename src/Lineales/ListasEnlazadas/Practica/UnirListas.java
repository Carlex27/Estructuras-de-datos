package Lineales.ListasEnlazadas.Practica;
import Lineales.ListasEnlazadas.Nodo;
import Lineales.ListaOrdenada.ListaOrdenada;
public class UnirListas {

    public static void main(String[] args) {
        ListaOrdenada lista1= new ListaOrdenada();
        ListaOrdenada lista2= new ListaOrdenada();
        ListaOrdenada lista3= new ListaOrdenada();
        ListaOrdenada listaUnida;
        darValores(lista1);
        darValores(lista2);
        darValores(lista3);
        listaUnida= unirListas(lista1,lista2,lista3);
        listaUnida.imprimir();
    }
    public static ListaOrdenada unirListas(ListaOrdenada lista1, ListaOrdenada lista2,ListaOrdenada lista3){
        ListaOrdenada listaUnida= new ListaOrdenada();
        Nodo actual;
        actual=lista1.primero;
        while (actual !=null){
            listaUnida.insertar((Integer) actual.getInfo());
            actual=actual.getSig();
        }
        actual=lista2.primero;
        while (actual !=null){
            listaUnida.insertar((Integer) actual.getInfo());
            actual=actual.getSig();
        }
        actual=lista3.primero;
        while (actual !=null){
            listaUnida.insertar((Integer) actual.getInfo());
            actual=actual.getSig();
        }
        return listaUnida;
    }
    public static ListaOrdenada darValores(ListaOrdenada lista){
        int tamanio=(int)(Math.random()*500);
        for(int i=0;i<tamanio;i++){
            int num=(int)(Math.random()*1001);
            lista.insertar(num);
        }
        return lista;
    }
}
