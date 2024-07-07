package Lineales.Repaso;

public class Persona {
    public String nombre;
    public int edad;
    public char genero;
    public Persona sig;
    public Persona(){
        nombre="";
        edad=0;
        genero=' ';
        sig=null;
    }
    public Persona(String nombre, int edad, char genero){
        this.nombre=nombre;
        this.edad=edad;
        this.genero=genero;
        this.sig=null;
    }

}
