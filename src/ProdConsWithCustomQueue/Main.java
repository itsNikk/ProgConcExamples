package ProdConsWithCustomQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue();
        Consumer consumer = new Consumer(queue);
        consumer.start();

        Producer p = new Producer(queue);
        p.start();
        p.join();

        int millis = 2000;
        System.out.println("New producer in " + millis / 1000 + " seconds");
        Thread.sleep(millis);

        Producer lastProducer = new Producer(queue);
        lastProducer.start();
        lastProducer.join();

        consumer.interrupt();

    }
}
