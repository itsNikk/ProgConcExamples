package ClassiQuinte.ProducerConsumer;

public class Resource {
    static final int BUFFER_SIZE = 1;
    private int value;
    private int numItems = 0;

    public synchronized void SetValue(int v) throws InterruptedException {
        if(numItems==BUFFER_SIZE) wait();
        value = v;
        numItems++;
        notify();
    }

    public synchronized int GetValue() throws InterruptedException {
        if (numItems == 0) wait();
        numItems--;
        notify();

        return value;
    }
}
