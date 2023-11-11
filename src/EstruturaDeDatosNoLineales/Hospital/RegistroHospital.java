package EstruturaDeDatosNoLineales.Hospital;

import java.util.Scanner;

public class RegistroHospital {
    static ArbolPacientes pacientes = new ArbolPacientes();
    public static void main(String[] args) {
        Paciente paciente1= new Paciente(1,"Carlos",20,"gripa");
        Paciente paciente2= new Paciente(2,"juan",20,"gripa");
        Paciente paciente3= new Paciente(0,"angel",20,"gripa");
        Paciente paciente4= new Paciente(4,"oscar",20,"gripa");
        pacientes.setRaiz(new NodoPaciente(paciente1));
        pacientes.insertar(paciente2);
        pacientes.insertar(paciente3);
        pacientes.insertar(paciente4);
        try{
            pacientes.borrar(2);
            System.out.println();
        }catch (Exception e){

        }
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
}
