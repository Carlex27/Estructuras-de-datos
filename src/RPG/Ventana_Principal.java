package RPG;

import java.awt.*;
import javax.swing.*;

public class Ventana_Principal {
  private JFrame ventana;
    private JPanel superior, inferior, principal;
    
    private JLabel etNombre, etNivel, etEXP, etOro, atributos;
    private JLabel etImage;
    private JButton botExplorar;

    private Personaje pj;
    public Ventana_Principal (Personaje pj){
        this.pj = pj;
        ventana = new JFrame("RPG");
        ventana.setSize(800, 600);

        principal = new JPanel(new BorderLayout());
        superior = new JPanel();
        inferior = new JPanel();

        etNombre = new JLabel("| "+pj.getNombre());
        etNivel = new JLabel(" | Nivel: " + pj.getNivel());
        etEXP = new JLabel(" | EXP: " + pj.getExp() + "/" + pj.getExp_Necesaria());
        etOro = new JLabel(" | Oro: " + pj.getOro());
        atributos = new JLabel(" | Atq: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + " | Vida: " + pj.getVidaActual() + "/" + pj.getVidaMaxima()+ " | ");
        etImage = new JLabel();

        botExplorar = new JButton("Explorar");
      }
      public void comenzarJuego(){
        montarEscena();
        ventana.setVisible(true);
      }
      public void montarEscena(){
        //PANEL SUPERIOR CON DATOS DEL PERSONAJE
        modificarFuentes();
        superior.add(etNombre);
        superior.add(etNivel);
        superior.add(etEXP);
        superior.add(etOro);
        superior.add(atributos);
        superior.add(pj.getBarraVida());
        
        //PANEL PRINCIPAL CON IMAGEN DEL PERSONAJE
        etImage.setIcon(new ImageIcon("src/RPG/img/kanaka.png"));
        principal.add(etImage, BorderLayout.CENTER);

        //PANEL INFERIOR CON BOTONES
        botExplorar.addActionListener(e->nuevaExploracion());
        inferior.add(botExplorar);

        //AÑADIMOS LOS PANELES A LA VENTANA
        principal.add(superior, BorderLayout.NORTH);
        principal.add(inferior, BorderLayout.SOUTH);
        ventana.add(principal);

      }
      private Object nuevaExploracion() {
        return null;
      }
      private void modificarFuentes(){
        Font fuente = new Font("Arial", Font.BOLD, 16);
        etNombre.setFont(fuente);
        etNivel.setFont(fuente);
        etEXP.setFont(fuente);
        etOro.setFont(fuente);
        atributos.setFont(fuente);
      }
      //GETTERS
      public Personaje getPj(){
        return pj;
      }
      //SETTERS
      public void setPj(Personaje pj){
        this.pj = pj;
      }
      
}
