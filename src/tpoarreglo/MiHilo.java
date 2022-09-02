/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpoarreglo;

/**
 *
 * @author ulises.corrales
 */
class MiHilo extends Thread {

    int inicio;
    int fin;
    int[] arreglo;
    int suma = 0;

    //Construye un nuevo hilo.
    MiHilo(int inicio, int fin, int[] arreglo) {
        this.inicio = inicio;
        this.fin = fin;
        this.arreglo = arreglo;

    }

    //Punto de entrada de hilo.
    public void run() {
        System.out.println(this.getName() + " iniciando.");
        try {
            for (int i = inicio; i <= fin; i++) {
                Thread.sleep(0);
                suma = suma + arreglo[i];
            }
        } catch (InterruptedException exc) {
            System.out.println(this.getName() + " interrumpudo.");
        }
        System.out.println(this.getName() + " terminado.");
    }

    public int getSuma() {
        return suma;
    }
}
