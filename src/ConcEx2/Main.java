package ConcEx2;

import java.util.concurrent.Semaphore;

public class Main {

    public static Semaphore smallSem = new Semaphore(1);
    public static Semaphore bigSem = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer();
        Producer producer = new Producer(b);
        producer.start();

        SmallConsumer sc = new SmallConsumer("SC", b);
        sc.start();


        BigConsumer bc = new BigConsumer("BC", b);
        bc.start();

        producer.join();
    }
}
