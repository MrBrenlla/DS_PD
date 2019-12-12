/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

import java.util.HashSet;

/**
 *
 * @author lorudarkuh
 */
public class MercadoBursatil {
    
    protected HashSet<Accion> HashSetMercado;
    
    
    //Os clientes deben ser notificados cada vez que se
    //modifique algo no mercado (PATRON OBSERVADOR)
    
    //Constructor
    public MercadoBursatil(){
        this.HashSetMercado = new HashSet<>();
    }
    
    void cierreAccion(Accion a, float f) {
        a.cierre(f);
    }
    
    //Set
    void setValorAccion(Accion a, float v){
        a.setValor(v);
    }
    
    void setVolumenAccion(Accion a, int v){
        a.setVolumen(v);
    }
    
    boolean addAccion(Accion a){
        return HashSetMercado.add(a);  
    }
    
    boolean rmAccion(Accion a){
        return HashSetMercado.remove(a);
    }    
    
    
    
}
