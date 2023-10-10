package EstructuraDeDatos.Pila;

public class TipoPila {
    private Object pila[];
    private static final int MAX=99;
    private int tope;

    public TipoPila(){
        pila=new Object[MAX+1];
        tope=-1;
    }
    protected void meter(Object dato)throws Exception{
        if(pilaLlena()){
            throw new Exception("Desbordamiento");
        }else{
            tope++;
            pila[tope]=dato;
        }
    }
    protected Object sacar()throws Exception{
        if(pilaVacia()){
            throw new Exception("Subdesbordamiento");
        }else{
            Object dato=pila[tope];
            pila[tope]=null;
            tope--;
            return dato;
        }
    }

    protected boolean pilaVacia() {
        return tope==-1;
    }

    protected boolean pilaLlena() {
        return tope==MAX;
    }
    protected void limpiarPila(){
        tope=-1;
    }
    public Object UltimoElem()throws Exception{
        if (pilaVacia()){
            throw new Exception("La pila esta vacia");
        }else
            return pila[tope];
    }

}
