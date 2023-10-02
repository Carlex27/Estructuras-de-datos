package Pila;

import java.util.Scanner;

public class Expresiones2 {
    static Scanner leer = new Scanner(System.in);
    static String posfijo="";
    static TipoPila pila = new TipoPila();
    public static void main(String[] args) {
        String infija=leer.nextLine();
        aPosfija(infija+")");
        System.out.println(posfijo);
        evaluar();
    }

    private static void aPosfija(String infija) {
        String aux="";
        try{
            pila.meter('(');
            for(int i =0; i<infija.length();i++){
                Character c=infija.charAt(i);
                //MANEJO DEL PARENTESIS IZQUIERDO
                if(c=='('){
                    pila.meter(c);
                } else if (c==')') { //MANEJO DEL PARENTESIS DERECHO
                    while (!pila.pilaVacia() && (pila.UltimoElem() !="(")){
                        posfijo+=aux+",";
                        posfijo+=pila.sacar();
                        aux="";
                        if(posfijo.charAt(posfijo.length()-1)=='('){
                            posfijo=posfijo.substring(0,posfijo.length()-2);
                        }
                    }
                }
                if(c>='0' && c<='9'){
                    aux+=c;
                }
                if(operador(c)){
                    posfijo+=aux+",";
                    aux="";
                    if(!pila.pilaVacia() && (prioridad(c)>=prioridad((Character) pila.UltimoElem()))){
                        pila.meter(c);
                    }else{
                        while (!pila.pilaVacia() && ((Character) pila.UltimoElem() !='(')){
                            posfijo+=pila.sacar()+",";

                        }
                        pila.meter(c);
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static boolean operador(char c) {
        return (c == '+') ||(c == '-') ||(c == '*') ||(c == '/');
    }
    private static int prioridad(char c){
        switch (c){
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            default:
                return -1;
        }
    }

    private static void evaluar() {
        pila.limpiarPila();
        int A = 0,B=0;
        String aux="";
        String partes[]= posfijo.split(",+");
        try{
            for (int i=0;i<partes.length;i++){
                if(partes[i].equals("+") || partes[i].equals("-") || partes[i].equals("*") || partes[i].equals("/")){
                    switch (partes[i]){
                        case "+":
                            A=Integer.parseInt((String) pila.sacar());
                            B=Integer.parseInt((String) pila.sacar());
                            aux= String.valueOf(A+B);
                            pila.meter(aux);
                            break;
                        case "-":
                            A=Integer.parseInt((String) pila.sacar());
                            B=Integer.parseInt((String) pila.sacar());
                            aux= String.valueOf(B-A);
                            pila.meter(aux);
                            break;
                        case "*":
                            A=Integer.parseInt((String) pila.sacar());
                            B=Integer.parseInt((String) pila.sacar());
                            aux= String.valueOf(A*B);
                            pila.meter(aux);
                            break;
                        case "/":
                            A=Integer.parseInt((String) pila.sacar());
                            B=Integer.parseInt((String) pila.sacar());
                            if(B!=0)
                                aux= String.valueOf(A/B);
                            pila.meter(aux);
                            break;
                    }
                }else{
                    pila.meter(partes[i]);
                }
            }
            System.out.println("El resultado es: " + pila.sacar());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
