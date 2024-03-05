package ClassiQuinte.ProducerConsumer;

public class Consumer extends Thread {

    private final Resource res;

    public Consumer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        int v;
        for (int i = 0; i < 10; i++) {
            try {
                v = res.GetValue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(" C" + v);
        }
    }
}
