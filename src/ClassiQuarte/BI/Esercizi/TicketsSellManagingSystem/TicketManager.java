package ClassiQuarte.BI.Esercizi.TicketsSellManagingSystem;

public class TicketManager {
    private int bigliettiTotali;

    public TicketManager(int bigliettiTotali) {
        this.bigliettiTotali = bigliettiTotali;
    }

    public synchronized void acquistaBiglietto() {
        if (bigliettiTotali == 0) {
            // In questo scenario non è sensato usare wait() :)
            Thread.currentThread().interrupt();
            return;
        }
        bigliettiTotali--;
        System.out.println(Thread.currentThread().getName() + " ha acquistato un biglietto. Biglietti rimanenti: " + bigliettiTotali);
    }
}
