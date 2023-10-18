package ConcEx2;

public class BigConsumer extends Thread {

    private final Buffer b;

    public BigConsumer(String name, Buffer b) {
        super(name);
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int takenValue = b.get();
                if (takenValue >= 6 && takenValue <= 10) {
                    System.out.println(getName() + ": " + takenValue);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
