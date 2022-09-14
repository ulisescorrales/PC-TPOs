package tpo2;

public class Hamaca {

    private boolean enUso = false;

    public synchronized void Hamacarse() {
        enUso = true;
    }

    public synchronized boolean getEnUso() {
        return enUso;
    }

    public  void terminarHamarcarse() {
        enUso = false;
    }
}
