package ClassiQuarte.BI.StampaATurno;

public class ThreadPrinter extends Thread {

    public ThreadPrinter(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ": in esecuzione");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
                break;
            }
        }
        System.out.println(getName() + " ha concluso.");
    }
}
