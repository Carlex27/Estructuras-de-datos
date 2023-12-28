package RPG;

public class Personaje extends Entidad{
    private int nivel,oro, exp, exp_Necesaria ;

    public Personaje(String nombre, int ataque, int defensa, double vidaMaxima) {
        super(nombre, ataque, defensa, vidaMaxima);
        nivel = 1;
        oro = 0;
        exp = 0;
        exp_Necesaria = 10;
    }
    //METODOS
    public void subirExp(int exp){
        this.exp += exp;
        if(this.exp >= exp_Necesaria) subirNivel();
    }
    public void subirNivel(){
        nivel++;
        exp = 0;
        exp_Necesaria += 10;
        setAtaque(getAtaque()+2);
        setDefensa(getDefensa()+1);
        setVidaMaxima(getVidaMaxima()*1.1);
        setVidaActual((int)getVidaMaxima());
        getBarraVida().setMaximum((int)getVidaMaxima());
        establecerVida((int)getVidaMaxima());
    }
    //SETTER Y GETTER
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public void setOro(int oro){
        this.oro = oro;
    }
    public void setExp(int exp){
        this.exp = exp;
    }
    public void setExp_Necesaria(int exp_Necesaria){
        this.exp_Necesaria = exp_Necesaria;
    }
    public int getNivel(){
        return nivel;
    }
    public int getOro(){
        return oro;
    }
    public double getExp(){
        return exp;
    }
    public int getExp_Necesaria(){
        return exp_Necesaria;
    }
}
