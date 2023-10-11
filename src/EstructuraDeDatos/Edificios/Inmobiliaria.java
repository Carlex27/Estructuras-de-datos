package EstructuraDeDatos.Edificios;



import EstructuraDeDatos.Lista;
import EstructuraDeDatos.Nodo;
import java.io.*;
import java.util.Scanner;

public class Inmobiliaria {
    /*Departamento depa1= new Departamento(false,1);
            Nodo temp= new Nodo(depa1);
            Piso piso1=new Piso(1,temp);
            Nodo temp2= new Nodo(piso1);
            Edificio lomasZihua= new Edificio("lomasZihua",temp2);
            listaEdificios=leerArchivo();
            registrarNuevoDepa();
            marcarDepartamento();
            consultarDepartamentos();
            */
    static Lista listaEdificios= new Lista();
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        boolean salir=true;
        int opc=0;
        do {
            try {
                System.out.println("ADMINISTRACION DE EDIFICIOS");
                System.out.println("1.Registrar nuevo edificio");
                System.out.println("2.Registrar nuevo apartamento");
                System.out.println("3.Marcar apartamento como (Disponible - Rentado)");
                System.out.println("4.Consultar departamentos en un piso");
                System.out.println("5.Mostrar el estado de una departamento");
                System.out.println("6.Mostrar todos los edificios");
                System.out.println("7.Guardar los datos");
                System.out.println("8.Cargar los datos");
                System.out.println("9.Salir");
                opc= leer.nextInt();
                switch (opc){
                    case 1://REGISTRAR NUEVO EDIFICIO
                        crearEdificio();
                        break;
                    case 2://REGISTRAR NUEVO APARTAMENTO
                        registrarNuevoDepa();
                        break;
                    case 3://MARCAR APARTAMENTO
                        marcarDepartamento();
                        break;
                    case 4://CONSULTAR DEPARTAMENTOS EN UN PISO
                        consultarDepartamentos();
                        break;
                    case 5://MOSTRAR EL ESTADO DE UN DEPARTAMENTO
                        mostarEstadoDepartamento();
                        break;
                    case 6://MOSTRAR TODOS LOS EDIFICIOS
                        mostrarEdificios();
                        break;
                    case 7://GUARDAR EDIFICIOS
                        guardar(listaEdificios);
                        break;
                    case 8://CARGAR EDIFICIOS
                        listaEdificios=leerArchivo();
                        break;
                    case 9://SALIR
                        salir=false;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (salir);
    }

    private static void mostrarEdificios() {
        Nodo recorre=listaEdificios.primero;
        if(recorre==null){
            System.out.println("ListaVacia");
        }
        while (recorre!=null){
            Edificio edificio=(Edificio) recorre.getInfo();
            System.out.println("Edificio: " + edificio.getNombre());
            Nodo recorre2=edificio.getPisos();
            while (recorre2!=null){
                Piso piso=(Piso)recorre2.getInfo();
                System.out.println("Piso " + piso.getNumDepiso());
                Nodo recorre3=piso.getDepartamento();
                while (recorre3!=null){
                    Departamento depa=(Departamento) recorre3.getInfo();
                    System.out.println("Departamento #" + depa.getNumDepa() + " Rentado: " + depa.isRentado());
                    recorre3=recorre3.getSig();
                }
                recorre2=recorre2.getSig();
            }
            recorre=recorre.getSig();
            System.out.println();
        }
        System.out.println();
    }

    public static void mostarEstadoDepartamento(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Vamos a mostrar el estado de un departamento");
        Edificio edificio = encontrarEdificio();
        if(edificio==null){
            System.out.println("No se encontro el edificio");
            return;
        }
        Piso piso= encontrarPiso(edificio);
        if(piso==null){
            System.out.println("No se encontro el piso");
            return;
        }
        Departamento depa=encontrarDepa(piso);
        if(depa==null){
            System.out.println("No se encontro el departamento");
            return;
        }
        System.out.println("Edificio " + edificio.getNombre());
        System.out.println("Piso " + piso.getNumDepiso());
        System.out.println("Departamento # " +depa.getNumDepa() + "Disponible: " + depa.isRentado() );
    }

    private static void consultarDepartamentos() {
        System.out.println("Vamos a mostrar todos los departamentos de un piso en especifico");
        Edificio edificio = encontrarEdificio();
        if(edificio==null){
            System.out.println("No se encontro el edificio");
            return;
        }
        Piso piso= encontrarPiso(edificio);
        if(piso==null){
            System.out.println("No se encontro el piso");
            return;
        }
        Nodo departamentos = piso.getDepartamento();
        Departamento depa;
        System.out.println("Edificio " + edificio.getNombre());
        System.out.println("Piso " + piso.getNumDepiso());
        while (departamentos!=null){
            depa= (Departamento) departamentos.getInfo();
            System.out.println("Departamento numero: " + depa.getNumDepa() + "Disponible: " + depa.isRentado());
            departamentos=departamentos.getSig();
        }
    }

    private static void marcarDepartamento() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Vamos a marcar un departamento como rentado o disponible");
        Edificio edificio = encontrarEdificio();
        if(edificio==null){
            System.out.println("No se encontro el edificio");
            return;
        }
        Piso piso= encontrarPiso(edificio);
        if(piso==null){
            System.out.println("No se encontro el piso");
            return;
        }
        Departamento depa=encontrarDepa(piso);
        if(depa==null){
            System.out.println("No se encontro el departamento");
            return;
        }
        System.out.println("Quieres marcarlo como disponible o rentado?\n1.Rentado 2.Disponilbe");
        int opc= leer.nextInt();
        switch (opc){
            case 1:
                if(depa.isRentado())
                    System.out.println("Departamento rentado");
                else
                    depa.setRentado(true);
                break;
                case 2:
                    if(!depa.isRentado())
                        System.out.println("Departamento Disponible");
                    else
                        depa.setRentado(false);
                    break;
        }
    }

    public static void registrarNuevoDepa() {
        Scanner leer = new Scanner(System.in);
        Edificio edificio = encontrarEdificio();
        if (edificio == null) {
            System.out.println("No se encontró el edificio");
            return;
        }
        Piso piso = encontrarPiso(edificio);
        if (piso == null) {
            System.out.println("No se encontró el piso");
            return;
        }
        System.out.println("Dime qué número de departamento es: ");
        int numDepa = leer.nextInt();
        System.out.println("¿Está rentado?\n1. Si\n2. No");
        int renta = leer.nextInt();
        Departamento nuevo = switch (renta) {
            case 1 -> new Departamento(true, numDepa);
            case 2 -> new Departamento(false, numDepa);
            default -> null;
        };
        Nodo insertar = piso.getDepartamento();
        while (insertar != null) {
            if (insertar.getSig() == null) {
                Nodo siguiente = new Nodo(nuevo);
                insertar.setSig(siguiente);
                break;
            }
            insertar = insertar.getSig();
        }
    }

    private static Departamento encontrarDepa(Piso piso) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Dime el numero del departamento");
        int numDepa= leer.nextInt();
        Nodo recorre=piso.getDepartamento();
        while (recorre!=null){
            Departamento temporal=(Departamento) recorre.getInfo();
            if(temporal.getNumDepa()==numDepa)
                return temporal;
            recorre = recorre.getSig();
        }
        return null;
    }
    private static Piso encontrarPiso(Edificio piso) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Dime cual piso deseas buscar");
        int i= leer.nextInt();
        Nodo recorre=piso.getPisos();
        while (recorre!=null){
            Piso temporal=(Piso) recorre.getInfo();
            if(temporal.getNumDepiso()==i)
                return temporal;
            recorre = recorre.getSig();
        }
        return null;
    }

    private static Edificio encontrarEdificio() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Dime el nombre del edificio que quieres buscar");
        String buscar= leer.nextLine();
        Nodo recorre=listaEdificios.primero;
        while (recorre!=null){
            Edificio temporal=(Edificio) recorre.getInfo();
            if(temporal.getNombre().equalsIgnoreCase(buscar))
                return temporal;
            recorre = recorre.getSig();
        }
        return null;
    }

    public static void crearEdificio(){
        Scanner leer = new Scanner(System.in);
        Edificio nuevoEdificio;
        System.out.println("Registrar nuevo edificio");
        System.out.println("Dame el nombre del edificio: ");
        nuevoEdificio= new Edificio(leer.nextLine(),crearPisos());
        listaEdificios.insertarFinal(nuevoEdificio);
    }

    private static Nodo crearPisos() {
        Scanner leer = new Scanner(System.in);
        Lista temp=new Lista();
        System.out.println("Dime cuantos pisos tiene el edificio");
        try{
            int aux= leer.nextInt();
            for (int i=0; i<aux;i++){
                System.out.println("Registrando piso " + (i+1));
                Piso nuevoPiso=new Piso((i+1),crearDepas());
                temp.insertarFinal(nuevoPiso);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return temp.primero;
    }

    private static Nodo crearDepas() {
        Scanner leer = new Scanner(System.in);
        Lista temp = new Lista();
        Departamento depa;
        System.out.println("Cuantos departamentos tiene?");
        int aux= leer.nextInt();
        for(int i = 0; i<aux;i++){
            System.out.println("Numero de departamento: ");
            int numDepa= leer.nextInt();
            depa= new Departamento(false,numDepa);
            temp.insertarFinal(depa);
        }
        return temp.primero;
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
            Lista lista;
            lista=(Lista) entrada.readObject();
            entrada.close();
            return lista;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
