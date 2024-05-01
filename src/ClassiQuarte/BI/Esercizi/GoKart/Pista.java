package ClassiQuarte.BI.Esercizi.GoKart;

public class Pista {
    private int kartDisponibili;

    public Pista(int kartDisponibili) {
        this.kartDisponibili = kartDisponibili;
    }

    public synchronized void accediPista() throws InterruptedException {
        while (kartDisponibili == 0) wait();
        kartDisponibili--;
    }

    public synchronized void esciPista() {
        kartDisponibili++;
        notify();
    }
}
