package EstruturaDeDatosNoLineales.Grafos.Matriz;

public class Elemento {
    int distancia;
    Boolean visitado;
    int anterior;
    public Elemento(int peso, int anterior){
        this.distancia=peso;
        this.visitado=false;
        this.anterior=anterior;
    }
    public Elemento(){
        this.distancia=0;
        this.visitado=false;
        this.anterior=0;
    }
    
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }
    public int getDistancia() {
        return distancia;
    }
    public Boolean getVisitado() {
        return visitado;
    }
    public int getAnterior() {
        return anterior;
    }
    public void setAnterior(int anterior) {
        this.anterior = anterior;
    }
}
