package EstructuraDeDatos;

import java.util.Scanner;

public class EditorTexto {
    static Scanner leer = new Scanner(System.in);
    static String texto = "";
    static TipoPila pilaUndo =new TipoPila();
    static TipoPila pilaRedo = new TipoPila();
    public static void main(String[] args) {
        String respuesta= "";
        try{
        do {
            respuesta = leer.nextLine();
            switch (respuesta.charAt(0)) {
                case 'a':
                    add(respuesta);
                    pilaUndo.meter(respuesta);
                    break;
                case 'd':
                    del(respuesta);
                    pilaUndo.meter(respuesta);
                    break;
                case 'r':

                    break;
                case 'u':

                    break;
            }
            System.out.println(texto);
        }while (respuesta.charAt(0)!='s');

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void add(String cadena){
        String[] partes =cadena.split(" ");
        texto+=partes[1];
    }
    public static void del(String cadena){
        String[] partes =cadena.split(" ");
        int del= Integer.parseInt(partes[1]);
        texto=texto.substring(0,texto.length()-del);
    }
    public static void redo() {
        String aux = "";
        try {
            aux = (String) pilaUndo.sacar();
            pilaRedo.meter(aux);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void undo(){

    }
}
