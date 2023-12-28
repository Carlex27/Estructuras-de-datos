package RPG;


public class Main {
    public static void main(String[] args) {
        Personaje pj = new Personaje("Kanaka",10,5,100);
        Ventana_Principal ventana = new Ventana_Principal(pj);
        ventana.comenzarJuego();
    }
}
