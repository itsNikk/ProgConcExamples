package ClassiQuinte.LavoriamoCon_Daemon.JoinExample;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("I thread stanno per partire");
        Thread t1 = new ThreadSleep("T1");
        Thread t2 = new ThreadSleep("T2");
        Thread t3 = new ThreadSleep("T3");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        System.out.println("Main: stampo dopo T1");
        t2.interrupt();
        t3.interrupt();
        t2.join();
        System.out.println("Main: stampo dopo T2");
        t3.join();
        System.out.println("Main: stampo dopo T3 e chiudo");
    }
}
