package EstruturaDeDatosNoLineales.Hospital;

import java.io.Serializable;

public class Paciente implements Serializable {
    private int numID;
    private String nombre;
    private int edad;
    private String diagnostico;

    public Paciente(int numID, String nombre, int edad, String diagnostico) {
        this.numID = numID;
        this.nombre = nombre;
        this.edad = edad;
        this.diagnostico = diagnostico;
    }
    public Paciente() {
        this.numID = 0;
        this.nombre = "";
        this.edad = 0;
        this.diagnostico = "";
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) {
        this.numID = numID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
