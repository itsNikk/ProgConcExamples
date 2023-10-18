package ProducerConsumer;

public class Producer extends Thread {

    private final Resource resource;

    public Producer(Resource res) {
        resource = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resource.SetValue(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(" P" + i);
        }
    }
}
