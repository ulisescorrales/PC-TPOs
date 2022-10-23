/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Obligatorio.punto2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Corrales Ulises
 */
public class Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        int capacidad=5;
        int contO=1;
        int contH=1;
        Random al=new Random();
                        
        Recipiente r=new Recipiente(capacidad);
        //Generador de átomos
        while(true){
            switch(al.nextInt(2)){
                case 0:
                        Oxigeno ox=new Oxigeno("Oxigeno "+contO,r);
                        ox.start();
                        contO++;
                        break;
                case 1:
                        Hidrogeno h=new Hidrogeno("Hidrógeno "+contH,r);
                        h.start();
                        contH++;
            }
            try {
                Thread.sleep(al.nextInt(5000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }

}
