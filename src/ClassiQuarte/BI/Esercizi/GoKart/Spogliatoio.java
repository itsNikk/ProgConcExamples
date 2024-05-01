package ClassiQuarte.BI.Esercizi.GoKart;

public class Spogliatoio {
    private int postiDisponibili;

    public Spogliatoio(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public synchronized void entraSpogliatoio() throws InterruptedException {
        while (postiDisponibili == 0) wait();
        postiDisponibili--;
    }

    public synchronized void esciSpogliatoio() {
        postiDisponibili++;
        notify();
    }
}
