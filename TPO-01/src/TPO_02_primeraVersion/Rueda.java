package TPO_02_primeraVersion;

public class Rueda {
    
    public synchronized void jugarEnRueda(){
        System.out.println("El hamster "+ Thread.currentThread().getName()+" esta jugando en la rueda");
        try{
            Thread.sleep(2000);
            
        }catch(InterruptedException e){
            
        }
        System.out.println("El hamster "+ Thread.currentThread().getName()+" termino de usar la rueda");
    }
    

}
