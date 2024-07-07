package Lineales.ColasDinamicas;

import Lineales.ListasEnlazadas.Lista;
import Lineales.ListasEnlazadas.Nodo;

public class ListasColas extends Lista {
    Nodo frente, ultimo;
    public ListasColas(){
        frente=null;
        ultimo=null;
    }
    public void insertar(Object elemento){
        Nodo nuevo= new Nodo(elemento);
        if(estaVacia()){
            frente=ultimo=nuevo;
        }else {
            ultimo.setSig(nuevo);
        ultimo=nuevo;
        }

    }
    public Object quitar(){
        Object elemento=null;
        if(!estaVacia()){
           elemento = frente.info;
            if(frente == ultimo){
                frente=ultimo=null;
            }else{
                frente=frente.getSig();
            }
        }
        return elemento;
    }

}
