package ClassiQuarte.BI.Esercizi.JoinChainNumberSequence;

public class ChainThread extends Thread {

    private final ChainThread previousThread;

    public ChainThread(String name, ChainThread previousThread) {
        super(name);
        this.previousThread = previousThread;
    }

    @Override
    public void run() {
        try {
            if (previousThread != null) previousThread.join();

            int startNumber = (previousThread != null) ? previousThread.getEndNumber() : 1;

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }

    public int getEndNumber() {
        return (previousThread != null) ? previousThread.getEndNumber() : 1;
    }
}
