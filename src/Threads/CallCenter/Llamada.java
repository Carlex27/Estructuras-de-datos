package Threads.CallCenter;

public class Llamada {
    private int numero;
        private int duracion;
        public Llamada(int numero, int  duracion){
            this.numero=numero;
            this.duracion=duracion;
        }
        public void setNumero(int numero){
            this.numero=numero;
        }
        public void setDuracion(int duracion){
            this.duracion=duracion;
        }
        public int getNumero(){
            return this.numero;
        }
        public int getDuracion(){
            return this.duracion;
        }
}
