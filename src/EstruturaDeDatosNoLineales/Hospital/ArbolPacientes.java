package EstruturaDeDatosNoLineales.Hospital;

import EstruturaDeDatosNoLineales.Hospital.ListaEnlazada.Lista;


import java.io.Serializable;

public class ArbolPacientes implements Serializable {
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
    //METODO QUE BUSCA UN ELEMENTO DENTRO DEL ARBOL
    private Paciente buscarArbol(NodoPaciente nodo, int numID)throws Exception {
        if(nodo==null){ //EN CASO DE NO ENCONTRAR EL ELEMENTO
            throw new Exception("No se encontro");
        }
        if(nodo.getNumID()==numID){ //SI LO ENCUENTRA SE RETORNA EL OBJ PACIENTE
            return nodo.getPaciente();
        }
        //RECURSIVIDAD
        if(numID< nodo.getNumID()){
            return buscarArbol(nodo.getNodoIzq(),numID);
        }else{
            return buscarArbol(nodo.getNodoDerecho(),numID);
        }
    }
    public void borrar(int numID){
        this.raiz=eliminar(this.raiz,numID);
    }

    //METODO PARA ELIMINAR UN ELEMENTO DEL ARBOL
    private NodoPaciente eliminar(NodoPaciente nodo, int numID) {
        if (nodo==null){//SI ES NODO ES NULO
            return nodo;
        }
        if(numID > nodo.getNumID()){ 
            nodo.setNodoDerecho(eliminar(nodo.getNodoDerecho(),numID));
        }else if(numID < nodo.getNumID()){
            nodo.setNodoIzq((eliminar(nodo.getNodoIzq(),numID)));
        }else { //SI EL NUMID ES IGUAL AL NUMID DEL NODO
            //SI EL NODO NO TIENE HIJOS
            if(nodo.getNodoDerecho()==null && nodo.getNodoIzq()==null){
                nodo=null;
            }else if(nodo.getNodoDerecho()!=null){
                //SI EL NODO TIENE UN HIJO DERECHO
                nodo.setPaciente(sucesor(nodo));
                nodo.setNumID(sucesorID(nodo));
                nodo.setNodoDerecho(eliminar(nodo.getNodoDerecho(),nodo.getNumID()));
            }else{
                //SI EL NODO TIENE UN HIJO IZQUIERDO O AMBOS
                nodo.setPaciente(predecesor(nodo));
                nodo.setNumID(predecesorID(nodo));
                nodo.setNodoIzq(eliminar(nodo.getNodoIzq(), nodo.getNumID()));
            }
        }
        return nodo;
    }
    //METODO QUE RETORNA EL NUMID DEL PREDECESOR
    private int predecesorID(NodoPaciente nodo) {
        nodo = nodo.getNodoIzq();
        while (nodo.getNodoDerecho() != null) {
            nodo = nodo.getNodoDerecho();
        }
        return nodo.getNumID();
    }
    //METODO QUE REGRESA EL OBJ PACIENTE DEL PREDECESOR
    private Paciente predecesor(NodoPaciente nodo) {
        nodo = nodo.getNodoIzq();
        while (nodo.getNodoDerecho() != null) {
            nodo = nodo.getNodoDerecho();
        }
        return nodo.getPaciente();
    }

    //METODO QUE REGRESA EL NUMID DEL SUCESOR
    private int sucesorID(NodoPaciente nodo) {
        nodo = nodo.getNodoDerecho();
        while (nodo.getNodoIzq() != null) {
            nodo = nodo.getNodoIzq();
        }
        return nodo.getNumID();
    }
    //METODO QUE RETORNA EL OBJ PACIENTE DEL SUCESOR
    private Paciente sucesor(NodoPaciente nodo) {
        nodo = nodo.getNodoDerecho();
        while (nodo.getNodoIzq() != null) {
            nodo = nodo.getNodoIzq();
        }
        return nodo.getPaciente();
    }
    //METODO PARA IMPRIMIR TODO EL ARBOL BINARIO
    public void imprimirElementos(){
        imprimirEnOrdenRec(raiz);
    }

    private void imprimirEnOrdenRec(NodoPaciente nodo) {
        if(nodo!=null){
            imprimirEnOrdenRec(nodo.getNodoIzq());
            System.out.println(nodo.getPaciente().toStringLinea());
            imprimirEnOrdenRec(nodo.getNodoDerecho());
        }
    }
    //METODO QUE REGRESA UNA LISTA DE OBJETOS PACIENTES EN PREORDEN
    public Lista preOrden(){
        Lista lista = new Lista();
        preOrdenALista(raiz,lista);
        return lista;
    }
    //METODO QUE INSERTA LOS ELEMENTOS DEL ARBOL EN UNA LISTA
    private void preOrdenALista(NodoPaciente nodo, Lista lista) {
        if(nodo!=null){
            lista.insertarFinal(nodo.getPaciente());
            preOrdenALista(nodo.getNodoIzq(),lista);
            preOrdenALista(nodo.getNodoDerecho(),lista);
        }
    }
    
    
}
