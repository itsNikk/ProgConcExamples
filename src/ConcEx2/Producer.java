package ConcEx2;

import java.util.Random;

public class Producer extends Thread {

    public static final int BOUND = 10;
    private final Buffer b;

    public Producer(Buffer b) {
        setName("Produttore");
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int value = 1 + new Random().nextInt(BOUND);
                b.produce(value);
            } catch (InterruptedException e) {
                System.out.println(getName() + " è stato interrotto e termina");
            }
        }
        System.out.println(getName() + " ha terminato.");
    }
}
