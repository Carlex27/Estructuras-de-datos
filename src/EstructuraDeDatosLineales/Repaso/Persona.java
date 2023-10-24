package EstructuraDeDatosLineales.Repaso;

public class Persona {
    public String nombre;
    public int edad;
    public char genero;
    public Persona(){
        nombre="";
        edad=0;
        genero=' ';
    }
    public Persona(String nombre, int edad, char genero){
        this.nombre=nombre;
        this.edad=edad;
        this.genero=genero;
    }

}
