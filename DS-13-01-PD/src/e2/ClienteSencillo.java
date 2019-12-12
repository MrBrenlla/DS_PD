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
public class ClienteSencillo extends Cliente{
    
        @Override
        public String toString(){
            
            String s = "";
            for(Info i: AccionList){
                s= s.concat(i.getSimbolo()+": "+i.getCierre()+", ");
            }
            return s;
        }
    
       public float getInfo(String s){
           int i = 0;
           while (i<AccionList.size()) {
               if(s.equals(AccionList.get(i).getSimbolo())) return AccionList.get(i).getCierre();
               i++;
           }
           throw new IllegalArgumentException("Accion non encontrada");
       }
       
    
    
}
