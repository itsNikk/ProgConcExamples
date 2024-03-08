package ClassiQuarte.BI.IntroSynch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        AdderThread at1 = new AdderThread("Adder 1", c);
        AdderThread at2 = new AdderThread("Adder 2", c);

        at1.start();
        at2.start();
        at2.join();
        at1.join();

        System.out.println("Counter:" + c.getCounter());
    }
}
