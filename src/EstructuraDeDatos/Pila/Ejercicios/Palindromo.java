package EstructuraDeDatos.Pila.Ejercicios;



import java.util.Scanner;

public class Palindromo {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        TipoPila pila;
        String cadena;
        StringBuilder aux= new StringBuilder();
        StringBuilder cadenainversa = new StringBuilder();
        char letra;
        System.out.println("Vamos a verificar si es un palindromo");
        cadena=leer.nextLine();
        try{
            pila= new TipoPila();
            for(int i=0;i<cadena.length();i++){
                letra=cadena.charAt(i);
                if(letra!=' ') {
                    aux.append(letra);
                    pila.meter(letra);
                }
            }
            while (!pila.pilaVacia()){
                cadenainversa.append(pila.sacar());
            }
            System.out.println("La cadena original sin espacios es: " + aux);
            if(cadena.contentEquals(cadenainversa)){
                System.out.println("Es un palindromo: " + cadenainversa);
            }else
                System.out.println("No es un palindromo: " + cadenainversa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
