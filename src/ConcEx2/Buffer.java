package ConcEx2;

public class Buffer {


    private int value;
    private boolean dataReady;

    public synchronized void put(int value) throws InterruptedException {
        while (dataReady) wait();
        this.value = value;
        dataReady = true;
        //se val in range c1 sveglia i c1
        if (value >= 1 && value <= 5) Main.smallSem.release();
        // se val in range c2 sveglia i c2
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (!dataReady) wait();
        dataReady = false;
        notifyAll();
        return value;
    }
}
