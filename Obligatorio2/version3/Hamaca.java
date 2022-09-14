package TPO_02;

public class Hamaca {

    private boolean enUso = false;    
    
    public synchronized boolean usar() { 
        boolean exito = false;
        
        if (!this.enUso) {
            System.out.println("El hamster " + Thread.currentThread().getName() + " se esta hamacando");
            exito = true;
            this.enUso = true;            
            
        }
        
        return exito;
        
    }
    

    public void terminarHamarcarse() {
        this.enUso = false;
        System.out.println("El hamster " + Thread.currentThread().getName() + " termino de hamacarse");
    }
}