package Lineales.Pila.Practica;

import java.util.Scanner;

public class EditorTexto {
    static Scanner leer = new Scanner(System.in);
    static String texto = "";
    static TipoPila pilaUndo =new TipoPila();
    static TipoPila pilaRedo = new TipoPila();
    public static void main(String[] args) {
        String respuesta="";
        System.out.println("Editor de texto simple\nComandos:\nadd <TEXTO>\ndel <n>\nundo\nredo");
        do {
            try{
            respuesta = leer.nextLine();
            String[] partes =respuesta.split(" ");
            switch (partes[0]) {
                case "add":
                    add(partes[1]);
                    break;
                case "del":
                    del(partes[1]);
                    break;
                case "undo":
                    undo();
                    break;
                case "redo":
                    redo();
                    break;
            }
            System.out.println(texto);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        }while (respuesta.charAt(0)!='s');
    }
    public static void add(String cadena){
        texto+=cadena;
        try{
            pilaUndo.meter("add "+cadena);
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
    public static void del(String cadena){
        int del = Integer.parseInt(cadena);
        if(!texto.isEmpty()) {
            String aux = texto.substring(texto.length() - del);
            texto = texto.substring(0, texto.length() - del);
            try {
                pilaUndo.meter("del " + aux);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else
            System.out.println("No hay texto");
    }
    public static void redo() {
        String aux = "";
        try {
            if(!pilaRedo.pilaVacia()){
                aux = (String) pilaRedo.sacar();
                String partes[]=aux.split(" ");
                if(partes[0].equals("add")){
                    aux= String.valueOf(partes[1].length());
                    del(aux);
                }else{
                    add(partes[1]);
                }
            }else
                System.out.println("PilaVacia");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void undo(){
        String aux = "";
        try {
            if(!pilaUndo.pilaVacia()){
                aux = (String) pilaUndo.sacar();
                String[] partes=aux.split(" ");
                if(partes[0].equals("add")){
                    del(String.valueOf(partes[1].length()));
                    pilaRedo.meter("del " +partes[1]);
                }else{
                    add(partes[1]);
                    pilaRedo.meter("add "+partes[1]);
                }
            }else
                System.out.println("PilaVacia");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
