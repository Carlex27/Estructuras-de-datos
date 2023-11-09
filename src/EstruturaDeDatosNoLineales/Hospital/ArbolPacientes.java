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

}
