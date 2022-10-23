package TPO_02;

import java.util.Random;

/*4) 

En una tienda de mascotas están teniendo problemas para tener a todos sus hámster felices.
Los hámster comparten una jaula en la que hay un plato con comida, una rueda para hacer
ejercicio, y una hamaca en la que pueden descansar. Todos los hamsters quieren comer del
plato, correr en la rueda y luego descansar en la hamaca. Pero se encuentran con el
inconveniente de que solo 1 de ellos puede comer del plato, solo uno puede correr en la
rueda y solo 1 puede descansar en la hamaca.
a) Implemente un programa para simular la situación planteada, en donde todos los
hámster puedan realizar todas las actividades.
b) Nota: considere que todas las actividades consumen cierto tiempo, por lo que para
la simulación se sugiere asignar ese tiempo con “sleep()". */

 /*Obs: Maximizar la concurrencia, no abusar de los syncronized.
 Mientras + fragmentado los metedos mejor .
 syns encapsula un lock del objeto que estamos trabajando
 Mejora posible: realizar un bloque sincronizado sobre 3 objetos diferentes//O crear una clase actividad e intanciarla 3 veces//o crear 3 clases como hicimos nosotros.
 
 
 
 --Correcion del print sleep print que hacemos en cada clase:Los deberia hacer cada hilo, no cada clase. hay que llevar los print/sleeps a los hilos.
Podriamos agregar un if en cada clase para que retorne true si esta en uso o false en caso contrario.Y otro metodo .dejarPlato donde seteariamos exitos=false
desps en el run,.usarPlato y dejar plato serian syncrinized, se deberia syn todos los modulos que realicen modificaciones en una variable.
 pondriamos un:
Hay que hacer un aleatorio para que elija la accion 
exito=.usarPlato()
if (exito) 
print 
sleep 
.dejarPlato()

Si lo dejamos de esta forma esto limitaria al objeto. ejemplo, si ubiera un metodo get en alguna clase no podriamos acceder por el syn y el sleep.
Si estamos haciendo un sleep en un metodo syncronized estaria mal.
 */
public class Hamster extends Thread {

    private final Hamaca hamaca;
    private final Plato plato;
    private final Rueda rueda;

    public Hamster(String nombre, Hamaca hamaca, Plato plato, Rueda rueda) {
        super(nombre);
        this.hamaca = hamaca;
        this.plato = plato;
        this.rueda = rueda;
    }

    @Override
    public void run() {
        int i = 0;
        boolean durmio = false, comio = false, jugo = false;
        Random al=new Random();
        int aleatorio;
        while (i < 3) {
            //Para hacer debugging es conveniente usar los println en el método syncronized
            aleatorio=al.nextInt();
            if (!durmio && hamaca.usar()) {
                usarHamaca();
                durmio = true;
                i++;
            } else if (!comio && plato.usar()) {
                usarPlato();
                comio = true;
                i++;
            } else if (!jugo && rueda.usar()) {
                usarRueda();
                jugo = true;
                i++;
            }
        }
        System.out.println("-----" + this.getName() + " terminó su ejecución" + " -------");
    }

    public void usarHamaca() {        
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        hamaca.terminarHamarcarse();
        
        
    }

    public void usarRueda() {        
        
        try {
            Thread.sleep(500);

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        rueda.terminarJugar();
        
    }

    public void usarPlato() {        
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        plato.terminarComer();
        
    }

}
