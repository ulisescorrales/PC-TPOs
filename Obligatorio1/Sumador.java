/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO_01;

/**
 *
 * @author ulises.corrales
 */
class Sumador extends Thread {
//Clase que extiende Thread
    private final int inicio;
    private final int fin;
    private final int[] arreglo;    
    private  Total total;

    //Construye un nuevo hilo.
    public Sumador(int inicio, int fin, int[] arreglo,Total total) {
        this.inicio = inicio;
        this.fin = fin;
        this.arreglo = arreglo;
        this.total=total;
    }

    //Punto de entrada de hilo.
    public void run() {        
        int suma=0;
        System.out.println(this.getName() + " iniciando.");
        try {
            for (int i = inicio; i <= fin; i++) {
                Thread.sleep(0);
                suma = suma + arreglo[i];
            }
        } catch (InterruptedException exc) {
            System.out.println(this.getName() + " interrumpudo.");
        }
        total.sumar(suma);
        System.out.println(this.getName() + " terminado.");
    }
   
}
