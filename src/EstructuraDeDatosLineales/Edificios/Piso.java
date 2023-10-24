package EstructuraDeDatosLineales.Edificios;

import EstructuraDeDatosLineales.Nodo;

import java.io.Serializable;

public class Piso implements Serializable {
    private int numPiso;
    private Nodo departamento;

    public Piso(int numPiso, Nodo departamento) {
        this.numPiso = numPiso;
        this.departamento = departamento;
    }
    public Piso() {
        this.numPiso = 0;
        this.departamento = null;
    }

    public int getNumDepiso() {
        return numPiso;
    }

    public void setNumDepiso(int numDepiso) {
        numPiso = numDepiso;
    }

    public Nodo getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Nodo departamento) {
        this.departamento = departamento;
    }

}

