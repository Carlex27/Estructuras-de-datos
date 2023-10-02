package EstructuraDeDatos.Edificios;

import EstructuraDeDatos.Nodo;

public class Edificio {
    private String nombre;
    private Nodo pisos;

    public Edificio(String nombre, Nodo pisos) {
        this.nombre = nombre;
        this.pisos = pisos;
    }
    public Edificio() {
        this.nombre = "";
        this.pisos = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getPisos() {
        return pisos;
    }

    public void setPisos(Nodo pisos) {
        this.pisos = pisos;
    }
}
