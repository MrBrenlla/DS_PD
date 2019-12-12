/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;


import java.util.Objects;
import java.util.Observable;


/**
 *
 * @author lorudarkuh
 */
public class Accion extends Observable{
    
    protected final String simbolo;
    protected float cierre, maximo, minimo;
    protected int volumen;
    
    //Constructor
    public Accion(String s, float c, int n) {
       this.simbolo = s;
       this.cierre = 0;
       this.maximo = c;
       this.minimo = c;
       this.volumen = n;
    }
    //Setters
    void setValor(float c){
        if (c > this.maximo) this.maximo = c;
        if (c < this.minimo) this.minimo = c;
        this.setChanged();
        this.notifyObservers();
    }
    
    void setVolumen(int v){
        this.volumen = v;
        this.setChanged();
        this.notifyObservers();
    }
    
    float cierre(float f){
        this.cierre = f;
        this.setChanged();
        this.notifyObservers();
        return this.cierre;
    }
    
    
    //Getters
    public String getSimbolo(){
        return this.simbolo;
    }    
    public float getCierre(){
        return this.cierre;
    }    
    public float getMaximo(){
        return this.maximo;
    }    
    public float getMinimo(){
        return this.minimo;
    }    
    public int getVolumen(){
        return this.volumen;
    }

       
}
