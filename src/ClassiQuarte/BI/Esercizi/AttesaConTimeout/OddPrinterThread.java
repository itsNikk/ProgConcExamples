package ClassiQuarte.BI.Esercizi.AttesaConTimeout;

public class OddPrinterThread extends Thread {

    public static final int MAX_NUMBER = 1000000;

    public OddPrinterThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= MAX_NUMBER; i += 2) {
            System.out.println(getName() + ": " + i);
            try {
                sleep(5);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interotto");
                break;
            }
        }
    }
}
