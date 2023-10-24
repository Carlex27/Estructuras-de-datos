package EstructuraDeDatosLineales.Edificios;

import java.io.Serializable;

public class Departamento implements Serializable {
    private boolean rentado;
    private int numDepa;

    public Departamento(boolean rentado, int numDepa) {
        this.rentado = rentado;
        this.numDepa = numDepa;
    }
    public Departamento() {
        this.rentado = false;
        this.numDepa = 0;
    }
    public int getNumDepa() {
        return numDepa;
    }

    public void setNumDepa(int numDepa) {
        this.numDepa = numDepa;
    }

    public boolean isRentado() {
        return rentado;
    }

    public void setRentado(boolean rentado) {
        this.rentado = rentado;
    }

}
