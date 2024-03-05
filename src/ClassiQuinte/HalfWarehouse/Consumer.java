package ClassiQuinte.HalfWarehouse;

public class Consumer extends Thread {
    private final Buffer b;
    private static int index;

    public Consumer(Buffer b) {
        setName("Consumatore " + ++index);
        this.b = b;
    }

    @Override
    public void run() {
        b.consume();
    }
}
