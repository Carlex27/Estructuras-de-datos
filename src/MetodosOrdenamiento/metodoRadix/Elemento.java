package MetodosOrdenamiento.metodoRadix;

public class Elemento {
    int num;
    Elemento Sig;

    public Elemento(int num) {
        this.num = num;
        Sig = null;
    }

    public Elemento() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Elemento getSig() {
        return Sig;
    }

    public void setSig(Elemento sig) {
        Sig = sig;
    }


}
