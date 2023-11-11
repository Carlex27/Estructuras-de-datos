package EstruturaDeDatosNoLineales.Grafos.Enlazados;

public class NodoSublista {
    private String nombre;
    private int peso;
    private NodoSublista sig;
    public NodoSublista(String nombre){
        this.nombre=nombre;
        sig=null;
        peso=0;
    }

}
