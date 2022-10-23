/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO_01;

import java.util.Random;

public class TPOArreglo {
//Punto 6 del TP3

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cantHilo = 100; //Cantidad n de hilos
        Total total = new Total();//Objeto compartido

        //Arreglo de números aleatorios
        int[] arreglo = new int[50000];
        llenarArreglo(arreglo);

        //Crear arreglo de sumadores (hilos) e inicializarlos
        Sumador[] sumador = new Sumador[cantHilo];
        crearyComenzarSumadores(sumador, arreglo, total);

        //Mostrar suma secuencial . Al estar entre start() y join() de los hilos, no se pierde concurrencia
        System.out.println("Suma Secuencial:" + sumaSecuencial(arreglo));
        //Enviar join() a cada hilo para que no obtener la suma total sin que terminen de ejecutarse los hilos
        join(sumador);
        //Mostrar suma concurrente                
        System.out.println("Suma Concurrente: " + total.getSuma());
    }

    public static void crearyComenzarSumadores(Sumador[] sum, int[] arr, Total tot) {
        int i, longitud = sum.length - 1;//Itera hasta el anteúltimo
        int cociente = 50000 / sum.length;
        int resto = 50000 % sum.length;
        int inicio = 0;
        int fin;
        for (i = 0; i < longitud; i++) {
            fin = cociente * (i + 1);
            sum[i] = crearYComenzar(inicio, fin, arr, tot);
            inicio = fin + 1;
        }
        //Al último hilo se le da la responsabilidad  de sumar el resto     
        fin = cociente * (i + 1);
        fin = fin + resto - 1;
        sum[i] = crearYComenzar(inicio, fin, arr, tot);
    }

    public static int sumaSecuencial(int[] arr) {
        int longitud = arr.length;
        int suma = 0;
        int i;
        for (i = 0; i < longitud; i++) {
            suma = suma + arr[i];
        }
        return suma;
    }

    public static void llenarArreglo(int[] arr) {
        int longitud = arr.length;
        int i;

        for (i = 0; i < longitud; i++) {
            Random aleatorio = new Random();
            int x = aleatorio.nextInt(10);
            arr[i] = x;
        }
    }

    //Un método de fábrica que crea e inicia un hilo.
    public static Sumador crearYComenzar(int inicio, int fin, int[] arreglo, Total tot) {
        Sumador miHilo = new Sumador(inicio, fin, arreglo, tot);
        miHilo.start(); //Inicia el hilo        
        return miHilo;
    }

    public static void join(Sumador[] sum) {
        int i, longitud = sum.length;
        for (i = 0; i < longitud; i++) {
            try {
                sum[i].join();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
    }
}
