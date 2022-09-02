/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO_01;

import java.util.Random;

/**
 *
 * @author ulises.corrales
 */
public class TPOArreglo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cantHilo=5; //Cantidad n de hilos
        
        //Arreglo de números aleatorios
        int[] arreglo = new int[50000];
        llenarArreglo(arreglo);        
        
        //Crear arreglo de sumadores(hilos) e inicializarlos
        Sumador[] sumador=new Sumador[cantHilo];
        crearyComenzarSumadores(sumador,arreglo);                        
        
        //Enviar join() a cada hilo para que no se ejecute  el método sumaConcurrente() sin que terminen de ejecutarse los hilos
        join(sumador);

        //Suma secuencial
        int suma = sumaSecuencial(arreglo);
        System.out.println("Suma Secuencial:" + suma);
        //SumaConcurrente

        System.out.println("Suma Concurrente: " + sumaConcurrente(sumador));
    }
    public static void crearyComenzarSumadores(Sumador[] sum,int[] arr){
        int i, longitud=sum.length;
        for(i=0;i<longitud;i++){
            sum[i]=crearYComenzar(0,1000,arr);
        }
    }

    public static int sumaConcurrente(Sumador[] sum) {
        int i,longitud=sum.length,suma=0;
        for(i=0;i<longitud;i++){
            suma=suma+sum[i].getSuma();
        }
        return suma;
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
    public static Sumador crearYComenzar(int inicio, int fin, int[] arreglo) {
        Sumador miHilo = new Sumador(inicio, fin, arreglo);
        miHilo.start(); //Inicia el hilo        
        return miHilo;
    }
    
    public static void join(Sumador[] sum){
        int i, longitud=sum.length;
        for(i=0;i<longitud;i++){
            try{
                sum[i].join();
            }catch(InterruptedException e){
                System.out.println("Error");
            }
        }
    }
}
