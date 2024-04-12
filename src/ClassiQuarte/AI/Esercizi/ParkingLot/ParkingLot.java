package ClassiQuarte.AI.Esercizi.ParkingLot;

public class ParkingLot {
    private int availableLots;

    public ParkingLot(int availableLots) {
        this.availableLots = availableLots;
    }

    public synchronized void enterLot() throws InterruptedException {
        while (availableLots == 0) wait();
        availableLots--;
        System.out.println(Thread.currentThread().getName() + " entra nel parcheggio. Posti disponibili: " + availableLots);
    }

    public synchronized void exitLot() {
        availableLots++;
        System.out.println(Thread.currentThread().getName() + " esce nel parcheggio. Posti disponibili: " + availableLots);
        notifyAll();
    }
}
