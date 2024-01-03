package RPG.Entidades;

import javax.swing.JProgressBar;

import RPG.Interfaces.I_Atacable;
import RPG.Interfaces.I_Curable;

import java.awt.Color;
import java.awt.Dimension;

public class Entidad implements I_Atacable{
    private String nombre;
    private int vidaActual, ataque, defensa;
    private double vidaMaxima;
    private boolean aLive;
    private JProgressBar barraVida;

    public Entidad(String nombre, int ataque,int defensa, double vidaMaxima) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vidaMaxima = vidaMaxima;
        this.aLive = true;
        this.vidaActual = (int)vidaMaxima;
        this.barraVida = new JProgressBar(0, (int)vidaMaxima);
        barraVida.setPreferredSize(new Dimension(100, 20));

        establecerVida(vidaActual);
    }
    //METODOS
    public void establecerVida(int vida) {
        barraVida.setValue(vida);
        barraVida.setForeground(Color.RED);
        barraVida.setStringPainted(true);
        barraVida.setString(vidaActual + "/" + (int)vidaMaxima);
    }
    public void atacar(I_Atacable enemigo){
        enemigo.recibirAtaque(ataque);
    }
    public void recibirAtaque(int danio){
        if(aLive){
            int danioTotal = danio - defensa;
            if (danioTotal <= 0) danioTotal = 1;
            vidaActual -= danioTotal;
            if(vidaActual <= 0){
                vidaActual = 0;
                aLive = false;
            }
            establecerVida(vidaActual);
        }
        
    }
    

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getAtaque() {
        return ataque;
    }

    public double getVidaMaxima() {
        return vidaMaxima;
    }

    public boolean isAlive() {
        return aLive;
    }

    public JProgressBar getBarraVida() {
        return barraVida;
    }
    public int getDefensa() {
        return defensa;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
        establecerVida(vidaActual);
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setVidaMaxima(double vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
        barraVida.setMaximum((int)vidaMaxima);
        establecerVida(vidaActual);
    }

    public void setAlive(boolean aLive) {
        this.aLive = aLive;
    }

    public void setBarraVida(JProgressBar barraVida) {
        this.barraVida = barraVida;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
    

