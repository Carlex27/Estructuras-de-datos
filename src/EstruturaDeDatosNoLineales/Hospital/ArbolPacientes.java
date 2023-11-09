package EstruturaDeDatosNoLineales.Hospital;

public class ArbolPacientes {
    private NodoPaciente raiz;
    public ArbolPacientes(){
        raiz=null;
    }
    public ArbolPacientes(NodoPaciente nodoPaciente){
        raiz=nodoPaciente;
    }
    public NodoPaciente getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoPaciente raiz) {
        this.raiz = raiz;
    }
    public void insertar(Paciente paciente){
        raiz.insertar(paciente);
    }
    public Paciente buscar(int numID){
        try {
            return buscarArbol(raiz,numID);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    private Paciente buscarArbol(NodoPaciente nodo, int numID)throws Exception {
        if(nodo==null){
            throw new Exception("No se encontro");
        }
        if(nodo.getNumID()==numID){
            return nodo.getPaciente();
        }
        if(numID< nodo.getNumID()){
            return buscarArbol(nodo.getNodoIzq(),numID);
        }else{
            return buscarArbol(nodo.getNodoDerecho(),numID);
        }
    }
    public void borrar(int numID){
        this.raiz=eliminar(this.raiz,numID);
    }

    private NodoPaciente eliminar(NodoPaciente nodo, int numID) {
        if (nodo==null){
            return nodo;
        }
        if(numID > nodo.getNumID()){
            nodo.setNodoDerecho(this.eliminar(nodo.getNodoDerecho(),numID));
        }else if(numID < nodo.getNumID()){
            nodo.setNodoIzq((this.eliminar(nodo.getNodoIzq(),numID)));
        }else {
            if(nodo.getNodoDerecho()==null && nodo.getNodoIzq()==null){
                nodo=null;
            }else if(nodo.getNodoDerecho()!=null){
                nodo.setPaciente(this.sucesor(nodo));
                nodo.setNumID(this.sucesorID(nodo));
                nodo.setNodoDerecho(this.eliminar(nodo.getNodoDerecho(),nodo.getNumID()));
            }else{
                nodo.setPaciente(this.predecesor(nodo));
                nodo.setNumID(this.predecesorID(nodo));
                nodo.setNodoIzq(this.eliminar(nodo.getNodoIzq(), nodo.getNumID()));
            }
        }
        return nodo;
    }

    private int predecesorID(NodoPaciente nodo) {
        nodo = nodo.getNodoIzq();
        while (nodo.getNodoDerecho() != null) {
            nodo = nodo.getNodoDerecho();
        }
        return nodo.getNumID();
    }

    private Paciente predecesor(NodoPaciente nodo) {
        nodo = nodo.getNodoIzq();
        while (nodo.getNodoDerecho() != null) {
            nodo = nodo.getNodoDerecho();
        }
        return nodo.getPaciente();
    }


    private int sucesorID(NodoPaciente nodo) {
        nodo = nodo.getNodoDerecho();
        while (nodo.getNodoIzq() != null) {
            nodo = nodo.getNodoIzq();
        }
        return nodo.getNumID();
    }

    private Paciente sucesor(NodoPaciente nodo) {
        nodo = nodo.getNodoDerecho();
        while (nodo.getNodoIzq() != null) {
            nodo = nodo.getNodoIzq();
        }
        return nodo.getPaciente();
    }

}
