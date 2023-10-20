package ConcEx2;

public class Buffer {


    private int value;
    private boolean dataReady;

    public synchronized void put(int value) throws InterruptedException {
        while (dataReady) wait();
        this.value = value;
        dataReady = true;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (!dataReady) wait();
        dataReady = false;
        notifyAll();
        return value;
    }
}
