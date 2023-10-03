package EstructuraDeDatos.Edificios;

import EstructuraDeDatos.Lista;
import EstructuraDeDatos.Nodo;

import java.util.Scanner;

public class Inmobiliaria {
    static Scanner leer = new Scanner(System.in);
    static Lista listaEdificios= new Lista();
    public static void main(String[] args) {
        Lista pisos= new Lista();
        Piso piso1,piso2;

        Edificio LomasZihua = new Edificio("LomasZihua",null);
        listaEdificios.insertarInicio(LomasZihua);
    }
    public static void registrarDepa(){

    }
}
