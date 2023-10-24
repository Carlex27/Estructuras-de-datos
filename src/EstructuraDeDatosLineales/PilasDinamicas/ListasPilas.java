package EstructuraDeDatosLineales.PilasDinamicas;

import EstructuraDeDatosLineales.ListasEnlazadas.Lista;
import EstructuraDeDatosLineales.ListasEnlazadas.Nodo;
public class ListasPilas extends Lista {
    Nodo tope;
    public ListasPilas(){
        tope=null;
    }
    public void meter(Object elemento){
        Nodo nuevo;
        nuevo= new Nodo(elemento);
        nuevo.setSig(tope);
        tope=nuevo;
    }
    public Object sacar (){
        Object elemento = null;
        if (estaVacia()){
            elemento=tope.getInfo();
            tope=tope.getSig();
        }
        return elemento;
    }
    public void visualizar(){
        Nodo recorre;

    }
}
