package ClassiQuarte.BI.Esercizi.Incrocio;

public class Incrocio {
    private boolean orizzontaleLibero = true;
    private boolean verticaleLibero = true;

    public synchronized void attraversaOrizzontale() throws InterruptedException {
        while (!orizzontaleLibero || !verticaleLibero) wait();

        orizzontaleLibero = false;
    }

    public synchronized void attraversaVerticale() throws InterruptedException {
        while (!orizzontaleLibero || !verticaleLibero) wait();

        verticaleLibero = false;
    }

    public synchronized void liberaOrizzontale() {
        orizzontaleLibero = true;
        notifyAll();
    }

    public synchronized void liberaVerticale() {
        verticaleLibero = true;
        notifyAll();
    }


}
