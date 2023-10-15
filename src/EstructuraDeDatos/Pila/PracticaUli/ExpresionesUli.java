package EstructuraDeDatos.Pila.PracticaUli;


import java.util.Scanner;
public class ExpresionesUli {
    static TipoPila pila = new TipoPila();
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        System.out.println("Ingrese la expresión infija: ");
        String entrada = x.next();
        String salida = convertirInfijaAPosfija(entrada);

        System.out.println("Expresión posfija: " + salida);

        double resultado = evaluarPosfija(salida);
        System.out.println("El resultado es: " + resultado);
    }

    private static String convertirInfijaAPosfija(String expresionInfija) {
        StringBuilder salida = new StringBuilder();
        StringBuilder operadores = new StringBuilder();

        try{
        for (int i = 0; i < expresionInfija.length(); i++) {
            char caracter = expresionInfija.charAt(i);

            if (Character.isDigit(caracter)) {
                salida.append(caracter);
            } else if (caracter == '+' || caracter == '-') {
                pila.meter(caracter);
            } else if (caracter == '*' || caracter == '/') {
                operadores.append(caracter);
            } else if (caracter == '(') {
                operadores.append(caracter);
            } else if (caracter == ')') {
                while (operadores.charAt(operadores.length() - 1) != '(') {
                    salida.append(operadores.charAt(operadores.length() - 1));
                    operadores.deleteCharAt(operadores.length() - 1);
                }
                operadores.deleteCharAt(operadores.length() - 1);
            }
        }

        while (operadores.length() > 0) {
            salida.append(operadores.charAt(operadores.length() - 1));
            operadores.deleteCharAt(operadores.length() - 1);
        }
        }catch (Exception e){
            System.out.println("ERROR");
        }

        return salida.toString();
    }

    private static double evaluarPosfija(String expresionPosfija) {
        double resultado = 0.0;

        return resultado;
    }
}
