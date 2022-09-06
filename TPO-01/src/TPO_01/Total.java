/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPO_01;


public class Total {
//Objeto compartido por los hilos sumadores
    private int accum;

    public Total() {
        this.accum = 0;
    }

    public synchronized void sumar(int numero) {
        accum = accum + numero;
    }

    public int getSuma() {
        return accum;
    }
}
