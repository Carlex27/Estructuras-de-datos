package EstruturaDeDatosNoLineales.ArbolBinario;

import java.io.Serializable;

public class NodoArbol implements Serializable {
    private int info;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDerecho;

    public NodoArbol(int object){
        info=object;
        nodoIzq=null;
        nodoDerecho=null;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(NodoArbol izq) {
        this.nodoIzq = izq;
    }

    public NodoArbol getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(NodoArbol der) {
        this.nodoDerecho = der;
    }
    public void insertar(int valor){
        if(valor <(int)this.info){
            //INSERTAR EN EL LADO IZQUIERDO
            if(this.nodoIzq==null){
                this.nodoIzq= new NodoArbol(valor);
            }else{
                this.nodoIzq.insertar(valor);
            }
        }else {
            if(this.nodoDerecho==null){
                this.nodoDerecho= new NodoArbol(valor);
            }else{
                this.nodoDerecho.insertar(valor);
            }
        }
    }
}
