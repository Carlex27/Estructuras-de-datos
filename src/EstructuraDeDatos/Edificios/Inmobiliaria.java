package EstructuraDeDatos.Edificios;

import EstructuraDeDatos.Lista;
import EstructuraDeDatos.Nodo;

import java.io.*;
import java.util.Scanner;

public class Inmobiliaria {
    static Scanner leer = new Scanner(System.in);
    static Lista listaEdificios= new Lista();
    public static void main(String[] args) {
        try{
            Departamento depa1= new Departamento(false,1);
            Nodo temp= new Nodo(depa1);
            Piso piso1=new Piso(1,temp);
            Nodo temp2= new Nodo(piso1);
            Edificio lomasZihua= new Edificio("lomasZihua",temp2);


        }catch (Exception e) {

        }


    }
    public static void registrarDepa(){

    }
    public static void guardar(Lista lista){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("ListaEdificios.txt"));
            salida.writeObject(lista);
            salida.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static Lista leerArchivo(){
        try{
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("ListaEdificios.txt"));
            Lista lista= new Lista();
            lista=(Lista) entrada.readObject();
            entrada.close();
            return lista;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
