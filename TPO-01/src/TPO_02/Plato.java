package TPO_02;

public class Plato {

    private boolean enUso = false;

    public synchronized boolean usar() { 
        boolean exito = false;
        
        if (!this.enUso) {          
            System.out.println("El hamster " + Thread.currentThread().getName() + " esta comiendo");
            exito = true;
            this.enUso = true;           
            
        }
        
        return exito;
        
    }

    public  void terminarComer() {
        this.enUso = false;
        System.out.println("El hamster " + Thread.currentThread().getName() + " termino de comer");
    }
}
