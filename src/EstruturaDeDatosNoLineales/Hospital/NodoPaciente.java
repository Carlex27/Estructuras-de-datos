package EstruturaDeDatosNoLineales.Hospital;

import java.io.Serializable;

public class NodoPaciente implements Serializable {
    private int numID;
    private Paciente paciente;
    private NodoPaciente nodoIzq;
    private NodoPaciente nodoDerecho;
    public NodoPaciente(Paciente paciente){
        this.numID= paciente.getNumID();
        this.paciente=paciente;
        nodoIzq=null;
        nodoDerecho=null;
    }
    public NodoPaciente(){
        numID=0;
        this.paciente=null;
        nodoIzq=null;
        nodoDerecho=null;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public NodoPaciente getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(NodoPaciente nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public NodoPaciente getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(NodoPaciente nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) {
        this.numID = numID;
    }

    public void insertar(Paciente paciente){
        if(this.paciente==null){
            this.paciente=paciente;
        }
       if(paciente.getNumID()<this.numID){
           if(this.nodoIzq==null){
               this.nodoIzq=new NodoPaciente(paciente);
           }else{
               this.nodoIzq.insertar(paciente);
           }
       }else{
           if(this.nodoDerecho==null){
               this.nodoDerecho=new NodoPaciente(paciente);
           }else{
               this.nodoDerecho.insertar(paciente);
           }
       }
    }
}
