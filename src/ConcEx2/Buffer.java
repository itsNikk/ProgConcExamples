package ConcEx2;

public class Buffer {

    private int value;
    private boolean isProducing;

    public synchronized void produce(int num) throws InterruptedException {
        while (isProducing) wait();

        value = num;
        isProducing = true;
        System.out.println("Produttore ha prodotto: " + num);
        notifyAll();
    }

    public synchronized int consume(int min, int max) throws InterruptedException {
        while (!isProducing || value < min || value > max) wait();

        int consumedValue = value;
        isProducing = false;
        System.out.println(Thread.currentThread().getName() + " ha consumato: " + consumedValue);
        notifyAll();
        return consumedValue;
    }
}
