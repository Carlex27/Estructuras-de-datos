/*
Nombre del programa: ISCTAPU1PRAC006.java
Fecha de programacion:01 de Marzo de 2024
Autor: 22570074 Ocampo de la Torre Carlos Jadir
Objetivo:  
*/
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JButton;
import java.util.Scanner;

public class ISCTAPU1PRAC006 extends JFrame implements ActionListener{
	private final JLabel JLFecha = new JLabel("Fecha de nacimiento");
	private final JLabel JLFecha1 = new JLabel("	Formato->");
	private final JLabel JLFecha2 = new JLabel("dd-mm-aaaa");
	
	//Etiquetas para el nombre
	private final JLabel Nombre = new JLabel("Nombre:");
	private final JLabel Paterno = new JLabel("Apellido paterno:");
	private final JLabel Materno = new JLabel("Apellido materno");
	
	//JTextFields para el nombre
	private final JTextField TxtNombre = new JTextField(20);
	private final JTextField TxtPaterno = new JTextField(20);
	private final JTextField TxtMaterno = new JTextField(20);
	
	//BOTON
	private final JButton BotonBorrar = new JButton("Borrar datos");
	{
		BotonBorrar.addActionListener(this);
	}
	
	
	//Crea un formateador de fechas que se va a manejar el formato: dia-mes(dos digitos)-anio(4 digitos)
	private final SimpleDateFormat SDFFecha = new SimpleDateFormat("dd-MM-yyyy");
	
	//Crea un cuadro de texto formateado que utiliza el formato anterior para manejar fechas
	private final JFormattedTextField JFTFFecha = new JFormattedTextField(SDFFecha);
	private final JLabel JLDia = new JLabel("Dia:");
	
	private final JTextField JTFDia = new JTextField(2);
	{
		JTFDia.setEditable(false);
		JTFDia.setHorizontalAlignment(JTextField.TRAILING);
	}
	
	private final JLabel JLMes = new JLabel("Mes:");
	private final JTextField JTFMes = new JTextField(10);
	{
		JTFMes.setEditable(false);
	}
	private final JLabel JLAnio = new JLabel("Año:");
	private final JTextField JTFAnio = new JTextField(4);
	{
		JTFAnio.setEditable(false);
		JTFAnio.setHorizontalAlignment(JTextField.TRAILING);
	}
	
	private final JMenuItem JMICalcular = new JMenuItem("Calcular RFC");
	{
		JMICalcular.addActionListener(this);
	}
	private final JMenuItem JMISalir = new JMenuItem("Salir");
	{
		JMISalir.addActionListener(this);
	}
	private final JMenu JMMenu = new JMenu("Archivo");
	{
		JMMenu.add(JMICalcular);
		JMMenu.add(JMISalir);
	}
	private final JMenuBar JMBMenu = new JMenuBar();
	{
		JMBMenu.add(JMMenu);
	}
	private final JPanel PanelNombre = new JPanel(new GridLayout(3,2,0,40));
	{
		PanelNombre.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
		PanelNombre.add(Nombre);
		PanelNombre.add(TxtNombre);
		PanelNombre.add(Paterno);
		PanelNombre.add(TxtPaterno);
		PanelNombre.add(Materno);
		PanelNombre.add(TxtMaterno);
	}
	private final JPanel PanelFecha = new JPanel(new GridLayout(6,2,12,12));
	{
		PanelFecha.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
		PanelFecha.add(JLFecha);
		PanelFecha.add(JFTFFecha);
		PanelFecha.add(JLFecha1);
		PanelFecha.add(JLFecha2);
		PanelFecha.add(JLDia);
		PanelFecha.add(JTFDia);
		PanelFecha.add(JLMes);
		PanelFecha.add(JTFMes);
		PanelFecha.add(JLAnio);
		PanelFecha.add(JTFAnio);
	}
	private final JPanel Panel = new JPanel(new BorderLayout());
	{
		Panel.add(PanelFecha, BorderLayout.EAST);
		Panel.add(PanelNombre, BorderLayout.WEST);
		Panel.add(BotonBorrar, BorderLayout.SOUTH);
	}
	//GETTERS
	
	public String getTxtNombre(){
		return TxtNombre.getText();
	}
	public String getTxtMaterno(){
		return TxtMaterno.getText();
	}
	public String getTxtPaterno(){
		return TxtPaterno.getText();
	}
	
