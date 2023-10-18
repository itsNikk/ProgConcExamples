package ConcEx2;

public class SmallConsumer extends Thread {
    private final Buffer b;

    public SmallConsumer(String s, Buffer b) {
        super(s);
        this.b = b;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                int value = b.get();
                if (value >= 1 && value <= 5) {
                    System.out.println(getName() + ": " + value);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
