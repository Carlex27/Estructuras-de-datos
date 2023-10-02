package EstructuraDeDatos.Edificios;

import EstructuraDeDatos.Nodo;

public class Piso {
    private int NumDepiso;
    private Nodo departamento;

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
}
