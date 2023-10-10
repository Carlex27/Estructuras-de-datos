package EstructuraDeDatos.ListaOrdenada;

import EstructuraDeDatos.ListasEnlazadas.Lista;
import EstructuraDeDatos.ListasEnlazadas.Nodo;
public class ListaOrdenada extends Lista {
    public void insertar(int elemeto){
        Nodo nuevo;
        nuevo=new Nodo(elemeto);
        if(estaVacia() || (int)nuevo.getInfo()<=(int)primero.getInfo()){
            nuevo.setSig(primero);
            primero=nuevo;
        }else{
            Nodo recorre=primero;
            Nodo anterior=null;
            while (recorre!=null && (int)nuevo.getInfo() > (int)recorre.getInfo()){
                anterior=recorre;
                recorre=recorre.getSig();
            }
            anterior.setSig(nuevo);
            nuevo.setSig(recorre);
        }
    }
    public void eliminar(int elemento) {
        Nodo recorre = primero;
        Nodo anterior = null;
        while (recorre != null && (int) recorre.getInfo() < elemento ) {
            anterior = recorre;
            recorre = recorre.getSig();
        }
        if (recorre != null && (int) recorre.getInfo() == elemento) {
            if (anterior == null) {
                primero = recorre.getSig();
            } else {
                anterior.setSig(recorre.getSig());
            }
        }
    }

    public void visualizar(){
        imprimir();
    }
}
