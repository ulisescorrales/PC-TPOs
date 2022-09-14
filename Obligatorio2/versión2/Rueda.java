package tpo2;

public class Rueda {

    private boolean enUso = false;

    public synchronized void jugarEnRueda() {

        enUso = true;
    }

    public boolean getEnUso() {
        return enUso;
    }

    public  void terminarJugar() {
        this.enUso = false;
    }

}
