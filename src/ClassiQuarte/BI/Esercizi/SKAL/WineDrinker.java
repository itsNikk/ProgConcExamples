package ClassiQuarte.BI.Esercizi.SKAL;

import java.util.Random;

public class WineDrinker extends Thread {

    private WineBarrel wineDispenser;

    public WineDrinker(String name, WineBarrel wineDispenser) {
        super(name);
        this.wineDispenser = wineDispenser;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            System.out.println(getName() + " cammina per la città...");
            sleep(random.nextInt(random.nextInt(5000)));
            wineDispenser.getTap(this);
            sleep(5);
            wineDispenser.releaseTap();
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto. Non c'è più vino.");
        }
    }
}
