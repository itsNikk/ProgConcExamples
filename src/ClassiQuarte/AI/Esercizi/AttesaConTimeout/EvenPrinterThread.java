package ClassiQuarte.AI.Esercizi.AttesaConTimeout;

public class EvenPrinterThread extends Thread {

    public static final int MAX_NUMBER = 1000000;

    public EvenPrinterThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 2; i <= MAX_NUMBER; i += 2) {
            System.out.println(getName() + ": " + i);
            try {
                sleep(5);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
                break;
            }
        }
    }
}
