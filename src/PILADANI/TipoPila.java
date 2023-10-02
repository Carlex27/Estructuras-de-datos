package PILADANI;

public class TipoPila {
    private Object pila[];
    private int max=99;
    private int tope;

    public TipoPila(){
        pila=new Object[max+1];
        tope=-1;
    }
    protected void meter(Object Dato)throws Exception{
        if (pilallena()){
            throw new Exception("Desbordamiento de pila");
        }else{
            tope++;
            pila[tope]=Dato;
        }
    }

    private boolean pilallena() {
        return (tope==max+1);
    }

    protected Object sacar()throws Exception {
        Object Dato;
        if (Pilavacia()){
            throw new Exception("Subdesbordamiento de pila");
        }else{
            Dato=pila[tope];
            tope--;
        }
        return Dato;

    }

    private boolean Pilavacia() {
        return (tope==-1);
    }
    public Object UltimoElem()throws Exception{
        if (Pilavacia()){
            throw new Exception("La pila esta vacia");
        }else
            return pila[tope];
    }
}
