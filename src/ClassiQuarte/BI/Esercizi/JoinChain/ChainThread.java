package ClassiQuarte.BI.Esercizi.JoinChain;

public class ChainThread extends Thread {

    private final Thread previousThread;

    public ChainThread(String name, Thread previousThread) {
        super(name);
        this.previousThread = previousThread;
    }

    @Override
    public void run() {
        if (previousThread != null) {
            try {
                previousThread.join();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
            }
        }
        System.out.println(getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ": " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
                break;
            }
        }
    }
}
