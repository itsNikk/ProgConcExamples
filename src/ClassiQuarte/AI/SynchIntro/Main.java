package ClassiQuarte.AI.SynchIntro;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        AdderThread at1 = new AdderThread(c);
        AdderThread at2 = new AdderThread(c);

        at1.start();
        at2.start();

        at1.join();
        at2.join();

        System.out.println("Counter: " + c.getCount());
    }
}
