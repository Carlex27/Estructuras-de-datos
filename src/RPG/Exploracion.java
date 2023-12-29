package RPG;

import javax.swing.*;
import java.awt.*;

public class Exploracion {
    private JDialog marco;
    private JPanel panelPrincipal,panelSuperior,panelInferior,panelMounstruo,panelMonstruoSec;
    private JButton botAtacar,botHuir;
    private JTextArea infoExploracion;
    private JScrollPane scroll;
    private Personaje pj;
    private Monstruo enemigo;
    private static int numExploraciones = 0;
    private Ventana_Principal vp;
    public Exploracion (Ventana_Principal vp){
        this.vp = vp;
        pj=vp.getPj();
        marco = new JDialog();
        
        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = vp.getSuperior();
        panelInferior = new JPanel();
        panelMounstruo = new JPanel();
        panelMonstruoSec = new JPanel();

        infoExploracion = new JTextArea();
        infoExploracion.setFont(new Font("Roboto",Font.BOLD,14));
        infoExploracion.setEditable(false);
        scroll = new JScrollPane(infoExploracion);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        botAtacar = new JButton("Atacar");
        botHuir = new JButton("Huir");

    }
    public void comenzarExploracion(){
        decidirDificultad();
        montarInterfaz();
    }
    private void montarInterfaz(){
        //PANEL SUPERIOR LISTO
        
        //PANEL PRINCIPAL
        panelPrincipal.add(scroll, BorderLayout.CENTER);
        //Agregar datos del mounstruo
        panelMonstruoSec.add(enemigo.getEtNombre());
        panelMonstruoSec.add(enemigo.getBarraVida());
        
        panelMounstruo.setLayout(new BoxLayout(panelMounstruo, BoxLayout.Y_AXIS));
        panelMounstruo.add(enemigo.getEtImagen());
        panelMounstruo.add(panelMonstruoSec);

        //PANEL INFERIOR
        botAtacar.addActionListener(e->atacar());
        botHuir.addActionListener(e->marco.dispose());
        panelInferior.add(botAtacar);
        panelInferior.add(new JLabel("       "));
        panelInferior.add(botHuir);

        //Paneles secundarios al principal
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);  
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        panelPrincipal.add(panelMounstruo, BorderLayout.EAST);
        

        marco.add(panelPrincipal);
        marco.setSize(800,600);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
        marco.setVisible(true);
    }
    private void decidirDificultad(){
        int numAleatorio = (int)(Math.random()*100)+ numExploraciones;
        numExploraciones++;
        //Instanciariamos un objeto de la clase mounstruo
        enemigo = Monstruo.generarMonstruo(numAleatorio);
        if (enemigo.getNombre().equals("Jefe")) bossBattle();
    }
    private void atacar(){
        //Atacar al mounstruo
        int damage;
        pj.atacar(enemigo);

        infoExploracion.setText(infoExploracion.getText() + pj.getNombre()
                                + " Ataca con una fuerza de " + pj.getAtaque() + ".\n");
        damage = pj.getAtaque() - enemigo.getDefensa();
        if (damage < 0) damage = 1;

        infoExploracion.setText(infoExploracion.getText() + enemigo.getNombre()
                                + " recibe " + damage + " puntos de daño.\n\n");
        if(!enemigo.isAlive()){
            enemigoDerrotado();
        }else{
            enemigo.atacar(pj);
            infoExploracion.setText(infoExploracion.getText() + enemigo.getNombre()
                                + " Ataca con una fuerza de " + enemigo.getAtaque() + ".\n");
            damage = enemigo.getAtaque() - pj.getDefensa();
            if (damage < 0) damage = 1;
            infoExploracion.setText(infoExploracion.getText() + pj.getNombre()
                                + " recibe " + damage + " puntos de daño.\n");
            if(!pj.isAlive()) pjDerrotado();
        }
    }
    private void enemigoDerrotado(){
        botAtacar.setEnabled(false);
        botHuir.setText("Salir");
        
        infoExploracion.setText(infoExploracion.getText() + "Haz vencido al " + enemigo.getNombre() + ".\n");
        infoExploracion.setText(infoExploracion.getText() + "Has ganado " + enemigo.getDropOro() + " de oro.\n");
        infoExploracion.setText(infoExploracion.getText() + "Has ganado " + enemigo.getDropExp() + " de experiencia.\n");
        
        pj.subirExp(enemigo.getDropExp());
        pj.setOro(pj.getOro() + enemigo.getDropOro());
        //ACTUALIZAR LAS ETIQUETAS EN LA PANTALLA   
        vp.getEtEXP().setText(" | EXP: " + pj.getExp() + "/" + pj.getExp_Necesaria());
        vp.getEtOro().setText(" | Oro: " + pj.getOro());
        vp.getEtNivel().setText(" | Nivel: " + pj.getNivel());
        vp.getAtributos().setText(" | Atq: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + " | Vida: ");
        if(enemigo.getNombre().equals("Jefe")) bossDerrotado();
            
    }
    private void bossBattle(){
        botHuir.setEnabled(false);
        infoExploracion.setText(infoExploracion.getText() + "¡¡¡HAZ ENCONTRADO AL JEFE FINAL!!!\n");
    }
    private void bossDerrotado(){
        Ventana_Final ventana = new Ventana_Final(Ventana_Final.VICTORIA,pj);
        ventana.abrir();
    }
    private void pjDerrotado(){
        Ventana_Final ventana = new Ventana_Final(Ventana_Final.DERROTA,pj);
        ventana.abrir();
    }
}
