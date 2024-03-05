package ClassiQuinte.ProdConsWithCustomQueue;

import java.util.Random;

public class Producer extends Thread {

    private final Queue q;
    private static int index;

    public Producer(Queue q) {
        super("Producer" + ++index);
        this.q = q;
    }

    @Override
    public void run() {
        int limit = 3 + new Random().nextInt(20);
        for (int i = 0; i < limit; i++) {
            String elem = "elem" + (i + 1);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            q.put(elem);
            System.out.println(getName() + " put: " + elem);
        }
    }
}
