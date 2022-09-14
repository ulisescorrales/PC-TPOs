package TPO_02_primeraVersion;



public class Hamaca {
    
    public synchronized void Hamacarse(){
        System.out.println("El hamster "+ Thread.currentThread().getName()+" se esta hamacando");
        try{
            Thread.sleep(2000);
            
        }catch(InterruptedException e){
            
        }
        System.out.println("El hamster "+ Thread.currentThread().getName()+" termino de hamacarse");
        
    }
}
