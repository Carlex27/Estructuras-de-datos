/*
Nombre del programa: Validacion.java
Fecha de programacion:01 de Marzo de 2024
Autor: 22570074 Ocampo de la Torre Carlos Jadir
Objetivo:  

*/
public class Validacion {
	private ISCTAPU1PRAC006 Practica;
	public String VerificarFecha(int anio){
		String Respuesta = "";
		if(anio > 1949 && anio < 2007){
			Respuesta +="Año no valido";
		}
		return Respuesta;
	}
	
	public boolean ValidarLetras(String Texto){
		for(int Posicion = 0; Posicion < Texto.length(); Posicion++){
			char Caracter = Texto.charAt(Posicion);
			Caracter = Character.toUpperCase(Caracter);
			if(!(Caracter >= 'A' && Caracter <= 'Z') || (Caracter == ' ') )
				return true;
		}
		return false;
	}
	public String VerificarContenido(){
		String Respuesta="Error: contiene caracteres diferentes (espacio y alfanumericos)";
		String Texto = Practica.getTxtNombre();
		if(ValidarLetras(Texto)){
			Respuesta += "Nombre,";
		}
		Texto= Practica.getTxtPaterno();
		if(ValidarLetras(Texto)){
			Respuesta += "Apellido paterno,";
		}
		Texto= Practica.getTxtMaterno();
		if(ValidarLetras(Texto)){
			Respuesta += "Apellido materno,";
		}
		if(Respuesta.equals("Error: contiene caracteres diferentes (espacio y alfanumericos)")){
			Respuesta="";
		}
		return Respuesta;
	}
	
	//Validar que los campos no esten vacios
	public String VerificarCampos(){
		String Respuesta = "";
		if(Practica.getTxtNombre().equals("")){
			Respuesta += "Falta el Nombre,";
		}
		if(Practica.getTxtPaterno().equals("")){
			Respuesta += "Falta El apellido paterno,";
		}
		if(Practica.getTxtMaterno().equals("")){
			Respuesta += "Falta el apellido materno,";
		}
		if(Practica.getJFTFFecha().equals("")){
			Respuesta += "Falta la fecha,";
		}
		return Respuesta;
		
	}
	public Validacion(ISCTAPU1PRAC006 Practica){
		this.Practica = Practica;
	}
	public static void main(String[] args){
	
	}
}
