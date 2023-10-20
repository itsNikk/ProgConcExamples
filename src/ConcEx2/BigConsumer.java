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
                int takenValue = b.consume(6, 10);
            } catch (InterruptedException e) {
                System.out.println(getName() + " è stato interrotto e termina.");
                break;
            }
        }
    }
}
