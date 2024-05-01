package ClassiQuarte.BI.Esercizi.SKAL;

public class WineBarrel {
    private int availableTaps;
    private int remainingWine; //in liters

    public WineBarrel(int availableTaps, int remainingWine) {
        this.availableTaps = availableTaps;
        this.remainingWine = remainingWine;
    }

    public synchronized void getTap(WineDrinker drinker) throws InterruptedException {

        if (remainingWine <= 0) drinker.interrupt();

        while (availableTaps == 0) {
            System.out.println(drinker.getName() + " aspetta. Taps: " + availableTaps);
            wait();
        }

        availableTaps--;

        if (remainingWine > 0) {
            remainingWine--;
            System.out.println(drinker.getName() + " drank a litre of wine. Remaining wine: " + remainingWine);
        } else drinker.interrupt();
    }


    public synchronized void releaseTap() {
        availableTaps++;
        notifyAll();
    }
}
