/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Obligatorio.punto2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Corrales Ulises
 */
public class Hidrogeno extends Thread {

    Recipiente recipiente;

    public Hidrogeno(String nombre, Recipiente recipiente) {
        super(nombre);
        this.recipiente = recipiente;
    }

    public void run() {
        Random al = new Random();        
        System.out.println("\u001B[36m"+"Entra "+this.getName());
        try {
            sleep(al.nextInt(2000));//deambular
            recipiente.HListo();      
            System.out.println(Thread.currentThread().getName() + " terminó");       
        } catch (InterruptedException ex) {
            Logger.getLogger(Hidrogeno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
