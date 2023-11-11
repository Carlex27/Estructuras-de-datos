package EstruturaDeDatosNoLineales.Grafos.Enlazados;

import EstruturaDeDatosNoLineales.Hospital.NodoPaciente;

public class NodoPrincipal {
    private String nombre;
    private NodoSublista prox;
    private NodoPrincipal abajo;
    public NodoPrincipal(String nombre){
        this.nombre=nombre;
        prox=null;
        abajo=null;
    }

}
