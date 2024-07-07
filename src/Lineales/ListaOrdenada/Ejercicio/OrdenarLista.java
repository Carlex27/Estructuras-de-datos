package Lineales.ListaOrdenada.Ejercicio;

import Lineales.ListaOrdenada.ListaOrdenada;

import java.util.Scanner;

public class OrdenarLista {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        ListaOrdenada lista = new ListaOrdenada();
        int opc;
        try{
            do{
                System.out.println("\nMENU\n1.Insertar\n2.Eliminar\n3.Visualizar\n4.Salir");
                opc= leer.nextInt();
                switch (opc){
                case 1://INSERTAR
                    System.out.println("Dame un numero entero");
                    lista.insertar(leer.nextInt());
                    break;
                case 2://ELIMINAR
                    System.out.println("Dime un numero que quieras eliminar de la lista");
                    lista.eliminar(leer.nextInt());
                    break;
                case 3://VISUALIZAR
                    lista.visualizar();
                    break;
                case 4://SALIR
                    System.out.println("Saliendo");
                    break;
                }
             }while(opc!=4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
