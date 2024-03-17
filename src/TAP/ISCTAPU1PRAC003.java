/*
Nombre del programa: ISCTAPU1PRAC003.java
Fecha de programacion:16 de Febrero de 2024
Autor: 22570074 Ocampo de la Torre Carlos Jadir
Objetivo:  1)En base al ejemplo ISCTAPU1EJEM003A
		   2)En el metodo principal de la clase principal nada mas hacer un llamada a un metodo llamado Interfaz
		   3)En el metodo llamado interfaz, debe contener el codigo completo para crear la interfaz grafica
		   4)Al codigo le debe agregar el objetivo de:
				a)Anterior
				b)Inicio
				c)Fin
		   5)Cada accion debe presentar un color de fondo diferente
		   6)Cada letreto de cada accion debe tener un color diferente
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class ISCTAPU1PRAC003{
	static Random Aleatorio = new Random();
	public static Color CrearNuevoColor(){
		return new Color(Aleatorio.nextInt(256),Aleatorio.nextInt(256),Aleatorio.nextInt(256));
	}
	public static void CambiarTextoColor(JPanel JPZonaCentroPanel){
		Component[] Componentes = JPZonaCentroPanel.getComponents();
		for(Component CComponente:Componentes){
			if(CComponente instanceof JLabel){
				if(CComponente.isVisible()){
					((JLabel)CComponente).setForeground(CrearNuevoColor());
				}
			}
		}
	}
	
	public static void Interfaz(){
		JFrame Ventana = new JFrame("ISCTAPU1EJEM003B -> Ejemplo BorderLayout con CardLayout");
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ventana.setSize(500,300);
		
		//Crear un panel principal con BorderLayout
		JPanel JPPanelPrincipal = new JPanel(new BorderLayout());
		
		//Crear un panel para el CardLayout en la region centro
		JPanel JPZonaCentroPanel = new JPanel(new CardLayout());
		JPZonaCentroPanel.setPreferredSize(new Dimension(400,200));
		
		JLabel JLEtiqueta_1 = new JLabel("Contenido de la tarjeta 1");
		JLEtiqueta_1.setFont(new Font("Arial", Font.BOLD, 16));
		JLEtiqueta_1.setForeground(Color.RED);
		JLEtiqueta_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Demas etiquetas
		JLabel JLEtiqueta_2 = new JLabel("Contenido de tarjeta 2");
		JLabel JLEtiqueta_3 = new JLabel("Contenido de tarjeta 3");
		
		//Añadir objetos en la zona centro del BorderLayout
		JPZonaCentroPanel.add(JLEtiqueta_1,"");
		JPZonaCentroPanel.add(JLEtiqueta_2,"");
		JPZonaCentroPanel.add(JLEtiqueta_3,"");
		
		//Crear botones para cambiar tarjetas en CardLayout
		JButton JBAnterior = new JButton("Anterior");
		JButton JBSiguiente = new JButton("Siguiente");
		
		JButton JBInicio = new JButton("Inicio");
		JButton JBFin = new JButton("Fin");
		
		//Crear los ActionListener para cada boton
		
		JBAnterior.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				CardLayout CLTarjetero = (CardLayout)JPZonaCentroPanel.getLayout();
				CLTarjetero.previous(JPZonaCentroPanel);
				JPZonaCentroPanel.setBackground(CrearNuevoColor());
				CambiarTextoColor(JPZonaCentroPanel);
			} 
		});
		JBFin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				CardLayout CLTarjetero = (CardLayout)JPZonaCentroPanel.getLayout();
				CLTarjetero.last(JPZonaCentroPanel);
				JPZonaCentroPanel.setBackground(CrearNuevoColor());
				CambiarTextoColor(JPZonaCentroPanel);
			} 
		});
		JBInicio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				CardLayout CLTarjetero = (CardLayout)JPZonaCentroPanel.getLayout();
				CLTarjetero.first(JPZonaCentroPanel);
				JPZonaCentroPanel.setBackground(CrearNuevoColor());
				CambiarTextoColor(JPZonaCentroPanel);
			} 
		});
		JBSiguiente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				CardLayout CLTarjetero = (CardLayout)JPZonaCentroPanel.getLayout();
				CLTarjetero.next(JPZonaCentroPanel);
				JPZonaCentroPanel.setBackground(CrearNuevoColor());
				CambiarTextoColor(JPZonaCentroPanel);
			} 
		});
		
		//Añadimos los botones a sus respectivas regiones
		
		JPanel JPNorte = new JPanel();
		JPNorte.add(JBAnterior);
		JPPanelPrincipal.add(JPNorte, BorderLayout.NORTH);
		
		JPanel JPSur = new JPanel();
		JPSur.add(JBSiguiente);
		JPPanelPrincipal.add(JPSur, BorderLayout.SOUTH);
		
		JPanel JPEste = new JPanel();
		JPEste.add(JBFin);
		JPPanelPrincipal.add(JPEste, BorderLayout.EAST);
		
		JPanel JPOeste = new JPanel();
		JPOeste.add(JBInicio);
		JPPanelPrincipal.add(JPOeste, BorderLayout.WEST);
		
		//Añadir el panel central al panel principal
		JPPanelPrincipal.add(JPZonaCentroPanel, BorderLayout.CENTER);
		
		Ventana.add(JPPanelPrincipal);
		Ventana.setLocationRelativeTo(null);
		Ventana.setVisible(true);
	}
	public static void main (String[] args){
		Interfaz();
	}
}
