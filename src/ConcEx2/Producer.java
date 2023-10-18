package ConcEx2;

import java.util.Random;

public class Producer extends Thread {

    public static final int BOUND = 10;
    private final Buffer b;

    public Producer(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (b) {
                try {
                    int value = 1 + new Random().nextInt(BOUND);
                    b.put(value);
                    System.out.println("P: " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
