package Hilos.Obligatorio2;

public class EjercicioHamster {

    public static void main(String[] args) {
        int cantHamster = 4;

        Hamaca hamaca = new Hamaca();
        Plato plato = new Plato();
        Rueda rueda = new Rueda();

        Hamster[] arreglo = new Hamster[cantHamster];
        llenarArreglo(arreglo, hamaca, plato, rueda);

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i].start();
        }

        for (int i = 0; i < arreglo.length; i++) {
            try {
                arreglo[i].join();
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }
        System.out.println("Programa terminado");
    }

    public static void llenarArreglo(Hamster[] arreglo, Hamaca hamaca, Plato plato, Rueda rueda) {
        for (int i = 0; i < arreglo.length; i++) {
            //nombre = "hamster" + i + 1;
            arreglo[i] = new Hamster( hamaca, plato, rueda);
        }
    }

}
