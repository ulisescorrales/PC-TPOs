package tpo2;

public class Plato {

    private boolean enUso = false;

    public synchronized void Comer() {
        enUso = true;        
    }

    public boolean getEnUso() {
        return enUso;
    }

    public  void terminarComer() {
        this.enUso = false;
    }
}
