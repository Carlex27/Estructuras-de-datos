package EstructuraDeDatos.ListasEnlazadas;

public class UnirListas2 {

    public static void main(String[] args) {
        Lista lista1= new Lista();
        Lista lista2= new Lista();
        Lista lista3= new Lista();
        Lista listaUnida;
        darValores(lista1);
        darValores(lista2);
        darValores(lista3);
        listaUnida= unirListas(lista1,lista2,lista3);
        listaUnida=ordenarLista(listaUnida);
        listaUnida.imprimir();
    }
    public static Lista unirListas(Lista lista1, Lista lista2,Lista lista3){
        Lista listaUnida= new Lista();
        Nodo actual,anterior=null;
        actual=lista1.primero;
        while (actual !=null){
            listaUnida.insetarFinal(actual.getInfo());
            anterior=actual;
            actual=actual.getSig();
        }
        actual=lista2.primero;
        while (actual !=null){
            listaUnida.insetarFinal(actual.getInfo());
            anterior=actual;
            actual=actual.getSig();
        }
        actual=lista3.primero;
        while (actual !=null){
            listaUnida.insetarFinal(actual.getInfo());
            anterior=actual;
            actual=actual.getSig();
        }
        return listaUnida;
    }
    public static Lista darValores(Lista lista){
        int tamanio=(int)(Math.random()*500);
        for(int i=0;i<tamanio;i++){
            int num=(int)(Math.random()*1001);
            lista.insertarInicio(num);
        }
        return lista;
    }
    public static Lista ordenarLista(Lista lista) {
        Lista listaTemporal = new Lista();
        Nodo recorre = lista.primero;
        while (recorre != null) {

        }
        return listaTemporal;
    }

    private static void insertarOrdenado(Lista lista, Nodo nodo) {

    }

}
