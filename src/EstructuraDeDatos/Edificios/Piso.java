package EstructuraDeDatos.Edificios;

import EstructuraDeDatos.Nodo;

import java.io.Serializable;

public class Piso implements Serializable {
    private int NumDepiso;
    private Nodo departamento;
    private int MAX=3;

    public Piso(int numDepiso, Nodo departamento) {
        this.NumDepiso = numDepiso;
        this.departamento = departamento;
    }
    public Piso() {
        this.NumDepiso = 0;
        this.departamento = null;
    }

    public int getNumDepiso() {
        return NumDepiso;
    }

    public void setNumDepiso(int numDepiso) {
        NumDepiso = numDepiso;
    }

    public Nodo getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Nodo departamento) {
        this.departamento = departamento;
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
    }

}

