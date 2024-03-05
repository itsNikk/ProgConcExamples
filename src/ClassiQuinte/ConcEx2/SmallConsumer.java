package ClassiQuinte.ConcEx2;

public class SmallConsumer extends Thread {
    private final Buffer b;

    public SmallConsumer(String s, Buffer b) {
        super(s);
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = b.consume(1, 5);
            } catch (InterruptedException e) {
                System.out.println(getName() + " è stato interrotto e termina.");
                break;
            }
        }
    }
}
