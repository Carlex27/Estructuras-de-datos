package RPG.Ventanas;

import java.awt.*;
import javax.swing.*;

import RPG.Entidades.Personaje;

public class Ventana_Principal {
    private JFrame ventana;
    private JPanel superior, inferior, principal;
    
    private JLabel etNombre, etNivel, etEXP, etOro, atributos;
    private JLabel etImage;
    private JButton botExplorar, botTienda;

    private Personaje pj;
    //Metodo constructor de la ventana principal
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
        atributos = new JLabel(" | Atq: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + " | Vida: ");
        etImage = new JLabel();

        botExplorar = new JButton("Explorar");
        botTienda = new JButton("Tienda");
      }
      //Monta la escena 
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
        botTienda.addActionListener(e->tienda());
        inferior.add(botExplorar);
        inferior.add(botTienda);

        //AÑADIMOS LOS PANELES A LA VENTANA
        principal.add(superior, BorderLayout.NORTH);
        principal.add(inferior, BorderLayout.SOUTH);
        ventana.add(principal);
        ventana.setLocationRelativeTo(null);

      }
      private void nuevaExploracion() {
        Exploracion exploracion = new Exploracion(this);
        exploracion.comenzarExploracion();
        principal.add(superior, BorderLayout.NORTH);
        ventana.repaint();
      }
      private void tienda(){
        Tienda tienda = new Tienda(this);
        tienda.comenzarTienda();
        principal.add(superior, BorderLayout.NORTH);
        ventana.repaint();
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
      public JPanel getPrincipal(){
        return principal;
      }
      public JPanel getSuperior(){
        return superior;
      }
      public JPanel getInferior(){
        return inferior;
      }
      public JLabel getEtOro(){
        return etOro;
      }
      public JLabel getEtEXP(){
        return etEXP;
      }
      public JLabel getEtNivel(){
        return etNivel;
      }
      public JLabel getAtributos(){
        return atributos;
      }
      //SETTERS
      public void setPj(Personaje pj){
        this.pj = pj;
      }
      public void setPrincipal(JPanel principal){
        this.principal = principal;
      }
      public void setSuperior(JPanel superior){
        this.superior = superior;
      }
      public void setInferior(JPanel inferior){
        this.inferior = inferior;
      }

}
