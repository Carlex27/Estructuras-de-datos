package EstructuraDeDatos.ListasEnlazadas;

import java.io.Serializable;

public class Nodo implements Serializable {
    public Object info;
    public Nodo sig;
    public Nodo(Object info){
        this.info = info;
        this.sig =  null;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
