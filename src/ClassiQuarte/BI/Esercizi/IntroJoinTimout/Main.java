package ClassiQuarte.BI.Esercizi.IntroJoinTimout;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EvenThread evenThread = new EvenThread("EvenThread");
        OddThread oddThread = new OddThread("OddThread");

        evenThread.start();
        oddThread.start();

        Thread.sleep(3000);
        if (evenThread.isAlive() || oddThread.isAlive()) {
            System.err.println(Thread.currentThread().getName() + " termina forzatamente.");
            System.exit(0);
        } else {
            System.out.println(Thread.currentThread().getName() + " termina.");
        }
    }
}
