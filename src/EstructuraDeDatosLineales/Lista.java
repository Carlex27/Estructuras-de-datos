package EstructuraDeDatosLineales;

import java.io.Serializable;

public class Lista implements Serializable {
    public Nodo primero;
    public Lista(){
        primero=null;
    }
    public void insertarInicio(Object entrada){
        Nodo nuevo = new Nodo(entrada);  //SE CREA EL NUEVO NODO
        nuevo.setSig(primero);
        primero=nuevo;

    }
    public void insertarSeg(Object entrada){
        Nodo nuevo = new Nodo(entrada);
        if(primero==null){ //SI LA LISTA ESTA VACIA
            primero=nuevo;
        }else{
            nuevo.setSig(primero.getSig());
            primero.setSig(nuevo);

        }

    }
    public void insertarFinal(Object entrada){
        Nodo nuevo = new Nodo(entrada);
        Nodo recorre;
        if(primero==null){
            primero=nuevo;
        }else{
            recorre =  primero;
            while (recorre.getSig()!=null){
                recorre=recorre.getSig();
            }
            recorre.setSig(nuevo);
        }

    }

    public void eleminarInicio(){
        if(primero!=null){
            primero=primero.sig;
        }

    }
    public void eliminarSeg(){
        Nodo borrar;
        if(primero!=null){
            borrar=primero.sig;
            if(borrar!=null)
                primero.setSig(borrar.sig);
            else
                primero=null;
        }

    }
    public void eliminarFinal(){
        Nodo recorre,anterior;
        if(primero!=null){
            recorre=primero;
            anterior=null;
            while (recorre.getSig()!=null){
                anterior=recorre;
                recorre=recorre.getSig();
            }
            if(anterior!=null){
                anterior.setSig(null);
            }else{
                primero=null;
            }
        }

    }
    public void imprimir(){ //METODO PARA IMPRIMIR LA LISTA
        Nodo recorre;
        int i=0;
        if(primero!=null){
            recorre=primero;
            while (recorre.getSig()!=null){
                System.out.print(recorre.getInfo()+ ", ");
                recorre=recorre.getSig();
                i++;
                if(i==30){
                    System.out.println();
                    i=0;
                }
            }
            if(recorre.getSig()==null){
                System.out.print(recorre.getInfo() + ", ");
            }
        }else{
            System.out.println("Lista vacia");
        }
    }
    //METODO PARA BUSCAR UN ELEMTO POR LA LISTA
    public boolean buscar(Object buscar){
        Nodo recorre;
        if(primero!=null){
            recorre=primero;
            if(recorre.getSig()==null && recorre.getInfo().equals(buscar)){
                System.out.println(recorre.getInfo());
                return true;
            }else{
                System.out.println("No se encuentra en la lista");
            }
            while (recorre.getSig()!=null){
                if(recorre.getInfo().equals(buscar)){
                    System.out.println("Se encuentra en la lista: " + recorre.getInfo());
                    return true;
                }
                recorre=recorre.getSig();
            }
        }else{
            System.out.println("Lista vacia");
            return false;
        }
        return false;
    }
    public boolean estaVacia(){
        return primero == null;
    }

}
