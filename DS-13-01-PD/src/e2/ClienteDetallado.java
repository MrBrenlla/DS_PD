/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

/**
 *
 * @author lorudarkuh
 */
public class ClienteDetallado extends Cliente{

    public Info getInfo(String s){
           int i = 0;
           while (i<AccionList.size()) {
               if(s.equals(AccionList.get(i).getSimbolo())) return AccionList.get(i);
               i++;
           }
           throw new IllegalArgumentException("Accion non encontrada");
       }
    
}
