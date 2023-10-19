package ProdConsWithCustomQueue;

public class Consumer extends Thread {

    private final Queue queue;
    private static int index;

    public Consumer(Queue queue) {
        super("Consumer" + ++index);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(getName() + " waiting for resource :(");
                System.out.println(getName() + " got: " + queue.get());
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
                break;
            }
        }
    }
}

