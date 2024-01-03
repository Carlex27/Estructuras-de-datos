package RPG.Items;

public class Item {
    private String nombre;
    private int cantidad;
    public Item(String nombre, int cantidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
    }

    //SETTERS
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    //GETTERS
    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }

}
