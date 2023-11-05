package EstruturaDeDatosNoLineales.Hospital;

public class PruebaPacientes {
    public static void main(String[] args) {
        Paciente paciente1= new Paciente(1,"Carlos",20,"gripa");
        Paciente paciente2= new Paciente(2,"juan",20,"gripa");
        Paciente paciente3= new Paciente(0,"angel",20,"gripa");
        Paciente paciente4= new Paciente(4,"oscar",20,"gripa");
        NodoPaciente arbolPacientes= new NodoPaciente(paciente1);
        arbolPacientes.insertar(paciente2);
        arbolPacientes.insertar(paciente3);
        arbolPacientes.insertar(paciente4);
    }
}
