package ClassiQuarte.BI.Esercizi.IntroJoin;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EvenThread evenThread = new EvenThread("EvenThread");
        OddThread oddThread = new OddThread("OddThread");

        evenThread.start();
        oddThread.start();
        evenThread.join();
        oddThread.join();

        System.out.println(Thread.currentThread().getName() + " termina.");
    }
}
