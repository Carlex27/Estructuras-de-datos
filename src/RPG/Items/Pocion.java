package RPG.Items;

public class Pocion extends Item {
    private int curacion;
    public Pocion(String nombre, int cantidad, int curacion){
        super(nombre, cantidad);
        this.curacion=curacion;
    }
    
}
