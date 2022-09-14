package TPO_02;

public class Rueda {

    private boolean enUso = false;

    public synchronized boolean usar() { 
        boolean exito = false;
        
        if (!this.enUso) {      
            System.out.println("El hamster " + Thread.currentThread().getName() + " esta jugando en la rueda");
            exito = true;
            this.enUso = true;
            
        }
        
        return exito;
        
    }

    public  void terminarJugar() {
        this.enUso = false;
        System.out.println("El hamster " + Thread.currentThread().getName() + " termino de usar la rueda");
    }

}
