/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Obligatorio.punto2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Corrales Ulises
 */
public class Recipiente {

    int cantAgua = 0;
    int cantEnvase = 0;
    int capacidad;
    Object hidrogeno;
    Object oxigeno;
    Semaphore mutex = new Semaphore(1, true);
    Semaphore semHidrogeno = new Semaphore(0, true);
    Semaphore semListo = new Semaphore(0, true);

    public Recipiente(int capacidad) {
        this.capacidad = capacidad;
    }

    public void HListo() {
        try {            
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }                
        semHidrogeno.release();
        mutex.release();
        HTerminar();
    }
    public void HTerminar(){
        try {
            semListo.acquire();                   
        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public void OListo() {
        hacerAgua();
    }

    public void hacerAgua() {
        try {            
            semHidrogeno.acquire(2);
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        System.out.println("Se formó una molécula de agua con" + Thread.currentThread().getName());
        semListo.release(2);
        
        mutex.release();        
        envasar();
    }

    public void envasar() {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cantAgua == capacidad) {
            cantEnvase++;
            System.out.println("Se generó envase Nº " + cantEnvase);
            cantAgua = 0;
        }
        mutex.release();
    }
}
