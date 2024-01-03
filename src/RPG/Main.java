package RPG;

import RPG.Entidades.Personaje;
import RPG.Ventanas.Ventana_Principal;

public class Main {
    public static void main(String[] args) {
        Personaje pj = new Personaje("Kanaka",20,15,100);
        Ventana_Principal ventana = new Ventana_Principal(pj);
        ventana.comenzarJuego();
    }
}