	public String getJFTFFecha(){
		return JFTFFecha.getText();
	}
	public void Salir(){
		try{
			String Respuesta = JOptionPane.showInputDialog(this, "Estas seguro de finalizar S/N?", "Salir", JOptionPane.QUESTION_MESSAGE);
			if (Respuesta.toUpperCase().equals("S")){
				System.exit(0);
			}else{
				throw new Exception();
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "ERROR: Opcion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void BorrarTextos(){
		TxtNombre.setText("");
		TxtPaterno.setText("");
		TxtMaterno.setText("");
		
		JTFDia.setText("");
		JTFMes.setText("");
		JTFAnio.setText("");
		JFTFFecha.setText("");
	}
	public void BorrarDatos(){
		try{
			String Respuesta = JOptionPane.showInputDialog(this, "Realmente deseas borrar los datos S/N?", "Borrar datos" ,JOptionPane.QUESTION_MESSAGE);
			switch(Respuesta.toUpperCase()){
				case "S":	BorrarTextos();
					break;
				case "N":	return;
				default:
					throw new Exception();
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "ERROR: Opcion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void CalculaRFC(){
		try{
			//Validaciones
			Validacion Validar = new Validacion(this);
			String Respuesta = Validar.VerificarCampos();
			if(!Respuesta.isEmpty()){
				throw new Exception(Respuesta);
			}
			Respuesta = "";
			Respuesta = Validar.VerificarContenido();
			if(!Respuesta.isEmpty()){
				throw new Exception(Respuesta);
			}
			
			Date Fecha = SDFFecha.parse(JFTFFecha.getText());

			Calendar calendario = Calendar.getInstance();
			calendario.setTime(Fecha);
			
			Respuesta = Validar.VerificarFecha(calendario.get(Calendar.YEAR));
			if(!Respuesta.isEmpty()){
				throw new Exception(Respuesta);
			}

			JTFDia.setText(String.valueOf(calendario.get(Calendar.DAY_OF_MONTH)));
			JTFAnio.setText(String.valueOf(calendario.get(Calendar.YEAR)));
			
			int mes = calendario.get(Calendar.MONTH);
			
			
			DateFormatSymbols simbolos = DateFormatSymbols.getInstance();
			String[] meses = simbolos.getMonths();
			JTFMes.setText(meses[mes]);
			
			//EMPIEZA A CALCULAR EL RFC
			String Resultado = "";
		
			//ESTRUCTURA DEL RFC
			//PRIMERA LETRA Y VOCAL DEL APELLIDO PATERNO
			String TextoTemporal = TxtPaterno.getText();
			Resultado+=TextoTemporal.charAt(0);		//PRIMERA LETRA
			
			//CICLO QUE BUSCA LA PRIMERA VOCAL DEL APELLIDO PATERNO
			for(int Ciclo = 1; Ciclo < TextoTemporal.length() ; Ciclo++){
				char Caracter = TextoTemporal.charAt(Ciclo);
				Caracter = Character.toUpperCase(Caracter);
				if(Caracter == 'A' || Caracter == 'E' || Caracter == 'I' || Caracter == 'O' || Caracter == 'U' ){
					Resultado += Caracter;
					Ciclo = TextoTemporal.length();
				}
			}
			
			//PRIMERA LETRA DEL APELLIDO MATERNO
			TextoTemporal = TxtMaterno.getText();
			Resultado+= TextoTemporal.charAt(0);
			
			//PRIMERA LETRA DEL NOMBRE
			TextoTemporal = TxtNombre.getText();
			Resultado+=TextoTemporal.charAt(0);
			
			String Anio = String.valueOf(calendario.get(Calendar.YEAR));
			//Agregar los datos de la fecha de nacimiento
			Resultado+=Anio.substring(2,4);//AÑO
			Resultado+="0"+(calendario.get(Calendar.MONTH)+1);					//MES
			Resultado+=calendario.get(Calendar.DAY_OF_MONTH);				//DIA
			
			//HOMOCLAVE 33
			int Contador = 0;
			while(Contador<3){
				Random Aleatorio = new Random();
				int Valor = Aleatorio.nextInt(43)+48;
				if((Valor > 47 && Valor< 58) || (Valor >64 && Valor < 91)){
					Resultado+= (char)Valor;
					Contador++;
				}
			}
			
			Resultado = Resultado.toUpperCase();
			
			JOptionPane.showMessageDialog(this, "PROCESO CORRECTO Y TERMINADO, RFC:"+Resultado, "RFC", JOptionPane.INFORMATION_MESSAGE);
		}catch(ParseException e){
			JOptionPane.showMessageDialog(this, "Formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void actionPerformed(ActionEvent evt){
		Object origen = evt.getSource();
		if(origen == JMICalcular){
			CalculaRFC();
		}else if(origen == BotonBorrar){
			BorrarDatos();
		}else if(origen == JMISalir){
			Salir();
		}
	}
	
	
	public ISCTAPU1PRAC006(){
		setTitle("ISCTAPU1EJEM006C -> Ejemplo Fechas");
		setJMenuBar(JMBMenu);
		setContentPane(Panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ISCTAPU1PRAC006().setVisible(true);
			}
		});
	}
	
}
