package Pila;

import java.util.Scanner;

public class Expresiones {
    static TipoPila pila= new TipoPila();
    static Scanner leer=new Scanner(System.in);
    static String posfija="";
    public static void main(String[] args) {
        String infija;
        System.out.println("Dame una expresion matematica");
        infija= leer.nextLine();
        infija= infija+")";
        aPosfija(infija);
        System.out.println(posfija);

    }
    public static void  aPosfija(String infija){
        String aux="";
        try {
            pila.meter('(');
            for(int i=0;i<infija.length();i++){
                if(infija.charAt(i)=='('){
                    pila.meter('(');
                }else if(infija.charAt(i)==')'){
                    pila.meter(')');
                    posfija=posfija+aux+',';
                    aux="";
                }
                if(infija.charAt(i)>='0' && infija.charAt(i)<='9'){
                    aux=aux+infija.charAt(i);
                }
                if(infija.charAt(i)== '*' || infija.charAt(i)== '/' ){
                    pila.meter(infija.charAt(i));
                    posfija=posfija+aux+',';
                    aux="";
                }else if(infija.charAt(i)== '+' || infija.charAt(i)== '-' ){
                    pila.meter(infija.charAt(i));
                    posfija=posfija+aux+',';
                    aux="";
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static int prioridad(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
    public static void evaluar() {
        int a, b, resultado;
        String aux = "";
        try {
            for (int i = 0; i < posfija.length(); i++) {
                char c = posfija.charAt(i);
                if (c >= '0' && c <= '9') {
                    aux += c;
                } else if (c == ',' && !aux.isEmpty()) {
                    pila.meter(aux);
                    aux = "";
                } else if (c == '+') {
                    a = Integer.parseInt((String) pila.sacar());
                    b = Integer.parseInt((String) pila.sacar());
                    resultado=a+b;
                    pila.meter(resultado);
                } else if (c == '-') {
                    a = Integer.parseInt((String) pila.sacar());
                    b = Integer.parseInt((String) pila.sacar());
                    pila.meter(a - b);
                } else if (c == '*') {
                    a = Integer.parseInt((String) pila.sacar());
                    b = Integer.parseInt((String) pila.sacar());
                    pila.meter(a * b);
                } else if (c == '/') {
                    a = Integer.parseInt((String) pila.sacar());
                    b = Integer.parseInt((String) pila.sacar());
                    if (b != 0) {
                        pila.meter(a / b);
                    }
                }
            }

            System.out.println("El resultado es: " + pila.sacar());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
