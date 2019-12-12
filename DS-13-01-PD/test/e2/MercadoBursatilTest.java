/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lorudarkuh
 */
public class MercadoBursatilTest {
    Accion apple, microsoft, inditex, msi;
    MercadoBursatil mercado;
    ClienteSencillo sencillo;
    ClienteDetallado detallado;
    Info i;
    
    @Before
    public void ini(){
        apple = new Accion("APL",5,10);
        microsoft = new Accion("MSF",6,12);
        inditex = new Accion("IND",8,20);
        msi = new Accion("MSI",6,13);
        
        i = new Info("MSI",6,13);
        
        sencillo = new ClienteSencillo();
        detallado = new ClienteDetallado();
        mercado = new MercadoBursatil();
        
        assertEquals("MSI",msi.getSimbolo());
    }
    
    @Test
    public void testAddAccion(){
        assertTrue(mercado.addAccion(apple));
        assertFalse(mercado.addAccion(apple));
        assertTrue(mercado.addAccion(microsoft));        
    }
    
    @Test
    public void testRmAccion(){
        mercado.addAccion(apple);
        assertTrue(mercado.rmAccion(apple));
        assertFalse(mercado.rmAccion(apple));
        assertFalse(mercado.rmAccion(inditex)); 
    }
    
    @Test
    public void testCierreAccion(){
        mercado.cierreAccion(msi, 8);
        assertEquals(8, msi.getCierre(), 0);
    }
    
    @Test
    public void testSetValorAccion(){
        mercado.setValorAccion(inditex, 10);
        assertEquals(10, inditex.getMaximo(), 0);
        
        
        mercado.setValorAccion(inditex, 5);
        assertEquals(5, inditex.getMinimo(), 0);
        
    } 
    
    @Test
    public void testSetVolumenAccion(){
        mercado.setVolumenAccion(inditex, 10);
        assertEquals(10, inditex.getVolumen(), 0);        
    } 

    @Test (expected = IllegalArgumentException.class)
    public void testMeterAccion(){
        sencillo.meterAccion(msi);
        sencillo.meterAccion(msi);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testQuitarAccion(){
        sencillo.quitarAccion(msi);
        
    }
    
    
    
    @Test
    public void testClienteInteresado(){
        sencillo.clienteInteresado(msi);
        assertEquals(msi.getCierre(),sencillo.getInfo("MSI"),0);
    } 
    
    @Test 
    public void testUpdateSencillo(){
        sencillo.clienteInteresado(apple);
        sencillo.clienteInteresado(microsoft);
        mercado.addAccion(apple);
        mercado.cierreAccion(apple,10);
        
        assertEquals(apple.getCierre(), sencillo.getInfo("APL"),0);
        
        assertEquals("APL: 10.0, ",sencillo.toString());
    }
    
    @Test
    public void testUpdateDetallado(){
        detallado.clienteInteresado(apple);
        detallado.clienteInteresado(microsoft);
        mercado.setVolumenAccion(apple,10);
            assertEquals(apple.getVolumen(), detallado.getInfo("APL").getVolumen());
        mercado.setValorAccion(apple, 1);
            assertEquals(apple.getMinimo(),detallado.getInfo("APL").getMinimo(),0);
        mercado.setValorAccion(apple, 20);
            assertEquals(apple.getMaximo(),detallado.getInfo("APL").getMaximo(),0);
        mercado.cierreAccion(apple,12);
            assertEquals(apple.getCierre(),detallado.getInfo("APL").getCierre(),0);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testClienteNonInteresado(){
        sencillo.clienteInteresado(inditex);
        sencillo.clienteInteresado(msi);
        sencillo.clienteNonInteresado(msi);
        sencillo.clienteNonInteresado(inditex);
        sencillo.getInfo("MSI");
    } 
    
    @Test (expected = IllegalArgumentException.class)
    public void testGetInfoDetallado(){
        detallado.clienteInteresado(msi);
        detallado.clienteNonInteresado(msi);
        detallado.getInfo("MSI");
    } 
    
    
}
