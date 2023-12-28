package Threads.CallCenter;

public class Main {
    public static void main(String[] args) {
        Operador op1 = new Operador("Carlos");
        Operador op2 = new Operador("Luis");
        Operador op3 = new Operador("Daniela");
        op1.start();
        op2.start();
        op3.start();
    }
}
