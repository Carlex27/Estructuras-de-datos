package NoLineales.Grafos.Enlazados;



public class NodoPrincipal {
    private String nombre;
    private NodoSublista prox;
    private NodoPrincipal abajo;
    public NodoPrincipal(String nombre){
        this.nombre=nombre;
        prox=null;
        abajo=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoSublista getProx() {
        return prox;
    }

    public void setProx(NodoSublista prox) {
        this.prox = prox;
    }

    public NodoPrincipal getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPrincipal abajo) {
        this.abajo = abajo;
    }

}
