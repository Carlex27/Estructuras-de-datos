package RPG.Ventanas;

import java.awt.*;

import javax.swing.*;

import RPG.Entidades.Personaje;

public class Ventana_Final {
    private JTextArea texto;
    private JLabel imagen;
    private ImageIcon icono;
    private JDialog marco;
    private JPanel panelPrincipal;

    private JButton botSalir;
    private Personaje pj;
    private int condicion;
    public static final int VICTORIA = 0;
    public static final int DERROTA = 1;

    public Ventana_Final(int condicion, Personaje pj){
        this.pj = pj;

        marco = new JDialog();
        panelPrincipal = new JPanel(new BorderLayout());
        
        texto = new JTextArea();
        

        //CONDICION DE VICTORIA
        if(condicion == VICTORIA) icono = new ImageIcon("src/RPG/img/victoria.png");
        else icono = new ImageIcon("src/RPG/img/derrota.png");
        this.condicion = condicion;

        imagen = new JLabel(icono);
        botSalir = new JButton("Salir");
        botSalir.addActionListener(e->System.exit(0));
    }
    public void abrir(){
        prepararTexto();
        montarEscena();
        marco.setVisible(true);
    }
    private void montarEscena(){
        //AGREGAR LA IMAGEN EN LA PARTE NORTE
        panelPrincipal.add(imagen, BorderLayout.NORTH);
        //AGREGAR EL TEXTO EN LA PARTE CENTRAL
        panelPrincipal.add(texto, BorderLayout.CENTER);
        //AGREGAR EL BOTON EN LA PARTE SUR
        panelPrincipal.add(botSalir, BorderLayout.SOUTH);

        marco.add(panelPrincipal);
        marco.setSize(600, 400);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
    }
    private void prepararTexto(){
        texto.setFont(new Font("Roboto",Font.BOLD,12));
        texto.setEditable(false);
        if(condicion == VICTORIA){
            texto.setText("¡¡¡FELICIDADES!!!\n\n"
                        + "Has derrotado a todos los monstruos y has salvado el mundo.\n"
                        + "Gracias a ti, la paz ha vuelto a reinar en el reino de Kanaka.\n\n"
                        + "¡¡¡GRACIAS POR JUGAR!!!");
        }else{
            texto.setText("¡¡¡HAS MUERTO!!!\n\n"
                        + "Has sido derrotado por los monstruos y el mundo ha caido en la oscuridad.\n");
        }
    }
}
