package Lineales.Pila.Ejercicios;



public class UsoPila {
    public static void main(String[] args) {
        TipoPila Vector;
        int aux;
        try {
            Vector=new TipoPila();
            for (int i=0; i<10;i++){
                System.out.println("Se ha guardado en la pila: " + (i+1)*10);
                Vector.meter((i+1)*10);
            }
            System.out.println("Ultimo elemento: " + Vector.UltimoElem());
            while (!Vector.pilaVacia()){
                aux= (int) Vector.sacar();
                System.out.println("Se saco de la pila: " + aux);
            }
        }catch (Exception e){

        }
    }

}
