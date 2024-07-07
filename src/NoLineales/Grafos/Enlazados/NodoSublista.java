package NoLineales.Grafos.Enlazados;

public class NodoSublista {
    private String nombre;

    private NodoSublista sig;
    public NodoSublista(String nombre){
        this.nombre=nombre;
        sig=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public NodoSublista getSig() {
        return sig;
    }

    public void setSig(NodoSublista sig) {
        this.sig = sig;
    }
}
