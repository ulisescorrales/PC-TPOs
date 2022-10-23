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
public class Oxigeno extends Thread {

    Recipiente recipiente;

    public Oxigeno(String nombre, Recipiente recipiente) {
        super(nombre);
        this.recipiente = recipiente;
    }

    public void run() {
        try {
            Random al = new Random();
            System.out.println("\u001B[31m"+"Entra "+this.getName());
            sleep(al.nextInt(2000));//Deambular
            recipiente.OListo();//Finaliza con la ejecución de hacerAgua en recipiente    
        } catch (InterruptedException ex) {
            Logger.getLogger(Oxigeno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
