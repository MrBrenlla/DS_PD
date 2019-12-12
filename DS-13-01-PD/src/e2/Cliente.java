/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author lorudarkuh
 */
public abstract class Cliente implements Observer {

    protected ArrayList<Info> AccionList;

    //Constructor 
    public Cliente() {
        this.AccionList = new ArrayList<>();
    }

    //Set
    boolean meterAccion(Accion a) {
        for (Info i : AccionList) {
            if (i.getSimbolo().equals(a.getSimbolo())) {
                throw new IllegalArgumentException("A accion xa esta na lista");
            }
        }
        return AccionList.add(new Info(a));
    }

    boolean quitarAccion(Accion a) {
        for (Info i : AccionList) 
            if (i.getSimbolo().equals(a.getSimbolo()))
                return AccionList.remove(i);
        
        throw new IllegalArgumentException("A Accion non esta na lista");
    }

    void clienteInteresado(Accion a) {
        a.addObserver(this);
        this.meterAccion(a);
        a.notifyObservers();
    }

    void clienteNonInteresado(Accion a) {
        a.deleteObserver(this);
        this.quitarAccion(a);
    }

    //Interfaz
    @Override
    public void update(Observable accion, Object a) {
        Accion aux2 = (Accion) accion;
        Info aux1;
        int i = 0, comp = 0;

        while ((i < AccionList.size()) && (comp == 0)) {
            aux1 = AccionList.get(i);
            if (aux1.getSimbolo().equals(aux2.getSimbolo())) {
                AccionList.remove(aux1);
                AccionList.add(new Info(aux2));
                comp = 1;
            }
            i++;
        }
    }
}
