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
public final class Info {

        protected final String simbolo;
        protected final float cierre, maximo, minimo;
        protected final int volumen;

        public Info(String s, float c, int n) {
            this.simbolo = s;
            this.cierre = 0;
            this.maximo = c;
            this.minimo = c;
            this.volumen = n;
        }

        public Info(Accion a) {
            this.simbolo = a.getSimbolo();
            this.cierre = a.getCierre();
            this.maximo = a.getMaximo();
            this.minimo = a.getMinimo();
            this.volumen = a.getVolumen();
        }

        public String getSimbolo() {
            return simbolo;
        }

        public float getCierre() {
            return cierre;
        }

        public float getMaximo() {
            return maximo;
        }

        public float getMinimo() {
            return minimo;
        }

        public int getVolumen() {
            return volumen;
        }

    }
