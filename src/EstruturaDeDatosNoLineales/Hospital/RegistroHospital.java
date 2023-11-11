package EstruturaDeDatosNoLineales.Hospital;

import EstruturaDeDatosNoLineales.Hospital.ListaEnlazada.Lista;
import EstruturaDeDatosNoLineales.Hospital.ListaEnlazada.Nodo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class RegistroHospital {
    static ArbolPacientes pacientes = new ArbolPacientes();
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        pacientes=cargarArchivo();
        boolean ban = true;
        System.out.println("Hospital");
        while (ban){
            System.out.println("1.Agregar nuevo Paciente");
            System.out.println("2.Buscar un paciente");
            System.out.println("3.Modificar el diagnostico");
            System.out.println("4.Eliminar un registro");
            System.out.println("5.Ver todos los pacientes");
            System.out.println("6.Salir");
            int opc=leer.nextInt();
            try{
                switch (opc){
                    case 1->{//AGREGAR PACIENTE
                        agregarPaciente();
                    }
                    case 2->{//BUSCAR UN PACIENTE
                        System.out.println("El numID del paciente a buscar");
                        pacientes.buscar(leer.nextInt());
                    }
                    case 3->{//MODIFICAR EL DIAGNOSTICO
                        System.out.println("El numID del paciente a modificar");
                        modificarRegistro(leer.nextInt());
                    }
                    case 4->{//ELIMINAR UN REGISTRO
                        System.out.println("El numID del paciente a eliminar");
                        pacientes.borrar(leer.nextInt());
                    }
                    case 5->{//VER TODOS OS PACIENTES
                        pacientes.imprimirElementos();
                    }
                    case 6->{
                        System.out.println("Saliendo");
                        ban=false;
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        guardarArchivo();
    }
    public static void agregarPaciente(){
        //Metodo para agregar un paciente
        Scanner leer = new Scanner(System.in);
        try{
            System.out.println("Registra nuevo paciente");
            System.out.println("Numero de identificacion");
            int numID=leer.nextInt();
            System.out.println("Dime el nombre del paciente");
            String nombre=leer.nextLine();
            System.out.println("Edad del paciente");
            int edad= leer.nextInt();
            System.out.println("Dime el diagnostico del paciente");
            String diagnostico=leer.nextLine();
            //Agrega al arbol el nuevo objeto Paciente
            pacientes.insertar(new Paciente(numID,nombre,edad,diagnostico));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void  modificarRegistro(int numID){
        //Metodo que modifica el registro de un paciente
        Scanner leer = new Scanner(System.in);
        Scanner leerString= new Scanner(System.in);
        boolean ban = true;
        String aux="";
        Paciente paciente=pacientes.buscar(numID);
        //Verifiica si el paciente es null
        if(paciente==null){
            return; //Termina el metodo
        }
        System.out.println("Se va a modificar el registro de un paciente");
        System.out.println(paciente.toString());
        do{
            System.out.println("1.Nombre del paciente");
            System.out.println("2.Edad del paciente");
            System.out.println("3.Diagnostico del paciente");
            System.out.println("4.Salir");
            int opc= leer.nextInt();
            //Escoger entre las opciones
            switch (opc) {
                case 1 -> {
                    System.out.println("Ingrese el nombre");
                    aux = leerString.nextLine();
                    paciente.setNombre(aux);
                }
                case 2 -> {
                    System.out.println("Ingrese la edad");
                    int edad = leer.nextInt();
                    paciente.setEdad(edad);
                }
                case 3 -> {
                    System.out.println("Ingrese el diagnostico");
                    aux = leerString.nextLine();
                    paciente.setDiagnostico(aux);
                }
                case 4 -> {
                    System.out.println("Terminando modificaciones");
                    ban = false;
                }
                default -> System.out.println("No es una opcion dispoible");
            }
            System.out.println("Nuevos datos del paciente");
            System.out.println(paciente.toString());
        }while (ban);
    }
    //METODO PARA GUARDAR A UN ARCHIVO
    public static void guardarArchivo(){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("RegistroPaciente.txt"));
            Lista lista=pacientes.preOrden();//SE OBTIENE UNA LISTA DEL ARBOL EN PREORDEN
            salida.writeObject(lista);
            salida.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //METODO QUE CARGA LOS DATOS DEL ARCHIVO BINARIO
    public static ArbolPacientes cargarArchivo(){
        try{
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("RegistroPaciente.txt"));
            Lista lista;
            lista=(Lista) entrada.readObject();
            ArbolPacientes arbol=insertarPacientes(lista);//SE INSERTAN LOS ELEMENTOS DE LA LISTA EN EL ARBOL
            entrada.close();
            return arbol;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    //METODO QUE INSERTA LA LISTA EN EL ARBOL
    private static ArbolPacientes insertarPacientes(Lista lista) {
        Nodo recorre = lista.primero.getSig();
        Paciente temp=(Paciente)lista.primero.getInfo();
        ArbolPacientes arbol=new ArbolPacientes();
        arbol.setRaiz(new NodoPaciente(temp));//SE SETEA DIRECTAMENTE LA RAIZ DEL ARBOL
        while (recorre!=null){
            arbol.insertar((Paciente)recorre.getInfo());
            recorre=recorre.getSig();
        }
        return arbol;
    }

}
