package ClassiQuinte.ConcEx2;


public class Main {


    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        SmallConsumer consumer1 = new SmallConsumer("SC", buffer);
        BigConsumer consumer2 = new BigConsumer("BC", buffer);

        producer.start();
        consumer1.start();
        consumer2.start();
        producer.join();
        consumer2.interrupt();
        consumer1.interrupt();
    }
}
