package ProducerConsumer;

public class Main {
    public static void main(String[] args) {
        Resource r = new Resource();
        new Producer(r).start();
        new Consumer(r).start();
        new Main().Exec();
    }

    private void Exec() {

    }
}
