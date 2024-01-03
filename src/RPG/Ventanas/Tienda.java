package RPG.Ventanas;

import javax.swing.*;

import RPG.Entidades.Personaje;

import java.awt.*;
public class Tienda {
    private JDialog marco;
    
    private JPanel panelPrincipal, panelSuperior, panelInferior, panelVendedor;
    private JButton botCurar, botComprar, botSalir;
    private JTextArea infoTienda;
    private JScrollPane scroll;
    private JLabel etImagen;

    private Personaje pj;
    private Ventana_Principal vp;
    
    public Tienda(Ventana_Principal vp){
        this.vp = vp;
        pj = vp.getPj();

        marco = new JDialog();
        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = vp.getSuperior();
        panelInferior = new JPanel();
        panelVendedor = new JPanel();
        etImagen = new JLabel(new ImageIcon("src/RPG/img/Vendedor.png"));

        infoTienda = new JTextArea();
        infoTienda.setFont(new Font("Roboto",Font.BOLD,14));
        infoTienda.setEditable(false);
        scroll = new JScrollPane(infoTienda);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        botCurar = new JButton("Curar");
        botComprar = new JButton("Comprar Armas");
        botSalir = new JButton("Salir");
        botCurar.addActionListener(e->curar());
        botComprar.addActionListener(e->comprarArmas());
        botSalir.addActionListener(e->marco.dispose());
    }
    public void comenzarTienda(){
        prepararTexto();
        montarInterfaz();
    }
    private void montarInterfaz(){
        //PANEL SUPERIOR LISTO

        //MONTANDO PANEL PRINCIPAL
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        //MONTANDO PANEL VENDEDOR
        panelVendedor.setLayout(new BoxLayout(panelVendedor, BoxLayout.Y_AXIS));
        panelVendedor.add(new JLabel("Vendedor"));
        panelVendedor.add(etImagen);
       

        //MONTANDO PANEL INFERIOR
        panelInferior.add(botCurar);
        panelInferior.add(new JLabel("       "));
        panelInferior.add(botComprar);
        panelInferior.add(new JLabel("       "));
        panelInferior.add(botSalir);

        //MONTANDO PANEL PRINCIPAL
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        panelPrincipal.add(panelVendedor, BorderLayout.EAST);

        //Agregando al marco
        marco.add(panelPrincipal);
        marco.setSize(800,600);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
        marco.setVisible(true);
    }
    private void prepararTexto(){
        infoTienda.setText(infoTienda.getText() + "Bienvenido a la tienda, ¿en qué puedo ayudarte?\n"
                                                +"Curar: 10 monedas de oro (+20 ps)\n"
                                                + "Comprar Armas: 20 monedas de oro (+5 atq)\n");
    }
    private void curar(){
        if(pj.getOro()>=10){
            pj.setOro(pj.getOro()-10);
            if(pj.getVidaActual()+20 > pj.getVidaMaxima()) pj.setVidaActual((int)pj.getVidaMaxima());
            else pj.setVidaActual(pj.getVidaActual()+20);
            infoTienda.setText(infoTienda.getText() + "Has sido curado, tu vida actual es: " + pj.getVidaActual() + "\n");
            actualizarDatos();
        }else{
            infoTienda.setText(infoTienda.getText() + "No tienes suficiente oro para curarte\n");
        }
        
    }
    private void comprarArmas(){
        if(pj.getOro()>=20){
            pj.setOro(pj.getOro()-20);
            pj.setAtaque(pj.getAtaque()+5);
            infoTienda.setText(infoTienda.getText() + "Has comprado un arma, tu ataque actual es: " + pj.getAtaque() + "\n");
            actualizarDatos();
        }else{
            infoTienda.setText(infoTienda.getText() + "No tienes suficiente oro para comprar un arma\n");
        }
        
    }

    private void actualizarDatos(){
        vp.getEtOro().setText(" | Oro: " + pj.getOro());
        vp.getEtNivel().setText(" | Nivel: " + pj.getNivel());
        vp.getEtEXP().setText(" | EXP: " + pj.getExp() + "/" + pj.getExp_Necesaria());
        vp.getAtributos().setText(" | Atq: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + " | Vida: ");
    }
}
