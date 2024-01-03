package RPG.Entidades;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import RPG.Interfaces.I_Atacable;


public class Monstruo extends Entidad implements I_Atacable{
    private int dropOro, dropExp;
    private JLabel etNombre, etImagen;

    private static String[] nombresFacil = {"Slime","Goblin"};
    private static String[] nombresMedio = {"Ogro","Golem"};
    private static String[] nombresDificil = {"Dragon","Demonio"};
    
    public Monstruo(String nombre, int ataque, int defensa, double vidaMaxima, String dificultad) {
        super(nombre, ataque, defensa, vidaMaxima);

        etNombre = new JLabel(nombre);
        etNombre.setFont(new Font("Roboto",Font.BOLD,20));
        String rutaImagen = "src/RPG/img/"+nombre+".png";
        etImagen = new JLabel(new ImageIcon(rutaImagen));
        switch (dificultad) {
            case "facil":
                    dropExp = (int)(Math.random()*10)+1;
                    dropOro = (int)(Math.random()*8)+1;
                    etNombre.setForeground(Color.RED);
                break;
            case "medio":
                    dropExp = (int)(Math.random()*25)+2;
                    dropOro = (int)(Math.random()*19)+3;
                break;
            case "dificil":
                    dropExp = (int)(Math.random()*40)+5;
                    dropOro = (int)(Math.random()*30)+5;
                break;
            default:
                    dropExp = (int)(Math.random()*500)+499;
                    dropOro = (int)(Math.random()*1000)+999;
                break;
        }
    }
    //
    public static Monstruo generarMonstruo(int i){
        Monstruo m;

        int nMonstruo= (int)(Math.random()*2);
        int ataque = (int)(Math.random()*10)+1;
        int defensa = (int)(Math.random()*8)+1;
        double vidaMaxima = (int)(Math.random()*100)+1;
        if(i<80){ 
            //VALORES BASE DE LOS MOSNTRUOS 10, 5, 15
            m = new Monstruo(nombresFacil[nMonstruo],ataque+10,defensa+5,vidaMaxima+15,"facil");
        }else if(i<130){
            //VALORES BASE DE LOS MOSNTRUOS 20, 10, 30
            m = new Monstruo(nombresMedio[nMonstruo],ataque+20,defensa+10,vidaMaxima+30,"medio");
        }else if(i<200){
            //VALORES BASE DE LOS MOSNTRUOS 40, 20, 50
            m = new Monstruo(nombresDificil[nMonstruo],ataque+40,defensa+20,vidaMaxima+50,"dificil");
        }else{
            //VALORES BASE DEL JEFE 100, 50, 100
            m = new Monstruo("Jefe",ataque+100,defensa+50,vidaMaxima+100,"jefe");
        }
        return m;
    }
    //GETTERS
    public int getDropOro() {
        return dropOro;
    }
    public int getDropExp() {
        return dropExp;
    }
    public JLabel getEtNombre() {
        return etNombre;
    }
    public JLabel getEtImagen() {
        return etImagen;
    }

}
