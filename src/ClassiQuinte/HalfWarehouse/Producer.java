package ClassiQuinte.HalfWarehouse;

import java.util.Random;

public class Producer extends Thread {

    private final Buffer b;
    private static int index;

    public Producer(Buffer b) {
        super("Produttore" + ++index);
        this.b = b;
    }

    @Override
    public void run() {
        b.produce(1 + new Random().nextInt(10));
    }
}
