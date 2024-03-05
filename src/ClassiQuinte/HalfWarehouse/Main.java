package ClassiQuinte.HalfWarehouse;


import java.util.ArrayList;

public class Main {

    private static final int NUM_PRODUCERS = 80;
    private static final int NUM_CONSUMERS = 6;

    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer(10);

        ArrayList<Consumer> consumers = new ArrayList<>();
        ArrayList<Producer> producers = new ArrayList<>();

        for (int i = 0; i < NUM_CONSUMERS; i++) consumers.add(new Consumer(b));
        for (int i = 0; i < NUM_PRODUCERS; i++) producers.add(new Producer(b));

        for (Thread t : consumers) t.start();
        for (Thread t : producers) t.start();

        for (Thread t : consumers) t.join();
        for (Thread t : producers) t.join();

        System.out.println("Elementi rimanenti in struttura:> " + b.getBufferSize());

    }
}
