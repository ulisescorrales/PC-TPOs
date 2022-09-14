package TPO_02_primeraVersion;

public class Plato {

    public synchronized void Comer(){
        System.out.println("El hamster "+ Thread.currentThread().getName()+" esta comiendo");
        try{
            Thread.sleep(2000);
            
        }catch(InterruptedException e){
            
        }
        System.out.println("El hamster "+ Thread.currentThread().getName()+" termino de comer");
    }
    
}
